package org.springsandbox.security.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springsandbox.core.configuration.DbConfiguration;

import javax.sql.DataSource;

@Configuration
@ComponentScan("org.springsandbox.security")
@EnableWebSecurity()
@EnableJpaRepositories("org.springsandbox.security.repo")
@EntityScan("org.springsandbox.security.repo.entity")
@Import(DbConfiguration.class)
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserDetailsService userDetailsService;


    private PasswordEncoder passwordEncoder;

    @Bean
    public PasswordEncoder standardPasswordEncoder() {
        passwordEncoder = new BCryptPasswordEncoder();
        return passwordEncoder;
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth
                .userDetailsService(userDetailsService)
                .passwordEncoder(passwordEncoder);
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .csrf().disable()
                //.cors().disable()
                .authorizeRequests()
                    //.antMatchers("/index", "/contractors", "/app").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/app/**", "/api/**").hasAnyRole("USER", "ADMIN")
                    .antMatchers("/images/**", "/test", "/build/**").permitAll()
                .and()
                    .formLogin()
                    .loginPage("/login")
                    .defaultSuccessUrl("http://localhost:8080", false);
                    //.defaultSuccessUrl("/index")

    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        super.configure(web);
    }




}
