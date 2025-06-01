package be.ehb.zakaria_korchi.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

@Entity
public class Location {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Naam is verplicht")
    private String name;

    @NotBlank(message = "Adres is verplicht")
    private String address;

    @NotNull(message = "Capaciteit is verplicht")
    @Min(value = 1, message = "Capaciteit moet minstens 1 zijn")
    private Integer capacity;

    public Location() {
    }

    public Location(int id, String name, String address, Integer capacity) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.capacity = capacity;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public @NotBlank(message = "Naam is verplicht") String getName() {
        return name;
    }

    public void setName(@NotBlank(message = "Naam is verplicht") String name) {
        this.name = name;
    }

    public @NotBlank(message = "Adres is verplicht") String getAddress() {
        return address;
    }

    public void setAddress(@NotBlank(message = "Adres is verplicht") String address) {
        this.address = address;
    }

    public @NotNull(message = "Capaciteit is verplicht") @Min(value = 1, message = "Capaciteit moet minstens 1 zijn") Integer getCapacity() {
        return capacity;
    }

    public void setCapacity(@NotNull(message = "Capaciteit is verplicht") @Min(value = 1, message = "Capaciteit moet minstens 1 zijn") Integer capacity) {
        this.capacity = capacity;
    }

    @Override
    public String toString() {
        return "Location{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", capacity=" + capacity +
                '}';
    }
}