package practice;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class InvalidTransaction {
//    public List<String> invalidTransactions(String[] transactions) {
//        List<Transaction> transactionsList = getTransaction(transactions);
//        return filterList(transactionsList);
//    }

//    private List<String> filterList(List<Transaction> transactionsList) {
//        List<Transaction> s1 = transactionsList.stream()
//                .filter(x->{
//                    return x.amount>1000;
//                }).collect(Collectors.toList());
//
//
//
//    }

    private List<Transaction> getTransaction(String[] transactions) {
        List<Transaction> transactionList = new ArrayList<>();
        for(String str : transactions) {
            String ans [] = str.split(",");
            Transaction transaction = new Transaction(ans[0],Integer.parseInt(ans[1]),Integer.parseInt(ans[2]),ans[3]);
            transactionList.add(transaction);
        }
        return transactionList;
    }
}

class Transaction {
    String name;
    int time;
    int amount;
    String city;

    public Transaction(String name, int time, int amount, String city) {
        this.name = name;
        this.time = time;
        this.amount = amount;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }
}