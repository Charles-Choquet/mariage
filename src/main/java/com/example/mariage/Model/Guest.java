package com.example.mariage.Model;

import lombok.Data;

@Data
public class Guest {

    public String id;
    public String firstName;
    public String lastName;
    public Presence presence;
}
