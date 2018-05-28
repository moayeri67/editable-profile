package com.sparknetwork.entity;

import com.sparknetwork.dto.inputentity.UserVO;

import javax.persistence.*;
import java.io.Serializable;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/20/2018, 02:29 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Entity
@Table(name = "users")
public class User implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "user_id")
    private int id;

    @Column(name = "user_name")
    private String username;

    @Column(name = "password")
    private String password;

    @Column(name = "enabled")
    private int enabled;

    @Column(name = "email")
    private String email;



    public User()
    {
    }



    public User(UserVO userVO)
    {
        this.username = userVO.getUsername();
        this.password = userVO.getPassword();
        this.email = userVO.getEmail();
        this.enabled = 1;
    }



    public int getId()
    {
        return id;
    }



    public void setId(int id)
    {
        this.id = id;
    }



    public String getUsername()
    {
        return username;
    }



    public void setUsername(String username)
    {
        this.username = username;
    }



    public String getPassword()
    {
        return password;
    }



    public void setPassword(String password)
    {
        this.password = password;
    }



    public int getEnabled()
    {
        return enabled;
    }



    public void setEnabled(int enabled)
    {
        this.enabled = enabled;
    }



    public String getEmail()
    {
        return email;
    }



    public void setEmail(String email)
    {
        this.email = email;
    }

}
