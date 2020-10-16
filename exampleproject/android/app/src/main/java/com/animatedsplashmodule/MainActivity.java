package com.animatedsplashmodule;

import android.os.Bundle;


import com.blitzapp.animatedsplash.animation.AddImageView;
import com.blitzapp.animatedsplash.animation.GroupAnimation;
import com.facebook.react.ReactActivity;

import static com.blitzapp.animatedsplash.animation.Splash.SPLASHSLIDEDOWN;
import static com.blitzapp.animatedsplash.animation.Splash.FADE;
import static com.blitzapp.animatedsplash.animation.Splash.SCALE;
import static com.blitzapp.animatedsplash.animation.Splash.SLIDE;
import static com.blitzapp.animatedsplash.animation.Splash.createSplashView;
import static com.blitzapp.animatedsplash.animation.Splash.performSingleAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;
import static com.blitzapp.animatedsplash.animation.Splash.setBackgroundColor;
import static com.blitzapp.animatedsplash.animation.Splash.setBackgroundImage;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideDelay;
import static com.blitzapp.animatedsplash.animation.Splash.splashShow;


public class MainActivity extends ReactActivity {


    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "animatedsplashmodule";
    }


    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        initiateSplash();
    }

    public void initiateSplash() {
        //Create dialog
        createSplashView(MainActivity.this);

        //Set Background
        setBackgroundColor("#101010");
        setSplashHideAnimation(SPLASHSLIDEDOWN);

        setSplashHideDelay(1500);
        // Create and add images to view
        AddImageView logoimage = new AddImageView(R.drawable.logo, screenHeight * 0.24, screenWidth * 0.4, AddImageView.getCenterX(screenWidth * 0.41), AddImageView.getCenterY(screenHeight * 0.26), 0, AddImageView.FIT_CENTER, false);

        AddImageView circle1 = new AddImageView(R.drawable.oval3, screenHeight * 0.39, screenWidth * 0.76, AddImageView.getCenterX(screenWidth * 0.76), AddImageView.getCenterY(screenHeight * 0.39), 0, AddImageView.FIT_XY, false);


        AddImageView circle2 = new AddImageView(R.drawable.oval2, screenHeight * 0.537, screenWidth + screenWidth * 0.06, AddImageView.getCenterX(screenWidth + screenWidth * 0.06), AddImageView.getCenterY(screenHeight * 0.537), 0, AddImageView.FIT_XY, false);

        AddImageView circle3 = new AddImageView(R.drawable.oval1, screenHeight * 0.676, screenWidth + screenWidth * 0.29, AddImageView.getCenterX(screenWidth + screenWidth * 0.29), AddImageView.getCenterY(screenHeight * 0.676), 0, AddImageView.FIT_XY, false);

        //    // Add single animation
        GroupAnimation group1 = new GroupAnimation();
        group1.performGroupAnimation(logoimage, FADE, 400, 0f, 1f);
        group1.performGroupAnimation(logoimage, SCALE, 400, 0f, 1f, 0f, 1f);

        performSingleAnimation(circle1, FADE, 500, 0f, 1f);

        performSingleAnimation(circle2, FADE, 400, 0f, 1f);

        performSingleAnimation(circle3, FADE, 400, 0f, 1f);


        splashShow();

    }
}
