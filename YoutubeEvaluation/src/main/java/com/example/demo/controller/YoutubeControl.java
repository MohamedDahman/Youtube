package com.example.demo.controller;


import com.example.demo.persistence.Video;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class YoutubeControl {

    public static void getVideoByMoreDisLike(List<Video> allVideo, Integer limitvalue, String country) {
        allVideo.stream()
                .filter(e->e.getCountry().equals(country))
                .sorted((e1,e2)->e2.getDislikes().compareTo(e1.getDislikes()))
                .limit(limitvalue)
                .map(e->e.getTitle()+" "+e.getDislikes())
                .forEach(e-> System.out.println(e));
    }
    public static void getVideoByMoreLike(List<Video> allVideo,Integer limitvalue,String country){
         allVideo.stream()
                 .filter(e->e.getCountry().equals(country))
                 .sorted((e1,e2)->e2.getLikes().compareTo(e1.getLikes()))
                 .limit(limitvalue)
                 .map(e->e.getTitle()+" "+e.getLikes())
                 .forEach(e-> System.out.println(e));
    }

    public static void getVideoByMoreView(List<Video> allVideo,Integer limitvalue,String country){

        allVideo.stream()
                .filter(e->e.getCountry().equals(country))
                .sorted((e1, e2) -> e2.getViews().compareTo(e1.getViews()))
                .limit(limitvalue)
                .map(e->e.getTitle()+" "+e.getViews())
                .forEach(e-> System.out.println(e));
    }

    public static void getCountVideoByCategory(List<Video> allVideo,Integer limitvalue,String country) {
       allVideo.stream()
               .filter(e->e.getCountry()==country)
               .map(e->e.getCategory_id())
               .collect(Collectors.groupingBy(e->e,Collectors.counting()))
               .entrySet()
               .stream()
               .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
               .limit(limitvalue)
               .forEach(e-> System.out.println(e));
   }
   public  static List<Map.Entry<String, Long>> getMostChannelHaveVideo(List<Video> allVideo,Integer limitValue,String country){
        Map<String, Long> collect = allVideo.stream()
               .filter(e->e.getCountry().equalsIgnoreCase(country))
               .map(e -> e.getChannel_title())
               .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

       List<Map.Entry<String, Long>> collect1 = collect.entrySet()
               .stream()
               .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
               .limit(limitValue)
               .collect(Collectors.toList());
       return collect1;
   }

   public static List<String> getMostChanelHaveVideoAsList(List<Video> allVideo, Integer limitValue, String country){
       List<Map.Entry<String, Long>> mostChannelHaveVideo = getMostChannelHaveVideo(allVideo, limitValue, country);
       List<String> collect = mostChannelHaveVideo.stream()
               .map(e -> e.getValue() + " " + e.getKey())
               .collect(Collectors.toList());
       return collect;
   }

    public static void getVideoByMoreDisLikeAllCountry(List<Video> allVideo,Integer limitvalue) {
        allVideo.stream()
                .sorted((e1,e2)->e2.getDislikes().compareTo(e1.getDislikes()))
                .limit(limitvalue)
                .map(e->e.getCountry()+" "+e.getTitle()+" "+e.getDislikes())
                .forEach(e-> System.out.println(e));
    }
    public static void getVideoByMoreLikeAllCountry(List<Video> allVideo,Integer limitvalue){
        allVideo.stream()
                .sorted((e1,e2)->e2.getLikes().compareTo(e1.getLikes()))
                .limit(limitvalue)
                .map(e->e.getCountry()+" "+e.getTitle()+" "+e.getLikes())
                .forEach(e-> System.out.println(e));
    }

    public static void getVideoByMoreViewAllCountry(List<Video> allVideo,Integer limitvalue){

        allVideo.stream()
                .sorted((e1, e2) -> e2.getViews().compareTo(e1.getViews()))
                .limit(limitvalue)
                .map(e->e.getCountry()+" "+e.getTitle()+" "+e.getViews())
                .forEach(e-> System.out.println(e));
    }

    public static void getCountVideoByCategoryAllCountry(List<Video> allVideo,Integer limitvalue) {
        allVideo.stream()
                .map(e->e.getCategory_id())
                .collect(Collectors.groupingBy(e->e,Collectors.counting()))
                .entrySet()
                .stream()
                .sorted((e1,e2)->e2.getValue().compareTo(e1.getValue()))
                .limit(limitvalue)
                .forEach(e-> System.out.println(e));
    }
    public  static List<Map.Entry<String, Long>> getMostChannelHaveVideoAllCountry(List<Video> allVideo,Integer limitValue){
        Map<String, Long> collect = allVideo.stream()
                .map(e -> e.getChannel_title())
                .collect(Collectors.groupingBy(e -> e, Collectors.counting()));

        List<Map.Entry<String, Long>> collect1 = collect.entrySet()
                .stream()
                .sorted((e1, e2) -> e2.getValue().compareTo(e1.getValue()))
                .limit(limitValue)
                .collect(Collectors.toList());
        return collect1;
    }


    public static List<String> getMostChanelHaveVideoAsListAllCountry(List<Video> allVideo, Integer limitValue){
        List<Map.Entry<String, Long>> mostChannelHaveVideo = getMostChannelHaveVideoAllCountry(allVideo, limitValue);
        List<String> collect = mostChannelHaveVideo.stream()
                .map(e -> e.getValue() + " " + e.getKey())
                .collect(Collectors.toList());
        return collect;
    }


}



