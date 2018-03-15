package com.example.demo.initialise;

import com.example.demo.model.CountriesFiles;
import com.example.demo.parser.Parser;
import com.example.demo.persistence.Tag;
import com.example.demo.persistence.TagRepository;
import com.example.demo.persistence.Video;
import com.example.demo.persistence.VideoRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

@Configuration
public class VideoInsialiser {

    @Bean
    ApplicationRunner applicationRunner(VideoRepository videoRepository, TagRepository tagRepository){
        return applicationArguments -> {


            Parser parser = new Parser(videoRepository, tagRepository);
            parser.moveDateFromFilesToDataBase("USA");



            videoRepository.findAll().forEach(System.out::println);

/*

            CountriesFiles countriesFiles = new CountriesFiles();
            Map countryMap = countriesFiles.countryData();
            List<Video> allVideo = new ArrayList<>();
            for (Object countries : countryMap.keySet()) {
                if (countries.toString().equalsIgnoreCase("USA")) {
                    Parser parser = new Parser();
                    allVideo = parser.getDataFromFile(countryMap.get(countries).toString(), countries.toString());
                }
            }
            allVideo.forEach(e->videoRepository.save(e));
            videoRepository.findAll().forEach(System.out::println);
*/
                //todo bring Data from files and insert it in database ;
/*
            Tag tag1 = new Tag();
            tag1.setName("First");
            tagRepository.save(tag1);

            Tag tag2 = new Tag();
            tag2.setName("Second");
            tagRepository.save(tag2);

            List<Tag> lis= new ArrayList<>();
            lis.add(tag1);
            lis.add(tag2);


            Video video1 = new Video();
            video1.setCountry("USA");
            video1.setTitle("I Love you");
            //video1.setTags(lis);
*/

            //videoRepository.save(video1);

/*
            Tag tag3 = new Tag();
            tag3.setName("Third");
            lis.add(tag3);
            tagRepository.save(tag3);

            Video video2 = new Video();
            video2.setCountry("USA");
            video2.setTitle("Do You Love me");
            //video2.setTags(lis);
            videoRepository.save(video2);

            videoRepository.findAll().forEach(System.out::println);
            tagRepository.findAll().forEach(System.out::println);
*/


            //Stream<Tag> tagStream = videoRepository.findAll()
            // .stream().map(e -> e.getTags())
            // .flatMap(e -> e.stream());

        };

    }
}
