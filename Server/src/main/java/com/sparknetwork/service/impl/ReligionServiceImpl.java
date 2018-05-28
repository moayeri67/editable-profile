package com.sparknetwork.service.impl;

import com.sparknetwork.dao.intrface.IReligionDao;
import com.sparknetwork.entity.Religion;
import com.sparknetwork.service.intrface.IReligionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:48 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Service
public class ReligionServiceImpl implements IReligionService
{
    @Autowired
    private IReligionDao religionDao_;



    @Override
    public List<Religion> getAllReligions()
    {
        return religionDao_.getAllReligions();
    }
}
