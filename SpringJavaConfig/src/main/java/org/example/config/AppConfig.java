package org.example.config;


import org.example.Market;
import org.example.Warehouse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.context.annotation.Scope;

@Configuration
public class AppConfig {

    @Bean
    public Market getMarket(){
        return  new Market();
    }
    @Bean
    @Primary
    //Autowiring via the paeams
    public Warehouse getWarehouse(@Autowired Market market) {
        Warehouse warehouse = new Warehouse();
        warehouse.setMarket(market);
        return warehouse;
    }

    @Bean
    //Autowiring via the paeams
    public Warehouse getWarehouse1(@Autowired Market market) {
        Warehouse warehouse = new Warehouse();
        warehouse.setMarket(market);
        return warehouse;
    }
}
