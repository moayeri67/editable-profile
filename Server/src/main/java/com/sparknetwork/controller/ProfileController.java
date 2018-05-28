package com.sparknetwork.controller;

import com.sparknetwork.dto.ProfileDTO;
import com.sparknetwork.dto.inputentity.ProfileVO;
import com.sparknetwork.entity.Profile;
import com.sparknetwork.service.intrface.IProfileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/22/2018, 12:49 PM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@RestController
@RequestMapping("api")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class ProfileController
{
    @Autowired
    private IProfileService profileService_;


    private Path rootLocation = Paths.get("upload-dir");



    public ProfileController()
    {
        try {
            Files.createDirectory(rootLocation);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }



    @GetMapping("getProfileById")
    public ProfileDTO getProfileById(int userId)
    {
        return new ProfileDTO(profileService_.getProfileById(userId));
    }



    @PostMapping("uploadProfileImage")
    public void uploadProfileImage(@RequestParam("file") MultipartFile profilePicture, @RequestParam("userId") String userId)
    {
        try {
            Files.copy(profilePicture.getInputStream(), this.rootLocation.resolve(profilePicture.getOriginalFilename()));

            Profile profile = new Profile();

            profile.setUserId(Integer.parseInt(userId));
            profile.setImageName(profilePicture.getOriginalFilename());

            profileService_.updateProfileImage(profile);
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
        }
    }



    @PostMapping
    @RequestMapping("updateProfile")
    public boolean updateProfile(@RequestBody ProfileVO profileVO)
    {
        try {
            profileService_.updateProfile(profileVO);
            return true;
        }
        catch (Exception exp) {
            System.out.println(exp.getMessage());
            return false;
        }
    }



    @GetMapping("getImage")
    @ResponseBody
    public ResponseEntity<Resource> getFile(int userId)
    {
        Profile profile = profileService_.getProfileById(userId);
        Resource file = loadFile(profile.getImageName());
        return ResponseEntity.ok().header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename\"" + file.getFilename() + "\"").body(file);
    }



    private Resource loadFile(String fileName)
    {
        try {
            Path file = rootLocation.resolve(fileName);

            Resource resource = new UrlResource(file.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            }
            else {
                throw new RuntimeException("FAIL!");
            }
        }
        catch (MalformedURLException exp) {
            throw new RuntimeException("FAIL!");
        }
    }
}
