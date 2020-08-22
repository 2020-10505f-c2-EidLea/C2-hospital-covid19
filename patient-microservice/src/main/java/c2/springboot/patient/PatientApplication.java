package c2.springboot.patient;

import java.util.stream.Stream;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@EnableDiscoveryClient
@SpringBootApplication
public class PatientApplication {

	public static void main(String[] args) {
		SpringApplication.run(PatientApplication.class, args);
	}

}

//@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@ToString
//@Entity

class Patient {
   
    public Patient(String name){
        this.name = name;
    }
    
    private Long id;
    private String name;
    
    @RepositoryRestResource
    interface PatientRepository extends JpaRepository<Patient, Long> {}
    
//    @Component
    class PatientInitializer implements CommandLineRunner {
        
        private final PatientRepository patientRepository;
        
        PatientInitializer(PatientRepository patientRepository){
                this.patientRepository = patientRepository;
        }
        
        @Override
        public void run(String... args) throws  Exception {
            Stream.of("AAA", "BBB", "CCC", "DDD", "EEE")
                    .forEach(patient -> patientRepository.save(new Patient(patient)));
            
            patientRepository.findAll().forEach(System.out::println);
        }
    }
}
