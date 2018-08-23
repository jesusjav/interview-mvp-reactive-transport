package com.coding.framework.mvp.ui.transport;


import com.coding.framework.mvp.di.PerActivity;
import com.coding.framework.mvp.ui.base.MvpPresenter;


/**
 * Created by Jesus Morales on 23-08-2018.
 */

@PerActivity
public interface MainMvpPresenter<V extends MainMvpView> extends MvpPresenter<V> {

    void shuffleCards();

    void sortCards();

    void initRoute();


}
