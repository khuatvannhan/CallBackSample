package com.cam.callbacksample;

import android.os.Build;
import android.support.annotation.RequiresApi;

import com.github.kittinunf.fuel.Fuel;
import com.github.kittinunf.fuel.core.FuelError;
import com.github.kittinunf.fuel.core.Handler;

import org.jetbrains.annotations.NotNull;

/**
 * Created by snowflower on 12/29/16.
 */

public class HandingB implements MainView {
    public static HandingC mainView;

    public static void getInstance() {
        mainView = new HandingC();
    }

    @Override
    public void sendRequst(String url, final GetCallBack callBack) {
        Fuel.get(url).responseString(new Handler<String>() {
            @RequiresApi(api = Build.VERSION_CODES.KITKAT)
            @Override
            public void success(@NotNull com.github.kittinunf.fuel.core.Request request, @NotNull com.github.kittinunf.fuel.core.Response response, String s) {
                callBack.onFinish("Request On finish");
            }

            @Override
            public void failure(@NotNull com.github.kittinunf.fuel.core.Request request, @NotNull com.github.kittinunf.fuel.core.Response response, @NotNull FuelError fuelError) {
                callBack.onError("Request On finish");
            }
        });
    }

    @Override
    public void checkIsZezo(int index, final GetCallBack callBack) {
        mainView.checkIsZezo(index, new GetCallBack() {
            @Override
            public void onFinish(String data) {

            }

            @Override
            public void onError(String error) {

            }

            @Override
            public void noZezo(String data) {
                callBack.noZezo(data);
            }

            @Override
            public void yesZezo(String data) {
                callBack.yesZezo(data);
            }
        });
    }
}
