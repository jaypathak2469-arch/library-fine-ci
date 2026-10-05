package com.example.library;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class LibraryFine {

    public static final double RATE_PER_DAY = 2.0;
    public static final double MEMBER_DISCOUNT = 0.20;

    public long calculateDaysLate(LocalDate dueDate, LocalDate returnDate) {
        long days = ChronoUnit.DAYS.between(dueDate, returnDate);
        return Math.max(days, 0);
    }

    public double calculateFine(long daysLate) {
        if (daysLate < 0) {
            throw new IllegalArgumentException("Days late cannot be negative");
        }
        return daysLate * RATE_PER_DAY;
    }

    public double applyMemberDiscount(double fine, boolean isMember) {
        return isMember ? fine * (1 - MEMBER_DISCOUNT) : fine;
    }
}
