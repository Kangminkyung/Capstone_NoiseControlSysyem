package com.monad.noisecontrolsystem;

import android.content.Intent;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.monad.noisecontrolsystem.Activity.MainActivity;
import com.monad.noisecontrolsystem.Activity.NetworkCall;
import com.monad.noisecontrolsystem.Model.Contributor;
import com.monad.noisecontrolsystem.Model.GitHubService;

import java.io.IOException;
import java.util.List;

import retrofit2.Call;
import retrofit2.Response;

public class Intro extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intro);

        GitHubService gitHubService = GitHubService.retrofit.create(GitHubService.class);
        final Call<List<Contributor>> call = gitHubService.repoContributors("square", "retrofit");
        new NetworkCall().execute(call);

        Intent i = new Intent(this, MainActivity.class);
        startActivity(i);
        finish();
    }


}
