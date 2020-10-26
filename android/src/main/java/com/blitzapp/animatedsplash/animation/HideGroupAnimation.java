package com.blitzapp.animatedsplash.animation;


import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class HideGroupAnimation {
    private String animationType;
    private int animationDuration;
    private boolean setFillAfter;
    // Translate animation
    private float fromXDelta;
    private float toXDelta;
    private float fromYDelta;
    private float toYDelta;
    private float scaleFromX;
    private float scaleToX;
    private float scaleFromY;
    private float scaleToY;
    private AnimatedImage object;
    public static int hidegroupCount = 0;
    public static int groupinnerCount = 0;
    public boolean isLastObject=false;
    private int priority;
    // for rotate animation
    private float rotateStartDegree;
    private float rotateEndDegree;
    private View animationView;
    public static List<AnimateObject> groupObjectList = new ArrayList<>();

    public HideGroupAnimation() {
        hidegroupCount++;
        Log.d(TAG, "add: " + hidegroupCount);
    }

    public static Splash splash = new Splash();


    public static void performHideGroupAnimation(AnimatedImage createImageObject, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {

        splash.performGroupAnimationOnHide(createImageObject, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, hidegroupCount);
    }

    public static void performHideGroupAnimation(AnimatedImage createImageObject, String typeofanimation, int duration, float fromValue, float toValue) {
        Log.d(TAG, "performGroupAnimation: ");

        splash.performGroupAnimationOnHide(createImageObject, typeofanimation, duration, fromValue, toValue, hidegroupCount);
    }
}