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
import com.blitzapp.animatedsplash.RNAnimatedSplashModule;
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
    public static int priority = 0;
    public static int animateObjectLength;
    private static ConstraintLayout mainBackground;
    public static FrameLayout view;
    public static final String SLIDE = "SLIDE_ANIMATION";
    public static final String ROTATE = "ROTATE_ANIMATION";
    public static final String SCALE = "SCALE_ANIMATION";
    public static final String FADE = "FADE_ANIMATION";
    public static final String DIALOGSLIDEDOWN = "SLIDEDOWN";
    public static final String DIALOGSLIDELEFT = "SLIDELEFT";
    public static final String DIALOGSLIDERIGHT = "SLIDERIGHT";
    public static final String DIALOGFADE = "FADE";
    public static int hideDelay = 1;
    public static boolean isHideOnDialogAnimation =false;
    public static List<AnimateObject> animatedObjectList = new ArrayList<>();
    public static List<AnimateObject> hideanimatedObjectList = new ArrayList<>();

    public static List<AddGroupObject> groupObjectList = new ArrayList<>();
    public static AnimateObject hideObject;


    //    private static ImageView imageView;
    public static boolean animationStatus = false;

    public static void createDialog(Context context) {
        getWindowDimensions();
        applicationContext =context;
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
    public static void setSplashHideAnimation(String animationType){
        if(animationType == "FADE") {
            dialog.getWindow().getAttributes().windowAnimations = R.style.fade; //style id
        }
        else if(animationType == "SLIDEDOWN"){
            dialog.getWindow().getAttributes().windowAnimations = R.style.slideDown; //style id
        }
        else if(animationType == "SLIDELEFT"){
            dialog.getWindow().getAttributes().windowAnimations = R.style.slideLeft; //style id
        }
        else if(animationType == "SLIDERIGHT"){
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

    public static void show() {
        Log.d(TAG, "createDialog: " + animatedObjectList.size());
        animateObjectLength = animatedObjectList.size();
        runAnimation();

        dialog.show();


    }

//    public static void hide() {
//        dialog.dismiss();
//    }

    public static void setBackgroundImage(Integer drawable) {

        view.setBackground(ContextCompat.getDrawable(RNAnimatedSplashModule.reactContext, drawable));
    }

    public static void setBackgroundColor(String colorString) {

        view.setBackgroundColor(Color.parseColor(colorString));
    }


    public static void addImagetoView(CreateImageObject objects) {
        View View = objects.initializeObject();
        view.addView(View);
    }


    public static void animateSingleObject(CreateImageObject object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean isLoop, boolean isLastObject) {
        priority++;
        AddGroupObject.groupCount = priority;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, isLoop,isLastObject, priority));

    }
    public static void animateSingleObject(CreateImageObject object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean isLastObject) {
        priority++;
        AddGroupObject.groupCount = priority;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, false, isLastObject, priority));

    }
    public static void animateSingleObject(CreateImageObject object, String typeofanimation, int duration, float fromValue, float toValue, boolean isLoop, boolean isLastObject) {
        priority++;
        AddGroupObject.groupCount = priority;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue, isLoop,isLastObject, priority));

    }
    public static void animateSingleObject(CreateImageObject object, String typeofanimation, int duration, float fromValue, float toValue, boolean isLastObject) {
        priority++;
        AddGroupObject.groupCount = priority;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue, false,isLastObject, priority));

    }
    public static void animateObject(CreateImageObject object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean isLoop, boolean isLastObject, int groupCount) {
        priority = groupCount;

        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, isLoop,isLastObject, priority));

    }

    public static void animateObject(CreateImageObject object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean isLastObject, int groupCount) {
        priority = groupCount;

        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta, false,isLastObject, priority));

    }


    public static void animateObject(CreateImageObject object, String typeofanimation, int duration, float fromValue, float toValue, boolean isLoop, boolean isLastObject, int groupCount) {
        priority = groupCount;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue, isLoop,isLastObject, priority));

    }
    public static void animateObject(CreateImageObject object, String typeofanimation, int duration, float fromValue, float toValue, boolean isLastObject, int groupCount) {
        priority = groupCount;
        animatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue, false,isLastObject, priority));

    }
    public static void animateObjectOnHide(CreateImageObject object, String typeofanimation, int duration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        isHideOnDialogAnimation=true;
//        hideObject = new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta);
        hideanimatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromXDelta, toXDelta, fromYDelta, toYDelta));

    }
    public static void animateObjectOnHide(CreateImageObject object, String typeofanimation, int duration, float fromValue, float toValue) {
        isHideOnDialogAnimation=true;

        hideanimatedObjectList.add(new AnimateObject(object, typeofanimation, duration, fromValue, toValue));


    }

    public static void runAnimation() {
//

        for (int i = counter; i < animateObjectLength; i++) {
            Log.d(TAG, "runAnimation: in for loop");
            if (i < animateObjectLength - 1 && animatedObjectList.get(counter).getPriority() == animatedObjectList.get(counter + 1).getPriority()) {
                Log.d(TAG, "runAnimation1: "+i+ animatedObjectList.get(counter).getAnimationType());
                runSpecificAnimation(animatedObjectList.get(counter).getObject(), animatedObjectList.get(counter).getAnimationType(), animatedObjectList.get(counter), null,animatedObjectList.get(counter).isLoop,animatedObjectList.get(counter).isLastObject);
                counter++;

            } else if (i < animateObjectLength - 1) {

                Log.d(TAG, "runAnimation3: "+i+ animatedObjectList.get(counter).getAnimationType());

                runSpecificAnimation(animatedObjectList.get(counter).getObject(), animatedObjectList.get(counter).getAnimationType(), animatedObjectList.get(counter), animatedObjectList.get(counter + 1).getObject(),animatedObjectList.get(counter).isLoop,animatedObjectList.get(counter).isLastObject);
//                counter++;

            }
//            else if (i == animateObjectLength-1) {
//                Log.d(TAG, "runAnimation4: "+i+ animatedObjectList.get(counter).getAnimationType());
//                runSpecificAnimation(animatedObjectList.get(counter).getObject(), animatedObjectList.get(counter).getAnimationType(), animatedObjectList.get(counter), null,true);
////                counter++;
//            }
            else {
                Log.d(TAG, "runAnimation2: "+i+ animatedObjectList.get(counter).getAnimationType());

                runSpecificAnimation(animatedObjectList.get(counter).getObject(), animatedObjectList.get(counter).getAnimationType(), animatedObjectList.get(counter), animatedObjectList.get(counter).getObject(),animatedObjectList.get(counter).isLoop,animatedObjectList.get(counter).isLastObject);
                counter++;

            }

        }


    }

    public static void runSpecificAnimation(CreateImageObject object, String animationType, AnimateObject animation, CreateImageObject nextObject,Boolean isLoop, Boolean isLasObject) {
        switch (animationType) {
            case SLIDE:
                animation.slideAnimation(object, nextObject,isLasObject,isLoop);
                break;
            case ROTATE:
                animation.rotateAnimation(object, nextObject,isLasObject,isLoop);
                break;
            case SCALE:
                animation.scaleAnimation(object, nextObject,isLasObject,isLoop);
                break;
            case FADE:
                animation.fadeAnimation(object, nextObject,isLasObject,isLoop);
                break;
        }
    }
    public static void runSpecificAnimation(CreateImageObject object, String animationType, AnimateObject animation, Boolean isTypeHide) {
        switch (animationType) {
            case SLIDE:
                animation.slideAnimation(object);
                break;
            case ROTATE:
                animation.rotateAnimation(object);
                break;
            case SCALE:
                animation.scaleAnimation(object);
                break;
            case FADE:
                animation.fadeAnimation(object);
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
                    animationhide(reactContext);

                }
            },hideDelay);
        }
        else{
            animationhide(reactContext);
        }
    }
    public static void animationhide(ReactContext reactContext) {

        Log.d(TAG, "hidecalled: ");
        if (shouldHide == true && jsCalled == true) {
            if(isHideOnDialogAnimation ==true){
//                runSpecificAnimation(hideObject.getObject(),hideObject.getAnimationType(),hideObject,true);
                for (int i = 0; i < hideanimatedObjectList.size(); i++) {
                    runSpecificAnimation(hideanimatedObjectList.get(i).getObject(),hideanimatedObjectList.get(i).getAnimationType(),hideanimatedObjectList.get(i),true);

                }
            }
            else dialog.dismiss();

        }
    }
    public static void dismissDialog() {

        dialog.dismiss();
    }

}
