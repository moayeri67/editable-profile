package com.sparknetwork.dao.impl;

import com.sparknetwork.dao.intrface.IEthnicityDao;
import com.sparknetwork.entity.Ethnicity;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:19 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Transactional
@Repository
public class EthnicityDaoImpl implements IEthnicityDao
{
    @PersistenceContext
    private EntityManager entityManager_;



    @Override
    public List<Ethnicity> getAllEthnicity()
    {
        String hql = "FROM Ethnicity";

        return (List<Ethnicity>) entityManager_.createQuery(hql).getResultList();
    }
}
