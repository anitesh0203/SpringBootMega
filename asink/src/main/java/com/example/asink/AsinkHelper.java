package com.example.asink;

import com.example.asink.model.Fact;
import com.example.asink.services.AsinkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CompletableFuture;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.Collectors;

@Component
public class AsinkHelper {
    @Autowired
    AsinkService asinkService;
    public List<Fact> helper() {
        List<CompletableFuture<Fact>> listOfFutures = new ArrayList<>();

        ExecutorService executorService = Executors.newFixedThreadPool(10);
        for (int i =0 ;i<10 ;i++ ) {
            CompletableFuture<Fact> completableFuture =
                    CompletableFuture.supplyAsync(()->{
                        //call the dao layer
                        return asinkService.detailsMethod();
                    },executorService);
            listOfFutures.add(completableFuture);
        }

        List<Fact> ans = listOfFutures.stream().map(CompletableFuture::join).collect(Collectors.toList());

        return ans;

    }
}
