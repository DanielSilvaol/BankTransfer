package com.work.cvc.transfer.Domain.Command.TransferCommand.Inputs;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.work.cvc.transfer.Domain.Command.TransferCommand.BaseCommand;
import com.work.cvc.transfer.Domain.Config.Error.ValidationContract;
import lombok.Getter;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import java.util.Calendar;

@Getter
public class SaveTransferCommand extends BaseCommand {

    String sourceAccount = "XXXXXX";
    String targetAccount = "XXXXXX";
    double transferAmount;

    LocalDate transferDate;

    @Override
    public boolean IsValid() {
        AddNotifications(new ValidationContract()
                .IsNotNullOrEmpty(sourceAccount, "Source Account", "Cannot be empty.")
                .IsNotNullOrEmpty(targetAccount, "Target Account", "Cannot be empty..")
                .IsGreaterThanZero(transferAmount, "Transfer Amount", "Cannot be less than zero.")
                .IsFutureDate(transferDate, "Transfer Date", "Cannot be less than the current date."));
        return isValid();
    }
}
