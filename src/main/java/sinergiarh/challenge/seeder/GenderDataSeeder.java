package sinergiarh.challenge.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import sinergiarh.challenge.entity.Gender;
import sinergiarh.challenge.repository.GenderRepository;

// Seeder utilizado para inciar la base de datos de género

@Configuration
public class GenderDataSeeder {
    @Bean
    CommandLineRunner initGenderTable(GenderRepository genderRepository) {
        return args -> {
            if (genderRepository.count() == 0) {
                Gender female = new Gender("Femenino");
                Gender male = new Gender("Masculino");

                genderRepository.save(female);
                genderRepository.save(male);
            }
        };
    }
}
