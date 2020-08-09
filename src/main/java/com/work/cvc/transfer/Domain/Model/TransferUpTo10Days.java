package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IFeeRule;
import org.joda.time.Days;
import org.joda.time.Interval;


public class TransferUpTo10Days implements IFeeRule {
    @Override
    public double calculateFee(Transfer transfer) {
        long days = Days.daysBetween(transfer.getSchedulingDate().toLocalDate(),transfer.getTransferDate()).getDays();
        return 12 * days;
    }
}
