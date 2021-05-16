package com.example.toodle;

import android.os.Bundle;

public class LoginActivity extends BasicActivity{

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setActivity(this,this);

        init();
    }

    private void init() {

    }

}
