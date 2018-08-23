package com.coding.framework.mvp.ui.transport;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.coding.framework.mvp.R;
import com.coding.framework.mvp.adapter.CardsAdapter;
import com.coding.framework.mvp.data.model.BoardingCards;
import com.coding.framework.mvp.data.model.BoardingRoute;
import com.coding.framework.mvp.ui.base.BaseActivity;

import java.util.HashMap;
import java.util.List;

import javax.inject.Inject;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by Jesus Morales on 23-08-2018.
 */

public class MainActivity extends BaseActivity implements MainMvpView {

    @Inject
    MainMvpPresenter<MainMvpView> mPresenter;

    @BindView(R.id.translate_recycler)
    RecyclerView mTranslateRecyclerView;

    @BindView(R.id.toolbar)
    Toolbar mToolbar;

    private CardsAdapter mTranslationAdapter;

    private BoardingRoute route;

    public static Intent getStartIntent(Context context) {
        Intent intent = new Intent(context, MainActivity.class);
        return intent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);

        setUnBinder(ButterKnife.bind(this));

        mPresenter.onAttach(MainActivity.this);

        setUp();

    }

    @Override
    protected void onDestroy() {
        mPresenter.onDetach();
        super.onDestroy();
    }

    @Override
    protected void setUp() {
        setSupportActionBar(mToolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(false);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        LinearLayoutManager mLayoutManager = new LinearLayoutManager(this);
        mLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mTranslateRecyclerView.setLayoutManager(mLayoutManager);
        mTranslateRecyclerView.setItemAnimator(new DefaultItemAnimator());
        mTranslationAdapter = new CardsAdapter(new BoardingRoute().getBoardingCards());
        mTranslateRecyclerView.setAdapter(mTranslationAdapter);

        mPresenter.initRoute();
    }

    @Override
    public void addBoardingCards(List<BoardingCards> translationResponse) {
        mTranslationAdapter.addItems(translationResponse);
    }

    @OnClick(R.id.btn_translate)
    public void onClickTranslate() {
        mPresenter.sortCards();
    }

    @OnClick(R.id.btn_shuffle)
    public void onClickShuffle() {
        mPresenter.shuffleCards();
    }

    @Override
    public void showErrorOnEditText(@StringRes int res) {

    }
}
