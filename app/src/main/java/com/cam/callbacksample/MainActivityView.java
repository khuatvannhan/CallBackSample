package com.cam.callbacksample;

/**
 * Created by snowflower on 12/29/16.
 */

interface MainActivityView {
    void onCheckZezoFinish(boolean isZezo);

    void onRequestFinish(String data);

    void onRequestError(String error);
}
