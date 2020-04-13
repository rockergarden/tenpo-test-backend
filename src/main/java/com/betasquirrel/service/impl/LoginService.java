package com.betasquirrel.service.impl;

import com.betasquirrel.model.ListResponse;
import com.betasquirrel.model.User;
import com.betasquirrel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Component("loginService")
public class LoginService implements com.betasquirrel.service.LoginService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public ListResponse login(User user, HttpServletResponse http) {
        ListResponse response = new ListResponse();
        try {
            response.setStatusCode(http.getStatus());
            User findedUser = userRepository.findByEmail(user.getEmail());
            if (findedUser == null) {
                response.setStatusCode(404);
                response.setMessage("Usuario no encontrado");
            } else {
                findedUser.setToken(UUID.randomUUID().toString());
                User result =  userRepository.save(findedUser);
                result.setPassword("");
                List<User> data = new ArrayList<>();
                data.add(result);
                response.setStatusCode(200);
                response.setData(data);
                response.setMessage(String.format("Usuario encontrado", user.getEmail()));
            }
        } catch (Exception ex) {
            response.setStatusCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @Override
    public ListResponse logout(User user, HttpServletResponse http) {
        ListResponse response = new ListResponse();
        try {
            response.setStatusCode(http.getStatus());
            User findedUser = userRepository.findByEmail(user.getEmail());
            if (findedUser == null) {
                response.setStatusCode(404);
                response.setMessage("Usuario no encontrado");
            } else {
                findedUser.setToken(null);
                User result = userRepository.save(findedUser);
                result.setPassword("");
                List<User> data = new ArrayList<>();
                data.add(result);
                response.setStatusCode(200);
                response.setData(data);
                response.setMessage(String.format("Usuario %s logout", user.getEmail()));
            }
        } catch (Exception ex) {
            response.setStatusCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}
