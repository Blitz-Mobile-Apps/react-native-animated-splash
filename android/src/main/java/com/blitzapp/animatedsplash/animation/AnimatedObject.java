package com.blitzapp.animatedsplash.animation;


import static com.blitzapp.animatedsplash.animation.Splash.applicationContext;
import static com.blitzapp.animatedsplash.animation.Splash.priority;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;

import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.annotation.NonNull;


public class AnimatedObject {
    private Integer imageSource;
    private int height;
    private int width;
    private float positionX = 0;
    private float positionY = 0;
    private float rotateDegree = 0;
    private float opacity = 1;
    private boolean visibility = true;
    public static Context context;
    private ImageView imageView;
    public ObjectAnimation animation;
    public ObjectAnimation hideAnimation;
    public String scaleType = "FIT_CENTER";
    public String next;
    public String hideNext;
    public int priority;
    public int hidePriority;


    public AnimatedObject(@NonNull Integer imageSource, @NonNull double height, @NonNull double width) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.positionX = getCenterX(width);
        this.positionY = getCenterY(height);
    }

    public AnimatedObject(@NonNull Integer imageSource) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.positionX = getCenterX(width);
        this.positionY = getCenterY(height);

    }

    public AnimatedObject(@NonNull Integer imageSource, @NonNull double height, @NonNull double width, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.positionX = getCenterX(width);
        this.positionY = getCenterY(height);
        this.visibility = visibility;

    }

    public AnimatedObject(@NonNull Integer imageSource, @NonNull double height, @NonNull double width, @NonNull double positionX, @NonNull double positionY, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;

    }

    public AnimatedObject(@NonNull Integer imageSource, @NonNull double height, @NonNull double width, double positionX, double positionY, String scaleType, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.scaleType = scaleType;
    }

    public AnimatedObject(@NonNull Integer imageSource, @NonNull double height, @NonNull double width, double positionX, double positionY, double rotateDegree, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
    }

    public AnimatedObject(@NonNull Integer imageSource, @NonNull double height, @NonNull double width, double positionX, double positionY, double rotateDegree, double opacity, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.opacity = (float) opacity;
    }

    public AnimatedObject(@NonNull Integer imageSource, @NonNull double height, @NonNull double width, double rotateDegree, String scaleType, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = getCenterX(width);
        this.positionY = getCenterY(height);
        this.visibility = visibility;
        this.scaleType = scaleType;
//        Splash.addImagetoView(this);

    }

    public AnimatedObject(@NonNull Integer imageSource, @NonNull double height, @NonNull double width, double positionX, double positionY, double rotateDegree, String scaleType, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.scaleType = scaleType;
//        Splash.addImagetoView(this);

    }

    public AnimatedObject(@NonNull Integer imageSource, double height, double width, double positionX, double positionY, double rotateDegree, double opacity, String scaleType, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.scaleType = scaleType;
        this.opacity = (float) opacity;
//        Splash.addImagetoView(this);
    }


    public View initializeObject() {
        imageView = new ImageView(context);
        imageView.setImageResource(imageSource);
        imageView.setRotation(rotateDegree);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        imageView.setLayoutParams(params);
        imageView.setX(getPositionX());
        imageView.setY(getPositionY());
        imageView.setAlpha(opacity);
        imageView.setScaleType(ImageView.ScaleType.valueOf(scaleType));
        if (visibility == true) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        return imageView;
    }

    public void setScaleType(String scaleType) {
        this.scaleType = scaleType;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public static float getCenterX(double width) {
        float position = (screenWidth - (float) width) / 2f;
        return position;
    }

    public static float getCenterY(double height) {
        float position = (screenHeight - (float) height) / 2f;
        return position;
    }

    public void setImageSource(Integer imageSource) {
        this.imageSource = imageSource;
    }

    public int getHeight() {
        return height;
    }

    public int getWidth() {
        return width;
    }

    public void setHeight(float height) {
        this.height = Math.round(height);
    }

    public void setWidth(float width) {
        this.width = Math.round(width);
    }

    public void setPositionX(float positionX) {
        this.positionX = positionX;
    }

    public void setPositionY(float positionY) {
        this.positionY = positionY;
    }

    public float getPositionX() {
        return positionX;
    }

    public float getPositionY() {
        return positionY;
    }

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public boolean getVisibility() {
        return visibility;
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

    public int getHidePriority() {
        return hidePriority;
    }

    public void setHidePriority(int hidePriority) {
        this.hidePriority = hidePriority;
    }

    public float getRotateDegree() {
        return rotateDegree;
    }

    public void setRotateDegree(float rotateDegree) {
        this.rotateDegree = rotateDegree;
    }

    public float getOpacity() {
        return opacity;
    }

    public void setOpacity(float opacity) {
        this.opacity = opacity;
    }
}
