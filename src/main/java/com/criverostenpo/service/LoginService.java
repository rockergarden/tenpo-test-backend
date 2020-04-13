package com.criverostenpo.service;

import com.criverostenpo.model.ListResponse;
import com.criverostenpo.model.User;

import javax.servlet.http.HttpServletResponse;


public interface LoginService {
    public ListResponse login(User user, HttpServletResponse http);

    public ListResponse logout(User user, HttpServletResponse http);

}
