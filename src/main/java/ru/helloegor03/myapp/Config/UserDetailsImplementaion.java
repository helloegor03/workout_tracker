package ru.helloegor03.myapp.Config;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import ru.helloegor03.myapp.Model.User;

import java.util.Collection;
import java.util.List;
@AllArgsConstructor
public class UserDetailsImplementaion implements UserDetails {

    private Long id;
    private String username;
    private String email;
    private String password;
    private User user; // Добавляем поле для сущности User


    public UserDetailsImplementaion(Long id, String username, String email, String password, User user) {
        this.id = id;
        this.username = username;
        this.email = email;
        this.password = password;
        this.user = user;
    }

    public static UserDetailsImplementaion build(User user){
        return new UserDetailsImplementaion(
                user.getId(),
                user.getUsername(),
                user.getEmail(),
                user.getPassword(),
                user // передаем сущность User
        );
    }


    public User getUser() {
        return user;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(); // Можно добавить роли при необходимости
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
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
}