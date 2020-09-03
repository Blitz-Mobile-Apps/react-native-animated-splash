package com.blitzapp.animatedsplash.animation;


import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;

import static android.content.ContentValues.TAG;
import static com.blitzapp.animatedsplash.animation.Splash.animateObjectLength;
import static com.blitzapp.animatedsplash.animation.Splash.animationhide;
import static com.blitzapp.animatedsplash.animation.Splash.dismissDialog;
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
    public AddImageView object, nextObject;

    private int priority;
    public boolean isLastObject;
    public boolean isLoop;

    // for rotate animation
    private float startFromValue;
    private float endToValue;
    private View animationView;

    // For translate animation
    public AnimateObject(AddImageView object, String animationType, int animationDuration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean isLoop, int priority) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.fromXDelta = fromXDelta;
        this.toXDelta = toXDelta;
        this.fromYDelta = fromYDelta;
        this.toYDelta = toYDelta;
        this.isLoop = isLoop;

        this.priority = priority;
        this.object = object;
        Log.d(TAG, "AnimateObject: priority " + this.priority);
    }

    public AnimateObject(AddImageView object, String animationType, int animationDuration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
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
    public AnimateObject(AddImageView object, String animationType, int animationDuration, float fromValue, float toValue, boolean isLoop, int priority) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.isLoop = isLoop;

        this.startFromValue = fromValue;
        this.endToValue = toValue;
        this.priority = priority;
        this.object = object;
        Log.d(TAG, "AnimateObject: priority " + this.priority);
    }


    // For rotate animation
    public AnimateObject(AddImageView object, String animationType, int animationDuration, float fromValue, float toValue) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.startFromValue = fromValue;
        this.endToValue = toValue;
        this.object = object;
    }

    public AddImageView getNextObject() {
        return nextObject;
    }

    public String getAnimationType() {
        return animationType;
    }

    public AddImageView getObject() {
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
        return startFromValue;
    }

    public float getRotateEndDegree() {
        return endToValue;
    }

    public void slideAnimation(AddImageView object, final AddImageView nextObject, Boolean isLoop) {

        View view = object.getImageView();

        TranslateAnimation slideImage = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        slideImage.setDuration(animationDuration);
        slideImage.setFillAfter(setFillAfter);
        view.setVisibility(View.VISIBLE);
        if (isLoop) {
            slideImage.setRepeatCount((int) Double.POSITIVE_INFINITY);
        }

        view.startAnimation(slideImage);
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

                    Log.d(TAG, "shouldHide slide:isLastObject" + animateObjectLength);
                    if (counter == animateObjectLength) {
                        shouldHide = true;
                        if (jsCalled == true) {
                            Log.d(TAG, "shouldHide slide:jsCalled" + jsCalled);

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    animationhide(savedReactContext);

                                }
                            }, Splash.hideDelay);

                        } else {
                            counter++;

                            return;
                        }

                    }
                }

            }


            @Override
            public void onAnimationRepeat(Animation animation) {
                if (nextObject != null && counter < animateObjectLength) {

                    Log.d(TAG, "onAnimationEnd rotate: " + nextObject);

                    runAnimation();
                } else {
                    Log.d(TAG, "shouldHide rotate:" + isLastObject);
                    if (isLastObject) {
                        shouldHide = true;
                        if (jsCalled == true) {

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    animationhide(savedReactContext);

                                }
                            }, Splash.hideDelay);

                        } else {
//                    counter++;
                            return;
                        }
                    }
                }
            }
        });

    }

    public void slideAnimation(AddImageView object) {

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

    public void rotateAnimation(AddImageView object) {
        View view = object.getImageView();
//        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, View.ROTATION, startFromValue, endToValue);
//        rotation.setDuration(animationDuration);
//        view.setVisibility(View.VISIBLE);
//        rotation.start();
        RotateAnimation rotateAnimation = new RotateAnimation(0.0f, 360.0f, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        rotateAnimation.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setFillAfter(true);

        view.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
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

    public void fadeAnimation(AddImageView object) {

        View view = object.getImageView();
        view.setAlpha(1);
        Animation fadeIn = new AlphaAnimation(startFromValue, endToValue);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(animationDuration);
        fadeIn.setFillAfter(setFillAfter);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(fadeIn);
        fadeIn.setAnimationListener(new Animation.AnimationListener() {
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

    public void scaleAnimation(AddImageView object) {
        View view = object.getImageView();
        ScaleAnimation scale = new ScaleAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        scale.setDuration(animationDuration);
        scale.setFillAfter(true);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(scale);

        scale.setAnimationListener(new Animation.AnimationListener() {
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

    public void fadeAnimation(AddImageView object, final AddImageView nextObject, Boolean isLoop) {

        View view = object.getImageView();
        view.setAlpha(1);
        Animation fadeIn = new AlphaAnimation(startFromValue, endToValue);
        fadeIn.setInterpolator(new DecelerateInterpolator()); //add this
        fadeIn.setDuration(animationDuration);
        fadeIn.setFillAfter(setFillAfter);
        view.setVisibility(View.VISIBLE);
        if (isLoop) {
            fadeIn.setRepeatCount((int) Double.POSITIVE_INFINITY);
        }
        view.startAnimation(fadeIn);

        fadeIn.setAnimationListener(new Animation.AnimationListener() {
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

                    Log.d(TAG, "shouldHide slide:" + animateObjectLength);
                    if (counter == animateObjectLength) {
                        Log.d(TAG, "in last animation fade:" + counter);

                        shouldHide = true;
                        if (jsCalled == true) {

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    animationhide(savedReactContext);

                                }
                            }, Splash.hideDelay);

                        } else {
                            counter++;

                            return;
                        }

                    }
                }

            }


            @Override
            public void onAnimationRepeat(Animation animation) {

                if (nextObject != null && counter < animateObjectLength) {

                    Log.d(TAG, "onAnimationEnd rotate: " + nextObject);

                    runAnimation();
                } else {
                    Log.d(TAG, "shouldHide rotate:" + isLastObject);
                    if (isLastObject) {
                        shouldHide = true;
                        if (jsCalled == true) {

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    animationhide(savedReactContext);

                                }
                            }, Splash.hideDelay);

                        } else {
//                    counter++;
                            return;
                        }
                    }
                }
            }
        });

    }

    public void rotateAnimation(AddImageView object, final AddImageView nextObject, Boolean isLoop) {
        View view = object.getImageView();
//        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, View.ROTATION, startFromValue, endToValue);
//        view.setVisibility(View.VISIBLE);
//
//        rotation.setDuration(animationDuration);
//        rotation.setInterpolator(new LinearInterpolator());
//        rotation.start();
////        rotation.setFillAfter(true);
//

        RotateAnimation rotateAnimation = new RotateAnimation(startFromValue, endToValue, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        rotateAnimation.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        rotateAnimation.setFillAfter(true);
        if (isLoop) {
            rotateAnimation.setRepeatCount((int) Double.POSITIVE_INFINITY);
        }
        view.startAnimation(rotateAnimation);
        rotateAnimation.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                Log.d(TAG, "shouldHide rotate: " + counter + "length");

                if (nextObject != null && counter < animateObjectLength) {

                    Log.d(TAG, "onAnimationEnd rotate: " + nextObject);


                    runAnimation();
//                    counter++;


                } else {

                    Log.d(TAG, "shouldHide rotate:" + animateObjectLength);
                    if (counter == animateObjectLength) {
                        shouldHide = true;
                        if (jsCalled == true) {

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    animationhide(savedReactContext);

                                }
                            }, Splash.hideDelay);

                        } else {
                            counter++;

                            return;
                        }

                    }
                }

            }


            @Override
            public void onAnimationRepeat(Animation animation) {

                if (nextObject != null && counter < animateObjectLength) {

                    Log.d(TAG, "onAnimationEnd rotate: " + nextObject);

                    runAnimation();
                } else {
                    Log.d(TAG, "shouldHide rotate:" + isLastObject);
                    if (isLastObject) {
                        shouldHide = true;
                        if (jsCalled == true) {

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    animationhide(savedReactContext);

                                }
                            }, Splash.hideDelay);

                        } else {
//                    counter++;
                            return;
                        }
                    }
                }
            }
        });

    }

    public void scaleAnimation(AddImageView object, final AddImageView nextObject, Boolean isLoop) {
        View view = object.getImageView();
        ScaleAnimation scale = new ScaleAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta, Animation.RELATIVE_TO_PARENT, 0.5f, Animation.RELATIVE_TO_PARENT, 0.5f);
        scale.setDuration(animationDuration);
        scale.setFillAfter(true);
        view.setVisibility(View.VISIBLE);
        if (isLoop) {
            scale.setRepeatCount((int) Double.POSITIVE_INFINITY);
        }
        view.startAnimation(scale);
        scale.setAnimationListener(new Animation.AnimationListener() {
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

                    Log.d(TAG, "shouldHide scale:" + animateObjectLength);
                    if (counter == animateObjectLength) {
                        Log.d(TAG, "onAnimationEnd: " + jsCalled);
                        shouldHide = true;
                        if (jsCalled == true) {

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    animationhide(savedReactContext);

                                }
                            }, Splash.hideDelay);

                        } else {
                            counter++;

                            return;
                        }

                    }

                }


            }

            @Override
            public void onAnimationRepeat(Animation animation) {
                if (nextObject != null && counter < animateObjectLength) {

                    Log.d(TAG, "onAnimationEnd rotate: " + nextObject);

                    runAnimation();
                } else {
                    Log.d(TAG, "shouldHide rotate:" + isLastObject);
                    if (isLastObject) {
                        shouldHide = true;
                        if (jsCalled == true) {

                            mHandler.postDelayed(new Runnable() {
                                @Override
                                public void run() {
                                    animationhide(savedReactContext);

                                }
                            }, Splash.hideDelay);

                        } else {
//                    counter++;
                            return;
                        }
                    }
                }
            }
        });
    }
}

