package com.criverostenpo.controller;

import com.criverostenpo.model.ListResponse;
import com.criverostenpo.model.MathRequest;
import com.criverostenpo.model.User;
import com.criverostenpo.service.impl.CalculatorService;
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
@Api(value="API Calculator", description="Operaciones matemáticas")
@RequestMapping("/api/v1/calculator")
public class CalculatorController {

    @Autowired
    CalculatorService calculatorService;

    @ApiOperation(value = "Servicio Suma", response = ListResponse.class)
    @RequestMapping(method = RequestMethod.POST)
    public ListResponse sum(@RequestBody MathRequest mathRequest, HttpServletResponse http) {
        return calculatorService.sum(mathRequest,http);
    }

    @ApiOperation(value = "Historial Suma", response = ListResponse.class)
    @RequestMapping(method = RequestMethod.GET)
    public ListResponse sum(@RequestBody User user, HttpServletResponse http) {
        return calculatorService.listHistory(user, http);
    }

}
