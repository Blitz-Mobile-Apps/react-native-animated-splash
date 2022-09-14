

## USAGE

 ###  Android
 >Following are the basic examples of using react-native-animated-splash. Go to your MainActivity.java file and add following code.
 
#### Example Animation 1
 
 ```sh
 package com.animatedsplashexample1;

import static com.blitzapp.animatedsplash.animation.AnimatedText.FIT_CENTER;
import static com.blitzapp.animatedsplash.animation.Constants.FADE;
import static com.blitzapp.animatedsplash.animation.Constants.SCALE;
import static com.blitzapp.animatedsplash.animation.Constants.SPLASH_SLIDE_RIGHT;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;
import com.blitzapp.animatedsplash.animation.AnimatedObject;
import com.blitzapp.animatedsplash.animation.GroupAnimation;
import com.blitzapp.animatedsplash.animation.ObjectAnimation;
import com.blitzapp.animatedsplash.animation.SingleAnimation;
import com.blitzapp.animatedsplash.animation.Splash;

import android.os.Bundle;
import android.util.Log;


import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;

public class MainActivity extends ReactActivity {

    /**
     * Returns the name of the main component registered from JavaScript. This is used to schedule
     * rendering of the component.
     */
    @Override
    protected String getMainComponentName() {
        return "AnimatedSplashExample1";
    }

    /**
     * Returns the instance of the {@link ReactActivityDelegate}. There the RootView is created and
     * you can specify the renderer you wish to use - the new renderer (Fabric) or the old renderer
     * (Paper).
     */
    @Override
    protected ReactActivityDelegate createReactActivityDelegate() {
        return new MainActivityDelegate(this, getMainComponentName());
    }

    public static class MainActivityDelegate extends ReactActivityDelegate {
        public MainActivityDelegate(ReactActivity activity, String mainComponentName) {
            super(activity, mainComponentName);
        }

        @Override
        protected ReactRootView createRootView() {
            ReactRootView reactRootView = new ReactRootView(getContext());
            // If you opted-in for the New Architecture, we enable the Fabric Renderer.
            reactRootView.setIsFabric(BuildConfig.IS_NEW_ARCHITECTURE_ENABLED);
            return reactRootView;
        }

        public void onCreate(Bundle saved) {
            super.onCreate(saved);
            try {
                initiateSplash();
            } catch (Exception e) {
                Log.e("ANIMATED_SPLASH", e.getMessage());
            }
        }

        public void initiateSplash() throws Exception {

            // Create Splash
            Splash splash = new Splash(getContext());
            //Set Background Color To View
            splash.setBackgroundColor("#101010");
            //Set Hiding Animation for Splash
            splash.setSplashHideAnimation(SPLASH_SLIDE_RIGHT);
            //Set Delay for Splash to hide
            splash.setSplashHideDelay(1500);

            //Creating Image and adding its properties and animation

            AnimatedObject logoimage = new AnimatedObject(R.drawable.logo, screenHeight * 0.24, screenWidth * 0.4);
            splash.addAnimatedImage(logoimage);


            ObjectAnimation logoimageAnimation1 = new ObjectAnimation(logoimage, FADE, 1000, 0f, 1f, false);
            ObjectAnimation logoimageAnimation2 = new ObjectAnimation(logoimage, SCALE, 1000, 0f, 1f, 0f, 1f, false);

            AnimatedObject image1 = new AnimatedObject(R.drawable.oval1, screenHeight * 0.39, screenWidth * 0.76);
            image1.setVisibility(false);
            ObjectAnimation image1Animation = new ObjectAnimation(image1, FADE, 500, 0f, 1f);
            splash.addAnimatedImage(image1);

            AnimatedObject image2 = new AnimatedObject(R.drawable.oval2, screenHeight * 0.537, screenWidth + screenWidth * 0.06);
            ObjectAnimation image2Animation = new ObjectAnimation(image2, FADE, 500, 0f, 1f);
            image2.setVisibility(false);
            splash.addAnimatedImage(image2);

            AnimatedObject image3 = new AnimatedObject(R.drawable.oval3, screenHeight * 0.676, screenWidth + screenWidth * 0.29);
            ObjectAnimation image3Animation = new ObjectAnimation(image3, FADE, 500, 0f, 1f);
            image3.setVisibility(false);
            splash.addAnimatedImage(image3);

            GroupAnimation group1 = new GroupAnimation(1);
            group1.addAnimation(logoimageAnimation1);
            group1.addAnimation(logoimageAnimation2);

            SingleAnimation single1  = new SingleAnimation(image1Animation,2);
            SingleAnimation single2  = new SingleAnimation(image2Animation,3);
            SingleAnimation single3  = new SingleAnimation(image3Animation,4);

            splash.ShowSplash();

        }


        @Override
        protected boolean isConcurrentRootEnabled() {
            // If you opted-in for the New Architecture, we enable Concurrent Root (i.e. React 18).
            // More on this on https://reactjs.org/blog/2022/03/29/react-v18.html
            return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
        }
    }
}

```
Then call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 
![](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/master/example1.gif?raw=true)
>
>
#### Example Animation 2

```sh
package com.animatedsplashexample2;

import static com.blitzapp.animatedsplash.animation.AnimatedText.FIT_XY;
import static com.blitzapp.animatedsplash.animation.Constants.SCALE;
import static com.blitzapp.animatedsplash.animation.Constants.SLIDE;
import static com.blitzapp.animatedsplash.animation.Constants.SPLASH_SLIDE_DOWN;
import static com.blitzapp.animatedsplash.animation.Constants.SPLASH_SLIDE_LEFT;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;

import android.os.Bundle;

import com.blitzapp.animatedsplash.animation.AnimatedObject;
import com.blitzapp.animatedsplash.animation.GroupAnimation;
import com.blitzapp.animatedsplash.animation.ObjectAnimation;
import com.blitzapp.animatedsplash.animation.SingleAnimation;
import com.blitzapp.animatedsplash.animation.Splash;
import com.facebook.react.ReactActivity;
import com.facebook.react.ReactActivityDelegate;
import com.facebook.react.ReactRootView;

public class MainActivity extends ReactActivity {

  /**
   * Returns the name of the main component registered from JavaScript. This is used to schedule
   * rendering of the component.
   */
  @Override
  protected String getMainComponentName() {
    return "AnimatedSplashExample2";
  }

  /**
   * Returns the instance of the {@link ReactActivityDelegate}. There the RootView is created and
   * you can specify the renderer you wish to use - the new renderer (Fabric) or the old renderer
   * (Paper).
   */
  @Override
  protected ReactActivityDelegate createReactActivityDelegate() {
    return new MainActivityDelegate(this, getMainComponentName());
  }

  public static class MainActivityDelegate extends ReactActivityDelegate {
    public MainActivityDelegate(ReactActivity activity, String mainComponentName) {
      super(activity, mainComponentName);
    }

    @Override
    protected ReactRootView createRootView() {
      ReactRootView reactRootView = new ReactRootView(getContext());
      // If you opted-in for the New Architecture, we enable the Fabric Renderer.
      reactRootView.setIsFabric(BuildConfig.IS_NEW_ARCHITECTURE_ENABLED);
      return reactRootView;
    }

    @Override
    protected boolean isConcurrentRootEnabled() {
      // If you opted-in for the New Architecture, we enable Concurrent Root (i.e. React 18).
      // More on this on https://reactjs.org/blog/2022/03/29/react-v18.html
      return BuildConfig.IS_NEW_ARCHITECTURE_ENABLED;
    }
  }

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    initiateSplash();
  }

  public void initiateSplash() {

    //create dialog
    Splash splash = new Splash(this);

    //set background
    splash.setBackgroundImage(R.drawable.splashbg);

    // set splash hide animation
    splash.setSplashHideAnimation(SPLASH_SLIDE_LEFT);

    // set splash hide delay
    splash.setSplashHideDelay(1500);

    // Create and add images to view
    AnimatedObject image1 = new AnimatedObject(R.drawable.header, screenHeight * 0.15, screenWidth);
    image1.setPositionX(0);
    image1.setPositionY(0);
    image1.setScaleType(FIT_XY);
    image1.setVisibility(false);
    splash.addAnimatedImage(image1);

    AnimatedObject image2 = new AnimatedObject(R.drawable.footer, screenHeight * 0.15, screenWidth, 0, screenHeight - screenHeight * 0.15, FIT_XY, false);
    image2.setPositionX(0);
    image2.setPositionY(screenHeight-screenHeight*0.15f);
    image2.setScaleType(FIT_XY);
    image2.setVisibility(false);
    splash.addAnimatedImage(image2);

    AnimatedObject logoimage = new AnimatedObject(R.drawable.logo2, screenHeight * 0.18, screenWidth * 0.45);
    splash.addAnimatedImage(logoimage);
    ObjectAnimation image1Animation = new ObjectAnimation(image1, SLIDE, 780, 0f, 0f, -screenHeight * 0.15f, 0f);
    ObjectAnimation image2Animation = new ObjectAnimation(image2, SLIDE, 780, 0f, 0f, screenHeight * 0.15f, 0f);
    ObjectAnimation logoimageAnimation = new ObjectAnimation(logoimage, SCALE, 780, 0.2f, 1f, 0.2f, 1f);
    // add group animation
    GroupAnimation group1 = new GroupAnimation(1);
    group1.addAnimation(image1Animation);
    group1.addAnimation(image2Animation);


    // add single animation
    SingleAnimation singleAnimation= new SingleAnimation(logoimageAnimation,2);

    splash.ShowSplash();

  }

}

```
Then call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 
 ![](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/master/example2.gif?raw=true)
 >
 >
#### Important Note

> add respective images from your drawable else it will give error
>
> for some variables which appears not defined like "screenHeight", import them from library class.
>
