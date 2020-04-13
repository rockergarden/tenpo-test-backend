package com.criverostenpo.service;

import com.criverostenpo.model.ListResponse;
import com.criverostenpo.model.MathRequest;
import com.criverostenpo.model.User;
import org.springframework.web.bind.annotation.RequestBody;

import javax.servlet.http.HttpServletResponse;

public interface CalculatorService {

    public ListResponse sum(@RequestBody MathRequest mathRequest, HttpServletResponse http);

    public ListResponse listHistory(@RequestBody User user, HttpServletResponse http);
}
