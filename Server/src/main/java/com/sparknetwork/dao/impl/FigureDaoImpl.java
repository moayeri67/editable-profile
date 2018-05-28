package com.sparknetwork.dao.impl;

import com.sparknetwork.dao.intrface.IFigureDao;
import com.sparknetwork.entity.Figure;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:28 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Transactional
@Repository
public class FigureDaoImpl implements IFigureDao
{
    @PersistenceContext
    private EntityManager entityManager_;



    @Override
    public List<Figure> getAllFigures()
    {
        String hql = "FROM Figure";
        return (List<Figure>) entityManager_.createQuery(hql).getResultList();
    }
}
