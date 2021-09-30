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
    private int id;
    private String sourceAccount = "XXXXXX";
    private String targetAccount = "XXXXXX";
    private double transferAmount;
    private double rate;
    private LocalDate transferDate;
    private DateTime schedulingDate;

    public void configSave(String sourceAccount, String targetAccount, double transferAmount, LocalDate transferDate) {
        this.sourceAccount = sourceAccount;
        this.targetAccount = targetAccount;
        this.transferAmount = transferAmount;
        this.transferDate = transferDate;
        this.schedulingDate = DateTime.now();
    }
}
