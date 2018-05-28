package com.sparknetwork.dao.intrface;

import com.sparknetwork.dto.inputentity.UserVO;
import com.sparknetwork.entity.User;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/20/2018, 02:22 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
public interface IUserDao
{
    boolean signUp(UserVO userRegister);

    int getUserId(String userName);

    User getUserByUserName(String userName);
}
