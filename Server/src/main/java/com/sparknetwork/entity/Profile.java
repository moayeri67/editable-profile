package com.sparknetwork.entity;

import com.sparknetwork.dto.inputentity.ProfileVO;
import sun.reflect.generics.repository.GenericDeclRepository;

import javax.persistence.*;
import java.util.Date;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/21/2018, 12:24 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@Entity
@Table(name = "profile")
public class Profile
{
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "profile_id")
    private int id;

    @Column(name = "user_id")
    private int userId;

    @Column(name = "display_name")
    private String displayName;

    @Column(name = "real_name")
    private String realName;

    @Column(name = "image_name")
    private String imageName;

    @Column(name = "birthday")
    private String birthday;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "gender")
    private Gender gender;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ethnicity")
    private Ethnicity ethnicity;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "religion")
    private Religion religion;

    @Column(name = "height")
    private int height;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "figure")
    private Figure figure;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "marital_status")
    private MaritalStatus maritalStatus;

    @Column(name = "occupation")
    private String occupation;

    @Column(name = "about_me")
    private String aboutMe;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "location")
    private City location;



    public Profile()
    {

    }



    public Profile(ProfileVO profileVO)
    {
        Gender gender = new Gender();
        gender.setId(profileVO.getGender());

        Ethnicity ethnicity = new Ethnicity();
        ethnicity.setId(profileVO.getEthnicity());

        Religion religion = new Religion();
        religion.setId(profileVO.getReligion());

        Figure figure = new Figure();
        figure.setId(profileVO.getFigure());

        MaritalStatus maritalStatus = new MaritalStatus();
        maritalStatus.setId(profileVO.getMaritalStatus());

        City city = new City();
        city.setId(profileVO.getLocation());

        this.userId = profileVO.getUserId();
        this.displayName = profileVO.getDisplayName();
        this.realName = profileVO.getRealName();
        this.birthday = profileVO.getBirthday();
        this.gender = gender;
        this.ethnicity = ethnicity;
        this.religion = religion;
        this.figure = figure;
        this.maritalStatus = maritalStatus;
        this.setOccupation(profileVO.getOccupation());
        this.setAboutMe(profileVO.getAboutMe());
        this.location = city;
    }



    public int getId()
    {
        return id;
    }



    public void setId(int id)
    {
        this.id = id;
    }



    public int getUserId()
    {
        return userId;
    }



    public void setUserId(int userId)
    {
        this.userId = userId;
    }



    public String getDisplayName()
    {
        return displayName;
    }



    public void setDisplayName(String displayName)
    {
        this.displayName = displayName;
    }



    public String getRealName()
    {
        return realName;
    }



    public void setRealName(String realName)
    {
        this.realName = realName;
    }



    public String getImageName()
    {
        return imageName;
    }



    public void setImageName(String imageName)
    {
        this.imageName = imageName;
    }



    public String getBirthday()
    {
        return birthday;
    }



    public void setBirthday(String birthday)
    {
        this.birthday = birthday;
    }



    public Gender getGender()
    {
        return gender;
    }



    public void setGender(Gender gender)
    {
        this.gender = gender;
    }



    public Ethnicity getEthnicity()
    {
        return ethnicity;
    }



    public void setEthnicity(Ethnicity ethnicity)
    {
        this.ethnicity = ethnicity;
    }



    public Religion getReligion()
    {
        return religion;
    }



    public void setReligion(Religion religion)
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



    public Figure getFigure()
    {
        return figure;
    }



    public void setFigure(Figure figure)
    {
        this.figure = figure;
    }



    public MaritalStatus getMaritalStatus()
    {
        return maritalStatus;
    }



    public void setMaritalStatus(MaritalStatus maritalStatus)
    {
        this.maritalStatus = maritalStatus;
    }



    public String getOccupation()
    {
        return occupation;
    }



    public void setOccupation(String occupation)
    {
        this.occupation = occupation;
    }



    public String getAboutMe()
    {
        return aboutMe;
    }



    public void setAboutMe(String aboutMe)
    {
        this.aboutMe = aboutMe;
    }



    public City getLocation()
    {
        return location;
    }



    public void setLocation(City location)
    {
        this.location = location;
    }
}
