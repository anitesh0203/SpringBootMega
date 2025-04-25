package org.example;

public class Warehouse {
    Market market;
    public Warehouse() {
        System.out.println("Warehouse being made");
    }

    public void getInventory() {
        market.getMarket();
        System.out.println("The inventory looks good here !!");
    }

    public Market getMarket() {
        return market;
    }

    public void setMarket(Market market) {
        this.market = market;
    }
}
