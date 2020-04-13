package com.betasquirrel.service;

import com.betasquirrel.model.ListResponse;
import com.betasquirrel.model.ObjectResponse;
import com.betasquirrel.model.User;
import javax.servlet.http.HttpServletResponse;


public interface UsersService {
    public ListResponse singUp(User user, HttpServletResponse http);

    public ListResponse getAllUsers(HttpServletResponse http);

    public ObjectResponse getUser(Integer userId, HttpServletResponse http);

    public ObjectResponse updateUser(User user, HttpServletResponse http);

    public ListResponse deleteUser(Integer userId, HttpServletResponse http);
}
