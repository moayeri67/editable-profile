package com.sparknetwork.service.impl;

import com.sparknetwork.dao.intrface.IProfileDao;
import com.sparknetwork.dto.inputentity.ProfileVO;
import com.sparknetwork.entity.Profile;
import com.sparknetwork.service.intrface.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 12:47 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Service
public class ProfileServiceImpl implements IProfileService
{
    @Autowired
    private IProfileDao profileDao_;



    @Override
    public Profile getProfileById(int id)
    {
        return profileDao_.getProfileById(id);
    }



    @Override
    public void updateProfile(ProfileVO profile)
    {
        profileDao_.updateProfile(profile);
    }



    @Override
    public void updateProfileImage(Profile profile)
    {
        profileDao_.updateProfileImage(profile);
    }
}
