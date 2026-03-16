package com.calendar.game;

public class CarPerformance {
    private static final int BASE_MAX_SPEED_KMH = 80;
    private static final int SPEED_PER_POINT_KMH = 5;

    private static final int STAMINA_LOW_SPEED_SECONDS = 40;
    private static final int STAMINA_MEDIUM_SPEED_SECONDS = 30;
    private static final int STAMINA_HIGH_SPEED_SECONDS = 20;
    private static final int STAMINA_PER_POINT_SECONDS = 5;

    private static final int BASE_RECOVERY_SECONDS_FOR_10_PERCENT = 2;
    private static final int RECOVERY_REDUCTION_PER_POINT_SECONDS = 3;

    private static final int ACCELERATOR_USES_PER_POINT_PER_3_SECONDS = 1;

    private final int maxSpeedKmh;
    private final int staminaDurationSeconds;
    private final int recoverySecondsFor10PercentStamina;
    private final int acceleratorUsesPer3Seconds;

    private CarPerformance(int maxSpeedKmh,
                           int staminaDurationSeconds,
                           int recoverySecondsFor10PercentStamina,
                           int acceleratorUsesPer3Seconds) {
        this.maxSpeedKmh = maxSpeedKmh;
        this.staminaDurationSeconds = staminaDurationSeconds;
        this.recoverySecondsFor10PercentStamina = recoverySecondsFor10PercentStamina;
        this.acceleratorUsesPer3Seconds = acceleratorUsesPer3Seconds;
    }

    public static CarPerformance fromAttributes(CarAttributes attributes) {
        int maxSpeed = BASE_MAX_SPEED_KMH + (attributes.getSpeedPoints() * SPEED_PER_POINT_KMH);
        int baseStamina = resolveBaseStamina(maxSpeed);
        int staminaDuration = baseStamina + (attributes.getStaminaPoints() * STAMINA_PER_POINT_SECONDS);

        int recoverySeconds = BASE_RECOVERY_SECONDS_FOR_10_PERCENT
                - (attributes.getRecoveryPoints() * RECOVERY_REDUCTION_PER_POINT_SECONDS);
        recoverySeconds = Math.max(0, recoverySeconds);

        int acceleratorUses = attributes.getAcceleratorPoints() * ACCELERATOR_USES_PER_POINT_PER_3_SECONDS;

        return new CarPerformance(maxSpeed, staminaDuration, recoverySeconds, acceleratorUses);
    }

    private static int resolveBaseStamina(int maxSpeed) {
        if (maxSpeed < 50) {
            return STAMINA_LOW_SPEED_SECONDS;
        }
        if (maxSpeed < 70) {
            return STAMINA_MEDIUM_SPEED_SECONDS;
        }
        return STAMINA_HIGH_SPEED_SECONDS;
    }

    public int getMaxSpeedKmh() {
        return maxSpeedKmh;
    }

    public int getStaminaDurationSeconds() {
        return staminaDurationSeconds;
    }

    public int getRecoverySecondsFor10PercentStamina() {
        return recoverySecondsFor10PercentStamina;
    }

    public int getAcceleratorUsesPer3Seconds() {
        return acceleratorUsesPer3Seconds;
    }
}
