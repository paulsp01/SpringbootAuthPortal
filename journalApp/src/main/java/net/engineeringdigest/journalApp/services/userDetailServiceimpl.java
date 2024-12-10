package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.user;
import net.engineeringdigest.journalApp.Repository.userRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
import org.springframework.security.core.userdetails.UserDetailsService;

@Component
public class userDetailServiceimpl implements UserDetailsService {

    @Autowired
    private  userRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {


        user User = userRepository.findByUserName(username);
        if(User!=null){
            UserDetails build = org.springframework.security.core.userdetails.User.builder()
                    .username(User.getUserName())
                    .password(User.getPassword())
                    .roles(User.getRoles().toArray(new String[0]))
                    .build();
            return build;
        }
        throw new UsernameNotFoundException("user not found"+username);
    }
}
