package com.example.toodle;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.webkit.CookieManager;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.google.firebase.platforminfo.GlobalLibraryVersionRegistrar;

public class BasicActivity extends AppCompatActivity implements GlobalValue {

     public int versionCode, push;
     public String versionName, lang, pushToken;

     public int loginState;
     public String userUuid, userPartition, userNick;
     public int userDbState;

     public void setDataLogin(String _userUuid, String _userPartition, String _userNick, int _userDbState) {
         push = PUSH_ON;
         loginState = LOGIN_EXIST;
         userUuid = _userUuid;
         userPartition = _userPartition;
         userNick = _userNick;
         userDbState = _userDbState;

         setDevicePreferences("push", push);
         setUserPreferences("login_state", loginState);
         setUserPreferences("user_uuid", userUuid);
         setUserPreferences("user_partition", userPartition);
         setUserPreferences("user_nick", userNick);
         setUserPreferences("user_db_state", userDbState);
     }

    public void setDataLogout() {
        //Log out 실행
    }

    public Context mContext;
     public Activity mActivity;
     public boolean isDebug = false;

     public String webUrl;
     public String apiUrl;

     public void setActivity(Context context, Activity activity) {
         mContext = context;
         mActivity = activity;

         versionName = getDevicePreferences("version_name", NOW_VERSION_NAME);
         versionCode = getDevicePreferences("version_code", NOW_VERSION_CODE);
         push = getDevicePreferences("push", PUSH_OFF);
         lang = getDevicePreferences("lang", LANG_DEFAULT);
         pushToken = getDevicePreferences("push_token", USER_PUSH_TOKEN_DEFAULT);

         loginState = getUserPreferences("login_state", LOGIN_NULL);
         userUuid = getUserPreferences("user_uuid", USER_UUID_DEFAULT);
         userPartition = getUserPreferences("user_partition", USER_PARTITION_DEFAULT);
         userNick = getUserPreferences("user_nick", USER_NICK_DEFAULT);
         userDbState = getUserPreferences("user_db_state", USER_DB_STATE_DEFAULT);

         if (lang.length() != 2 || !lang.equals("ko")) {
             lang = LANG_DEFAULT;
         }

         setToastMessage();
     }

     //region Start, finish Activity

    public void startActivityClass(Class c) {
        Intent intent = new Intent(mContext, c);
        startActivity(intent);
    }
    public void startActivityClass(Class c, int showId, int hideId) {
        Intent intent = new Intent(mContext, c);
        startActivity(intent);
        overridePendingTransition(showId, hideId);
    }

    public void startActivityResultClass(Class c, int requestCode) {
        Intent intent = new Intent(mContext, c);
        startActivityForResult(intent, requestCode);
    }
    public void startActivityResultClass(Class c, int requestCode, int showId, int hideId) {
        Intent intent = new Intent(mContext, c);
        startActivityForResult(intent, requestCode);
        overridePendingTransition(showId, hideId);
    }
    public void startActivityIntent(Intent intent) {
        startActivity(intent);
    }
    public void startActivityIntent(Intent intent, int showId, int hideId) {
        startActivity(intent);
        overridePendingTransition(showId, hideId);
    }
    public void startActivityIntentForResult(Intent intent, int requestCode) {
        startActivityForResult(intent, requestCode);
    }
    public void startActivityIntentForResult(Intent intent, int requestCode, int showId, int hideId) {
        startActivityForResult(intent, requestCode);
        overridePendingTransition(showId, hideId);
    }
    public void finishActivity() {
        finish();
    }
    public void finishActivity(int showId, int hideId) {
        finish();
        overridePendingTransition(showId, hideId);
    }

    public void BackClicked(View v) {
        backActivity();
    }

    public void backActivity() {
        finishActivity(R.anim.animation_stop_short, R.anim.animation_fade_out);
    }

    //end region

     //region Toast Message
    public static Toast mToast;

     public void setToastMessage() {
         mToast = Toast.makeText(mContext, "null", Toast.LENGTH_SHORT);
     }

    public void showToastMessage(String msg) {
        mToast.setText(msg);
        mToast.show();
    }

    public void showToastMessage(int id) {
        mToast.setText(id);
        mToast.show();
    }

    //end region

     //region Preference Getter and Setter

    public int getUserPreferences(String key, int fault) {
        SharedPreferences pref = getSharedPreferences(USER_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return pref.getInt(key, fault);
    }
    public String getUserPreferences(String key, String fault) {
        SharedPreferences pref = getSharedPreferences(USER_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return pref.getString(key, fault);
    }
    public void setUserPreferences(String key, int value) {
        SharedPreferences pref = getSharedPreferences(USER_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void setUserPreferences(String key, String value) {
        SharedPreferences pref = getSharedPreferences(USER_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public void clearUserPreferences() {
        SharedPreferences pref = getSharedPreferences(USER_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public int getViewPreferences(String key, int fault) {
        SharedPreferences pref = getSharedPreferences(VIEW_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return pref.getInt(key, fault);
    }
    public String getViewPreferences(String key, String fault) {
        SharedPreferences pref = getSharedPreferences(VIEW_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return pref.getString(key, fault);
    }
    public void setViewPreferences(String key, int value) {
        SharedPreferences pref = getSharedPreferences(VIEW_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void setViewPreferences(String key, String value) {
        SharedPreferences pref = getSharedPreferences(VIEW_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }
    public void clearViewPreferences() {
        SharedPreferences pref = getSharedPreferences(VIEW_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.clear();
        editor.apply();
    }

    public int getDevicePreferences(String key, int fault) {
        SharedPreferences pref = getSharedPreferences(DEVICE_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return pref.getInt(key, fault);
    }
    public String getDevicePreferences(String key, String fault) {
        SharedPreferences pref = getSharedPreferences(DEVICE_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        return pref.getString(key, fault);
    }
    public void setDevicePreferences(String key, int value) {
        SharedPreferences pref = getSharedPreferences(DEVICE_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putInt(key, value);
        editor.apply();
    }
    public void setDevicePreferences(String key, String value) {
        SharedPreferences pref = getSharedPreferences(DEVICE_PREFERENCE_NAME, Activity.MODE_PRIVATE);
        SharedPreferences.Editor editor = pref.edit();
        editor.putString(key, value);
        editor.apply();
    }

    //end region


    // hide keyboard region
    public boolean isKeyboardHide = true;

    @Override // hide keyboard when touch outside
    public boolean dispatchTouchEvent(MotionEvent ev) {
        View v = getCurrentFocus();

        if (v != null &&
                (ev.getAction() == MotionEvent.ACTION_UP || ev.getAction() == MotionEvent.ACTION_MOVE) &&
                v instanceof EditText &&
                !v.getClass().getName().startsWith("android.webkit."))
        {
            int scrcoords[] = new int[2];
            v.getLocationOnScreen(scrcoords);
            float x = ev.getRawX() + v.getLeft() - scrcoords[0];
            float y = ev.getRawY() + v.getTop() - scrcoords[1];

            if (x < v.getLeft() || x > v.getRight() || y < v.getTop() || y > v.getBottom()) { // when touch outside
                if (isKeyboardHide) {
                    hideSoftKeyboard(mActivity);
                    clearFocusBundle();
                }
            }
        }
        return super.dispatchTouchEvent(ev);
    }
    public static void hideSoftKeyboard(Activity activity) { // hide keyboard
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(activity.getCurrentFocus().getWindowToken(), 0);
    }
    public void clearFocusBundle() {

    }
    public static void showSoftKeyboard(Activity activity, EditText editText) {
        InputMethodManager inputMethodManager = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.showSoftInput(editText, 0);
    }

    //endregion

    //region AppExit
    public long backKeyPressedTime;

    public void exitApp() {
        long nowTime = System.currentTimeMillis();
        if (nowTime > backKeyPressedTime + BACK_KEY_DELAY_TIME) {
            backKeyPressedTime = nowTime;
            showToastMessage(R.string.msg_app_exit);

        } else if (nowTime <= backKeyPressedTime + BACK_KEY_DELAY_TIME) {
            mToast.cancel();
            ActivityCompat.finishAffinity(mActivity);
        }
    }

    public void killApp() {
        ActivityCompat.finishAffinity(mActivity);
    }

    //endregion
}
