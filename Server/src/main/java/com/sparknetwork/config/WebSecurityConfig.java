package com.sparknetwork.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.savedrequest.NullRequestCache;

import javax.sql.DataSource;


/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 07/29/2017, 12:22 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter
{
    @Autowired
    DataSource dataSource;



    @Override
    protected void configure(HttpSecurity http) throws Exception
    {
        http.authorizeRequests().antMatchers("/api/signup", "/api/uploadProfileImage", "/api/getImage/**").permitAll().anyRequest().authenticated() //
                .and().requestCache().requestCache(new NullRequestCache()) //
                .and().httpBasic() //
                .and().cors()
                .and().csrf().disable();
    }



    @Autowired
    void configureGlobal(AuthenticationManagerBuilder auth) throws Exception
    {
        auth.jdbcAuthentication().dataSource(dataSource)
                .usersByUsernameQuery("select user_name,password, enabled from users where user_name=?")
                .authoritiesByUsernameQuery("select username, role from user_roles where username=?");
    }
}
