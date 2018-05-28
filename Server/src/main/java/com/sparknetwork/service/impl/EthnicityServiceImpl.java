package com.sparknetwork.service.impl;

import com.sparknetwork.dao.intrface.IEthnicityDao;
import com.sparknetwork.entity.Ethnicity;
import com.sparknetwork.service.intrface.IEthnicityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:25 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Service
public class EthnicityServiceImpl implements IEthnicityService
{
    @Autowired
    private IEthnicityDao ethnicityDao_;



    @Override
    public List<Ethnicity> getAllEthnicity()
    {
        return ethnicityDao_.getAllEthnicity();
    }
}
