package com.example.anglesea;


import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.KeyguardManager;
import android.content.Intent;
import android.hardware.fingerprint.FingerprintManager;
import android.os.Build;
import android.os.Bundle;
import android.security.keystore.KeyGenParameterSpec;
import android.security.keystore.KeyProperties;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


import com.example.anglesea.util.BaseActivity;
import com.example.anglesea.util.StrUtil;
import com.example.anglesea.util.ToastUtil;

import java.security.KeyStore;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import javax.crypto.SecretKey;

import butterknife.BindView;
import butterknife.ButterKnife;


public class LoginActivity extends BaseActivity {
    @BindView(R.id.pwd0)
    TextView pwd0;
    @BindView(R.id.pwd1)
    TextView pwd1;
    @BindView(R.id.pwd2)
    TextView pwd2;
    @BindView(R.id.pwd3)
    TextView pwd3;
    String spwd0, spwd1, spwd2, spwd3;

    @BindView(R.id.t0)
    TextView t0;
    @BindView(R.id.t1)
    TextView t1;
    @BindView(R.id.t2)
    TextView t2;
    @BindView(R.id.t3)
    TextView t3;
    @BindView(R.id.t4)
    TextView t4;
    @BindView(R.id.t5)
    TextView t5;
    @BindView(R.id.t6)
    TextView t6;
    @BindView(R.id.t7)
    TextView t7;
    @BindView(R.id.t8)
    TextView t8;
    @BindView(R.id.t9)
    TextView t9;
    @BindView(R.id.t2t)
    TextView t2t;
    @BindView(R.id.iv_zhiwei)
    ImageView iv_zhiwei;


    final String mypwd = "1234";
    final String userpwd="4321";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_login);
        ButterKnife.bind(this);
        getSupportActionBar().hide();



        t0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t0.getText().toString(), true);
            }
        });

        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t1.getText().toString(), true);
            }
        });
        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t2.getText().toString(), true);
            }
        });
        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t3.getText().toString(), true);
            }
        });
        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t4.getText().toString(), true);
            }
        });
        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t5.getText().toString(), true);
            }
        });
        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t6.getText().toString(), true);
            }
        });
        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t7.getText().toString(), true);
            }
        });
        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t8.getText().toString(), true);
            }
        });
        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue(t9.getText().toString(), true);
            }
        });

        //clear
        t2t.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                setvalue("", false);
            }
        });

        // Fingerprint login
        iv_zhiwei.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                zhiwenLogin();
            }
        });

    }

    // Custom digital login
    private void setvalue(String str, boolean isadd) {
        if (isadd) {
            if (StrUtil.isEmpty(spwd0)) {
                spwd0 = str;
                pwd0.setBackgroundResource(R.mipmap.v1);
                pwd1.setBackgroundResource(R.mipmap.v0);
                pwd2.setBackgroundResource(R.mipmap.v0);
                pwd3.setBackgroundResource(R.mipmap.v0);
            } else if (StrUtil.isEmpty(spwd1)) {
                spwd1 = str;
                pwd0.setBackgroundResource(R.mipmap.v1);
                pwd1.setBackgroundResource(R.mipmap.v1);
                pwd2.setBackgroundResource(R.mipmap.v0);
                pwd3.setBackgroundResource(R.mipmap.v0);
            } else if (StrUtil.isEmpty(spwd2)) {
                spwd2 = str;
                pwd0.setBackgroundResource(R.mipmap.v1);
                pwd1.setBackgroundResource(R.mipmap.v1);
                pwd2.setBackgroundResource(R.mipmap.v1);
                pwd3.setBackgroundResource(R.mipmap.v0);
            } else if (StrUtil.isEmpty(spwd3)) {
                spwd3 = str;
                pwd0.setBackgroundResource(R.mipmap.v1);
                pwd1.setBackgroundResource(R.mipmap.v1);
                pwd2.setBackgroundResource(R.mipmap.v1);
                pwd3.setBackgroundResource(R.mipmap.v1);

                String temp = spwd0 + spwd1 + spwd2 + spwd3;
                if (temp.equals(mypwd)) {
                    ToastUtil.showToast(LoginActivity.this, " The password is correct and the login is successful ");
                    startActivity(new Intent(LoginActivity.this, AdmainProfile.class));
                }else if(temp.equals(userpwd)) {
                    ToastUtil.showToast(LoginActivity.this, " The password is correct and the login is successful ");
                    startActivity(new Intent(LoginActivity.this, UserDashboard.class));
                }else
                {
                    ToastUtil.showToast(LoginActivity.this, " Password error ");
                }


            } else {

            }
        } else {

            if (!StrUtil.isEmpty(spwd3)) {
                spwd3 = str;
                pwd0.setBackgroundResource(R.mipmap.v1);
                pwd1.setBackgroundResource(R.mipmap.v1);
                pwd2.setBackgroundResource(R.mipmap.v1);
                pwd3.setBackgroundResource(R.mipmap.v0);
            } else if (!StrUtil.isEmpty(spwd2)) {
                spwd2 = str;
                pwd0.setBackgroundResource(R.mipmap.v1);
                pwd1.setBackgroundResource(R.mipmap.v1);
                pwd2.setBackgroundResource(R.mipmap.v0);
                pwd3.setBackgroundResource(R.mipmap.v0);
            } else if (!StrUtil.isEmpty(spwd1)) {
                spwd1 = str;
                pwd0.setBackgroundResource(R.mipmap.v1);
                pwd1.setBackgroundResource(R.mipmap.v0);
                pwd2.setBackgroundResource(R.mipmap.v0);
                pwd3.setBackgroundResource(R.mipmap.v0);
            } else if (!StrUtil.isEmpty(spwd0)) {
                spwd0 = str;
                pwd0.setBackgroundResource(R.mipmap.v0);
                pwd1.setBackgroundResource(R.mipmap.v0);
                pwd2.setBackgroundResource(R.mipmap.v0);
                pwd3.setBackgroundResource(R.mipmap.v0);
            } else {
                ToastUtil.showToast(LoginActivity.this, " The password is clear ");
            }


        }
    }

    // Fingerprint login
    private void zhiwenLogin(){


        if (supportFingerprint()) {// Determine whether fingerprint is supported
            initKey();
            initCipher();
        }
    }


    // Fingerprint login
    private static final String DEFAULT_KEY_NAME = "default_key";
    KeyStore keyStore;
    /**
     *  Determine whether fingerprint is supported
     * @return
     */
    @SuppressLint("MissingPermission")
    public boolean supportFingerprint() {
        if (Build.VERSION.SDK_INT < 23) {
            Toast.makeText(this, " Your system version is too low to support fingerprint function ", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            // Keyboard lock manager
            KeyguardManager keyguardManager = getSystemService(KeyguardManager.class);
            // Fingerprint Manager
            FingerprintManager fingerprintManager = getSystemService(FingerprintManager.class);
            if (!fingerprintManager.isHardwareDetected()) {// Judge whether the hardware support does not support fingerprints
                Toast.makeText(this, " Your phone does not support fingerprint function ", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!keyguardManager.isKeyguardSecure()) {// The lock screen has not been set
                Toast.makeText(this, " You haven't set the lock screen yet. Please set the lock screen and add a fingerprint first ", Toast.LENGTH_SHORT).show();
                return false;
            } else if (!fingerprintManager.hasEnrolledFingerprints()) {// Fingerprint not registered
                Toast.makeText(this, " You need to add at least one fingerprint to the system settings ", Toast.LENGTH_SHORT).show();
                return false;
            }
        }
        return true;
    }

    @TargetApi(23)
    private void initKey() {
        try {
            keyStore = KeyStore.getInstance("AndroidKeyStore");
            keyStore.load(null);
            // Secret key generator
            KeyGenerator keyGenerator = KeyGenerator.getInstance(KeyProperties.KEY_ALGORITHM_AES, "AndroidKeyStore");
            KeyGenParameterSpec.Builder builder = new KeyGenParameterSpec.Builder(DEFAULT_KEY_NAME,
                    KeyProperties.PURPOSE_ENCRYPT |
                            KeyProperties.PURPOSE_DECRYPT)
                    .setBlockModes(KeyProperties.BLOCK_MODE_CBC)
                    .setUserAuthenticationRequired(true)
                    .setEncryptionPaddings(KeyProperties.ENCRYPTION_PADDING_PKCS7);
            keyGenerator.init(builder.build());
            keyGenerator.generateKey();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @TargetApi(23)
    private void initCipher() {
        try {
            SecretKey key = (SecretKey) keyStore.getKey(DEFAULT_KEY_NAME, null);
            Cipher cipher = Cipher.getInstance(KeyProperties.KEY_ALGORITHM_AES + "/"
                    + KeyProperties.BLOCK_MODE_CBC + "/"
                    + KeyProperties.ENCRYPTION_PADDING_PKCS7);
            cipher.init(Cipher.ENCRYPT_MODE, key);
            showFingerPrintDialog(cipher);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    private void showFingerPrintDialog(Cipher cipher) {
        FingerprintDialogFragment fragment = new FingerprintDialogFragment();
        fragment.setCipher(cipher);
        fragment.show(getSupportFragmentManager(), "fingerprint");
    }

    public void onAuthenticated() {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
