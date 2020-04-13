package com.betasquirrel.service;

import com.betasquirrel.model.ListResponse;
import com.betasquirrel.model.MathRequest;
import com.betasquirrel.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

public interface CalculatorService {

    public ListResponse sum(@RequestBody MathRequest mathRequest, HttpServletResponse http);

    public ListResponse listHistory(@RequestBody User user, HttpServletResponse http);
}
