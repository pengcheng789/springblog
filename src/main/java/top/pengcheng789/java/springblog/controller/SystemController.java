package top.pengcheng789.java.springblog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 系统控制器
 *
 * CreateDate:2017-08-04
 *
 * @author pen
 */
@Controller
public class SystemController {

    @RequestMapping(value = {"/", "/home"}, method = RequestMethod.GET)
    public String home(Model model) {
        String name = "Pen";
        model.addAttribute("name", name);
        return "common/home";
    }
}
