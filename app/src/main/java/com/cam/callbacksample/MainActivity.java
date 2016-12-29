package com.cam.callbacksample;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements MainActivityView{
    TextView textView, textView2;
    MainPresent mainPresent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView = (TextView) findViewById(R.id.text);
        textView2 = (TextView) findViewById(R.id.text2);
        mainPresent = new MainPresent(this);
        mainPresent.send("http://vi.vp9.tv/tivichannel/Channel_05_20150704.json");
        mainPresent.checkIsZezo(2);
    }

    @Override
    public void onCheckZezoFinish(boolean isZezo) {
        if (isZezo) {
            textView2.setText("is Zezo");
        } else {
            textView2.setText("isn't Zezo");
        }
    }

    @Override
    public void onRequestFinish(String data) {
        textView.setText("Request Finish");
    }

    @Override
    public void onRequestError(String error) {
        textView.setText("Request Error");
    }
}
