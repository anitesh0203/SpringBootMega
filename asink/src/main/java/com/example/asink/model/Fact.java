package com.example.asink.model;

import org.springframework.context.annotation.Bean;


public class Fact {
    String fact;
    int length;

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    @Override
    public String toString() {
        return "Fact{" +
                "fact='" + fact + '\'' +
                ", length=" + length +
                '}';
    }
}
