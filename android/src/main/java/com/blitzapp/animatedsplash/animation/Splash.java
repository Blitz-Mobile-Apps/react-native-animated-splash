package com.blitzapp.animatedsplash.animation;


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
import java.util.List;

import static android.content.ContentValues.TAG;
import static com.facebook.react.bridge.UiThreadUtil.runOnUiThread;

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

    private static ConstraintLayout mainBackground;
    public static FrameLayout view;
    public static final String SLIDE = "SLIDE_ANIMATION";
    public static final String ROTATE = "ROTATE_ANIMATION";
    public static final String SCALE = "SCALE_ANIMATION";
    public static final String FADE = "FADE_ANIMATION";
    public static final String SPLASHSLIDEDOWN = "SLIDEDOWN";
    public static final String SPLASHSLIDELEFT = "SLIDELEFT";
    public static final String SPLASHSLIDERIGHT = "SLIDERIGHT";
    public static final String SPLASHFADE = "FADE";
    public static int hideDelay = 1;
    public static boolean isHideOnDialogAnimation = false;
    public static List<AnimateObject> animatedObjectList = new ArrayList<>();
    public static List<AnimateObject> hideanimatedObjectList = new ArrayList<>();

    public static List<GroupAnimation> groupObjectList = new ArrayList<>();
    public static AnimateObject hideObject;


    //    private static ImageView imageView;
    public static boolean animationStatus = false;

    public static void createSplashView(Context context) {
        getWindowDimensions();
        applicationContext = context;
        // Create dialog to present view
        dialog = new Dialog(context, android.R.style.Theme_DeviceDefault_Light_NoActionBar_Fullscreen);
//        setDialogAnimation(DIALOGFADE);
//        dialog.getWindow().getAttributes().windowAnimations = R.style.Custom; //style id
        dialog.setCancelable(false);
        view = new FrameLayout(context);
        dialog.setContentView(view);
        view.getLayoutParams().height = screenHeight;
        view.getLayoutParams().width = screenWidth;
        setView();

        mHandler = new Handler();
    }

    public static void setSplashHideAnimation(String animationType) {
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

    public static void setAnimationStatus(boolean animationStatus) {
        Splash.animationStatus = animationStatus;
    }

    public static void setSplashHideDelay(int hideDelay) {
        Splash.hideDelay = hideDelay;
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

    public static void splashShow() {
        Log.d(TAG, "createDialog: " + animatedObjectList.size());
        animateObjectLength = animatedObjectList.size();
        hideanimateObjectLength = hideanimatedObjectList.size();
        dialog.show();

        mHandler.postDelayed(new Runnable() {
            @Override
            public void run() {
                runAnimation();

            }
        }, 1000);


    }

//    public static void hide() {
//        dialog.dismiss();
//    }

    public static void setBackgroundImage(Integer drawable) {

        view.setBackground(ContextCompat.getDrawable(applicationContext, drawable));
    }

    public static void setBackgroundColor(String colorString) {

        view.setBackgroundColor(Color.parseColor(colorString));
    }


    public static void addImagetoView(AddImageView objects) {
        View View = objects.initializeObject();
        view.addView(View);
    }


    public static void performSingleAnimation(AddImageView object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean loop) {
        priority++;
        GroupAnimation.groupCount = priority;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, loop, priority));

    }

    public static void performSingleAnimation(AddImageView object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        priority++;
        GroupAnimation.groupCount = priority;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, false, priority));

    }

    public static void performSingleAnimation(AddImageView object, String typeofanimation, int duration, float fromValue, float toValue, boolean loop) {
        priority++;
        GroupAnimation.groupCount = priority;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue, loop, priority));

    }

    public static void performSingleAnimation(AddImageView object, String typeofanimation, int duration, float fromValue, float toValue) {
        priority++;
        GroupAnimation.groupCount = priority;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue, false, priority));

    }

    public static void animateObject(AddImageView object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean loop, int groupCount) {
        priority = groupCount;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, loop, priority));

    }

    public static void animateObject(AddImageView object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, int groupCount) {
        priority = groupCount;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, false, priority));

    }


    public static void animateObject(AddImageView object, String typeofanimation, int duration, float fromValue, float toValue, boolean loop, int groupCount) {
        priority = groupCount;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue, loop, priority));

    }

    public static void animateObject(AddImageView object, String typeofanimation, int duration, float fromValue, float toValue, int groupCount) {
        priority = groupCount;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue, false, priority));

    }

    public static void performHideSingleAnimation(AddImageView object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        isHideOnDialogAnimation = true;
        hidepriority++;
        HideGroupAnimation.hidegroupCount = hidepriority;
//        hideObject = new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta);
        hideanimatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta,hidepriority));

    }

    public static void performHideSingleAnimation(AddImageView object, String typeofanimation, int duration, float fromValue, float toValue) {
        isHideOnDialogAnimation = true;
        hidepriority++;
        HideGroupAnimation.hidegroupCount = hidepriority;
        hideanimatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue,hidepriority));


    }
    public static void performGroupAnimationOnHide(AddImageView object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, int groupCount) {
        isHideOnDialogAnimation = true;
        hidepriority = groupCount;
        hideanimatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta,hidepriority));

    }

    public static void performGroupAnimationOnHide(AddImageView object, String typeofanimation, int duration, float fromValue, float toValue, int groupCount) {
        isHideOnDialogAnimation = true;
        hidepriority = groupCount;
        hideanimatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue,hidepriority));


    }
    public static void runAnimation() {
//
        for (int i = counter; i < animateObjectLength; i++) {
            if (i < animateObjectLength - 1 && animatedObjectList.get(counter).getPriority() == animatedObjectList.get(counter + 1).getPriority()) {

                runSpecificAnimation(animatedObjectList.get(i).getObject(), animatedObjectList.get(i).getAnimationType(), animatedObjectList.get(i), null, animatedObjectList.get(i).isLoop);
                counter++;

            } else if (i < animateObjectLength - 1) {


                runSpecificAnimation(animatedObjectList.get(i).getObject(), animatedObjectList.get(i).getAnimationType(), animatedObjectList.get(i), animatedObjectList.get(i + 1).getObject(), animatedObjectList.get(i).isLoop);
                counter++;
                break;

            } else {

                    runSpecificAnimation(animatedObjectList.get(i).getObject(), animatedObjectList.get(i).getAnimationType(), animatedObjectList.get(i), animatedObjectList.get(i).getObject(),animatedObjectList.get(i).isLoop);
                counter++;
            }



        }


    }

    public static void runSpecificAnimation(AddImageView object, String animationType, AnimateObject animation, AddImageView nextObject, Boolean isLoop) {
        switch (animationType) {
            case SLIDE:
                animation.slideAnimation(object, nextObject, isLoop);
                break;
            case ROTATE:
                animation.rotateAnimation(object, nextObject, isLoop);
                break;
            case SCALE:
                animation.scaleAnimation(object, nextObject, isLoop);
                break;
            case FADE:
                animation.fadeAnimation(object, nextObject, isLoop);
                break;
        }
    }

    public static void runSpecificAnimation(AddImageView object, String animationType, AnimateObject animation, AddImageView nextObject) {
        switch (animationType) {
            case SLIDE:
                animation.slideAnimation(object,nextObject);
                break;
            case ROTATE:
                animation.rotateAnimation(object,nextObject);
                break;
            case SCALE:
                animation.scaleAnimation(object,nextObject);
                break;
            case FADE:
                animation.fadeAnimation(object,nextObject);
                break;
        }
    }

    public static void hide(ReactContext rc) {
        jsCalled = true;
        final ReactContext reactContext = rc;
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

        Log.d(TAG, "hidecalled: ");
        if (shouldHide == true && jsCalled == true) {
            if (isHideOnDialogAnimation == true) {
//                runSpecificAnimation(hideObject.getObject(),hideObject.getAnimationType(),hideObject,true);
                for (int i = hidecounter; i < hideanimateObjectLength; i++) {
                    if (i < hideanimateObjectLength - 1 && hideanimatedObjectList.get(hidecounter).getPriority() == hideanimatedObjectList.get(hidecounter + 1).getPriority()) {
                        runSpecificAnimation(hideanimatedObjectList.get(i).getObject(), hideanimatedObjectList.get(i).getAnimationType(), hideanimatedObjectList.get(i), null);
                   hidecounter++;
                    }
                    else if (i < hideanimateObjectLength - 1) {


                        runSpecificAnimation(hideanimatedObjectList.get(i).getObject(), hideanimatedObjectList.get(i).getAnimationType(), hideanimatedObjectList.get(i), hideanimatedObjectList.get(i + 1).getObject());
                        hidecounter++;
                        break;

                    } else {


                        runSpecificAnimation(hideanimatedObjectList.get(i).getObject(), hideanimatedObjectList.get(i).getAnimationType(), hideanimatedObjectList.get(i),null);
                        hidecounter++;
                    }

                }
            } else dialog.dismiss();

        }
    }

    public static void dismissDialog() {

        dialog.dismiss();
    }

}
