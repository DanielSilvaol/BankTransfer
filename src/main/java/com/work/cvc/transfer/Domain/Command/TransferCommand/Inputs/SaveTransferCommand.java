package com.work.cvc.transfer.Domain.Command.TransferCommand.Inputs;

import com.work.cvc.transfer.Domain.Command.BaseCommand;
import com.work.cvc.transfer.Api.Config.Error.ValidationContract;
import lombok.Getter;
import lombok.Setter;
import org.joda.time.LocalDate;

@Getter
@Setter
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
