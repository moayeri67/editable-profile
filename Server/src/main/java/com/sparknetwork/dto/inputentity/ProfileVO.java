package com.sparknetwork.dto.inputentity;

import org.springframework.web.multipart.MultipartFile;

import java.util.Date;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/21/2018, 01:06 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
public class ProfileVO {
    private int userId;

    private String displayName;

    private String realName;

    private String birthday;

    private int gender;

    private int ethnicity;

    private int religion;

    private int figure;

    private int maritalStatus;

    private String occupation;

    private String aboutMe;

    private int location;

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }



    public String getBirthday()
    {
        return birthday;
    }



    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }



    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getEthnicity() {
        return ethnicity;
    }

    public void setEthnicity(int ethnicity) {
        this.ethnicity = ethnicity;
    }

    public int getReligion() {
        return religion;
    }

    public void setReligion(int religion) {
        this.religion = religion;
    }

    public int getFigure() {
        return figure;
    }

    public void setFigure(int figure) {
        this.figure = figure;
    }

    public int getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(int maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public String getOccupation() {
        return occupation;
    }

    public void setOccupation(String occupation) {
        this.occupation = occupation;
    }

    public String getAboutMe() {
        return aboutMe;
    }

    public void setAboutMe(String aboutMe) {
        this.aboutMe = aboutMe;
    }

    public int getLocation() {
        return location;
    }

    public void setLocation(int location) {
        this.location = location;
    }
}
