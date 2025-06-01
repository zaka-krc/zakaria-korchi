package be.ehb.zakaria_korchi.model;

import be.ehb.zakaria_korchi.model.Location;
import org.springframework.data.repository.CrudRepository;

public interface LocationDAO extends CrudRepository<Location, Integer> {

    Location findByNameIgnoreCase(String name);
}