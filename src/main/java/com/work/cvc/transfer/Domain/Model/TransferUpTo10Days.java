package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IRateRule;
import org.joda.time.Days;


public class TransferUpTo10Days implements IRateRule {
    private IRateRule next;
    private long days;

    @Override
    public double CalculateRate(Transfer transfer) {
        if (days > 0 && days <= 10) {
            return 12 * days;
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
