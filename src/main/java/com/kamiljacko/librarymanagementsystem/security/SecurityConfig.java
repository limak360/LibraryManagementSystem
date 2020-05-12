package com.kamiljacko.librarymanagementsystem.security;


import com.kamiljacko.librarymanagementsystem.auth.ApplicationAccountUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;


import static com.kamiljacko.librarymanagementsystem.security.ApplicationUserRole.*;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final ApplicationAccountUserService applicationAccountUserService;

    @Autowired
    public SecurityConfig(ApplicationAccountUserService applicationAccountUserService) {
        this.applicationAccountUserService = applicationAccountUserService;
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/**").permitAll()
//                .antMatchers("/save", "index", "/css/*", "/js/*").permitAll()
//                .antMatchers("/api/main").permitAll()
//                .antMatchers("/api/main/**").hasAnyRole(ADMIN.name(), LIBRARIAN.name(), MEMBER.name())
//                .antMatchers("/api/lib").hasRole(LIBRARIAN.name())
//                .antMatchers("/api/admin").hasRole(ADMIN.name())
                .anyRequest()
                .authenticated()
                .and()
                .formLogin()
                .loginPage("/users/login")
                .permitAll()
                .defaultSuccessUrl("/library/books", true)
                .and()
                .logout()
                .logoutRequestMatcher(new AntPathRequestMatcher("/users/logout"))
                .logoutSuccessUrl("/library/books")
                .invalidateHttpSession(true)
                .clearAuthentication(true)
                .deleteCookies("JSESSIONID");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(applicationAccountUserService);
    }
}