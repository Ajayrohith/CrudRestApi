package com.main.Security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import com.main.Dao.EmployeeDao;
import com.main.Entity.Employee;

import jakarta.servlet.Filter;

@Configuration
public class SecurityConfig {

   

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,CustomFilterConfig customFilterConfig )
    {

        http.csrf(csrf -> csrf.disable());
        http.authorizeHttpRequests(request -> request.anyRequest().authenticated());
        http.httpBasic(Customizer.withDefaults());
        http.sessionManagement(session -> session.sessionCreationPolicy(SessionCreationPolicy.STATELESS));
        http.addFilterBefore(customFilterConfig, UsernamePasswordAuthenticationFilter.class);
        return http.build();
    }

    // @Bean
    // public InMemoryUserDetailsManager userDetailsManager()
    // {
    //     UserDetails user1 = User.builder().username("ajay").password("{noop}test123").roles("Admin").build();
    //     return new InMemoryUserDetailsManager(user1);
        
    // }

    @Bean
    public UserDetailsService userDetailsService (EmployeeDao employeeDao)
    {
        return firstName ->{
            Employee employee = employeeDao.findEmployeeByUsername(firstName);
            if(employee == null)
            {
                throw new UsernameNotFoundException("User not found");
            }
        return employee;
        };
        
    }

    

}
