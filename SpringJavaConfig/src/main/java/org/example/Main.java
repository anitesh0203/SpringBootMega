package org.example;

import org.example.config.AppConfig;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        // get the applicaion context
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(AppConfig.class);
        Warehouse warehouse = applicationContext.getBean(Warehouse.class);
        Warehouse warehouse1 = applicationContext.getBean(Warehouse.class);

        warehouse.getInventory();
    }
}