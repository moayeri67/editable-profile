package com.sparknetwork.dao.impl;

import com.sparknetwork.dao.intrface.IMaritalStatusDao;
import com.sparknetwork.entity.MaritalStatus;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:40 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Transactional
@Repository
public class MaritalStatusDaoImpl implements IMaritalStatusDao
{
    @PersistenceContext
    private EntityManager entityManager_;



    @Override
    public List<MaritalStatus> getAllMaritalStatus()
    {
        String hql = "From MaritalStatus";
        
        return (List<MaritalStatus>) entityManager_.createQuery(hql).getResultList();
    }
}
