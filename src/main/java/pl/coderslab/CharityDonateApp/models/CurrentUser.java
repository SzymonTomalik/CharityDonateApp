package pl.coderslab.CharityDonateApp.models;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.User;
import pl.coderslab.CharityDonateApp.entities.CharityUser;

import java.util.Collection;

public class CurrentUser extends User {
    private final CharityUser user;

    public CurrentUser(String username, String password,
                       Collection<? extends GrantedAuthority> authorities, CharityUser user) {
        super(username, password, authorities);
        this.user=user;
    }

    public CharityUser getUser() {
        return user;
    }

}
