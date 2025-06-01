package be.ehb.zakaria_korchi.controller;

import be.ehb.zakaria_korchi.model.Event;
import be.ehb.zakaria_korchi.model.EventDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Optional;

@Controller
public class DetailsController {

    private EventDAO eventRepo;

    @Autowired
    public DetailsController(EventDAO eventRepo) {
        this.eventRepo = eventRepo;
    }

    @RequestMapping(value = "/details/{id}", method = RequestMethod.GET)
    public String showEventDetails(ModelMap map, @PathVariable(value = "id") int id) {
        Optional<Event> optional = eventRepo.findById(id);
        if (optional.isPresent()) {
            map.addAttribute("event", optional.get());
            return "event-details";
        }
        return "redirect:/index";
    }
}
