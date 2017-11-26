package playground.securedmvc.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.ArrayList;
import java.util.List;

import static playground.securedmvc.security.SecurityHelper.userHasAnyAuthorities;

@Controller
public class HomeController {

    @RequestMapping("/")
    //@PreAuthorize("hasAuthority('authority_name')")
    public ModelAndView welcome() {
        ModelAndView index = new ModelAndView("layouts/layout");
        index.addObject("template", "index");
        index.addObject("name", "MVC");

        index.addObject("authorities", getUIAuthorities());
        return index;
    }

    private List<String> getUIAuthorities() {
        List<String> authorities = new ArrayList<>();
        if (userHasAnyAuthorities("employee")) {
            authorities.add("auth_employee");
        }
        if (userHasAnyAuthorities("manager")) {
            authorities.add("auth_manager");
        }
        return authorities;
    }

}
