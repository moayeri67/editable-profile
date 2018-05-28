package com.sparknetwork.controller;

import com.sparknetwork.entity.*;
import com.sparknetwork.service.intrface.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 08:55 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@RestController
@RequestMapping("api")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class GetAttributesController
{
    @Autowired
    private ICityService cityService_;

    @Autowired
    private IEthnicityService ethnicityService_;

    @Autowired
    private IFigureService figureService_;

    @Autowired
    private IGenderService genderService_;

    @Autowired
    private IMaritalStatusService maritalStatusService_;

    @Autowired
    private IReligionService religionService_;



    @GetMapping("getAllCities")
    List<City> getAllCities()
    {
        return cityService_.getAllCities();
    }



    @GetMapping("getAllEthnicities")
    List<Ethnicity> getAllEthnicities()
    {
        return ethnicityService_.getAllEthnicity();
    }



    @GetMapping("getAllFigures")
    List<Figure> getAllFigures()
    {
        return figureService_.getAllFigures();
    }



    @GetMapping("getAllGenders")
    List<Gender> getAllGenders()
    {
        return genderService_.getAllGenders();
    }



    @GetMapping("getAllMaritalStatus")
    List<MaritalStatus> getAllMaritalStatus()
    {
        return maritalStatusService_.getAllMaritalStatus();
    }



    @GetMapping("getAllReligions")
    List<Religion> getAllReligions()
    {
        return religionService_.getAllReligions();
    }
}