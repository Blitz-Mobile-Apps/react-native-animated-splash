package com.animatedsplashmodule;

import android.os.Bundle;


import com.blitzapp.animatedsplash.animation.AnimateGroupObject;
import com.facebook.react.ReactActivity;
import com.blitzapp.animatedsplash.animation.AddGroupObject;
import com.blitzapp.animatedsplash.animation.CreateImageObject;

import static com.blitzapp.animatedsplash.animation.Splash.DIALOGSLIDEDOWN;
import static com.blitzapp.animatedsplash.animation.Splash.DIALOGSLIDELEFT;
import static com.blitzapp.animatedsplash.animation.Splash.FADE;
import static com.blitzapp.animatedsplash.animation.Splash.SCALE;
import static com.blitzapp.animatedsplash.animation.Splash.SLIDE;
import static com.blitzapp.animatedsplash.animation.Splash.animateSingleObject;
import static com.blitzapp.animatedsplash.animation.Splash.createDialog;
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
        createDialog(MainActivity.this);

        //Set Background
        setBackgroundColor("#101010");
        setSplashHideAnimation(DIALOGSLIDEDOWN);

        setSplashHideDelay(1500);
        // Create and add images to view
     CreateImageObject addObject1 = new CreateImageObject(R.drawable.logo, screenHeight * 0.24, screenWidth * 0.4, CreateImageObject.getCenterX(screenWidth * 0.41), CreateImageObject.getCenterY(screenHeight * 0.26), 0, CreateImageObject.FIT_CENTER, false);

        CreateImageObject addObject2 = new CreateImageObject(R.drawable.oval3, screenHeight * 0.39, screenWidth * 0.76, CreateImageObject.getCenterX(screenWidth * 0.76), CreateImageObject.getCenterY(screenHeight * 0.39), 0, CreateImageObject.FIT_XY, false);


        CreateImageObject addObject3 = new CreateImageObject(R.drawable.oval2, screenHeight * 0.537, screenWidth + screenWidth * 0.06, CreateImageObject.getCenterX(screenWidth + screenWidth * 0.06), CreateImageObject.getCenterY(screenHeight * 0.537), 0, CreateImageObject.FIT_XY, false);

        CreateImageObject addObject4 = new CreateImageObject(R.drawable.oval1, screenHeight * 0.676, screenWidth + screenWidth * 0.29, CreateImageObject.getCenterX(screenWidth + screenWidth * 0.29), CreateImageObject.getCenterY(screenHeight * 0.676), 0, CreateImageObject.FIT_XY, false);

        //    // Add single animation
     AnimateGroupObject gObject1 = new AnimateGroupObject();
        gObject1.addObject(addObject1, FADE, 400, 0f, 1f, false);
        gObject1.addObject(addObject1, SCALE, 400, 0f, 1f, 0f, 1f, false);

        animateSingleObject(addObject2, FADE, 500, 0f, 1f, false);

        animateSingleObject(addObject3, FADE, 400, 0f, 1f, false);

        animateSingleObject(addObject4, FADE, 400, 0f, 1f, true);


        splashShow();

    }
}
