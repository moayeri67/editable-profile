package com.sparknetwork.service.impl;

import com.sparknetwork.dao.intrface.IMaritalStatusDao;
import com.sparknetwork.entity.MaritalStatus;
import com.sparknetwork.service.intrface.IMaritalStatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:43 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Service
public class MaritalServiceImpl implements IMaritalStatusService
{
    @Autowired
    private IMaritalStatusDao maritalStatusDao_;



    @Override
    public List<MaritalStatus> getAllMaritalStatus()
    {
        return maritalStatusDao_.getAllMaritalStatus();
    }
}
