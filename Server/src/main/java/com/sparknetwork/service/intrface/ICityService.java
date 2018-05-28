package com.sparknetwork.service.intrface;

import com.sparknetwork.entity.City;

import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/21/2018, 02:58 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
public interface ICityService
{
    List<City> getAllCities();

    void insertCity(City city);

    City getCityById(int id);
}
