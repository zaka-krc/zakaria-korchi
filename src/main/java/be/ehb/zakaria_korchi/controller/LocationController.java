package be.ehb.zakaria_korchi.controller;

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
public class LocationController {

    private LocationDAO locationRepo;

    @Autowired
    public LocationController(LocationDAO locationRepo) {
        this.locationRepo = locationRepo;
    }

    @ModelAttribute("new_location")
    public Location createNewLocation() {
        return new Location();
    }

    @ModelAttribute("all_locations")
    public Iterable<Location> getAllLocations() {
        return locationRepo.findAll();
    }

    @RequestMapping(value = "/locations", method = RequestMethod.GET)
    public String showLocations(ModelMap map) {
        return "locations";
    }

    @RequestMapping(value = "/locations", method = RequestMethod.POST)
    public String saveLocation(@ModelAttribute("new_location") @Valid Location newLocation, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "locations";
        }
        locationRepo.save(newLocation);
        return "redirect:/locations";
    }
}