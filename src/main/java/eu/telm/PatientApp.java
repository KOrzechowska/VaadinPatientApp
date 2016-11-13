package eu.telm;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class PatientApp {

    private static final Logger log = LoggerFactory.getLogger(PatientApp.class);


    public static void main(String[] args) {
        SpringApplication.run(PatientApp.class, args);
    }

}

