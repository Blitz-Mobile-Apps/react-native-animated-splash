package com.blitzapp.animatedsplash.animation;


import static android.content.ContentValues.TAG;
import static com.blitzapp.animatedsplash.AnimationsList.animationListHead;
import static com.blitzapp.animatedsplash.AnimationsList.animationsList;
import static com.blitzapp.animatedsplash.animation.Constants.FADE;
import static com.blitzapp.animatedsplash.animation.Constants.ROTATE;
import static com.blitzapp.animatedsplash.animation.Constants.SCALE;
import static com.blitzapp.animatedsplash.animation.Constants.SLIDE;
import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

import android.app.Dialog;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Handler;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.FrameLayout;

import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.core.content.ContextCompat;

import com.blitzapp.animatedsplash.R;
import com.facebook.react.bridge.ReactContext;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;


public class Splash {
    public static ReactContext savedReactContext = null;
    public static Context applicationContext;
    public static boolean shouldHide = false;
    private static Dialog dialog;
    public static Handler mHandler;
    public static int screenWidth;
    public static int screenHeight;
    private static Button exitBtn;
    public static boolean jsCalled = false;
    public static int counter = 0;
    public static int hidecounter = 0;
    public static int priority = 0;
    public static int hidepriority = 0;
    public static int animateObjectLength;
    public static int hideanimateObjectLength;
    public static boolean allExecuted = false;
    public static boolean allHideExecuted = false;

    private static ConstraintLayout mainBackground;
    public static FrameLayout view;

    public static int hideDelay = 1;
    public static boolean isHideOnDialogAnimation = false;
    //    public static List<List<ObjectAnimation>> animatedObjectList = new ArrayList<>();
    public static LinkedList<Object> animatedObjectList = new LinkedList<>();
    public static List<ObjectAnimation> hideanimatedObjectList = new ArrayList<>();

    public static List<GroupAnimation> groupObjectList = new ArrayList<>();
    public static ObjectAnimation hideObject;

    public static boolean animationStatus = false;


    public Splash(Context context) {
        getWindowDimensions();
        applicationContext = context;
        // Create dialog to present view
        dialog = new Dialog(context, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
        dialog.setCancelable(false);
        view = new FrameLayout(context);
        dialog.setContentView(view);
        view.getLayoutParams().height = screenHeight;
        view.getLayoutParams().width = screenWidth;
        setView();
//        animationList = new com.blitzapp.animatedsplash.LinkedList();
        mHandler = new Handler();
    }

    public void setSplashHideAnimation(String animationType) {
        if (animationType == "FADE") {
            dialog.getWindow().getAttributes().windowAnimations = R.style.fade; //style id
        } else if (animationType == "SLIDEDOWN") {
            dialog.getWindow().getAttributes().windowAnimations = R.style.slideDown; //style id
        } else if (animationType == "SLIDELEFT") {
            dialog.getWindow().getAttributes().windowAnimations = R.style.slideLeft; //style id
        } else if (animationType == "SLIDERIGHT") {
            dialog.getWindow().getAttributes().windowAnimations = R.style.slideRight; //style id
        }
    }

    public void setAnimationStatus(boolean animationStatus) {
        this.animationStatus = animationStatus;
    }

    public void setSplashHideDelay(int hideDelay) {
        this.hideDelay = hideDelay;
    }

    private static void getWindowDimensions() {
        DisplayMetrics metrics = Resources.getSystem().getDisplayMetrics();
        screenWidth = metrics.widthPixels;
        screenHeight = metrics.heightPixels;
    }

    public static void setView() {
        getWindowDimensions();
        dialog.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,
                WindowManager.LayoutParams.MATCH_PARENT);

    }

    public void ShowSplash() {
        Log.d(TAG, "createDialog: " + animatedObjectList.size());
        animateObjectLength = animatedObjectList.size() - 1;
        hideanimateObjectLength = hideanimatedObjectList.size();
        dialog.show();

        new Runnable() {
            @Override
            public void run() {
                runAnimation();
            }
        }.run();
    }

    public static void setBackgroundImage(Integer drawable) {

        view.setBackground(ContextCompat.getDrawable(applicationContext, drawable));
    }

    public void setBackgroundColor(String colorString) {

        view.setBackgroundColor(Color.parseColor(colorString));
    }

    public void addAnimatedImage(AnimatedObject objects) {

            View View = objects.initializeObject();
            view.addView(View);

    }

    public void addStaticImage(AnimatedObject objects)  {

            View View = objects.initializeObject();
            view.addView(View);

    }

    public static void addTexttoView(AnimatedText objects) {
        View View = objects.initializeObject();
        view.addView(View);
    }

    public static void runAnimation() {
        if(!animationsList.isEmpty()){
            runSpecificAnimation(animationsList.get(animationListHead));
        }else{
            shouldHide = true;
        }

    }


    public static void runSpecificAnimation(ObjectAnimation object) {
        if (object.getExecuted()) {
            return;
        } else {
            object.setExecuted(true);
        }
        switch (object.animationType) {
            case SLIDE:
                object.slideAnimation(object);
                break;
            case ROTATE:
                object.rotateAnimation(object);
                break;
            case SCALE:
                object.scaleAnimation(object);
                break;
            case FADE:
                object.fadeAnimation(object);
                break;
        }
    }

    public static void runHideAnimation(ObjectAnimation object) {


        switch (object.animationType) {
            case SLIDE:
                object.slideHideAnimation(object);
                break;
            case ROTATE:
                object.rotateHideAnimation(object);
                break;
            case SCALE:
                object.scaleHideAnimation(object);
                break;
            case FADE:
                object.fadeHideAnimation(object);
                break;
        }
    }


    public static void hide() {
        jsCalled = true;
        if (shouldHide == true) {
            Log.d(TAG, "hidecalled true: ");
            runOnUiThread(new Runnable() {

                @Override
                public void run() {
                    animationhide();

                }
            }, hideDelay);
        } else {
            animationhide();
        }
    }

    public static void animationhide() {
        if (shouldHide == true && jsCalled == true) {
            new Timer().schedule(new TimerTask() {
                @Override
                public void run() {
                    dismissDialog();
                }
            }, hideDelay);
        }
    }


    public static void dismissDialog() {
        dialog.dismiss();
    }

//    public void createSplashView(com.geoff.MainActivity mainActivity) {
//    }
}
