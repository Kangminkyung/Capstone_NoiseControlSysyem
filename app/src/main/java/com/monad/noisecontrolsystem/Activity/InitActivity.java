package com.monad.noisecontrolsystem.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;

import com.monad.noisecontrolsystem.R;
import com.monad.noisecontrolsystem.Realm.Myinfo;

import io.realm.Realm;

public class InitActivity extends AppCompatActivity implements View.OnClickListener {
    private Button next;
    private Realm realm;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_init);

        Realm.init(getApplicationContext());
        realm = Realm.getDefaultInstance();

        SpinnerSet();
        LayoutSet();
    }


    private void SpinnerSet() {
        Spinner spinner = (Spinner) findViewById(R.id.test1);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.planets_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
    }
    private void LayoutSet() {
        next = (Button) findViewById(R.id.initActivity_next);
        next.setOnClickListener(this);
    }



    @Override
    public void onClick(View v) {
        int id = v.getId();

        switch (id) {
            case R.id.initActivity_next:

                realm.beginTransaction();
                Myinfo myinfo = realm.createObject(Myinfo.class); // Create a new object
                myinfo.setFirtNumber(101);
                myinfo.setLastNumber(102);
                realm.commitTransaction();
                Intent i = new Intent(this, MainActivity.class);
                startActivity(i);
                break;
        }
    }
}
