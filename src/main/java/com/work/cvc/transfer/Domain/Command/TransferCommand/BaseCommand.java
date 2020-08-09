package com.work.cvc.transfer.Domain.Command.TransferCommand;


import com.work.cvc.transfer.Domain.Config.Error.Notifiable;

public abstract class BaseCommand extends Notifiable {

    protected BaseCommand() {
        new Notifiable();
    }
    public boolean IsValid(){
        return isValid();
    }
}