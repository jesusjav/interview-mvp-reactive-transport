package com.coding.framework.mvp.data.model;

/**
 * Created by Jesus Morales on 23-08-2018.
 */

public class TrainCard extends BoardingCards {

    private String trainNumber;
    private boolean isFirstClass;

    public TrainCard(String departure, String arrival, String seat, String trainNumber, boolean isFirstClass) {
        super(departure, arrival, seat);
        this.trainNumber = trainNumber;
        this.isFirstClass = isFirstClass;
    }

    @Override
    public String toString() {
        return "Take Train in "
                + (isFirstClass ? "First class": "Tourist") + " with number "
                + trainNumber + " from " + departure + " to " + arrival + " and "
                + (seat == null ? "no seat" : "sit in " + seat);
    }
}
