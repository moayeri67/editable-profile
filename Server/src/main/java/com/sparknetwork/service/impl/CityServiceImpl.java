package com.sparknetwork.service.impl;

import com.sparknetwork.dao.intrface.ICityDao;
import com.sparknetwork.entity.City;
import com.sparknetwork.service.intrface.ICityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/21/2018, 02:59 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Service
public class CityServiceImpl implements ICityService
{
    @Autowired
    ICityDao cityDao_;



    @Override
    public List<City> getAllCities()
    {
        return cityDao_.getAllCities();
    }



    @Override
    public void insertCity(City city)
    {
        cityDao_.insertCity(city);
    }



    @Override
    public City getCityById(int id)
    {
        return null;
    }
}
