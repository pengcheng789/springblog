package top.pengcheng789.java.springblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.pengcheng789.java.springblog.model.RegisterUserForm;
import top.pengcheng789.java.springblog.service.DateTimeService;
import top.pengcheng789.java.springblog.service.UserService;

import javax.validation.Valid;


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

    private UserService userService;
    private DateTimeService dateTimeService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @Autowired
    private void setDateTimeService(DateTimeService dateTimeService) {
        this.dateTimeService = dateTimeService;
    }

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public String list(Model model) {
        model.addAttribute("users", userService.findAll());

        return "user/list";
    }

    /**
     * 用户详情
     */
    @RequestMapping(value = "/profile/{userId}", method = RequestMethod.GET)
    public String profile(@PathVariable String userId, Model model) {
        model.addAttribute(userService.findById(userId));
        model.addAttribute("greetings", dateTimeService.getGreetings());

        return "user/profile";
    }

    /**
     * 用户注册
     */
    @RequestMapping(value = "/register", method = RequestMethod.GET)
    public String register(Model model) {
        model.addAttribute("user", new RegisterUserForm());

        return "user/register";
    }

    @RequestMapping(value = "/register", method = RequestMethod.POST)
    public String processRegister(@Valid RegisterUserForm form, Errors errors, Model model) {
        if (errors.hasErrors()) {
            return "user/register";
        }

        if (userService.mailIsExist(form.getMail())) {
            model.addAttribute("user", form);
            model.addAttribute("errorMessage", "邮箱已被注册");

            return "user/register";
        }

        return "redirect:/user/profile/" + userService.add(form);
    }
}
