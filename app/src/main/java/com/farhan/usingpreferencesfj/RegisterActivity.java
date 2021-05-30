package com.farhan.usingpreferencesfj;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.EditText;
import android.widget.TextView;

public class RegisterActivity extends AppCompatActivity {

    private EditText mViewUser, mViewPassword, mViewRepassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);

        /* Kita inisialisasikan variable ini dengan Form User, Form Password, dan Form Repassword dari Layout RegisterActivity */
        mViewUser =findViewById(R.id.et_emailSignup);
        mViewPassword =findViewById(R.id.et_passwordSignup);
        mViewRepassword =findViewById(R.id.et_passwordSignup2);

        /* Code ini menjalankan Method (razia()) ini, dan akan mentrigger tombol SignUp di keyboard jika disentuh */
        mViewRepassword.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
                if (actionId == EditorInfo.IME_ACTION_DONE || actionId == EditorInfo.IME_NULL) {
                    razia();
                    return true;
                }
                return false;
            }
        });
        /* Code ini menjalankan Method (razia()) ini, akan mentrigger tombol SignUp saat di klik */
        findViewById(R.id.button_signupSignup).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                razia();
            }
        });
    }

    /** Code ini untuk Mengecheck inputan User dan Password dan code ini Memberikan akses ke MainActivity */
    private void razia(){
        /* Lalu COde ini Mereset semua Error dan fokus menjadi default */
        mViewUser.setError(null);
        mViewPassword.setError(null);
        mViewRepassword.setError(null);
        View fokus = null;
        boolean cancel = false;

        /* Code ini mengambil text dari Form User, Password, Repassword dengan variable baru dan bertipe data String*/
        String repassword = mViewRepassword.getText().toString();
        String user = mViewUser.getText().toString();
        String password = mViewPassword.getText().toString();

        /* Kemudian jika form user itu kosong atau MEMENUHI kriteria di Method cekUser() maka yang terjadi adalah Set error di Form-
         * User dengan men-set variable fokus dan error yang ada di View, dan juga di cancel menjadi true*/
        if (TextUtils.isEmpty(user)){
            mViewUser.setError("This field is required");
            fokus = mViewUser;
            cancel = true;
        }else if(cekUser(user)){
            mViewUser.setError("This Username is already exist");
            fokus = mViewUser;
            cancel = true;
        }

        /* Kemudian jika form password kosong dan MEMENUHI kriteria di Method cekPassword maka yang terjadi adalah
         * Reaksinya akan sama dengan percabangan yang ada di User yang di atas. Kemudian itu code tersebut untuk membedakan mana Password dan Repassword*/
        if (TextUtils.isEmpty(password)){
            mViewPassword.setError("This field is required");
            fokus = mViewPassword;
            cancel = true;
        }else if (!cekPassword(password,repassword)){
            mViewRepassword.setError("This password is incorrect");
            fokus = mViewRepassword;
            cancel = true;
        }

        /** Code tersebut jika di cancel akan menumbulkan true, pada variable itu tetap fokus untuk mendapatkan fokus. Jika code tersebut di false, maka
         *  yang terjadi adalah Kembali ke LoginActivity dan Set User dan Password untuk data yang sudah terdaftar */
        if (cancel){
            fokus.requestFocus();
        }else{
            Preferences.setRegisteredUser(getBaseContext(),user);
            Preferences.setRegisteredPass(getBaseContext(),password);
            finish();
        }
    }

    /** Code True jika parameter password sama dengan parameter repassword */
    private boolean cekPassword(String password, String repassword){
        return password.equals(repassword);
    }
    /** Code True jika parameter user sama dengan data user yang terdaftar dari Preferences */
    private boolean cekUser(String user){
        return user.equals(Preferences.getRegisteredUser(getBaseContext()));
    }
}