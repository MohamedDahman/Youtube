package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;


@Controller
@RequestMapping("/video")

public class GetByCountryName {

    @GetMapping
    String page() {
        return "video";
    }

    @GetMapping("/{country}")
    String  showOneCountry(@PathVariable String country, Model model) {
        model.CountriesFiles countriesFiles = new model.CountriesFiles();
        Map countryMap = countriesFiles.countryData();
        List<model.Video> videos = new ArrayList<>();
        for (Object countries : countryMap.keySet()) {
            if (countries.toString().equalsIgnoreCase(country)) {
                parser.Parser parser = new parser.Parser();
                videos = parser.getDataFromFile(countryMap.get(countries).toString(), countries.toString());
            }
        }
        model.addAttribute("videos",videos);
        return "video";
    }


}
