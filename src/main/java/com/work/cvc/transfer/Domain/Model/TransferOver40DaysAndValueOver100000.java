package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IRateRule;
import org.joda.time.Days;

public class TransferOver40DaysAndValueOver100000 implements IRateRule {
    private IRateRule next;
    private long days;

    @Override
    public double CalculateRate(Transfer transfer) {
        if (days > 40 && transfer.getTransferAmount() > 100000)
            return (transfer.getTransferAmount() * 0.02);

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

