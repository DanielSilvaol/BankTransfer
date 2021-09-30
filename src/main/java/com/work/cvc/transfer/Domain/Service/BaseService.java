package com.work.cvc.transfer.Domain.Service;

import com.work.cvc.transfer.Api.Config.Error.Notifiable;
import com.work.cvc.transfer.Api.Config.Error.Notification;
import com.work.cvc.transfer.Domain.Interface.IService;
import lombok.Getter;

import java.util.List;

@Getter
public abstract class BaseService extends Notifiable implements IService {
    protected BaseService(){
    }


    @Override
    public List<Notification> Notifications() {
        return this.Notifications;
    }
}