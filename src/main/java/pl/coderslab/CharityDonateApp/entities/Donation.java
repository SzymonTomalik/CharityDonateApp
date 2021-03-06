package pl.coderslab.CharityDonateApp.entities;

import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "donations")
public class Donation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Positive
    private Integer quantity;

    @ManyToMany
    @JoinTable(name = "donations_categories", joinColumns = @JoinColumn(name = "donation_id"),
            inverseJoinColumns = @JoinColumn(name = "category_id"))
    private Set<Category> categories = new HashSet<>();

    @NotNull
    @ManyToOne
    @JoinColumn(name = "institution_id")
    private Institution institution;
    @NotBlank
    @Size(max = 50)
    private String street;
    @Size(max = 50)
    private String city;
    @Column(length = 6)
    private String zipCode;
    @Column(length = 12)
    private String phoneNumber;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate pickUpDate;
    private LocalTime pickUpTime;
    private String pickUpComment;

    public Donation() {
    }

    @Override
    public String toString() {
        return "Donation{" +
                "Bags quantity=" + quantity +
                ", items categories=" + categories +
                ", institution=" + institution +
                ", pickUpDate=" + pickUpDate +
                '}';
    }
}
