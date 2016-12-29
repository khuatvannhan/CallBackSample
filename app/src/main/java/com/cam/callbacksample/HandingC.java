package com.cam.callbacksample;

/**
 * Created by snowflower on 12/29/16.
 */

public class HandingC {
    public void checkIsZezo(int index, MainView.GetCallBack callBack) {
        if (index == 0) {
            callBack.yesZezo("yes");
        } else {
            callBack.noZezo("no");
        }
    }
}
