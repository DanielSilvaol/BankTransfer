package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IRateRule;

public class TransferOver10To20Days implements IRateRule {
    private long days;
    private IRateRule next;

    @Override
    public double CalculateRate(Transfer transfer) {
        if (days > 10 && days <= 20)
            return (transfer.getTransferAmount() * 0.08);
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
