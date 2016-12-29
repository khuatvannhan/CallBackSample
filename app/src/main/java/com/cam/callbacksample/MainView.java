package com.cam.callbacksample;

/**
 * Created by snowflower on 12/29/16.
 */
public interface MainView {
    interface GetCallBack {
        void onFinish(String data);
        void onError(String error);
        void noZezo(String data);
        void yesZezo(String data);
    }
    void sendRequst(String url, GetCallBack callBack);

    void checkIsZezo(int index, GetCallBack callBack);
}
