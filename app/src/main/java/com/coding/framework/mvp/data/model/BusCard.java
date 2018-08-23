package com.coding.framework.mvp.data.model;

/**
 * Created by Jesus Morales on 23-08-2018.
 */

public class BusCard extends BoardingCards {

    public BusCard(String departure, String arrival, String seat) {
        super(departure, arrival, seat);
    }

    @Override
    public String toString() {
        return "Take bus from " + departure + " to " + arrival + " and "
                + (seat == null ? "no seat assignment" : "sit in " + seat);
    }
}
