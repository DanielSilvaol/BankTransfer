package com.work.cvc.transfer.Domain.Config.Error;


import lombok.Getter;

@Getter
public class Notification {
    private String Property;
    private String Message;

    public Notification(String property, String message)
    {
        this.Property = property;
        this.Message = message;
    }
}