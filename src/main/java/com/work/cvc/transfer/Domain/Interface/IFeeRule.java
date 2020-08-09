package com.work.cvc.transfer.Domain.Interface;

import com.work.cvc.transfer.Domain.Entity.Transfer;

public interface IFeeRule {
    double calculateFee(Transfer transfer);
}
