package com.exampleproject2;

import android.os.Bundle;

import com.blitzapp.animatedsplash.animation.AnimateGroupObject;
import com.blitzapp.animatedsplash.animation.CreateImageObject;
import com.facebook.react.ReactActivity;

import static com.blitzapp.animatedsplash.animation.Splash.DIALOGSLIDELEFT;
import static com.blitzapp.animatedsplash.animation.Splash.ROTATE;
import static com.blitzapp.animatedsplash.animation.Splash.SCALE;
import static com.blitzapp.animatedsplash.animation.Splash.SLIDE;
import static com.blitzapp.animatedsplash.animation.Splash.animateSingleObject;
import static com.blitzapp.animatedsplash.animation.Splash.createDialog;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;
import static com.blitzapp.animatedsplash.animation.Splash.setBackgroundImage;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideDelay;
import static com.blitzapp.animatedsplash.animation.Splash.splashShow;

public class MainActivity extends ReactActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initiateSplash();
  }

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */

  @Override
  protected String getMainComponentName() {
    return "exampleproject2";
  }

  public void initiateSplash() {
    //Create dialog
    createDialog(MainActivity.this);

       setBackgroundImage(R.drawable.splashbg);
       setSplashHideAnimation(DIALOGSLIDELEFT);

       setSplashHideDelay(1500);

       // Create and add images to view
       CreateImageObject addObject1 = new CreateImageObject(R.drawable.header, screenHeight * 0.15, screenWidth, 0, 0, CreateImageObject.FIT_XY, false);
       CreateImageObject addObject2 = new CreateImageObject(R.drawable.footer, screenHeight * 0.15, screenWidth, 0, screenHeight - screenHeight * 0.15, CreateImageObject.FIT_XY, false);
       CreateImageObject addObject3 = new CreateImageObject(R.drawable.logo2, screenHeight * 0.18, screenWidth * 0.45, CreateImageObject.getCenterX(screenWidth * 0.45), CreateImageObject.getCenterY(screenHeight * 0.18), CreateImageObject.FIT_XY, false);


       AnimateGroupObject gObject1 = new AnimateGroupObject();
       gObject1.addObject(addObject1, SLIDE, 780, 0f, 0f, -screenHeight * 0.15f, 0f, false);
       gObject1.addObject(addObject2, SLIDE, 780, 0f, 0f, screenHeight * 0.15f, 0f, false);
       animateSingleObject(addObject3, SCALE, 780, 0.2f, 1f, 0.2f, 1f, false);

    splashShow();

  }
}
