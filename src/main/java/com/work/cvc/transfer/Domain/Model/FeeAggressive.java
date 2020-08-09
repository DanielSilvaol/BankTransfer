package com.work.cvc.transfer.Domain.Model;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import com.work.cvc.transfer.Domain.Interface.IFeeRule;
import org.joda.time.Days;
import org.joda.time.Interval;

public class FeeAggressive implements IFeeRule {
    @Override
    public double calculateFee(Transfer transfer) {
        long days = Days.daysBetween(transfer.getSchedulingDate().toLocalDate(),transfer.getTransferDate()).getDays();

        if (days > 10 && days <= 20)
            return (transfer.getTransferAmount() * 0.08);

        else if (days > 20 && days <= 30)
            return (transfer.getTransferAmount() * 0.06);

        else if (days > 30 && days <= 40)
            return (transfer.getTransferAmount() * 0.04);

        else if (days > 40 && transfer.getTransferAmount() > 100000)
            return (transfer.getTransferAmount() * 0.02);

        return 0;
    }

    /*
        Acima de 10 até 20 dias da data de agendamento 8%
        Acima de 20 até 30 dias da data de agendamento 6%
        Acima de 30 até 40 dias da data de agendamento 4%
        Acima de 40 dias da data de agendamento e valor superior a 100.000 2%
     */
}

