package com.coding.framework.mvp.data.model;

/**
 * Created by Jesus Morales on 23-08-2018.
 */

public class FlightCard extends BoardingCards {

    private String flightNumber, gate, counter;

    public FlightCard(String departure, String arrival, String seat,
                      String flightNumber, String gate, String counter) {
        super(departure, arrival, seat);
        this.flightNumber = flightNumber;
        this.gate = gate;
        this.counter = counter;
    }

    @Override
    public String toString() {
        return "Take flight " + flightNumber + " from " + departure + " to " + arrival + " and "
                + (seat == null ? "no seat" : "sit in " + seat) + " and "
                + (counter == null ? " baggage transfered, no action required" : "counter " + counter)
                + " and go to gate " + (gate==null ? "not available" : gate);
    }
}
