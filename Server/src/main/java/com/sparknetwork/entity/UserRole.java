package com.sparknetwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/20/2018, 05:03 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Entity
@Table(name = "user_roles")
public class UserRole implements Serializable
{
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "user_role_id")
    private int id;

    @Column(name = "username")
    private String username;

    @Column(name = "role")
    private String role;



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



    public String getRole()
    {
        return role;
    }



    public void setRole(String role)
    {
        this.role = role;
    }
}
