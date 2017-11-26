package playground.securedmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class HomeController {

    @RequestMapping("/")
    public ModelAndView welcome() {
        ModelAndView index = new ModelAndView("layouts/layout");
        index.addObject("template", "index");
        index.addObject("name", "MVC");
        return index;
    }

}
