package com.sparknetwork.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.session.ExpiringSession;
import org.springframework.session.MapSessionRepository;
import org.springframework.session.SessionRepository;
import org.springframework.session.config.annotation.web.http.EnableSpringHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 07/29/2017, 11:55 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Configuration
@EnableSpringHttpSession
public class HttpSessionConfig
{
    @Bean
    SessionRepository<ExpiringSession> inMemorySessionRepository()
    {
        return new MapSessionRepository();
    }



    @Bean
    HttpSessionStrategy httpSessionStrategy()
    {
        return new HeaderHttpSessionStrategy();
    }
}
