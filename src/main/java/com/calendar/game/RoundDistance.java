package com.calendar.game;

public enum RoundDistance {
    FIVE_KM(5),
    TEN_KM(10),
    TWENTY_KM(20);

    private final int kilometers;

    RoundDistance(int kilometers) {
        this.kilometers = kilometers;
    }

    public int getKilometers() {
        return kilometers;
    }
}
