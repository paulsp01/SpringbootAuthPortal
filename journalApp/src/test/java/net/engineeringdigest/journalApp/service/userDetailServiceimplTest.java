//package net.engineeringdigest.journalApp.service;
//
//import lombok.Data;
//import net.engineeringdigest.journalApp.Entity.user;
//import net.engineeringdigest.journalApp.Repository.userRepository;
//import net.engineeringdigest.journalApp.services.userDetailServiceimpl;
//import org.junit.jupiter.api.Assertions;
//import org.junit.jupiter.api.BeforeEach;
//import org.junit.jupiter.api.Disabled;
//import org.junit.jupiter.api.Test;
//import org.mockito.*;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.test.context.SpringBootTest;
//import org.springframework.boot.test.mock.mockito.MockBean;
//import org.springframework.security.core.userdetails.User;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Component;
//
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.mockito.Mockito.*;
//import static sun.reflect.annotation.AnnotationParser.toArray;
//
//@Component
//@SpringBootTest
//public class userDetailServiceimplTest  {
//
//    @InjectMocks
//    private userDetailServiceimpl  userDetailServiceimpl;
//
//    @Mock
//    private  userRepository userRepository;
//
//    @BeforeEach
//    void setUp(){
//        MockitoAnnotations.initMocks(this);
//    }
//
//
////    @Test
////    @Disabled
////    void loadUserByUsernameTest(){
////        when(userRepository.findByUserName(ArgumentMatchers.anyString())).thenReturn(User.builder().username("ram").password("inrinrick").roles("roles").build());
////        UserDetails user = userDetailServiceimpl.loadUserByUsername("ram");
////        Assertions.assertNotNull(user);
////    }
//
//}
