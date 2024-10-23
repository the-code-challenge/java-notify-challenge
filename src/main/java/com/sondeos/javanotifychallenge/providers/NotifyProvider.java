package com.sondeos.javanotifychallenge.providers;

import com.sondeos.javanotifychallenge.providers.dto.ContactDto;
import com.sondeos.javanotifychallenge.providers.dto.NotifyPayloadDto;
import com.sondeos.javanotifychallenge.providers.dto.NotifyResultDto;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;

@Component
public class NotifyProvider {

    public ContactDto getContact(String id){

        RestClient httpClient = RestClient.create();

        String url = "http://notify.showvlad.com/api/contact/"+id;

        ContactDto result = httpClient.get()
                .uri(url)
                .retrieve()
                .body(ContactDto.class);

        return result;
    }


    public NotifyResultDto notify(String type, String destination, String message){

        NotifyPayloadDto payload = new NotifyPayloadDto(destination,message);

        RestClient httpClient = RestClient.create();
        String url = "http://notify.showvlad.com/api/notify/"+type;

        NotifyResultDto result = httpClient.post()
                .uri(url)
                .header("Content-Type", "application/json")
                .body(payload)
                .retrieve()
                .body(NotifyResultDto.class);

        return result;
    }

}
