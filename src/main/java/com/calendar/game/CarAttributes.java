package com.calendar.game;

public class CarAttributes {
    private static final int TOTAL_ASSIGNABLE_POINTS = 10;

    private final int speedPoints;
    private final int staminaPoints;
    private final int recoveryPoints;
    private final int acceleratorPoints;

    public CarAttributes(int speedPoints, int staminaPoints, int recoveryPoints, int acceleratorPoints) {
        this.speedPoints = speedPoints;
        this.staminaPoints = staminaPoints;
        this.recoveryPoints = recoveryPoints;
        this.acceleratorPoints = acceleratorPoints;
        validate();
    }

    private void validate() {
        if (speedPoints < 0 || staminaPoints < 0 || recoveryPoints < 0 || acceleratorPoints < 0) {
            throw new IllegalArgumentException("Attribute points cannot be negative.");
        }

        int usedPoints = speedPoints + staminaPoints + recoveryPoints + acceleratorPoints;
        if (usedPoints != TOTAL_ASSIGNABLE_POINTS) {
            throw new IllegalArgumentException("Exactly 10 points must be assigned across all attributes.");
        }
    }

    public int getSpeedPoints() {
        return speedPoints;
    }

    public int getStaminaPoints() {
        return staminaPoints;
    }

    public int getRecoveryPoints() {
        return recoveryPoints;
    }

    public int getAcceleratorPoints() {
        return acceleratorPoints;
    }
}
