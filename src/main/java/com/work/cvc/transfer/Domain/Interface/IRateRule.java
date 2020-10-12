package com.work.cvc.transfer.Domain.Interface;

import com.work.cvc.transfer.Domain.Entity.Transfer;

public interface IRateRule {
    double CalculateRate(Transfer transfer);
    void SetNext(IRateRule next);
    void SetDays(long days);
}
