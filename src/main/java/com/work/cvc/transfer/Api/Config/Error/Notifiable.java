package com.work.cvc.transfer.Api.Config.Error;

import io.swagger.annotations.ApiModelProperty;

import java.util.ArrayList;
import java.util.List;

public class Notifiable {
    @ApiModelProperty(required = true, hidden=true)
    public List<Notification> Notifications;

    @ApiModelProperty(required = true, hidden=true)
    public boolean isValid() {
        return this.Notifications.isEmpty();
    }

    public Notifiable()
    {
        this.Notifications = new ArrayList<>();
    }

    public static Notification CreateNotification(String property,String message) {
        return new Notification(property, message);
    }

    public void AddNotification(Notification notification)
    {
        this.Notifications.add(notification);
    }

    public void AddNotifications(List<Notification> notifications)
    {
        this.Notifications.addAll(notifications);
    }

    public void AddNotifications(Notifiable item)
    {
        this.AddNotifications(item.Notifications);
    }
    public void ClearNotification(){
        this.Notifications = new ArrayList<>();
    }
    public void AddNotifications(Notifiable[] items)
    {
        for (Notifiable notifiable :items) {
            this.AddNotifications(notifiable);
        }
    }
}