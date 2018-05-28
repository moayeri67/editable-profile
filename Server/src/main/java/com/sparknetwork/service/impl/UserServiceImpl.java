package com.sparknetwork.service.impl;

import com.sparknetwork.dao.intrface.IUserDao;
import com.sparknetwork.dto.inputentity.UserVO;
import com.sparknetwork.entity.User;
import com.sparknetwork.service.intrface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/20/2018, 02:19 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Service
public class UserServiceImpl implements IUserService {
    @Autowired
    private IUserDao userDao_;


    @Override
    public boolean signUp(UserVO userRegister) {
        return userDao_.signUp(userRegister);
    }

    @Override
    public User getUserByUserName(String userName) {
        return userDao_.getUserByUserName(userName);
    }
}
