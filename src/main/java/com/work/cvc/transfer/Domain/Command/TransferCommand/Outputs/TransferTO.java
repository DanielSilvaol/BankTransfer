package com.work.cvc.transfer.Domain.Command.TransferCommand.Outputs;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import lombok.Getter;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TransferTO {

    String sourceAccount;
    String targetAccount;
    double transferAmount;
    double fee;
    LocalDate transferDate;
    DateTime schedulingDate;

    public TransferTO(Transfer transfer) {
        this.sourceAccount = transfer.getSourceAccount();
        this.targetAccount = transfer.getTargetAccount();
        this.transferAmount = transfer.getTransferAmount();
        this.fee = transfer.getFee();
        this.transferDate = transfer.getTransferDate();
        this.schedulingDate = transfer.getSchedulingDate();
    }

    public static List<TransferTO> Converter(List<Transfer> transfers){
        return transfers.stream().map(TransferTO::new).collect(Collectors.toList());
    }
}
