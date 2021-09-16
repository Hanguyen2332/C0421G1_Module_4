package com.practice.config;

import com.practice.model.service.MyUserDetailServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.rememberme.InMemoryTokenRepositoryImpl;
import org.springframework.security.web.authentication.rememberme.PersistentTokenRepository;


@Configuration
@EnableWebSecurity
public class AppConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private MyUserDetailServiceImpl userDetailService;


    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(userDetailService).passwordEncoder(passwordEncoder());
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable()
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/home").permitAll()
                //phân quyền:
                .and()
                .authorizeRequests()
                .antMatchers("/blog/list").permitAll()

                .antMatchers("/search_by_title", "/search_by_category", "/view","/category")
                .hasAnyRole("USER","ADMIN")
                .antMatchers("/create", "/blog/edit", "/delete",
                        "/category/category_create","/category/category_edit","/category/category_delete").hasRole("ADMIN")
                .anyRequest().authenticated(); //all request gửi lên --> phải đc authentication;
        //remember me:
       http.authorizeRequests().and().rememberMe()
               .tokenRepository(this.persistentTokenRepository()).tokenValiditySeconds(60*60*24);
    }
    @Bean
    public PersistentTokenRepository persistentTokenRepository() {
        InMemoryTokenRepositoryImpl memoryTokenRepository = new InMemoryTokenRepositoryImpl();
        return memoryTokenRepository;
    }
}
