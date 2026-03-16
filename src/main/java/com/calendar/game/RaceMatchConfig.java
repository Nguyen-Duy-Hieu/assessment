package com.calendar.game;

import java.util.Arrays;
import java.util.List;

public class RaceMatchConfig {
    private static final int MIN_CARS = 4;
    private static final int MAX_CARS = 10;
    private static final List<Integer> ALLOWED_MATCH_ROUNDS = Arrays.asList(3, 5, 7);

    private final int numberOfCars;
    private final int roundsPerMatch;
    private final RoundDistance roundDistance;

    public RaceMatchConfig(int numberOfCars, int roundsPerMatch, RoundDistance roundDistance) {
        this.numberOfCars = numberOfCars;
        this.roundsPerMatch = roundsPerMatch;
        this.roundDistance = roundDistance;
        validate();
    }

    private void validate() {
        if (numberOfCars < MIN_CARS || numberOfCars > MAX_CARS) {
            throw new IllegalArgumentException("Number of cars must be between 4 and 10.");
        }
        if (!ALLOWED_MATCH_ROUNDS.contains(roundsPerMatch)) {
            throw new IllegalArgumentException("Rounds per match must be 3, 5 or 7.");
        }
        if (roundDistance == null) {
            throw new IllegalArgumentException("Round distance is required.");
        }
    }

    public int getNumberOfCars() {
        return numberOfCars;
    }

    public int getRoundsPerMatch() {
        return roundsPerMatch;
    }

    public RoundDistance getRoundDistance() {
        return roundDistance;
    }
}
