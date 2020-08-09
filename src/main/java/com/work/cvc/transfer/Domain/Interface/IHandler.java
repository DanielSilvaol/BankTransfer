package com.work.cvc.transfer.Domain.Interface;

import com.work.cvc.transfer.Domain.Config.Error.Notification;

import java.util.List;

public interface IHandler {
    List<Notification> Notifications();
    void ClearNotification();
}