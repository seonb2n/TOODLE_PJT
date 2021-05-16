package com.example.toodle;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.Locale;

public class IntroActivity extends BasicActivity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);
        setActivity(this, this);

        lang = Locale.getDefault().getLanguage();
        setDevicePreferences("lang", lang);

        getToken();
    }

    private void getToken() {
        //get Token

        checkLogin();
    }

    protected void checkLogin() {
        if(loginState == LOGIN_EXIST) {
            new UserCheckTask().execute();
        } else {
            startDelayActivity(LoginActivity.class);
        }
    }

    private class UserCheckTask extends AsyncTask<Void, Void, String> {
        @Override
        protected String doInBackground(Void... voids) {
            //user 정보를 가져옴

            return "";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);
            //Log in 결과를 체크

            startDelayActivity(LoginActivity.class);
        }
    }

    private Intent introActivityIntent;

    private void startDelayActivity(Class c) {
        introActivityIntent = new Intent(mContext, c);
        delayActivityHandler.sendEmptyMessageDelayed(0, INTRO_DELAY_TIME);
    }

    private Handler delayActivityHandler = new Handler() {
        public void handleMessage(Message msg) {
            //region delayActivityHandler
            startActivityIntent(introActivityIntent, R.anim.animation_fade_in, R.anim.animation_stop_short);
            //endregion
            finish();
        }
    };
}
