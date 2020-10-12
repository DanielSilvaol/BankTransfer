package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IRateRule;
import org.joda.time.Days;

public class RateCalculator {
    public static double Calculates(Transfer transfer) {
        long days = Days.daysBetween(transfer.getSchedulingDate().toLocalDate(),transfer.getTransferDate()).getDays();

        IRateRule rate_one = new SameDayTransfer();
        IRateRule rate_two = new TransferUpTo10Days();
        IRateRule rate_three = new TransferUpTo10Days();
        IRateRule rate_four = new TransferOver10To20Days();
        IRateRule rate_five = new TransferOver20To30Days();
        IRateRule rate_six = new TransferOver30To40Days();
        IRateRule rate_seven = new TransferOver40DaysAndValueOver100000();
        IRateRule rate_eight = new NoRate();

        rate_one.SetNext(rate_two);
        rate_two.SetNext(rate_three);
        rate_three.SetNext(rate_four);
        rate_four.SetNext(rate_five);
        rate_five.SetNext(rate_six);
        rate_six.SetNext(rate_seven);
        rate_seven.SetNext(rate_eight);

        rate_one.SetDays(days);
        rate_one.SetDays(days);
        rate_two.SetDays(days);
        rate_three.SetDays(days);
        rate_four.SetDays(days);
        rate_five.SetDays(days);
        rate_six.SetDays(days);
        rate_seven.SetDays(days);

        return rate_one.CalculateRate(transfer);
    }
}
