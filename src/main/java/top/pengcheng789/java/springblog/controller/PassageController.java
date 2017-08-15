package top.pengcheng789.java.springblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.pengcheng789.java.springblog.model.Passage;
import top.pengcheng789.java.springblog.model.PassageCategory;
import top.pengcheng789.java.springblog.service.PassageCategoryService;
import top.pengcheng789.java.springblog.service.PassageService;

import javax.validation.Valid;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * passage 控制器
 *
 * CreateDate:2017-08-12
 *
 * @author pen
 */
@Controller
@RequestMapping(value = "/passage")
public class PassageController {

    private PassageCategoryService passageCategoryService;
    private PassageService passageService;

    @Autowired
    public void setPassageCategoryService(PassageCategoryService passageCategoryService) {
        this.passageCategoryService = passageCategoryService;
    }

    @Autowired
    public void setPassageService(PassageService passageService) {
        this.passageService = passageService;
    }

    @RequestMapping(value = "/category/add", method = RequestMethod.POST)
    public String addPassageCategory(@Valid PassageCategory category, Errors errors,
                                     Model model) {
        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        if (errors.hasErrors()) {
            return "passage/list_by_category";
        }

        passageCategoryService.add(category.getName());
        int categoryId = passageCategoryService.findByName(category.getName()).getId();

        return "redirect:/passage/category/" + categoryId;
    }

    @RequestMapping(value = "/category/{categoryId}", method = RequestMethod.GET)
    public String showPassageWithCategoryId(@PathVariable int categoryId, Model model) {
        List<Passage> passageList = passageService.findByCategoryId(categoryId);
        List<PassageCategory> categoryList = passageCategoryService.findAll();
        PassageCategory currentCategory = passageCategoryService.findById(categoryId);

        model.addAttribute("categoryList", categoryList);
        model.addAttribute("passageList", passageList);
        model.addAttribute("currentCategory", currentCategory);

        return "passage/list_by_category";
    }

    @RequestMapping(value = "/category/delete/{categoryId}", method = RequestMethod.GET)
    public String deleteCategory(@PathVariable int categoryId) {
        passageCategoryService.delete(categoryId);

        return "redirect:/home";
    }

    @RequestMapping(value = "/detail/{passageId}", method = RequestMethod.GET)
    public String showPassage(@PathVariable String passageId, Model model) {
        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        Passage passage = passageService.findById(passageId);
        model.addAttribute("passage", passage);
        return "passage/detail";
    }

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addPassage(@AuthenticationPrincipal User user,
                             @Valid Passage passage, Errors errors, Model model) {
        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        if (errors.hasErrors()) {
            return "/passage/category/" + passage.getCategoryId();
        }

        String passageId = UUID.randomUUID().toString();

        passage.setId(passageId);
        passage.setAuthorId(user.getUsername());
        passage.setCreateDate(new Date());
        passage.setUpdateDate(new Date());

        passageService.add(passage);

        return "redirect:/passage/detail/" + passageId;
    }

    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public String updatePassage(@Valid Passage passage, Errors errors, Model model) {
        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        if (errors.hasErrors()) {
            return "passage/detail";
        }

        passage.setUpdateDate(new Date());

        passageService.update(passage);

        return "redirect:/passage/detail/" + passage.getId();
    }

    @RequestMapping(value = "delete/{passageId}", method = RequestMethod.GET)
    public String deletePassage(@PathVariable String passageId) {
        int categoryId = passageService.findById(passageId).getCategoryId();

        passageService.delete(passageId);

        return "redirect:/passage/category/" + categoryId;
    }
}
