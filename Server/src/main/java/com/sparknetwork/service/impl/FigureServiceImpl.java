package com.sparknetwork.service.impl;

import com.sparknetwork.dao.intrface.IFigureDao;
import com.sparknetwork.entity.Figure;
import com.sparknetwork.service.intrface.IFigureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:31 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Service
public class FigureServiceImpl implements IFigureService
{
    @Autowired
    private IFigureDao figureDao_;



    @Override
    public List<Figure> getAllFigures()
    {
        return figureDao_.getAllFigures();
    }
}
