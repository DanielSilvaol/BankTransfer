package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IFeeRule;

public class SameDayTransfer implements IFeeRule {
    @Override
    public double calculateFee(Transfer transfer) {
        return 3 + (transfer.getTransferAmount() * 0.03);
    }
}
