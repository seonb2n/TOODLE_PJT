package com.example.toodle;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class LoginActivity extends BasicActivity{

    //region View

    private EditText mail_EditTxt, pw_EditTxt;
    private ImageView pwShow_Img;
    private TextView userMsg_Txt;
    private RelativeLayout loginBtn_Layout;
    private ImageView loginBtn_Img;

    //endregion

    //region Variable

    private String mail, pw;
    private boolean isPwShow = false;

    //endregion

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        setActivity(this,this);

        init();
    }

    private void init() {
        setDataLogout();
        mail_EditTxt = findViewById(R.id.mail_EditTxt);
        mail_EditTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                setInputResult();
            }
        });

        pw_EditTxt = findViewById(R.id.pw_EditTxt);
        pw_EditTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
            }

            @Override
            public void afterTextChanged(Editable s) {
                setInputResult();
            }
        });

        pw_EditTxt.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int actionId, KeyEvent keyEvent) {
                switch (actionId) {
                    case EditorInfo.IME_ACTION_DONE:
                        hideSoftKeyboard(mActivity);
                        clearFocusBundle();
                        break;
                    default:
                        return false;
                }
                return true;
            }
        });

        pwShow_Img = findViewById(R.id.pwShow_Img);
        userMsg_Txt = findViewById(R.id.userMsg_Txt);
        loginBtn_Layout = findViewById(R.id.loginBtn_Layout);
        loginBtn_Img = findViewById(R.id.loginBtn_Img);
    }

    public void PwShowClicked(View v) {
        //???????????? ????????? ?????? ??????
    }

    public void LoginClicked(View v) {
        //????????? ?????? ??????
    }

    public void FindClicked(View v) {
        //???????????? ?????? ?????? ??????
    }

    public void JoinMailClicked(View v) {
        startActivityClass(JoinMailActivity.class, R.anim.animation_fade_in, R.anim.animation_stop_short);
    }

    private void setInputResult() {
        //??????, email ??? pw ??? ???????????? ????????? ?????? ????????????

        //???????????? ????????????, ????????? ????????? ????????? ?????????
    }

}
