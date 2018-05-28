package service;

import com.google.gson.Gson;
import com.sparknetwork.dao.impl.CityDaoImpl;
import com.sparknetwork.service.impl.CityServiceImpl;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import com.sparknetwork.entity.City;

import java.io.FileReader;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/21/2018, 03:16 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
public class CityDaoTest
{
    private static CityDaoImpl cityDao;



    @BeforeClass
    public static void runBeforeClass()
    {
        cityDao = new CityDaoImpl();
    }



    @AfterClass
    public static void runAfterClass()
    {
        cityDao = null;
    }



    @Test
    public void insertCity()
    {
        try {
            JSONParser parser = new JSONParser();
            Gson gson = new Gson();

            Object obj = parser.parse(new FileReader("E:\\workSpace\\Spark Network\\coding_exercises_options-master\\editable_profile\\server\\en\\locations\\cities.json"));

            JSONObject jsonObject = (JSONObject) obj;

            JSONArray jsonArray = (JSONArray) jsonObject.get("cities");

            for (int i = 0; i < jsonArray.size(); i++) {
                City city = gson.fromJson(jsonArray.get(i).toString(), City.class);
                cityDao.insertCity(city);
            }
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }
}
