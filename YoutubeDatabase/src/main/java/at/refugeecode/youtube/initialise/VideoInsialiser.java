package at.refugeecode.youtube.initialise;

import at.refugeecode.youtube.persistence.VideoRepository;
import org.springframework.boot.ApplicationRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;

@Configuration
public class VideoInsialiser {

    @Bean
    ApplicationRunner applicationRunner(VideoRepository videoRepository){
        return  args -> {


            };
    }

}
