package com.monad.noisecontrolsystem.Model;

/**
 * Created by temp on 2017. 5. 18..
 */

public class Contributor {

    String login;
    String html_url;

    int contributions;

    @Override
    public String toString() {
        return login + " (" + contributions + ")";
    }
}