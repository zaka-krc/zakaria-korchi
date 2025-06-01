package be.ehb.zakaria_korchi.controller;

import be.ehb.zakaria_korchi.model.Event;
import be.ehb.zakaria_korchi.model.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class IndexController {

    private EventDAO eventRepo;

    @Autowired
    public IndexController(EventDAO eventRepo) {
        this.eventRepo = eventRepo;
    }

    @ModelAttribute("latest_events")
    public List<Event> getLatestEvents() {
        return eventRepo.findTop10ByOrderByDateTimeAsc();
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.GET)
    public String showIndex(ModelMap map) {
        return "index";
    }

    @RequestMapping(value = {"/", "/index"}, method = RequestMethod.POST)
    public String handleIndexPost() {
        return "redirect:/index";
    }
}