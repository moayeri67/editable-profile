package com.sparknetwork.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/21/2018, 11:31 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Entity
@Table(name = "gender")
public class Gender
{
    public static final long serialVersionUID = 1l;

    @Id
    @Column(name = "gender_id")
    private int id;

    @Column(name = "name")
    private String name;



    public int getId()
    {
        return id;
    }



    public void setId(int id)
    {
        this.id = id;
    }



    public String getName()
    {
        return name;
    }



    public void setName(String name)
    {
        this.name = name;
    }
}
