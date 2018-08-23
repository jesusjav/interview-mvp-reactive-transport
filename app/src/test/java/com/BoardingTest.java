package com;

import android.util.Log;

import com.coding.framework.mvp.data.model.BoardingRoute;
import com.coding.framework.mvp.data.model.BusCard;
import com.coding.framework.mvp.data.model.FlightCard;
import com.coding.framework.mvp.data.model.TrainCard;

import org.junit.Assert;
import org.junit.Test;

public class BoardingTest {

    @Test
    public void BoardingCards1() {

        BoardingRoute route = new BoardingRoute();

        route.addBoardingCard(new FlightCard("London", "New York", "7B",
                "SK22","22", null));


        route.addBoardingCard(new BusCard("Barcelona", "Girona", null));


        route.addBoardingCard(new TrainCard("Madrid", "Barcelona", "45B",
                "78A", false));


        route.addBoardingCard(new FlightCard("Girona", "London", "3A",
                "SK455","45B", "344"));

        long start = System.nanoTime();
        route.sort(0); // measuring recursive
        long end = System.nanoTime();
        long res = end-start;
        System.out.print((end - start) + " microsec");


    }

    @Test
    public void BoardingCards2() {

        BoardingRoute route = new BoardingRoute();

        route.addBoardingCard(new BusCard("Barcelona", "Girona", null));


        route.addBoardingCard(new TrainCard("Madrid", "Barcelona", "45B",
                "78A", false));


        route.addBoardingCard(new FlightCard("Girona", "London", "3A",
                "SK455","45B", "344"));

        route.addBoardingCard(new FlightCard("London", "New York", "7B",
                "SK22","22", null));

        long start = System.nanoTime();
        route.sort(0); //recursive
        long end = System.nanoTime();
        long res = end-start;
        System.out.print((end - start) + " microsec");


    }

    @Test
    public void BoardingCards3() {

        BoardingRoute route = new BoardingRoute();

        route.addBoardingCard(new FlightCard("London", "New York", "7B",
                "SK22","22", null));


        route.addBoardingCard(new BusCard("Barcelona", "Girona", null));


        route.addBoardingCard(new TrainCard("Madrid", "Barcelona", "45B",
                "78A", false));


        route.addBoardingCard(new FlightCard("Girona", "London", "3A",
                "SK455","45B", "344"));

        long start = System.nanoTime();
        route.sort(); //measuring hash
        long end = System.nanoTime();
        long res = end-start;
        System.out.print((end - start) + " microsec");

    }
}
