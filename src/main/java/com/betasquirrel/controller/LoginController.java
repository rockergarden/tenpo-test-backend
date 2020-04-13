package com.betasquirrel.controller;


import com.betasquirrel.model.ListResponse;
import com.betasquirrel.model.User;
import com.betasquirrel.repository.UserRepository;
import com.betasquirrel.service.impl.LoginService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;

@RestController
@EnableAutoConfiguration
@Api(value="API Login", description="Operaciones relacionadas con login y logout usuario")
@RequestMapping("/api/v1/login")
public class LoginController {
    @Autowired
    private UserRepository userRepository;

    @Autowired
    private LoginService loginService;

    @ApiOperation(value = "Servicio Login Usuario", response = ListResponse.class)
    @RequestMapping(method = RequestMethod.POST)
    public ListResponse loginUser(@RequestBody final User user, HttpServletResponse http) {
        return loginService.login(user, http);
    }

    @ApiOperation(value = "Servicio Logout Usuario", response = ListResponse.class)
    @RequestMapping(method = RequestMethod.PUT)
    public ListResponse logoutUser(@RequestBody final User user, HttpServletResponse http) {
        return loginService.logout(user, http);
    }
}
