package com.coding.framework.mvp.ui.transport;

import com.coding.framework.mvp.data.DataManager;
import com.coding.framework.mvp.data.model.BoardingRoute;
import com.coding.framework.mvp.data.model.BusCard;
import com.coding.framework.mvp.data.model.FlightCard;
import com.coding.framework.mvp.data.model.TrainCard;
import com.coding.framework.mvp.ui.base.BasePresenter;

import java.util.Collections;

import javax.inject.Inject;

import io.reactivex.disposables.CompositeDisposable;


/**
 * Created by Jesus Morales on 23-08-2018.
 */

public class MainPresenter<V extends MainMvpView> extends BasePresenter<V>
        implements MainMvpPresenter<V> {

    private static final String TAG = "MainPresenter";

    private BoardingRoute route;

    @Inject
    public MainPresenter(DataManager dataManager,
                         CompositeDisposable compositeDisposable) {
        super(dataManager, compositeDisposable);
    }

    @Override
    public void shuffleCards() {
        Collections.shuffle(route.getBoardingCards());
        getMvpView().addBoardingCards(route.getBoardingCards());
    }


    @Override
    public void initRoute() {
        route = new BoardingRoute();

        route.addBoardingCard(new FlightCard("London", "New York", "7B",
                "SK22","22", null));


        route.addBoardingCard(new BusCard("Barcelona", "Girona", null));


        route.addBoardingCard(new TrainCard("Madrid", "Barcelona", "45B",
                "78A", false));


        route.addBoardingCard(new FlightCard("Girona", "London", "3A",
                "SK455","45B", "344"));

        getMvpView().addBoardingCards(route.getBoardingCards());

    }

    @Override
    public void sortCards() {
        route.sort(0);
        getMvpView().addBoardingCards(route.getBoardingCards());
    }

}
