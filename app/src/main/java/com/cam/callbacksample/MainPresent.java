package com.cam.callbacksample;

/**
 * Created by snowflower on 12/29/16.
 */

public class MainPresent implements MainView.GetCallBack {
    MainView mainView;
    MainActivityView mainActivityView;
    HandingB handingB;

    public MainPresent(MainActivityView mainActivityView) {
        this.mainActivityView = mainActivityView;
        mainView = new HandingA();
        handingB = new HandingB();
        handingB.getInstance();
    }

    public void send(String url) {
        mainView.sendRequst(url, this);
    }

    public void checkIsZezo(int index) {
        handingB.checkIsZezo(index, this);
    }

    @Override
    public void onFinish(String data) {
        mainActivityView.onRequestFinish(data);
    }

    @Override
    public void onError(String error) {
        mainActivityView.onRequestError(error);
    }

    @Override
    public void noZezo(String data) {
        mainActivityView.onCheckZezoFinish(false);
    }

    @Override
    public void yesZezo(String data) {
        mainActivityView.onCheckZezoFinish(true);
    }
}
