package com.example.mariage.Constants.Enums;

public enum Plate {

    BEEF("BEEF", "Boeuf"),
    FISH("FISH", "Poisson"),
    VEGE("VEGE", "végé");

    private String code;
    private String name;

    Plate(String code, String name){
        this.code = code;
        this.name = name;
    }

}
