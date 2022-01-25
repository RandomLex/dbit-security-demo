package com.dbit.controllers;

import com.dbit.dto.EmployeeDto;
import com.dbit.services.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.security.Principal;
import java.util.Optional;

@Controller
@RequestMapping
@RequiredArgsConstructor
public class EmployeeController {
    private final EmployeeService employeeService;

    @GetMapping(path = "/info")
    public ModelAndView getAll(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
//        Principal principal = (Principal)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
//        String name = principal.getName();
        modelAndView.addObject("employees", employeeService.findAll());
        modelAndView.addObject("principal", principal);
        modelAndView.setViewName("employees");
        return modelAndView;
    }

    @GetMapping(path = "/self")
    public ModelAndView employee(Principal principal) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("employee");
        modelAndView.addObject("principal", principal);
        Optional<EmployeeDto> employee = employeeService.findByName(principal.getName());
        employee.ifPresent(employeeDto -> modelAndView.addObject("employee", employeeDto));
        return modelAndView;
    }
}
