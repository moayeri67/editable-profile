package com.sparknetwork.dto;

import com.sparknetwork.entity.Profile;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/28/2018, 03:26 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
public class ProfileDTO
{
    private String displayName;
    private String birthday;
    private String gender;
    private String ethnicity;
    private String religion;
    private int height;
    private String figure;
    private String aboutMe;
    private String location;



    public ProfileDTO(Profile profile)
    {
        this.displayName = profile.getDisplayName();
        this.birthday = profile.getBirthday();
        this.gender = profile.getGender().getName();
        this.ethnicity = profile.getEthnicity().getName();
        this.religion = profile.getReligion().getName();
        this.height = profile.getHeight();
        this.figure = profile.getFigure().getName();
        this.aboutMe = profile.getAboutMe();
        this.location = profile.getLocation().getCity();
    }



    public String getDisplayName()
    {
        return displayName;
    }



    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }



    public String getBirthday()
    {
        return birthday;
    }



    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }



    public String getGender()
    {
        return gender;
    }



    public void setGender(String gender)
    {
        this.gender = gender;
    }



    public String getEthnicity()
    {
        return ethnicity;
    }



    public void setEthnicity(String ethnicity)
    {
        this.ethnicity = ethnicity;
    }



    public String getReligion()
    {
        return religion;
    }



    public void setReligion(String religion)
    {
        this.religion = religion;
    }



    public int getHeight()
    {
        return height;
    }



    public void setHeight(int height)
    {
        this.height = height;
    }



    public String getFigure()
    {
        return figure;
    }



    public void setFigure(String figure)
    {
        this.figure = figure;
    }



    public String getAboutMe()
    {
        return aboutMe;
    }



    public void setAboutMe(String aboutMe)
    {
        this.aboutMe = aboutMe;
    }



    public String getLocation()
    {
        return location;
    }



    public void setLocation(String location)
    {
        this.location = location;
    }
}
