package com.example.parallel.parallelApp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class ApplicationController {
    @RequestMapping (value = "/retrieve",method = RequestMethod.GET)
    public String handler() {
        return "hello beta";
    }
}
