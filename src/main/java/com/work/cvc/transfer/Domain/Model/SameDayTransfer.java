package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IRateRule;

public class SameDayTransfer implements IRateRule {
    private IRateRule next;
    private long days;

    @Override
    public double CalculateRate(Transfer transfer) {
        if(days == 0){
            return 3 + (transfer.getTransferAmount() * 0.03);
        }
        return next.CalculateRate(transfer);
    }

    @Override
    public void SetNext(IRateRule next) {
        this.next = next;
    }

    @Override
    public void SetDays(long days) {
        this.days = days;
    }
}
