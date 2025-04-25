package com.example.spring_boot.controller;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
public class TeslaController {
    @GetMapping("/cars/{id}")
    @ResponseBody
    public String getCars(@PathVariable int id) {
        return "Tesla Model Y Plaid"+id;
    }
}
