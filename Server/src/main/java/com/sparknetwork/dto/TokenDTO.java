package com.sparknetwork.dto;

/**
 * Copyright (c) 2008-2015, Co. All rights reserved.
 * <p> 08/23/2017, 10:51 AM PM </p>
 * <p/>
 *
 * @author <a href="mailto:moayeri67@yahoo.com">Hamed Moayeri</a>
 */
public class TokenDTO
{
    private int userId_;
    private String userName_;
    private String tokenId_;



    public int getUserId()
    {
        return userId_;
    }



    public void setUserId(int userId)
    {
        this.userId_ = userId;
    }



    public String getUserName()
    {
        return userName_;
    }



    public void setUserName(String userName)
    {
        this.userName_ = userName;
    }



    public String getTokenId()
    {
        return tokenId_;
    }



    public void setTokenId(String tokenId)
    {
        tokenId_ = tokenId;
    }
}
