package com.example.demo.initialise;



import com.example.demo.persistence.TestVideo;
import com.example.demo.persistence.TestVideoRepository;
import org.aspectj.weaver.ast.Test;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class TestVideoInitialiser {

    @Bean
    ApplicationRunner initialiseTestVideo(TestVideoRepository testVideoRepository) {
        return applicationArguments -> {

            TestVideo testVideo = new TestVideo("Austria");
            TestVideo testUsa = new TestVideo("USA");
            TestVideo t = new TestVideo("DeutschLand");

            testVideoRepository.save(testVideo) ;
            testVideoRepository.save(testUsa);
            testVideoRepository.save(t);


            testVideoRepository.findAll()
                            .forEach(System.out::println);
        };
    }
}
