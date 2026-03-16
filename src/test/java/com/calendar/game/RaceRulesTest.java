package com.calendar.game;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class RaceRulesTest {

    @Test
    public void shouldCalculatePerformanceFromAssignedPoints() {
        CarAttributes attributes = new CarAttributes(4, 3, 2, 1);

        CarPerformance performance = CarPerformance.fromAttributes(attributes);

        assertEquals(100, performance.getMaxSpeedKmh());
        assertEquals(35, performance.getStaminaDurationSeconds());
        assertEquals(0, performance.getRecoverySecondsFor10PercentStamina());
        assertEquals(1, performance.getAcceleratorUsesPer3Seconds());
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectAttributeAssignmentsThatDoNotUseTenPoints() {
        new CarAttributes(1, 2, 3, 1);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectCarCountOutsideAllowedRange() {
        new RaceMatchConfig(3, 3, RoundDistance.TEN_KM);
    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldRejectRoundsOutsideAllowedValues() {
        new RaceMatchConfig(6, 4, RoundDistance.FIVE_KM);
    }

    @Test
    public void shouldAcceptValidRaceConfiguration() {
        RaceMatchConfig config = new RaceMatchConfig(10, 7, RoundDistance.TWENTY_KM);

        assertEquals(10, config.getNumberOfCars());
        assertEquals(7, config.getRoundsPerMatch());
        assertEquals(20, config.getRoundDistance().getKilometers());
    }
}
