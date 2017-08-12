package top.pengcheng789.java.springblog.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;
import top.pengcheng789.java.springblog.model.PassageCategory;
import top.pengcheng789.java.springblog.model.RegisterUserForm;
import top.pengcheng789.java.springblog.model.UpdateNicknameForm;
import top.pengcheng789.java.springblog.model.UpdateSexForm;
import top.pengcheng789.java.springblog.service.DateTimeService;
import top.pengcheng789.java.springblog.service.PassageCategoryService;
import top.pengcheng789.java.springblog.service.UserService;

import javax.servlet.ServletContext;
import javax.validation.Valid;
import java.io.File;
import java.io.IOException;
import java.util.List;


/**
 * 用户控制器
 *
 * CreateDate:2017-08-06
 *
 * @author pen
 */
@Controller
@RequestMapping(value = "/user")
public class UserController {

    private static final Logger LOGGER = LoggerFactory.getLogger(UserController.class);

    private UserService userService;
    private DateTimeService dateTimeService;
    private ServletContext servletContext;
    private PassageCategoryService passageCategoryService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private void setDateTimeService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @Autowired
    private void setServletContext(ServletContext servletContext) {
        this.servletContext = servletContext;
    }

    @Autowired
    private void setPassageCategoryService(PassageCategoryService service) {
        this.passageCategoryService = service;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());

        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        return "user/list";
    }

    /**
     * 用户登录
     */
    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        return "user/login";
    }

    /**
     * 用户详情
     */
    @RequestMapping(value = "/profile", method = RequestMethod.GET)
    public String profile(@AuthenticationPrincipal User user,
                          Model model) {
        String userId = user.getUsername();
        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);
        model.addAttribute(userService.findById(userId));
        model.addAttribute("greetings", dateTimeService.getGreetings());

        return "user/profile";
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute(new RegisterUserForm());

        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@Valid RegisterUserForm form, Errors errors, Model model) {

        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        if (errors.hasErrors()) {
            return "user/register";
        }

        if (userService.mailIsExist(form.getMail())) {
            model.addAttribute("isMailExist", true);
            model.addAttribute("registerUserForm", form);
            model.addAttribute("errorMessage", "邮箱已被注册");

            return "user/register";
        }

        userService.add(form);

        return "redirect:/user/profile";
    }

    /**
     * 更新用户昵称
     */
    @RequestMapping(value = "/update/nickname", method = RequestMethod.POST)
    public String updateNickname(@Valid UpdateNicknameForm form, Errors errors,
            @AuthenticationPrincipal User user) {
        String userId = user.getUsername();
        if (errors.hasErrors()) {
            return "redirect:/user/profile";
        }

        userService.updateNickname(userId, form.getNickname());

        return "redirect:/user/profile";
    }

    /**
     * 更新用户性别
     */
    @RequestMapping(value = "/update/sex", method = RequestMethod.POST)
    public String updateSex(@Valid UpdateSexForm form, Errors errors,
                            @AuthenticationPrincipal User user) {
        String userId = user.getUsername();
        if (errors.hasErrors()) {
            return "redirect:/user/profile";
        }

        userService.updateSex(userId, form.getSex());

        return "redirect:/user/profile";
    }

    /**
     * 更新用户头像
     */
    @RequestMapping(value = "/update/head_image", method = RequestMethod.POST)
    public String updateHeadImage(
            @RequestPart("headImage")MultipartFile headImage,
            @AuthenticationPrincipal User user) {
        String userId = user.getUsername();

        if (headImage.isEmpty()
                || !(headImage.getContentType().equalsIgnoreCase("image/jpeg")
                || headImage.getContentType().equalsIgnoreCase("image/png")
                || headImage.getContentType().equalsIgnoreCase("image/gif"))) {
            return "redirect:/user/profile";
        }

        String path = servletContext.getRealPath("/asset/head_image/") +
                userId + "." + headImage.getContentType().substring(6);
        String sqlPath = "/asset/head_image/" + userId + "." +
                headImage.getContentType().substring(6);

        try {
            headImage.transferTo(new File(path));
            userService.updateHeadImage(userId, sqlPath);
        } catch (IOException e) {
            LOGGER.error("save the head image file failure" + path, e);
            throw new RuntimeException(e);
        }

        return "redirect:/user/profile";
    }

    /**
     * 删除用户
     */
    @RequestMapping(value = "/delete/{userId}", method = RequestMethod.GET)
    public String delete(@PathVariable String userId) {
        userService.delete(userId);

        return "redirect:/user/list";
    }
}
