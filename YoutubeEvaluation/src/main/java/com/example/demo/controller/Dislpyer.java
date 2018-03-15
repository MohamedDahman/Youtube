package com.example.demo.controller;

import com.example.demo.persistence.Video;
import com.example.demo.parser.Parser;

import java.util.ArrayList;
import java.util.List;

import static com.example.demo.controller.YoutubeControl.getMostChanelHaveVideoAsList;

public class Dislpyer {


    public List<String> displayMostChanelHaveVideoAsList(Integer limitValue, String country){
        YoutubeControl youtubeControl = new YoutubeControl();
        Parser parser = new Parser();
        List<Video> videos = new ArrayList<>();
        videos = parser.getDataOneCountry(country);
        return getMostChanelHaveVideoAsList(videos, limitValue, country);
    }
}
