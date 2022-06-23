package com.example.ordinario.simpleMVP.Base;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivity <Presenter extends BasePresenter> extends AppCompatActivity {
    protected Presenter miPresenter;

    protected abstract Presenter createPresenter(@NonNull final Context context);

    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        miPresenter = createPresenter(this);
        miPresenter.onCreate(savedInstanceState);
    }

    public void onSaveInstanceState(Bundle outState, PersistableBundle outPersistableBundle){
        super.onSaveInstanceState(outState, outPersistableBundle);
        miPresenter.onSaveInstanceState(outState);
    }

    protected void onPause(){
        super.onPause();
        miPresenter.onPause();
    }

    protected void onDestroy(){
        super.onDestroy();
        miPresenter.onDestroy();
    }

    protected void onActivityResult (int requestCode, int resultCode, @Nullable Intent data){
        super.onActivityResult(requestCode, resultCode, data);
        miPresenter.onActivityResult(requestCode, resultCode, data);
    }

    public void onRequestPermissionResult (int requestCode, @NonNull String[] permissions, @NonNull final int[] grantResults){
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        miPresenter.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }
}
