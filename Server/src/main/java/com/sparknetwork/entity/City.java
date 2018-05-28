package com.sparknetwork.entity;

import javax.persistence.*;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/21/2018, 11:08 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Entity
@Table(name = "cities")
public class City
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "city_id")
    private int id;

    @Column(name = "lat")
    private String lat;

    @Column(name = "lon")
    private String lon;

    @Column(name = "city")
    private String city;



    public int getId()
    {
        return id;
    }



    public void setId(int id)
    {
        this.id = id;
    }



    public String getLat()
    {
        return lat;
    }



    public void setLat(String lat)
    {
        this.lat = lat;
    }



    public String getLon()
    {
        return lon;
    }



    public void setLon(String lon)
    {
        this.lon = lon;
    }



    public String getCity()
    {
        return city;
    }



    public void setCity(String city)
    {
        this.city = city;
    }
}
