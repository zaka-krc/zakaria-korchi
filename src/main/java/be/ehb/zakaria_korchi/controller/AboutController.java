package be.ehb.zakaria_korchi.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class AboutController {

    @RequestMapping(value = "/about", method = RequestMethod.GET)
    public String showAbout(ModelMap map) {
        return "about";
    }
}