package com.sparknetwork.config;

//import org.apache.ibatis.session.SqlSessionFactory;
//import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.stereotype.Repository;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 07/29/2017, 04:32 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Configuration
public class RestConfig
{
    @Bean(name = "datasource")
    public DriverManagerDataSource datasource(){
        DriverManagerDataSource driverManagerDataSource = new DriverManagerDataSource();
        driverManagerDataSource.setDriverClassName("com.mysql.jdbc.Driver");
        driverManagerDataSource.setUrl("jdbc:mysql://localhost:3306/editableprofile");
        driverManagerDataSource.setUsername("root");
        driverManagerDataSource.setPassword("");
        
        return driverManagerDataSource;
    }
}
