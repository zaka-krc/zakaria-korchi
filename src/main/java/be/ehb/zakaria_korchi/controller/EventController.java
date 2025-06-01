package be.ehb.zakaria_korchi.controller;

import be.ehb.zakaria_korchi.model.Event;
import be.ehb.zakaria_korchi.model.EventDAO;
import be.ehb.zakaria_korchi.model.Location;
import be.ehb.zakaria_korchi.model.LocationDAO;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class EventController {

    private EventDAO eventRepo;
    private LocationDAO locationRepo;

    @Autowired
    public EventController(EventDAO eventRepo, LocationDAO locationRepo) {
        this.eventRepo = eventRepo;
        this.locationRepo = locationRepo;
    }

    @ModelAttribute("new_event")
    public Event createNewEvent() {
        return new Event();
    }

    @ModelAttribute("all_locations")
    public Iterable<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    @RequestMapping(value = "/new", method = RequestMethod.GET)
    public String showNewEventForm(ModelMap map) {
        return "new-event";
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    public String saveEvent(@ModelAttribute("new_event") @Valid Event newEvent, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "new-event";
        }
        eventRepo.save(newEvent);
        return "redirect:/index";
    }
}