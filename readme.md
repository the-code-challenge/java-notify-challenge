# Java Notification Processor Challenge

## Objetivo

El objetivo de este challenge es evaluar tus habilidades en Programación Orientada a Objetos (POO), uso de patrones de diseño, validaciones, manejo de errores y optimización de performance.

---

## Descripción del Challenge

Se te proporciona un código base para completar el desarrollo de un procesador de notificaciones. Este procesador interactúa con una API externa para enviar notificaciones a contactos especificados.

---

### API de Proveedor de notificaciones EMAIL & SMS

#### Endpoint: Obtener contactos
**url**: http://notify.showvlad.com/api/contact/:id  
**method**: GET  
**response**: {id: String, name: String, surname: String, email:String, phoneNumber: String}

#### Endpoint: Enviar notificacion
**url**: http://notify.showvlad.com/api/notify/:type  (type: sms|email)  
**method**: POST  
**body**: {destination: String, message: String}  
**response**: {status: String, uuid: String}

---

### Clases Proporcionadas

1. **ContactProvider** Implementa una integración básica a la API HTTP del proveedor de contactos.
    - **Método `getContact(id)`**: Obtiene los datos del contacto mediante su ID. Retorna el nombre, apellido, email y teléfono del contacto.

2. **NotifyProvider** Implementa una integración básica a la API HTTP del proveedor de notificaciones.
   - **Método `notify(type, destination, message)`**: Envía notificaciones de tipo email o SMS.

3. **NotifyRepository** Provee una lista de notificaciones a procesar.
    - **Método `getNotifications()`**: Retorna una lista de notificaciones que deben ser procesadas. Cada notificación incluye el `contactId`, el `type` (email|sms) y el `message` a ser enviado.

4. **NotifyService** Se ocupa de procesar y enviar las notificaciones.
    - **Método `processNotifications()`**: Obtiene las notificaciones del `NotifyRepository`, las recorre e invoca al método `sendNotification()` para cada una. Además, se contabiliza las notificaciones procesadas, las enviadas y la duración del procesamiento.
    - **Método `dispatchNotification(type, contactId, message)`**: Actualmente lanzará una excepción indicando que la implementación aún no está hecha. Tu tarea principal será completar este método.

   
### Problemas Intencionales

El challenge incluye algunos problemas intencionales que deberás resolver:

- Validación de datos y formatos
- Posibilidad de errores en integración HTTP
- Delay en integración HTTP

## Instrucciones

1. Descarga el código base proporcionado.
2. Implementa las clases, interfaces y patrones que creas conveniente para manejar los diferentes tipos de notificaciones.
3. Implementa la lógica necesaria en el método `sendNotification()` de la clase `NotifyService`.
4. Asegúrate de manejar adecuadamente los errores y optimizar el rendimiento.
5. Realiza las pruebas necesarias para verificar el correcto funcionamiento de tu implementación.
6. Envía tu solución para su revisión.

## Requisitos

- Java 17 o superior.
- Maven para la gestión de dependencias.

### TEST

En la seccion de test hay una prueba que verificará:

- Si todas las notificaciones fueron procesadas.
- Si se enviaron las notificaciones esperadas.
- Si el tiempo de procesamiento es óptimo.

## Entrega

Por favor, sube tu solución a un repositorio público de GitHub y comparte el enlace para que pueda ser revisada.

## Valoraciones

- Se valora que se puedan procesar todas las notificaciones
- Se valora el manejo de errores y validaciones
- Se valora que se puedan enviar todas las notificaciones posibles
- Se valora la optimización de los tiempos de procesamiento
- Se valora la implementación de patrones de POO como Factory Method, Strategy, Singleton
- Se valora la creación de test adicionales

---

¡Buena suerte y esperamos ver tus habilidades en acción!
