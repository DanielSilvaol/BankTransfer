package com.work.cvc.transfer.Domain.Interface;

import com.work.cvc.transfer.Api.Config.Error.Notification;

import java.util.List;

public interface IService {
    List<Notification> Notifications();
    void ClearNotification();
}