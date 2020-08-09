package com.work.cvc.transfer.Domain.Handler;

import com.work.cvc.transfer.Domain.Config.Error.Notifiable;
import com.work.cvc.transfer.Domain.Config.Error.Notification;
import com.work.cvc.transfer.Domain.Interface.IHandler;
import lombok.Getter;

import java.util.List;

@Getter
public  class BaseHandler extends Notifiable implements IHandler {
    protected BaseHandler(){
    }


    @Override
    public List<Notification> Notifications() {
        return this.Notifications;
    }
}