package com.betasquirrel.controller;

import com.betasquirrel.model.ListResponse;
import com.betasquirrel.model.ObjectResponse;
import com.betasquirrel.model.User;
import com.betasquirrel.repository.UserRepository;
import com.betasquirrel.service.impl.UsersService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;


@RestController
@EnableAutoConfiguration
@Api(value="API Usuarios", description="Operaciones relacionadas con creación, autenticación y listado de usuarios")
@RequestMapping("/api/v1/users")
public class UsersController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UsersService usersService;

    @ApiOperation(value = "Lista de usuarios registrados", response = ListResponse.class)
    @RequestMapping(method = RequestMethod.GET)
    public ListResponse getAllUsers(HttpServletResponse http) {
        return usersService.getAllUsers(http);
    }

    @ApiOperation(value = "Registro de nuevos usuarios", response = ListResponse.class)
    @RequestMapping(method = RequestMethod.POST)
    public ListResponse singUp(@RequestBody final User user, HttpServletResponse http) {
        return usersService.singUp(user, http);
    }

    @ApiOperation(value = "Obtiene un usuario especifico a partir de su id", response = ObjectResponse.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public ObjectResponse getUser(@PathVariable("id") Integer userId, HttpServletResponse http) {
        return usersService.getUser(userId, http);
    }

    @ApiOperation(value = "Actualiza un usuario especifico a partir de objeto user", response = ObjectResponse.class)
    @RequestMapping(method = RequestMethod.PUT)
    public ObjectResponse updateUser(@RequestBody final User user, HttpServletResponse http) {
        return usersService.updateUser(user, http);
    }

    @ApiOperation(value = "Elimina un usuario especifico a partir de su id", response = ListResponse.class)
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public ListResponse deleteUser(@PathVariable("id") Integer userId, HttpServletResponse http) {
        return usersService.deleteUser(userId, http);
    }
}
