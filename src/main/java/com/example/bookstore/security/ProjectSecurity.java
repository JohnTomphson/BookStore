package com.example.bookstore.security;//package com.example.demoatm.security;

import com.example.bookstore.jwt.JwtFilter;
import com.example.bookstore.models.enums.ApplicationUserRole;
import com.example.bookstore.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true, jsr250Enabled = true)
@RequiredArgsConstructor
public class ProjectSecurity extends WebSecurityConfigurerAdapter {

    private final AuthService authService;


    private final JwtFilter jwtFilter;


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
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http
//                .csrf().disable()
//                .cors().disable()
//                 .authorizeRequests()
//                .antMatchers(HttpMethod.POST, "/apiBookStore/book/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
//                .antMatchers(HttpMethod.PUT, "/apiBookStore/book/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
//                .antMatchers(HttpMethod.GET, "/apiBookStore/user/**").hasAnyRole(ApplicationUserRole.ADMIN.name())
//                .antMatchers(HttpMethod.DELETE, "/apiBookStore/book/**").hasAnyRole(ApplicationUserRole.SUPER_ADMIN.name())
//                .antMatchers("/apiBookStore/book/**").permitAll()
//                .anyRequest()
//                .authenticated()
//                .and()
//                .httpBasic();
//    }


    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.
                cors().and().csrf().disable()
                .sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                .and()
                .authorizeRequests()
                .antMatchers(HttpMethod.GET,"/apiBookStore/book/**").permitAll()
                .antMatchers(HttpMethod.POST,"/apiBookStore/auth/login/**").permitAll()
                .anyRequest()
                .authenticated();

        http.addFilterBefore(jwtFilter, UsernamePasswordAuthenticationFilter.class);

    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(authService);
    }


    @Bean
    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
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
//    @Override
//    @Bean
//    protected UserDetailsService userDetailsService() {
//        UserDetails admin = User.builder()
//                .username("linda")
//                .password(passwordEncoder().encode("root123"))
//                .roles(ApplicationUserRole.ADMIN.name())
//                .build();
//        UserDetails super_admin = User.builder()
//                .username("tom")
//                .password(passwordEncoder().encode("tom123"))
//                .roles(ApplicationUserRole.SUPER_ADMIN.name())
//                .build();
//
//        return new InMemoryUserDetailsManager(admin,super_admin);
//    }
}

