package com.sparknetwork.controller;

import com.sparknetwork.dto.TokenDTO;
import com.sparknetwork.dto.inputentity.UserVO;
import com.sparknetwork.service.intrface.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 05/20/2018, 09:52 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
@RestController
@RequestMapping("api")
@CrossOrigin(origins = {"http://localhost:4200", "http://localhost:4201"})
public class SecurityController
{
    @Autowired
    private IUserService userService_;



    @GetMapping("login")
    TokenDTO login(String username, HttpSession session)
    {
        TokenDTO tokenDTO = new TokenDTO();
        tokenDTO.setUserId(userService_.getUserByUserName(username).getId());
        tokenDTO.setUserName(username);
        tokenDTO.setTokenId(session.getId());
        return tokenDTO;
    }



    @PostMapping
    @RequestMapping("signup")
    boolean signUp(@RequestBody UserVO userRegister)
    {
        return userService_.signUp(userRegister);
    }
}
