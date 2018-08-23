package com.coding.framework.mvp.ui.transport;

import android.support.annotation.StringRes;

import com.coding.framework.mvp.data.model.BoardingCards;
import com.coding.framework.mvp.ui.base.MvpView;

import java.util.List;


/**
 * Created by Jesus Morales on 23-08-2018.
 */

public interface MainMvpView extends MvpView {

    void addBoardingCards(List<BoardingCards> translationResponse);

    void showErrorOnEditText(@StringRes int res);

}
