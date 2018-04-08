package com.example.demo.model;

import java.util.HashMap;
import java.util.Map;

public class CountriesFiles {
        public  Map countryData(){
            Map<String,String> countryFileWithSymbol = new HashMap();
            countryFileWithSymbol.put("Canada","src\\main\\java\\comexample\\demo\\data\\CAvideos.csv");
            countryFileWithSymbol.put("Deutschland","src\\main\\java\\com\\example\\demo\\data\\DEvideos.csv");
            countryFileWithSymbol.put("France","src\\main\\java\\com\\example\\demo\\data\\FRvideos.csv");
            countryFileWithSymbol.put("England","src/main/java/com/example/demo/data/GBvideos.csv");
            countryFileWithSymbol.put("USA","src\\main\\java\\com\\example\\demo\\data\\USvideos.csv");
            return  countryFileWithSymbol;

        }
}



