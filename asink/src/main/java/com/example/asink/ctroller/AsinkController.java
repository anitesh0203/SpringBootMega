package com.example.asink.ctroller;

import com.example.asink.AsinkHelper;
import com.example.asink.model.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class AsinkController {

    @Autowired
    AsinkHelper asinkHelper;

    @GetMapping("/provide")
    public List<Fact> controlMe() {
        return asinkHelper.helper();
    }
}
