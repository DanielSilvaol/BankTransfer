package com.work.cvc.transfer.Domain.Enum;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IFeeRule;
import com.work.cvc.transfer.Domain.Model.FeeAggressive;
import com.work.cvc.transfer.Domain.Model.SameDayTransfer;
import com.work.cvc.transfer.Domain.Model.TransferUpTo10Days;
import org.joda.time.Days;
import org.joda.time.Duration;
import org.joda.time.Interval;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public enum EFee {
    FEE_A(new SameDayTransfer()),
    FEE_B(new TransferUpTo10Days()),
    FEE_C(new FeeAggressive());

    private final IFeeRule _iFeeRule;

    EFee(IFeeRule iFeeRule) {
        this._iFeeRule = iFeeRule;
    }

    public static double getFee(Transfer transfer) {

        long days = Days.daysBetween(transfer.getSchedulingDate().toLocalDate(),transfer.getTransferDate()).getDays();
        if (days == 0) {
            return FEE_A._iFeeRule.calculateFee(transfer);
        } else if (days > 0 && days <= 10) {
            return FEE_B._iFeeRule.calculateFee(transfer);
        } else {
            return FEE_C._iFeeRule.calculateFee(transfer);
        }

    }
}
