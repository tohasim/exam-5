package com.example.exam5syncandasync.dtos;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@NoArgsConstructor
public class Nation {
    int count;
    String name;
    List<Country> country;

    @Getter
    @Setter
    @NoArgsConstructor
    public static class Country {
        String country_id;
        double probability;
    }
}
