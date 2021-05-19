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

import java.util.function.ToDoubleBiFunction;

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

        mail_EditTxt = findViewById(R.id.mail_EditTxt);
        mail_EditTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setInputResult();
            }
        });

        pwRe_EditTxt = findViewById(R.id.pwRe_EditTxt);
        pwRe_EditTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
            }

            @Override
            public void afterTextChanged(Editable editable) {
                setInputResult();
            }
        });

        //TODO
        // EditTxt 에 다음키 누르면 키보드  숨기는 기능 추가.


        pwShow_Img = findViewById(R.id.pwShow_Img);
        pwReShow_Img = findViewById(R.id.pwReShow_Img);
        userMsg_Txt = findViewById(R.id.userMsg_Txt);
        joinEmailBtn_Layout = findViewById(R.id.joinEmailBtn_Layout);
        joinEmailBtn_Img = findViewById(R.id.joinEmailBtn_Img);

    }

    public void setInputResult() {
        // TODO
        //  만약 mail_EdiText 에 입력이 안되어 있으면, 버튼 비활성화
        //  입력 되어 있으면 버튼 활성화
    }

    public void PwShowClicked(View v) {
        //TODO
        // 버튼 눌리면 비밀번호 보여줌
    }

    public void PwReShowClicked(View v) {
        //TODO
        //버튼 눌리면 비밀번호 보여줌
    }

    public void JoinMailClicked(View v) {
        //TODO
        //유효성 검사 후 가입 Task 실행
    }

    @Override
    public void clearFocusBundle() {
        mail_EditTxt.clearFocus();
        pw_EditTxt.clearFocus();
        pwRe_EditTxt.clearFocus();
    }


    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            backActivity();
        }

        return true;
    }

}
