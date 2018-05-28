package com.sparknetwork.dao.impl;

import com.sparknetwork.dao.intrface.IUserDao;
import com.sparknetwork.dto.inputentity.UserVO;
import com.sparknetwork.entity.Profile;
import com.sparknetwork.entity.User;
import com.sparknetwork.entity.UserRole;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/20/2018, 02:23 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Transactional
@Repository
public class UserDaoImpl implements IUserDao {
    @PersistenceContext
    private EntityManager entityManager;


    @Override
    public boolean signUp(UserVO userVO) {
        try {
            User user = new User(userVO);


            entityManager.persist(user);

            Profile userProfile = new Profile();
            userProfile.setUserId(getUserId(user.getUsername()));
            userProfile.setHeight(userVO.getHeight());

            entityManager.persist(userProfile);

            UserRole userRole = new UserRole();
            userRole.setUsername(user.getUsername());
            userRole.setRole("ROLE_USER");

            entityManager.persist(userRole);
            return true;
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            return false;
        }
    }


    @Override
    public int getUserId(String userName) {
        try {
            return getUserByUserName(userName).getId();
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            return 0;
        }
    }


    @Override
    public User getUserByUserName(String userName) {
        try {
            String hql = "FROM User WHERE user_name = :userName";

            Query query = entityManager.createQuery(hql);

            query.setParameter("userName", userName);

            return ((User) query.getResultList().get(0));
        } catch (Exception exp) {
            System.out.println(exp.getMessage());
            return null;
        }
    }
}