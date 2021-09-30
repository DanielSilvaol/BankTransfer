package com.work.cvc.transfer.Domain.Command.TransferCommand.Outputs;

import com.work.cvc.transfer.Domain.Entity.Transfer;
import lombok.Getter;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.List;
import java.util.stream.Collectors;

@Getter
public class TransferDTO {

    String sourceAccount;
    String targetAccount;
    double transferAmount;
    double rate;
    LocalDate transferDate;
    DateTime schedulingDate;

    public TransferDTO(Transfer transfer) {
        this.sourceAccount = transfer.getSourceAccount();
        this.targetAccount = transfer.getTargetAccount();
        this.transferAmount = transfer.getTransferAmount();
        this.rate = transfer.getRate();
        this.transferDate = transfer.getTransferDate();
        this.schedulingDate = transfer.getSchedulingDate();
    }

    public static List<TransferDTO> Converter(List<Transfer> transfers){
        return transfers.stream().map(TransferDTO::new).collect(Collectors.toList());
    }
}
