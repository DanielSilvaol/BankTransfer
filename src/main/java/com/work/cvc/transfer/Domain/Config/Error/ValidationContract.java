package com.work.cvc.transfer.Domain.Config.Error;

import org.joda.time.DateTime;
import org.joda.time.Days;
import org.joda.time.Interval;
import org.joda.time.LocalDate;

import java.util.Calendar;

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
        long days = Days.daysBetween(val, LocalDate.now()).getDays();
        if (days < 0)
            this.AddNotification(CreateNotification(property, message));
        return this;
    }


}
