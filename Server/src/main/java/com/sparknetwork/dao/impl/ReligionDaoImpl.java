package com.sparknetwork.dao.impl;

import com.sparknetwork.dao.intrface.IReligionDao;
import com.sparknetwork.entity.Religion;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:45 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Transactional
@Repository
public class ReligionDaoImpl implements IReligionDao
{
    @PersistenceContext
    private EntityManager entityManager_;



    @Override
    public List<Religion> getAllReligions()
    {
        String hql = "FROM Religion";

        return (List<Religion>) entityManager_.createQuery(hql).getResultList();
    }
}
