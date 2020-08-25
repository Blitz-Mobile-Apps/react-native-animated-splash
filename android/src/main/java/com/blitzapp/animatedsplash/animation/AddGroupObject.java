package com.blitzapp.animatedsplash.animation;


import android.util.Log;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

import static android.content.ContentValues.TAG;

public class AddGroupObject {
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
    private CreateImageObject object;
    public static int groupCount = 0;
    public static int groupinnerCount = 0;
    public boolean isLastObject=false;
    private int priority;
    // for rotate animation
    private float rotateStartDegree;
    private float rotateEndDegree;
    private View animationView;
    public static List<AnimateObject> groupObjectList = new ArrayList<>();

    public AddGroupObject() {
        groupCount++;
        Log.d(TAG, "add: " + groupCount);
    }

    public static Splash splash = new Splash();

    public static void add(CreateImageObject createImageObject, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean isLoop, boolean isLastObject) {
        splash.animateObject(createImageObject, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta,isLoop,isLastObject, groupCount);
    }

    public static void add(CreateImageObject createImageObject, String typeofanimation, int duration, float fromValue, float toValue, boolean isLoop, boolean isLastObject) {
        splash.animateObject(createImageObject, typeofanimation, duration, fromValue, toValue, isLoop,isLastObject, groupCount);
    }

    public static void add(CreateImageObject createImageObject, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean isLastObject) {
        splash.animateObject(createImageObject, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta,false,isLastObject, groupCount);
    }

    public static void add(CreateImageObject createImageObject, String typeofanimation, int duration, float fromValue, float toValue, boolean isLastObject) {
        splash.animateObject(createImageObject, typeofanimation, duration, fromValue, toValue, false, isLastObject, groupCount);
    }
}