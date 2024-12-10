package net.engineeringdigest.journalApp.config;

import net.engineeringdigest.journalApp.services.userDetailServiceimpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
@Profile("prod")
public class SpringSecurityprod extends WebSecurityConfigurerAdapter {

    @Autowired
    private userDetailServiceimpl userDetailServiceimpl;



    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
               

                .anyRequest().permitAll()
                .and()
                .httpBasic();
        http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS).and().csrf().disable();



    }

//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//                // Allow /user API without authentication
//                .antMatchers("/user/**").permitAll()
//                // Require authentication for /journal APIs
//                .antMatchers("/journal/**").authenticated()
//                // Allow all other requests
//                .anyRequest().permitAll()
//                .and()
//                .httpBasic()
//                .and()
//                .csrf().disable();
//    }


    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailServiceimpl).passwordEncoder(passwordEncoder());
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }
}