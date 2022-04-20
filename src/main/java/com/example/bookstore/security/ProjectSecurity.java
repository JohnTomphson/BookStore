package com.example.bookstore.security;//package com.example.demoatm.security;

import com.example.bookstore.models.enums.ApplicationUserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
public class ProjectSecurity extends WebSecurityConfigurerAdapter {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
//
//
//    /**
//     * owner method: Teacher
//     * function: This method add any user and role.
//     * <p>
//     * Ustozni methodi
//     * BU metod user va rollarni qushadi
//     *
//     * @param
//     * @throws Exception
//     */
////    @Override
////    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
////        //tizimda bazasiz bir nechta userdan foydalanish imkonini berib turibti
////        auth.inMemoryAuthentication()
////                .withUser("kamron").password(passwordEncoder().encode("123")).roles("Admin")
////                .and()
////                .withUser("user").password(passwordEncoder().encode("user")).roles("USER")
////                .and()
////                .withUser("moderator").password(passwordEncoder().encode("moderator")).roles("MODERATOR");
////    }
//
//
//
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
//                .cors().disable()
                .authorizeRequests()
                .antMatchers(HttpMethod.POST, "/apiBookStore/book/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
                .antMatchers(HttpMethod.PUT, "/apiBookStore/book/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
                .antMatchers(HttpMethod.GET, "/apiBookStore/user/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
                .antMatchers(HttpMethod.DELETE, "/apiBookStore/book/**").hasAnyRole(ApplicationUserRole.SUPER_ADMIN.name())
                .antMatchers("/apiBookStore/book/**").permitAll()
                .anyRequest()
                .authenticated()
                .and()
                .httpBasic();
    }


    /**
     * owner: https://youtu.be/her_7pa0vrg
     * function: This method add any user and role.
     * <p>
     * Ustozni methodi
     * BU metod user va rollarni qushadi.
     *
     * @return
     */
    @Override
    @Bean
    protected UserDetailsService userDetailsService() {
        UserDetails admin = User.builder()
                .username("linda")
                .password(passwordEncoder().encode("root123"))
                .roles(ApplicationUserRole.ADMIN.name())
                .build();
        UserDetails super_admin = User.builder()
                .username("tom")
                .password(passwordEncoder().encode("tom123"))
                .roles(ApplicationUserRole.SUPER_ADMIN.name())
                .build();

        return new InMemoryUserDetailsManager(admin,super_admin);
    }
}
