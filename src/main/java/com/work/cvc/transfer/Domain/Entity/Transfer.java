package com.work.cvc.transfer.Domain.Entity;

import lombok.Data;
import org.joda.time.DateTime;
import org.joda.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

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
    LocalDate transferDate;
    DateTime schedulingDate;

    public void ConfigSave(String sourceAccount,
                           String targetAccount,
                           double transferAmount,
                           LocalDate transferDate) {

        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transferAmount = transferAmount;
        this.transferDate = transferDate;
        this.schedulingDate = DateTime.now();
    }
}
