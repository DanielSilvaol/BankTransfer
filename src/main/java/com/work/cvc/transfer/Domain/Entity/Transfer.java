package com.work.cvc.transfer.Domain.Entity;

import com.work.cvc.transfer.Domain.Enum.EFee;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import org.joda.time.DateTime;

import javax.persistence.*;
import java.util.Calendar;

@Data
@Entity
public class Transfer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    int id;
    String sourceAccount = "XXXXXX";
    String targetAccount = "XXXXXX";
    double transferAmount;
    double fee;
    EFee eFee;
    DateTime transferDate;
    DateTime schedulingDate;

    public void ConfigSave(String sourceAccount,
                           String targetAccount,
                           double transferAmount,
                           double fee,
                           DateTime transferDate) {

        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transferAmount = transferAmount;
        this.fee = fee;
        this.transferDate = transferDate;
        this.schedulingDate = DateTime.now();
    }
}
