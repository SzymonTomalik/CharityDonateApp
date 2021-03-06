package pl.coderslab.CharityDonateApp.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Objects;

@Entity
@Getter
@Setter
@ToString
@Table(name = "institutions")
public class Institution {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank(message = "Name of institution is mandatory")
    @Column(unique = true)
    @Size(max = 300)
    private String name;

    private String description;

    public Institution() {
    }

    public Institution(@NotBlank(message = "Name of institution is mandatory") @Size(max = 300) String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Institution)) return false;
        Institution that = (Institution) o;
        return getName().equals(that.getName());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getName());
    }
}
