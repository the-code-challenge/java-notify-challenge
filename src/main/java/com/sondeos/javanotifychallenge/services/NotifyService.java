package com.sondeos.javanotifychallenge.services;

import com.sondeos.javanotifychallenge.notifications.NotificationRepository;
import com.sondeos.javanotifychallenge.providers.NotifyProvider;
import com.sondeos.javanotifychallenge.services.dto.NotificationProcessResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.concurrent.atomic.AtomicInteger;

@Component
public class NotifyService {

    @Autowired
    NotifyProvider notifyProvider;


    public NotificationProcessResult processNotifications(){

        //Iniciamos contador de tiempo
        long startTime = System.currentTimeMillis();

        //Iniciamos contador de notificaciones procesadas
        AtomicInteger processed = new AtomicInteger();

        //Iniciamos contador de notificaciones enviadas
        AtomicInteger sent = new AtomicInteger();

        //Pedimos las notificaciones y las recorremos para enviarlas
        NotificationRepository.getNotifications().forEach(n -> {

            //Procesamos cada notificación
            Boolean r = this.sendNotification(n.getType(), n.getContactId(), n.getMessage());

            //Incrementamos el contador de notificaciones procesadas
            processed.getAndIncrement();

            //Incrementamos el contador de notificaciones enviadas si el resultado fue exitoso
            if(r){
                sent.getAndIncrement();
            }

        });

        //Calculamos el tiempo de procesamiento
        long duration = (System.currentTimeMillis() - startTime) / 1000;

        //Devolvemos el resultado con el número de notificaciones procesadas y enviadas y el tiempo de procesamiento
        return new NotificationProcessResult(processed.get(), sent.get(), duration)  ;
    }

    /*
    * Debe procesar cada notificación y enviarla usando el proveedor de notificaciones (NotifyProvider)
    * Se pueden implementar clases, interfaces o utilidades adicionales para enviar las notificaciones
    * Debe retornar true si la notificación se envió correctamente, false en caso contrario
    */
    public Boolean sendNotification(String type, String contactId, String message){
        throw new RuntimeException("Not implemented yet");

    }
}
