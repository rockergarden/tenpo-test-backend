package com.criverostenpo.service;

import com.criverostenpo.model.ListResponse;
import com.criverostenpo.model.ObjectResponse;
import com.criverostenpo.model.User;
import javax.servlet.http.HttpServletResponse;


public interface UsersService {
    public ListResponse singUp(User user, HttpServletResponse http);

    public ListResponse getAllUsers(HttpServletResponse http);

    public ObjectResponse getUser(Integer userId, HttpServletResponse http);

    public ObjectResponse updateUser(User user, HttpServletResponse http);

    public ListResponse deleteUser(Integer userId, HttpServletResponse http);
}
