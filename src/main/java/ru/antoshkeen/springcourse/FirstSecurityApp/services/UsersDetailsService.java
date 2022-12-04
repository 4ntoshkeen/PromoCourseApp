package ru.antoshkeen.springcourse.FirstSecurityApp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.antoshkeen.springcourse.FirstSecurityApp.models.User;
import ru.antoshkeen.springcourse.FirstSecurityApp.repositories.UsersRepository;
import ru.antoshkeen.springcourse.FirstSecurityApp.security.UsersDetails;

import java.util.Optional;

@Service
public class UsersDetailsService implements UserDetailsService {

    public final UsersRepository usersRepository;

    public UsersDetailsService(UsersRepository usersRepository) {
        this.usersRepository = usersRepository;
    }

    @Override
    public UsersDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Optional<User> user = usersRepository.findByUsername(s);
        if (user.isEmpty()) {
            throw new UsernameNotFoundException("User not found");
        }
        return new UsersDetails(user.get());
    }

}
