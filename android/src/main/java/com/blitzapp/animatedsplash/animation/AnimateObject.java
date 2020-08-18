package com.blitzapp.animatedsplash.animation;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import com.blitzapp.animatedsplash.animation.CreateImageObject;

import static android.content.ContentValues.TAG;
import static com.blitzapp.animatedsplash.animation.Splash.animateObjectLength;
import static com.blitzapp.animatedsplash.animation.Splash.animationhide;
import static com.blitzapp.animatedsplash.animation.Splash.dismissDialog;
import static com.blitzapp.animatedsplash.animation.Splash.hide;
import static com.blitzapp.animatedsplash.animation.Splash.jsCalled;
import static com.blitzapp.animatedsplash.animation.Splash.shouldHide;
import static com.blitzapp.animatedsplash.animation.Splash.mHandler;
import static com.blitzapp.animatedsplash.animation.Splash.counter;
import static com.blitzapp.animatedsplash.animation.Splash.savedReactContext;
import static com.blitzapp.animatedsplash.animation.Splash.runAnimation;

public class AnimateObject {

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
    private CreateImageObject object, nextObject;

    private int priority;
    public boolean isLastObject;
    // for rotate animation
    private float rotateStartDegree;
    private float rotateEndDegree;
    private View animationView;

    // For translate animation
    public AnimateObject(CreateImageObject object, String animationType, int animationDuration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean isLastObject, int priority) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.fromXDelta = fromXDelta;
        this.toXDelta = toXDelta;
        this.fromYDelta = fromYDelta;
        this.toYDelta = toYDelta;
        this.priority = priority;
        this.object = object;
        this.isLastObject = isLastObject;
        Log.d(TAG, "AnimateObject: priority " + this.priority);
    }

    public AnimateObject(CreateImageObject object, String animationType, int animationDuration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.fromXDelta = fromXDelta;
        this.toXDelta = toXDelta;
        this.fromYDelta = fromYDelta;
        this.toYDelta = toYDelta;
        this.object = object;
    }


    // For rotate animation
    public AnimateObject(CreateImageObject object, String animationType, int animationDuration, float rotateStartDegree, float rotateEndDegree,boolean isLastObject, int priority) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.rotateStartDegree = rotateStartDegree;
        this.rotateEndDegree = rotateEndDegree;
        this.priority = priority;
        this.object = object;
        this.isLastObject = isLastObject;
        Log.d(TAG, "AnimateObject: priority " + this.priority);
    }


    // For rotate animation
    public AnimateObject(CreateImageObject object, String animationType, int animationDuration, float rotateStartDegree, float rotateEndDegree) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.rotateStartDegree = rotateStartDegree;
        this.rotateEndDegree = rotateEndDegree;
        this.object = object;
    }

    public CreateImageObject getNextObject() {
        return nextObject;
    }

    public String getAnimationType() {
        return animationType;
    }

    public CreateImageObject getObject() {
        return object;
    }

    public int getAnimationDuration() {
        return animationDuration;
    }

    public boolean isSetFillAfter() {
        return setFillAfter;
    }

    public float getFromXDelta() {
        return fromXDelta;
    }

    public float getToXDelta() {
        return toXDelta;
    }

    public float getFromYDelta() {
        return fromYDelta;
    }

    public float getToYDelta() {
        return toYDelta;
    }

    public float getScaleFromX() {
        return scaleFromX;
    }

    public float getScaleToX() {
        return scaleToX;
    }

    public float getScaleFromY() {
        return scaleFromY;
    }

    public float getScaleToY() {
        return scaleToY;
    }

    public boolean isLastObject() {
        return isLastObject;
    }


    public int getPriority() {
        return priority;
    }

    public float getRotateStartDegree() {
        return rotateStartDegree;
    }

    public float getRotateEndDegree() {
        return rotateEndDegree;
    }

    public void slideAnimation(CreateImageObject object, final CreateImageObject nextObject, Boolean last) {

        View view = object.getImageView();

        TranslateAnimation slideImage = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        slideImage.setDuration(animationDuration);
        slideImage.setFillAfter(setFillAfter);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(slideImage);
        final boolean isLastObject = last;
        slideImage.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "shouldHide slide: " + counter + "length");

                if (nextObject != null && counter < animateObjectLength) {

                    Log.d(TAG, "onAnimationEnd slide: " + nextObject);


                    runAnimation();
//                    counter++;


                } else {

                    Log.d(TAG, "shouldHide slide:" + isLastObject);
                    if (isLastObject) {
                        shouldHide = true;
                        if (jsCalled == true) {

                            if (savedReactContext != null) {
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        animationhide(savedReactContext);

                                    }
                                }, Splash.hideDelay);
                            } else return;

                        } else {
                            counter++;

                            return;
                        }

                    }
                }

            }


            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }

    public void slideAnimation(CreateImageObject object) {

        View view = object.getImageView();

        TranslateAnimation slideImage = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        slideImage.setDuration(animationDuration);
        slideImage.setFillAfter(setFillAfter);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(slideImage);
        slideImage.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Splash.dismissDialog();

            }


            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });

    }
    public void rotateAnimation(CreateImageObject object) {
        View view = object.getImageView();
        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, View.ROTATION, rotateStartDegree, rotateEndDegree);
        rotation.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        rotation.start();

        rotation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                Splash.dismissDialog();
            }
        });
    }
    public void scaleAnimation(CreateImageObject object) {
        View view = object.getImageView();
        ScaleAnimation fade_in = new ScaleAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        fade_in.setDuration(animationDuration);
        fade_in.setFillAfter(true);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(fade_in);

        fade_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                dismissDialog();

            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
    public void rotateAnimation(CreateImageObject object, final CreateImageObject nextObject, Boolean last) {
        View view = object.getImageView();
        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, View.ROTATION, rotateStartDegree, rotateEndDegree);
        rotation.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        rotation.start();
        final boolean isLastObject = last;
        rotation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                if (nextObject != null && counter < animateObjectLength) {

                    Log.d(TAG, "onAnimationEnd rotate: " + nextObject);


//                        Log.d(TAG, "onAnimationEnd: scaling " + counter);
                    runAnimation();
//                    counter++;


                } else {

                    Log.d(TAG, "shouldHide rotate:" + isLastObject);
                    if (isLastObject) {

                        shouldHide = true;
                        if (jsCalled == true) {
                            if (savedReactContext != null) {
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        animationhide(savedReactContext);

                                    }
                                }, Splash.hideDelay);
                            } else return;

                        } else {
                            counter++;

                            return;
                        }
                    }
                }
            }
        });
    }

    public void scaleAnimation(CreateImageObject object, final CreateImageObject nextObject, Boolean last) {
        View view = object.getImageView();
        ScaleAnimation fade_in = new ScaleAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        fade_in.setDuration(animationDuration);
        fade_in.setFillAfter(true);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(fade_in);
        final boolean isLastObject = last;
        fade_in.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "shouldHide scale check:" + animateObjectLength);
                if (nextObject != null && counter < animateObjectLength) {

                    Log.d(TAG, "onAnimationEnd scale: " + nextObject);


                    Log.d(TAG, "onAnimationEnd: scaling " + counter);

                    runAnimation();
//                    counter++;


                } else {

                    Log.d(TAG, "shouldHide scale:" + isLastObject);
                    if (isLastObject) {
                        Log.d(TAG, "onAnimationEnd: " + jsCalled);
                        shouldHide = true;
                        if (jsCalled == true) {

                            if (savedReactContext != null) {
                                mHandler.postDelayed(new Runnable() {
                                    @Override
                                    public void run() {
                                        animationhide(savedReactContext);

                                    }
                                }, Splash.hideDelay);
                            } else return;

                        } else {
                            counter++;

                            return;
                        }

                    }

                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }
        });
    }
}

