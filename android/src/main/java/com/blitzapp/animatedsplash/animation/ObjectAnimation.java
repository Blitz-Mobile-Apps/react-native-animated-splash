package com.blitzapp.animatedsplash.animation;


import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;

import static android.content.ContentValues.TAG;
import static com.blitzapp.animatedsplash.AnimationsList.animationsList;
import static com.blitzapp.animatedsplash.HideAnimationList.hideAnimationListHead;
import static com.blitzapp.animatedsplash.HideAnimationList.hideAnimationsList;
import static com.blitzapp.animatedsplash.animation.Splash.allExecuted;
import static com.blitzapp.animatedsplash.animation.Splash.allHideExecuted;
import static com.blitzapp.animatedsplash.animation.Splash.animationhide;
import static com.blitzapp.animatedsplash.animation.Splash.hide;
import static com.blitzapp.animatedsplash.animation.Splash.runAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.runHideAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.runSpecificAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.shouldHide;

public class ObjectAnimation {

    public String animationType;
    private int animationDuration;
    private boolean setFillAfter;
    // Translate animation
    private float fromXDelta;
    private float toXDelta;
    private float fromYDelta;
    private float toYDelta;
    public String next;
    public String hideNext;
    public int priority;
    public int hidePriority;

    public AnimatedObject object, nextObject;
    public AnimatedText textobject, textNextObject;

    public boolean isLastObject;
    public boolean isLoop;

    // for rotate animation
    private float startFromValue;
    private float endToValue;
    private boolean isText = false;
    private View animationView;

    private Boolean executed = false;

    public ObjectAnimation() {
    }

    // For translate animation
    public ObjectAnimation(AnimatedObject object, String animationType, int animationDuration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta, boolean loop) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.fromXDelta = fromXDelta;
        this.toXDelta = toXDelta;
        this.fromYDelta = fromYDelta;
        this.toYDelta = toYDelta;
        this.isLoop = loop;

        this.priority = priority;
        this.object = object;
        this.isText = false;
        Log.d(TAG, "AnimateObject: priority " + this.priority);
    }

    public ObjectAnimation(AnimatedObject object, String animationType, int animationDuration, float fromXDelta, float toXDelta, float fromYDelta, float toYDelta) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.fromXDelta = fromXDelta;
        this.toXDelta = toXDelta;
        this.fromYDelta = fromYDelta;
        this.toYDelta = toYDelta;
        this.priority = priority;
        this.object = object;
        this.isText = false;

    }

    // For rotate animation
    public ObjectAnimation(AnimatedObject object, String animationType, int animationDuration, float fromValue, float toValue, boolean loop) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.isLoop = loop;
        this.startFromValue = fromValue;
        this.endToValue = toValue;
        this.priority = priority;
        this.object = object;
        this.isText = false;

        Log.d(TAG, "AnimateObject: priority " + this.priority);
    }

    // For rotate animation
    public ObjectAnimation(AnimatedObject object, String animationType, int animationDuration, float fromValue, float toValue) {
        this.animationType = animationType;
        this.animationDuration = animationDuration;
        this.setFillAfter = true;
        this.startFromValue = fromValue;
        this.endToValue = toValue;
        this.priority = priority;
        this.object = object;
        this.isText = false;

    }


    public AnimatedObject getNextObject() {
        return nextObject;
    }

    public String getAnimationType() {
        return animationType;
    }

    public AnimatedObject getObject() {
        return object;
    }

    public AnimatedText getTextObject() {
        return textobject;
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

    public boolean isLastObject() {
        return isLastObject;
    }

    public int getPriority() {
        return priority;
    }

    public boolean isTextType() {
        return isText;
    }

    public float getRotateStartDegree() {
        return startFromValue;
    }

    public float getRotateEndDegree() {
        return endToValue;
    }

    public Boolean getExecuted() {
        return executed;
    }

    public void setExecuted(Boolean executed) {
        this.executed = executed;
    }

    private void checkGroup(ObjectAnimation object) {
        if (object.next != null) {
            Log.d("ANIMATED_SPLASH", object.priority + "==" + animationsList.get(object.next).priority);
            if (object.priority == animationsList.get(object.next).priority) {
                runSpecificAnimation(animationsList.get(object.next));
            }
        }
    }

    private void checkHideGroup(ObjectAnimation object) {
        if (object.hideNext != null) {
            if (object.hidePriority == hideAnimationsList.get(object.hideNext).hidePriority) {
                runHideAnimation(hideAnimationsList.get(object.hideNext));
            }
        }
    }

    private void runNextAnimation(ObjectAnimation object) {
        if (object.next != null) {
            runSpecificAnimation(animationsList.get(object.next));
        } else {
            allExecuted = true;
            if (!hideAnimationsList.isEmpty()) {
                runHideAnimation(hideAnimationsList.get(hideAnimationListHead));
            }else{
                allHideExecuted = true;
                shouldHide = true;
                animationhide();
            }

        }
    }

    private void runNextHideAnimation(ObjectAnimation object) {
        if (object.hideNext != null) {

            runHideAnimation(hideAnimationsList.get(object.hideNext));
        } else {
            allHideExecuted = true;
            shouldHide = true;
            animationhide();


        }
    }

    public void slideAnimation(ObjectAnimation object) {

        View view = object.object.getImageView();

        TranslateAnimation slideImage = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        slideImage.setDuration(animationDuration);
        slideImage.setFillAfter(setFillAfter);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(slideImage);

        checkGroup(object);

        if (object.isLoop) {
            slideImage.setRepeatCount((int) Double.POSITIVE_INFINITY);
            slideImage.setRepeatMode(ValueAnimator.REVERSE);

        }

        slideImage.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                runNextAnimation(object);
            }


            @Override
            public void onAnimationRepeat(Animation animation) {
                runNextAnimation(object);


            }
        });

    }

    public void rotateAnimation(ObjectAnimation object) {
        View view = object.object.getImageView();

        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, View.ROTATION, startFromValue, endToValue);
        rotation.setInterpolator(new LinearInterpolator());
        rotation.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        checkGroup(object);

        if (object.isLoop) {
            rotation.setRepeatCount(ValueAnimator.INFINITE);
            rotation.setRepeatMode(ValueAnimator.REVERSE);
            rotation.setInterpolator(new LinearInterpolator());
        }
        rotation.start();

        rotation.addListener(new AnimatorListenerAdapter() {

            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
                runNextAnimation(object);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                runNextAnimation(object);
            }
        });
    }

    public void fadeAnimation(ObjectAnimation object) {

        View view = object.object.getImageView();
        view.setAlpha(1);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(view, "alpha", startFromValue, endToValue);
        fadeIn.setInterpolator(new LinearInterpolator()); //add this
        fadeIn.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        checkGroup(object);

        if (object.isLoop) {
            fadeIn.setRepeatCount(ValueAnimator.INFINITE);
            fadeIn.setRepeatMode(ValueAnimator.REVERSE);
        }
        fadeIn.start();

        fadeIn.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                runNextAnimation(object);
            }


            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d("ANIMATED_SPLASH", object.toString());
                runNextAnimation(object);

            }
        });

    }

    public void scaleAnimation(ObjectAnimation object) {
        View view = object.object.getImageView();
        ObjectAnimator scale = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat("scaleX", fromXDelta, toXDelta),
                PropertyValuesHolder.ofFloat("scaleY", fromYDelta, toYDelta));
        scale.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        checkGroup(object);

        if (object.isLoop) {
            scale.setRepeatCount(ValueAnimator.INFINITE);
            scale.setRepeatMode(ValueAnimator.REVERSE);
        }
        scale.start();

        scale.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                runNextAnimation(object);

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                runNextAnimation(object);

            }
        });
    }

    public void slideHideAnimation(ObjectAnimation object) {

        View view = object.object.getImageView();

        TranslateAnimation slideImage = new TranslateAnimation(fromXDelta, toXDelta, fromYDelta, toYDelta);
        slideImage.setDuration(animationDuration);
        slideImage.setFillAfter(setFillAfter);
        view.setVisibility(View.VISIBLE);
        view.startAnimation(slideImage);

        checkHideGroup(object);

        slideImage.setAnimationListener(new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {

            }

            @Override
            public void onAnimationEnd(Animation animation) {
                runNextHideAnimation(object);
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

        });

    }

    public void rotateHideAnimation(ObjectAnimation object) {
        View view = object.object.getImageView();

        ObjectAnimator rotation = ObjectAnimator.ofFloat(view, View.ROTATION, startFromValue, endToValue);
        rotation.setInterpolator(new LinearInterpolator());
        rotation.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        checkHideGroup(object);
        rotation.start();

        rotation.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationRepeat(Animator animation) {
                super.onAnimationRepeat(animation);
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                runNextHideAnimation(object);

            }
        });
    }

    public void fadeHideAnimation(ObjectAnimation object) {

        View view = object.object.getImageView();
        view.setAlpha(1);
        ObjectAnimator fadeIn = ObjectAnimator.ofFloat(view, "alpha", startFromValue, endToValue);
        fadeIn.setInterpolator(new LinearInterpolator()); //add this
        fadeIn.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        checkHideGroup(object);

        fadeIn.start();

        fadeIn.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                runNextHideAnimation(object);

            }


            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    public void scaleHideAnimation(ObjectAnimation object) {
        View view = object.object.getImageView();
        ObjectAnimator scale = ObjectAnimator.ofPropertyValuesHolder(view,
                PropertyValuesHolder.ofFloat("scaleX", fromXDelta, toXDelta),
                PropertyValuesHolder.ofFloat("scaleY", fromYDelta, toYDelta));
        scale.setDuration(animationDuration);
        view.setVisibility(View.VISIBLE);
        checkHideGroup(object);

        scale.start();

        scale.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationStart(Animator animation) {
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                runNextHideAnimation(object);
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
            }
        });
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getHideNext() {
        return hideNext;
    }

    public void setHideNext(String hideNext) {
        this.hideNext = hideNext;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    public int getHidePriority() {
        return hidePriority;
    }

    public void setHidePriority(int hidePriority) {
        this.hidePriority = hidePriority;
    }
}

