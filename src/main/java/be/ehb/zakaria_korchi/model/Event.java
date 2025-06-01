package be.ehb.zakaria_korchi.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Entity
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @NotBlank(message = "Titel is verplicht")
    private String title;

    @NotBlank(message = "Omschrijving is verplicht")
    @Column(length = 1000)
    private String description;

    @NotNull(message = "Datum en tijd zijn verplicht")
    @Future(message = "Evenement moet in de toekomst plaatsvinden")
    @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH:mm")
    private LocalDateTime dateTime;

    @NotBlank(message = "Organisatie is verplicht")
    private String organization;

    @Email(message = "Ongeldig email adres")
    @NotBlank(message = "Contact email is verplicht")
    private String contactEmail;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "location_id")
    @NotNull(message = "Locatie is verplicht")
    private Location location;

    public Event() {
    }

    public Event(String title, String description, LocalDateTime dateTime,
                 String organization, String contactEmail, Location location) {
        this.title = title;
        this.description = description;
        this.dateTime = dateTime;
        this.organization = organization;
        this.contactEmail = contactEmail;
        this.location = location;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public String getOrganization() {
        return organization;
    }

    public void setOrganization(String organization) {
        this.organization = organization;
    }

    public String getContactEmail() {
        return contactEmail;
    }

    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "Event{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", description='" + description + '\'' +
                ", dateTime=" + dateTime +
                ", organization='" + organization + '\'' +
                ", contactEmail='" + contactEmail + '\'' +
                ", location=" + location +
                '}';
    }
}