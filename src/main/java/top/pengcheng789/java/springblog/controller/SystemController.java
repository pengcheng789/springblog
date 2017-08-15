package top.pengcheng789.java.springblog.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import top.pengcheng789.java.springblog.model.Passage;
import top.pengcheng789.java.springblog.model.PassageCategory;
import top.pengcheng789.java.springblog.service.PassageCategoryService;
import top.pengcheng789.java.springblog.service.PassageService;

import java.util.List;

/**
 * 系统控制器
 *
 * CreateDate:2017-08-04
 *
 * @author pen
 */
@Controller
public class SystemController {

    private PassageCategoryService passageCategoryService;
    private PassageService passageService;

    @Autowired
    private void setPassageCategoryService(PassageCategoryService service) {
        this.passageCategoryService = service;
    }

    @Autowired
    public void setPassageService(PassageService passageService) {
        this.passageService = passageService;
    }

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        List<PassageCategory> categoryList = passageCategoryService.findAll();
        model.addAttribute("categoryList", categoryList);

        List<Passage> passageList = passageService.findAll();
        model.addAttribute("passageList", passageList);

        return "common/home";
    }
}
