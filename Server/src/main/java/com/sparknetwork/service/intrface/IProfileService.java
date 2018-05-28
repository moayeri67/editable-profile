package com.sparknetwork.service.intrface;


import com.sparknetwork.dto.inputentity.ProfileVO;
import com.sparknetwork.entity.Profile;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 12:46 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
public interface IProfileService
{
    Profile getProfileById(int id);

    void updateProfile(ProfileVO profile);

    void updateProfileImage(Profile profile);
}
