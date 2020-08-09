package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IFeeRule;
import org.joda.time.Interval;


public class TransferUpTo10Days implements IFeeRule {
    @Override
    public double calculateFee(Transfer transfer) {
        Interval interval = new Interval(transfer.getSchedulingDate(),transfer.getTransferDate());
        return 12 * interval.toDuration().getStandardDays();
    }
}
