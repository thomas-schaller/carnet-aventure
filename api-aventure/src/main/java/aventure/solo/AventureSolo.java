package aventure.solo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.persistence.autoconfigure.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EntityScan("aventure.solo")
@EnableJpaRepositories("aventure.solo")
public class AventureSolo {


        public static void main(String[] args) {
            SpringApplication.run(AventureSolo.class, args);
        }

}
