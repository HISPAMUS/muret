package es.ua.dlsi.grfia.im3ws.muret.auth.services;

import com.fasterxml.jackson.annotation.JsonIgnore;
import es.ua.dlsi.grfia.im3ws.muret.entity.User;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;

public class UserPrinciple implements UserDetails {
	private static final long serialVersionUID = 1L;

    private Collection<? extends GrantedAuthority> authorities;

    User user;

    public UserPrinciple(User user, Collection<? extends GrantedAuthority> authorities) {
        this.authorities = authorities;
        this.user = user;
    }

    /*public UserPrinciple(Integer id, String username, String password,
			    		Collection<? extends GrantedAuthority> authorities) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.authorities = authorities;
    }*/

    public static UserPrinciple build(User user) {
        List<GrantedAuthority> authorities = new ArrayList<>();
        if (user.isAdministrator()) {
            authorities.add(new SimpleGrantedAuthority(User.ADMINISTRATOR_ROLE));
        }

        /*return new UserPrinciple(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                authorities
        );*/
        return new UserPrinciple(user, authorities);
    }

    public Integer getId() {
        return user.getId();
    }

    @Override
    public String getUsername() {
        return user.getUsername();
    }

    @JsonIgnore
    @Override
    public String getPassword() {
        return user.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        
        UserPrinciple user = (UserPrinciple) o;
        return Objects.equals(user, user.user);
    }

    public User getUser() {
        return user;
    }
}
