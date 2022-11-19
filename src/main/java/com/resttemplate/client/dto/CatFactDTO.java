package com.resttemplate.client.dto;

public class CatFactDTO {
    private String fact, length;

    public CatFactDTO(){}

    public CatFactDTO(String fact, String length) {
        this.fact = fact;
        this.length = length;
    }

    public String getFact() {
        return fact;
    }

    public void setFact(String fact) {
        this.fact = fact;
    }

    public String getLength() {
        return length;
    }

    public void setLength(String length) {
        this.length = length;
    }
}
