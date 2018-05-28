package com.sparknetwork.dao.impl;

import com.sparknetwork.dao.intrface.IProfileDao;
import com.sparknetwork.dto.inputentity.ProfileVO;
import com.sparknetwork.entity.Profile;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;
import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 11:17 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Transactional
@Repository
public class ProfileDaoImpl implements IProfileDao
{
    @PersistenceContext
    private EntityManager entityManager_;



    @Override
    public Profile getProfileById(int id)
    {
        String hql = "FROM Profile as prof WHERE prof.userId = :userId";

        try {
            Profile profile = ((List<Profile>) entityManager_.createQuery(hql).setParameter("userId", id).getResultList()).get(0);

            return profile;
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
            return null;
        }
    }



    @Override
    public void updateProfile(ProfileVO profileVO)
    {
        String hql = "UPDATE Profile as prof SET prof.userId = :userId, prof.displayName = :displayName, prof.realName = :realName, " +
                "prof.birthday = :birthday, prof.gender = :gender, prof.ethnicity = :ethnicity, " +
                "prof.religion = :religion, prof.figure = :figure, prof.maritalStatus = :maritalStatus, prof.occupation = :occupation, " +
                "prof.aboutMe = :aboutMe, prof.location = :location WHERE prof.userId = :userId";

        Profile profile = new Profile(profileVO);
        try {
            entityManager_.createQuery(hql).setParameter("userId", profile.getUserId())
                    .setParameter("displayName", profile.getDisplayName())
                    .setParameter("realName", profile.getRealName())
                    .setParameter("birthday", profile.getBirthday())
                    .setParameter("gender", profile.getGender())
                    .setParameter("ethnicity", profile.getEthnicity())
                    .setParameter("religion", profile.getReligion())
                    .setParameter("figure", profile.getFigure())
                    .setParameter("maritalStatus", profile.getMaritalStatus())
                    .setParameter("occupation", profile.getOccupation())
                    .setParameter("aboutMe", profile.getAboutMe())
                    .setParameter("location", profile.getLocation()).executeUpdate();
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }



    @Override
    public void updateProfileImage(Profile profile)
    {
        String hql = "UPDATE Profile as prof SET prof.imageName = :imageName WHERE prof.userId = :userId";
        try {
            entityManager_.createQuery(hql).setParameter("userId", profile.getUserId())
                    .setParameter("imageName", profile.getImageName()).executeUpdate();
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}
