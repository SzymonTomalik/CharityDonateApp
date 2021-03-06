package pl.coderslab.CharityDonateApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import pl.coderslab.CharityDonateApp.entities.CharityUser;
import pl.coderslab.CharityDonateApp.models.CurrentUser;

import java.util.HashSet;
import java.util.Set;


public class UserDetailsServiceImp implements UserDetailsService {
    private UserService userService;

    @Autowired
    public  void setUserService(UserService userService) {
        this.userService=userService;
    }

    @Override
    public UserDetails loadUserByUsername(String email) {
        CharityUser user = userService.findByEmail(email);
        if (user == null) {throw new UsernameNotFoundException(email); }
        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
        user.getRoles().forEach(r ->
                grantedAuthorities.add(new SimpleGrantedAuthority(r.getName())));
        return new CurrentUser(user.getUsername(),user.getPassword(),
                grantedAuthorities, user);
    }
}
