package net.engineeringdigest.journalApp.service;

import net.engineeringdigest.journalApp.Repository.userRepository;
import net.engineeringdigest.journalApp.services.EmailService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class emailServiceTests {

    @Autowired
    private EmailService emailService;


    @Test
    void testSendMail() {
        emailService.sendEmail("paulswarnalee01@gmail.com",
                "Testing Java mail sender",
                "Hi, aap kaise hain ?");
    }

}
