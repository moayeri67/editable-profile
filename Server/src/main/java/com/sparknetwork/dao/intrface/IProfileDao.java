package com.sparknetwork.dao.intrface;

import com.sparknetwork.dto.inputentity.ProfileVO;
import com.sparknetwork.entity.Profile;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 11:16 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
public interface IProfileDao
{
    Profile getProfileById(int id);

    void updateProfile(ProfileVO profile);

    void updateProfileImage(Profile profile);
}
