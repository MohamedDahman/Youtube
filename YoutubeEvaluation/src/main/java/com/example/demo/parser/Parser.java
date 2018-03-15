package com.example.demo.parser;

import com.example.demo.model.CountriesFiles;
import com.example.demo.persistence.Tag;
import com.example.demo.persistence.TagRepository;
import com.example.demo.persistence.Video;
import com.example.demo.persistence.VideoRepository;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Parser {

    private VideoRepository videoRepository;
    private TagRepository tagRepository;

    public Parser()
    {

    }
    public Parser(VideoRepository videoRepository, TagRepository tagRepository) {
        this.videoRepository = videoRepository;
        this.tagRepository = tagRepository;
    }

    public void moveDateFromFilesToDataBase(String country){
        CountriesFiles countriesFiles = new CountriesFiles();
        Map countryMap = countriesFiles.countryData();
        List<Video> videos = new ArrayList<>();
        for (Object countries : countryMap.keySet()) {
            if (countries.toString().equalsIgnoreCase(country)) {
                List<String> list = new ArrayList<>();
                String fileName = countryMap.get(countries).toString();
                try {
                    list = Files.readAllLines(Paths.get(fileName));
                    list.remove(0);
                    for (String line: list) {
                        String[] splitLines = line.split(",");
                        if (splitLines.length == 16){

                            String tags = splitLines[6];

                            tags = tags.replaceAll("\"", "");
                            String[] split = tags.split("\\|");
/*

                            //String[] split = tags.split("|");
                            List<String> collect = Stream.of(tags)
                                    .map(e -> e.split("\\|"))
                                    .flatMap(e-> Arrays.stream(e))
                                    .collect(Collectors.toList());

*/

                            List<Tag> tagsList = new ArrayList<>();

                            for (String tagName:split) {
                                Tag tag = new Tag();
                                tag.setName(tagName);
                                tagRepository.save(tag);
                                tagsList.add(tag);
                            }

                            try {
                                Video video = new Video();
                                video.setTitle(splitLines[2].replaceAll("\"",""));
                                video.setChannel_title(splitLines[3]);
                                video.setCountry(country);
                                video.setDescription(splitLines[12]);
                                video.setCategory_id(Integer.parseInt(splitLines[4]));
                                video.setViews(Integer.parseInt(splitLines[7]));
                                video.setLikes(Integer.parseInt(splitLines[8]));
                                video.setDislikes(Integer.parseInt(splitLines[9]));
                                video.setComment_count(Integer.parseInt(splitLines[10]));
                                video.setTags(tagsList);
                                videoRepository.save(video);

                            } catch (NumberFormatException e1) {
                                System.out.println("##################error in this video id##################");
                                System.out.println(splitLines[0]);
                                System.out.println("##########################################################");
                                e1.printStackTrace();
                            }

                        }
                    }

                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    public List<Video> getDataOneCountry(String country){
        CountriesFiles countriesFiles = new CountriesFiles();
        Map countryMap = countriesFiles.countryData();
        List<Video> videos = new ArrayList<>();
        for (Object countries : countryMap.keySet()) {
            if (countries.toString().equalsIgnoreCase(country)) {

                videos = getDataFromFile(countryMap.get(countries).toString(), countries.toString());
            }
        }
       return  videos;

    }


    public static List<Video> getDataFromFile(String fileName, String country) {
        List<String> list = new ArrayList<>();
        try {
            list = Files.readAllLines(Paths.get(fileName));
            List<Video> collect = list.stream()
                    .skip(1)
                    .map(e -> e.split(","))
                    .filter(e -> e.length == 16)
                    .filter(e -> e[1].length() == 8)
                    .map(e -> getToVideo(e, country))
                    .collect(Collectors.toList());
            return collect;
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }

    private static Video getToVideo(String[] e,String country) {

        Video video = new Video();
        video.setTitle(e[2]);
        video.setChannel_title(e[3]);
        video.setCountry(country);
        String tags = e[6];
        tags.replaceAll("\"", "");
        String[] splitTags = tags.split("|");
        //video.setTags();
        List<String> taglist = Stream.of(splitTags).collect(Collectors.toList());

        //video.setTags(taglist);


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
