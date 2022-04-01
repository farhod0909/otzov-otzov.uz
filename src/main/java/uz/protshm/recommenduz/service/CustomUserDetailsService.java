package uz.protshm.recommenduz.service;

import lombok.RequiredArgsConstructor;
import org.apache.catalina.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import uz.protshm.recommenduz.dto.CustomUserDetails;
import uz.protshm.recommenduz.entities.Users;
import uz.protshm.recommenduz.repository.UsersRepository;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class CustomUserDetailsService implements UserDetailsService {
    private final UsersRepository usersRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Users users =  usersRepository.findByUsernameAndDeletedFalse(username).orElseThrow(()->new RuntimeException("User not found"));
        return new CustomUserDetails( users);


    }
}
