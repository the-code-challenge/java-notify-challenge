package com.sondeos.javanotifychallenge;

import com.sondeos.javanotifychallenge.providers.dto.ContactDto;
import com.sondeos.javanotifychallenge.providers.dto.NotifyResultDto;
import com.sondeos.javanotifychallenge.providers.NotifyProvider;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class NotifyProviderTests {

    @Autowired
    NotifyProvider notifyProvider;

    @Test
    void getContact() {
        String id = "1";
        ContactDto contact = notifyProvider.getContact(id);
        System.out.println(contact.toString());
        assertEquals(id, contact.getId());
    }


    @Test
    void sendSMS() {
        String destination = "1122334455";
        String message = "Hello from Java Notify Challenge!";
        NotifyResultDto result = notifyProvider.notify("sms", destination, message);
        System.out.println(result.toString());
        assertEquals("sent", result.getStatus());
    }


    @Test
    void sendEmail() {
        String destination = "challenge@example.com";
        String message = "Hello from Java Notify Challenge!";
        NotifyResultDto result = notifyProvider.notify("email", destination, message);
        System.out.println(result.toString());
        assertEquals("sent", result.getStatus());
    }



}
