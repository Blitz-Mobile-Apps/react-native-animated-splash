package com.blitzapp.animatedsplash.animation;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;

import static com.blitzapp.animatedsplash.animation.Splash.applicationContext;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;

public class AnimatedText {
      private Integer imageSource;
    private int height;
    private int width;
    private float fontsize =12;
    private float positionX=0;
    private float positionY=0;
    private float rotateDegree=0;
    private float opacity=1;
    private boolean visibility = true;
    public static Context context;
    private ImageView imageView;
    public String text = "Some Text";
    private static TextView textView;
    public static final String FIT_XY = "FIT_XY";
    public static final String FIT_CENTER = "FIT_CENTER";
    public static final String FIT_END = "FIT_END";
    public static final String FIT_START = "FIT_START";
    public AnimatedText(@NonNull String text, double fontsize) {
        this.context = applicationContext;
        this.text = text;
        this.fontsize = (float) fontsize;
        Splash.addTexttoView(this);
    }
//    public AnimatedText(@NonNull String text, double positionX, double positionY, boolean visibility) {
//        this.context = applicationContext;
//        this.text = text;
//        this.positionX = (float) positionX;
//        this.positionY = (float) positionY;
//        this.visibility = visibility;
//        // this.scaleType = scaleType;
//        Splash.addTexttoView(this);
//
//    }

    public AnimatedText(@NonNull String text, double fontsize, double positionX, double positionY, boolean visibility) {
        this.context = applicationContext;
        this.text = text;
        this.fontsize = (float) fontsize;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        // this.scaleType = scaleType;
        Splash.addTexttoView(this);

    }



    public AnimatedText(@NonNull String text, double fontsize, double positionX, double positionY, double rotateDegree, boolean visibility) {
        this.context = applicationContext;
        this.text = text;
        this.fontsize = (float) fontsize;
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        Splash.addTexttoView(this);
    }
    public AnimatedText(@NonNull String text, double fontsize, double positionX, double positionY, double rotateDegree, double opacity, boolean visibility) {
        this.context = applicationContext;
        this.text = text;
        this.fontsize = (float) fontsize;
        this.rotateDegree = (float) rotateDegree;
        this.positionX = (float) positionX;
        this.positionY = (float) positionY;
        this.visibility = visibility;
        this.opacity =  (float) opacity;
        Splash.addTexttoView(this);
    }



    public void setContext(Context context) {
        this.context = context;
    }

//    public ImageView getImageView() {
//        return imageView;
//    }
    public TextView getTextView() {
        return textView;
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
        textView = new TextView(context);
        textView.setText(text);
        textView.setGravity(Gravity.CENTER_VERTICAL | Gravity.CENTER_HORIZONTAL);
        textView.setTextSize(fontsize);
        textView.setTextColor(Color.parseColor("#000000"));
        textView.setBackgroundColor(Color.parseColor("#FFFFFF"));
        textView.setRotation(rotateDegree);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT );
        textView.setLayoutParams(params);
        textView.setX(positionX);
        textView.setY(positionY);
        textView.setAlpha(opacity);
//        textView.set(ImageView.ScaleType.valueOf(scaleType));
        if (visibility == true) {
            textView.setVisibility(View.VISIBLE);
        } else {
            textView.setVisibility(View.GONE);
        }
        return textView;
    }
//  public static float getCenterX(){
//
//  }
//    public static float getCenterY(){
//        float position = (screenHeight- (float)textView.getHeight())/2f;
//        return position;
//    }
}
