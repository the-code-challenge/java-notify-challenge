package com.sondeos.javanotifychallenge.notifications;

public class Notification {

    String contactId;
    String type;
    String message;

    public Notification(String contactId, String type, String message) {
        this.contactId = contactId;
        this.type = type;
        this.message = message;
    }

    public String getContactId() {
        return contactId;
    }

    public void setContactId(String contactId) {
        this.contactId = contactId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
