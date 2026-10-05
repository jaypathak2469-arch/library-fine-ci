package com.example.library;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;
import org.junit.jupiter.api.Test;

class LibraryFineTest {

    private final LibraryFine lf = new LibraryFine();

    @Test
    void daysLate_returnsCorrectDifference() {
        assertEquals(5, lf.calculateDaysLate(LocalDate.of(2026, 10, 1), LocalDate.of(2026, 10, 6)));
    }

    @Test
    void daysLate_isZeroWhenReturnedEarly() {
        assertEquals(0, lf.calculateDaysLate(LocalDate.of(2026, 10, 10), LocalDate.of(2026, 10, 5)));
    }

    @Test
    void fine_calculatedAtRatePerDay() {
        assertEquals(10.0, lf.calculateFine(5), 0.001);
    }

    @Test
    void fine_negativeDaysThrowsException() {
        assertThrows(IllegalArgumentException.class, () -> lf.calculateFine(-1));
    }

    @Test
    void memberDiscount_appliedForMembers() {
        assertEquals(8.0, lf.applyMemberDiscount(10.0, true), 0.001);
    }

    @Test
    void memberDiscount_notAppliedForNonMembers() {
        assertEquals(10.0, lf.applyMemberDiscount(10.0, false), 0.001);
    }
}
