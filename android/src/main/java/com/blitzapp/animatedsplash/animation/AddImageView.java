package com.blitzapp.animatedsplash.animation;


import android.content.Context;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.blitzapp.animatedsplash.RNAnimatedSplashModule;

import static com.blitzapp.animatedsplash.animation.Splash.applicationContext;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;


public class AddImageView {
    private Integer imageSource;
    private int height;
    private int width;
    private float positionX=0;
    private float positionY=0;
    private float rotateDegree=0;
    private float opacity=1;
    private boolean visibility = true;
    public static Context context;
    private ImageView imageView;
    public String scaleType = "FIT_CENTER";
    private static TextView textView;
    public static final String FIT_XY = "FIT_XY";
    public static final String FIT_CENTER = "FIT_CENTER";
    public static final String FIT_END = "FIT_END";
    public static final String FIT_START = "FIT_START";
    public AddImageView(@NonNull Integer imageSource, double height, double width) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        Splash.addImagetoView(this);
    }
    public AddImageView(@NonNull Integer imageSource, double height, double width, double positionX, double positionY, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.scaleType = scaleType;
        Splash.addImagetoView(this);

    }

    public AddImageView(@NonNull Integer imageSource, double height, double width, double positionX, double positionY, String scaleType, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.scaleType = scaleType;
        Splash.addImagetoView(this);
    }

    public AddImageView(@NonNull Integer imageSource, double height, double width, double positionX, double positionY, double rotateDegree, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        Splash.addImagetoView(this);
    }
    public AddImageView(@NonNull Integer imageSource, double height, double width, double positionX, double positionY, double rotateDegree, double opacity, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.opacity =  (float) opacity;
        Splash.addImagetoView(this);
    }
    public AddImageView(@NonNull Integer imageSource, double height, double width, double positionX, double positionY, double rotateDegree, String scaleType, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.scaleType = scaleType;
        Splash.addImagetoView(this);

    }
    public AddImageView(@NonNull Integer imageSource, double height, double width, double positionX, double positionY, double rotateDegree, double opacity, String scaleType, boolean visibility) {
        this.context = applicationContext;
        this.imageSource = imageSource;
        this.height = (int) (height);
        this.width = (int) (width);
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.scaleType = scaleType;
        this.opacity =  (float) opacity;
        Splash.addImagetoView(this);

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

    public void setVisibility(boolean visibility) {
        this.visibility = visibility;
    }

    public boolean getVisibility() {
        return visibility;
    }

    public TextView initializeTextObject() {
        textView = new TextView(context);

        return textView;
    }

    public View initializeObject() {
        imageView = new ImageView(context);
        imageView.setImageResource(imageSource);
        imageView.setRotation(rotateDegree);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        imageView.setLayoutParams(params);
        imageView.setX(positionX);
        imageView.setY(positionY);
        imageView.setAlpha(opacity);
        imageView.setScaleType(ImageView.ScaleType.valueOf(scaleType));
        if (visibility == true) {
            imageView.setVisibility(View.VISIBLE);
        } else {
            imageView.setVisibility(View.GONE);
        }
        return imageView;
    }
  public static float getCenterX(double width){
        float position = (screenWidth- (float)width)/2f;
        return position;
  }
    public static float getCenterY(double height){
        float position = (screenHeight- (float)height)/2f;
        return position;
    }
}
