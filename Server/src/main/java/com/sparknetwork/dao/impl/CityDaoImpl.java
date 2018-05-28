package com.sparknetwork.dao.impl;

import com.sparknetwork.dao.intrface.ICityDao;
import com.sparknetwork.entity.City;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/21/2018, 02:54 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Transactional
@Repository
public class CityDaoImpl implements ICityDao
{
    @PersistenceContext
    private EntityManager entityManager_;



    @Override
    public List<City> getAllCities()
    {
        String hql = "FROM City";

        return (List<City>) entityManager_.createQuery(hql).getResultList();
    }



    @Override
    public void insertCity(City city)
    {
        try {
            entityManager_.persist(city);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }



    @Override
    public City getCityById(int id)
    {
        return null;
    }
}
