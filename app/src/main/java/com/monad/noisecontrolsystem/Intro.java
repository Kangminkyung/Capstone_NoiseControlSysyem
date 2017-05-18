package com.monad.noisecontrolsystem;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.monad.noisecontrolsystem.Activity.InitActivity;
import com.monad.noisecontrolsystem.Activity.MainActivity;
import com.monad.noisecontrolsystem.Realm.Myinfo;

import io.realm.Realm;
import io.realm.RealmQuery;
import io.realm.RealmResults;


public class Intro extends AppCompatActivity {
    Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();


        RealmQuery<Myinfo> query = realm.where(Myinfo.class);
        RealmResults<Myinfo> result = query.findAll();

        if(result.size() == 0) {
            Intent i = new Intent(this, InitActivity.class);
            startActivity(i);
        } else {
            Intent i = new Intent(this, MainActivity.class);
            startActivity(i);
        }
        finish();
    }


}
