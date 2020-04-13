package com.criverostenpo.service.impl;

import com.criverostenpo.model.*;
import com.criverostenpo.repository.LogMathOperationsRepository;
import com.criverostenpo.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Component("calculatorService")
public class CalculatorService implements com.criverostenpo.service.CalculatorService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    LogMathOperationsRepository logMathOperationsRepository;

    @Override
    public ListResponse sum(MathRequest mathRequest, HttpServletResponse http) {
        User user = mathRequest.getUser();
        MathInput mathInput = mathRequest.getMathInput();
        ListResponse response = new ListResponse();
        try {
            response.setStatusCode(http.getStatus());
            User findedUser = userRepository.findByEmailAndToken(user.getEmail(), user.getToken());
            if (findedUser == null) {
                response.setStatusCode(401);
                response.setMessage("acceso restringido");
            } else {
                LogMathOperations logMathOperations = new LogMathOperations();
                logMathOperations.setUserid(findedUser.getId());
                logMathOperations.setEmail(findedUser.getEmail());
                logMathOperations.setOperation(mathInput.getValue1().toString() + " + " + mathInput.getValue2().toString());
                logMathOperationsRepository.save(logMathOperations);
                response.setStatusCode(200);
                response.setMessage(String.format("El resultado es: %s", (mathInput.getValue1() + mathInput.getValue2())));
            }
        } catch (Exception ex) {

            response.setStatusCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }

    @Override
    public ListResponse listHistory(User user, HttpServletResponse http) {

        ListResponse response = new ListResponse();
        try {
            response.setStatusCode(http.getStatus());
            User findedUser = userRepository.findByEmailAndToken(user.getEmail(), user.getToken());
            if (findedUser == null) {
                response.setStatusCode(401);
                response.setMessage("acceso restringido");
            } else {
                List<LogMathOperations> logMathOperations = logMathOperationsRepository.findByEmail(findedUser.getEmail());
                response.setData(logMathOperations);
                response.setStatusCode(200);
                response.setMessage(String.format("Registros obtenidos"));
            }
        } catch (Exception ex) {

            response.setStatusCode(500);
            response.setMessage(ex.getMessage());
        }
        return response;
    }
}
