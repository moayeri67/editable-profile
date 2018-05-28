package com.sparknetwork.dao.impl;

import com.sparknetwork.dao.intrface.IGenderDao;
import com.sparknetwork.entity.Gender;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:34 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Transactional
@Repository
public class GenderDaoImpl implements IGenderDao
{
    @PersistenceContext
    private EntityManager entityManager_;



    @Override
    public List<Gender> getAllGender()
    {
        String hql = "FROM Gender";
        return (List<Gender>) entityManager_.createQuery(hql).getResultList();
    }
}
