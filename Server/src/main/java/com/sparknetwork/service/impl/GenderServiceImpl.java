package com.sparknetwork.service.impl;

import com.sparknetwork.dao.intrface.IGenderDao;
import com.sparknetwork.entity.Gender;
import com.sparknetwork.service.intrface.IGenderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:37 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Service
public class GenderServiceImpl implements IGenderService
{
    @Autowired
    private IGenderDao genderDao_;



    @Override
    public List<Gender> getAllGenders()
    {
        return genderDao_.getAllGender();
    }
}
