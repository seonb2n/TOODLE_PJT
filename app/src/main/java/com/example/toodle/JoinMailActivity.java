package com.example.toodle;


import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

public class JoinMailActivity extends BasicActivity {

    //region View

    private EditText mail_EditTxt, pw_EditTxt, pwRe_EditTxt;
    private ImageView pwShow_Img, pwReShow_Img;
    private TextView userMsg_Txt;
    private RelativeLayout joinEmailBtn_Layout;
    private ImageView joinEmailBtn_Img;

    //endregion

    //region Variable

    private String mail, pw, pwRe;
    private boolean isPwShow = false, isPwReShow = false, isAgree = true;

    //endregion


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_join_mail);
        setActivity(this,this);

        init();
    }

    private void init() {
        setDataLogout();



    }
}
