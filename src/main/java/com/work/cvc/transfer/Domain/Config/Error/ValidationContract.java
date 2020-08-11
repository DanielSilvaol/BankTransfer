package com.work.cvc.transfer.Domain.Config.Error;

import org.joda.time.Days;
import org.joda.time.LocalDate;

public class ValidationContract extends Notifiable {
    private boolean IsNullOrEmpty(String attribute) {
        return (attribute == null || attribute.isEmpty());
    }

    public ValidationContract IsNotNullOrEmpty(
            String val,
            String property,
            String message) {
        if (IsNullOrEmpty(val))
            this.AddNotification(CreateNotification(property, message));
        return this;
    }

    public ValidationContract IsGreaterThanZero(
            double val,
            String property,
            String message) {
        if (val <= 0)
            this.AddNotification(CreateNotification(property, message));
        return this;
    }

    public ValidationContract IsFutureDate(
            LocalDate val,
            String property,
            String message) {
        long days = Days.daysBetween(LocalDate.now(),val).getDays();
        if (days < 0)
            this.AddNotification(CreateNotification(property, message));
        return this;
    }


}
