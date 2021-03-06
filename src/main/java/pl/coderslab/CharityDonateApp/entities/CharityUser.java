package pl.coderslab.CharityDonateApp.entities;

import lombok.Getter;
import lombok.Setter;
import org.mindrot.jbcrypt.BCrypt;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.util.Set;

@Entity
@Getter
@Setter
@Table(name = "users")
public class CharityUser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @NotBlank(message = "firstName is mandatory")
    @Size(max = 30)
    private String firstName;
    @NotBlank(message = "lastName is mandatory")
    @Size(max = 30)
    private String lastName;
    @Email
    @Column(unique = true)
    @NotBlank(message = "Email is mandatory")
    private String email;
    @NotBlank(message = "Password is mandatory")
    @Size(min = 8)
    private String password = BCrypt.hashpw("", BCrypt.gensalt());
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(name = "user_role", joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<Role> roles;
    private int enabled;



    public CharityUser() {
    }

    public CharityUser(@Size(max = 30) String firstName, @Size(max = 30) String lastName, @Email @NotBlank(message = "Email is mandatory") String email, @NotBlank(message = "Password is mandatory") String password) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    public void setPassword(String password) {
        this.password = BCrypt.hashpw(password, BCrypt.gensalt());
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public String getUsername() {
        return email;
    }
}
