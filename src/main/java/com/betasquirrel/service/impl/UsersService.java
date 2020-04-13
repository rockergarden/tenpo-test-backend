package com.betasquirrel.service.impl;

import com.betasquirrel.model.ListResponse;
import com.betasquirrel.model.ObjectResponse;
import com.betasquirrel.model.User;
import com.betasquirrel.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.List;

@Component("usersService")
public class UsersService implements com.betasquirrel.service.UsersService
{
    @Autowired
    private UserRepository userRepository;

    @Override
    public ListResponse singUp(User user, HttpServletResponse http) {
        ListResponse response = new ListResponse();
        try {
            response.setStatusCode(http.getStatus());
            List<User> data = new ArrayList<>();
            User findedUser = userRepository.findByEmail(user.getEmail());
            if (findedUser == null) {
                userRepository.save(user);
                User dataUser = userRepository.findByEmail(user.getEmail());
                data.add(dataUser);
                response.setData(data);
                response.setMessage("Creado con exito!");
            } else {
                response.setStatusCode(404);
                response.setData(data);
                response.setMessage(String.format("El usuario con el correo %s ya existe", user.getEmail()));
            }
        } catch (Exception ex) {
            response.setStatusCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @Override
    public ListResponse getAllUsers(HttpServletResponse http) {
        ListResponse response = new ListResponse();
        response.setMessage("Successfully Retrieved");
        response.setStatusCode(http.getStatus());
        List<User> users = userRepository.findAll();
        response.setData(users);
        return response;
    }

    @Override
    public ObjectResponse getUser(Integer userId, HttpServletResponse http) {
        ObjectResponse response = new ObjectResponse();
        if (userRepository.exists(userId)) {
            response.setMessage("Successfully Retrieved");
            response.setStatusCode(http.getStatus());
            response.setData(userRepository.findOne(userId));
        } else {
            response.setMessage("Record not found");
            response.setStatusCode(404);
            response.setData(null);
        }
        return response;
    }

    @Override
    public ObjectResponse updateUser(User user, HttpServletResponse http) {
        ObjectResponse response = new ObjectResponse();
        if (userRepository.exists(user.getId())) {
            userRepository.updateUser(user.getName(), user.getEmail(), user.getMobile(), user.getId());
            response.setMessage("Successfully Updated");
            response.setStatusCode(http.getStatus());
            response.setData(userRepository.findOne(user.getId()));
        } else {
            response.setMessage("Record not found");
            response.setStatusCode(404);
            response.setData(null);
        }
        return response;
    }

    @Override
    public ListResponse deleteUser(Integer userId, HttpServletResponse http) {
        ListResponse response = new ListResponse();
        if(userRepository.exists(userId)) {
            userRepository.delete(userId);
            response.setStatusCode(http.getStatus());
            response.setMessage("Successfully Deleted");
        } else {
            response.setStatusCode(404);
            response.setMessage("Record not found");
        }
        List<User> users = userRepository.findAll();
        response.setData(users);
        return response;
    }
}
