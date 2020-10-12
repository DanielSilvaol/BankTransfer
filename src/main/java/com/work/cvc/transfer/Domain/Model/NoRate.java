package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IRateRule;

public class NoRate implements IRateRule {
    @Override
    public double CalculateRate(Transfer transfer) {
        return 0;
    }

    @Override
    public void SetNext(IRateRule next) {
    }

    @Override
    public void SetDays(long days) {
    }
}
