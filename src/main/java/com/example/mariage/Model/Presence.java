package com.example.mariage.Model;

import com.example.mariage.Constants.Enums.Plate;
import lombok.Data;

@Data
public class Presence {

    public String id;
    public String guestId;
    public boolean ceremony;
    public boolean wineReception;
    public boolean meal;
    public Plate plate;
}
