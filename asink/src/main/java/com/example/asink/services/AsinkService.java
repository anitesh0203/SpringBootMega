package com.example.asink.services;

import com.example.asink.model.Fact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;

@Component
public class AsinkService {



    public Fact detailsMethod() {
        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<Fact> response = restTemplate.exchange("https://catfact.ninja/fact", HttpMethod.GET, null, Fact.class);
        return response.getBody();

    }
}
