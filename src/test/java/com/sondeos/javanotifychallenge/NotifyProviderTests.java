package com.sondeos.javanotifychallenge;

import com.sondeos.javanotifychallenge.providers.dto.ContactDto;
import com.sondeos.javanotifychallenge.providers.dto.NotifyResultDto;
import com.sondeos.javanotifychallenge.providers.NotifyProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.web.client.HttpClientErrorException;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
class NotifyProviderTests {

    @Autowired
    NotifyProvider notifyProvider;


    @Test
    void sendSMS() {
        String destination = "1122334455";
        String message = "Hello from Java Notify Challenge!";
        NotifyResultDto result = notifyProvider.notify("sms", destination, message);
        System.out.println(result.toString());
        assertEquals("sent", result.getStatus());
    }

    @Test
    void sendSMSInvalidDestination() {
        String destination = "123";
        String message = "Hello from Java Notify Challenge!";
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> {
            notifyProvider.notify("sms", destination, message);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());
    }


    @Test
    void sendEmail() {
        String destination = "challenge@example.com";
        String message = "Hello from Java Notify Challenge!";
        NotifyResultDto result = notifyProvider.notify("email", destination, message);
        System.out.println(result.toString());
        assertEquals("sent", result.getStatus());
    }


    @Test
    void sendSMSInvalidEmail() {
        String destination = "challenge-invalid-email";
        String message = "Hello from Java Notify Challenge!";
        HttpClientErrorException exception = assertThrows(HttpClientErrorException.class, () -> {
            notifyProvider.notify("email", destination, message);
        });
        assertEquals(HttpStatus.BAD_REQUEST, exception.getStatusCode());

    }


}
