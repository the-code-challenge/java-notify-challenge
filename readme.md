# Java Notification Processor Challenge

## Objetivo

El objetivo de este challenge es evaluar tus habilidades en Programación Orientada a Objetos (POO), uso de patrones de diseño, validaciones, manejo de errores y optimización de performance.

## Descripción del Challenge

Se te proporciona un código base para completar el desarrollo de un procesador de notificaciones. Este procesador interactúa con una API externa para enviar notificaciones a contactos especificados.

### Clases Proporcionadas

1. **NotifyProvider**
    - **Método `getContact(id)`**: Obtiene los datos del contacto mediante su ID. Retorna el nombre, apellido, email y teléfono del contacto.
    - **Método `notify(type, destination, message)`**: Envía notificaciones de tipo email o SMS.

2. **NotifyRepository**
    - **Método `getNotifications()`**: Retorna una lista de notificaciones que deben ser procesadas. Cada notificación incluye el `contactId`, el `type` (email|sms) y el `message` a ser enviado.

3. **NotifyService**
    - **Método `processNotifications()`**: Obtiene las notificaciones del `NotifyRepository`, las recorre e invoca al método `sendNotification()` para cada una. Además, se contabiliza las notificaciones procesadas, las enviadas y la duración del procesamiento.
    - **Método `sendNotification(type, contactId, message)`**: Actualmente lanzará una excepción indicando que la implementación aún no está hecha. Tu tarea principal será completar este método.

### Problemas Intencionales

El challenge incluye algunos problemas intencionales que deberás resolver:

- Validación de datos y formatos
- Errores HTTP
- Delay HTTP

### Prueba Final

Al finalizar tu implementación, habrá una prueba que verificará lo siguiente:

- Si todas las notificaciones fueron procesadas.
- Si se enviaron las notificaciones esperadas.
- Si el tiempo de procesamiento es menor a 30 segundos.

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

## Entrega

Por favor, sube tu solución a un repositorio público de GitHub y comparte el enlace para que pueda ser revisada.

---

¡Buena suerte y esperamos ver tus habilidades en acción!
