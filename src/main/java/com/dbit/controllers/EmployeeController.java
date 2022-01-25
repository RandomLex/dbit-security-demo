package com.dbit.controllers;

import com.dbit.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;

@Controller
@RequestMapping(path = "/info")
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping
    public ModelAndView getAll(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
//        Principal principal = (Principal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String name = principal.getName();
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("principal", principal);
        modelAndView.setViewName("employees");
        return modelAndView;
    }
}
