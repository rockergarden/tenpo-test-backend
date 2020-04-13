package com.betasquirrel.service;

import com.betasquirrel.model.ListResponse;
import com.betasquirrel.model.User;

import javax.servlet.http.HttpServletResponse;


public interface LoginService {
    public ListResponse login(User user, HttpServletResponse http);

    public ListResponse logout(User user, HttpServletResponse http);

}
