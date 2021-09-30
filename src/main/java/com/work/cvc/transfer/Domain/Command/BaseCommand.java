package com.work.cvc.transfer.Domain.Command;


import com.work.cvc.transfer.Api.Config.Error.Notifiable;

public abstract class BaseCommand extends Notifiable {

    protected BaseCommand() {
        new Notifiable();
    }
    public boolean IsValid(){
        return isValid();
    }
}