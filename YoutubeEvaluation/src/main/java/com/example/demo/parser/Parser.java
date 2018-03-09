package com.example.demo.parser;

import model.Video;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    public static List<Video> getDataFromFile(String fileName,String country) {
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Paths.get(fileName));
            List<Video> collect = list.stream()
                    .skip(1)
                    .map(e -> e.split(","))


                    .filter(e-> e.length == 16)
                    .filter(e-> e[1].length()==8)
                    //.peek(e-> System.out.println(e[0]))
                    .map(e -> getToVideo(e,country))
                    .limit(10)
                    .collect(Collectors.toList());
            return collect;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Video getToVideo(String[] e,String country) {
        Video video = new Video();
        video.setVideo_id(e[0]);
        video.setTitle(e[2]);
        video.setCountry(country);
        String tags = e[6];
        tags.replaceAll("\"","");
        String[] splitTags = tags.split("|");
        List<String>  taglist= Stream.of(splitTags).collect(Collectors.toList());
        video.setTags(taglist);

        video.setChannel_title(e[3]);

        try {
            video.setCategory_id(Integer.parseInt(e[4]));
            video.setViews(Integer.parseInt(e[7]));
            video.setLikes(Integer.parseInt(e[8]));
            video.setDislikes(Integer.parseInt(e[9]));
            video.setComment_count(Integer.parseInt(e[10]));

        } catch (NumberFormatException e1) {
            System.out.println("------------------------------------------------------------");
            System.out.println(e[0]);
            System.out.println("------------------------------------------------------------");
            e1.printStackTrace();
        }
        video.setDescription(e[12]);
        return video;
    }

}
