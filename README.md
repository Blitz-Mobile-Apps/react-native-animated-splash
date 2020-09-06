# [react-native-animated-splash](https://www.npmjs.com/package/react-native-animated-splash)
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
![Supports Android and iOS](https://img.shields.io/badge/platforms-android%20|%20ios-lightgrey.svg?style=flat-square)
[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
[![NPM](https://img.shields.io/npm/dm/react-native-animated-splash)](https://www.npmjs.com/package/react-native-animated-splash)
[![Version](https://img.shields.io/npm/v/react-native-animated-splash)](https://www.npmjs.com/package/react-native-animated-splash)


React-Native-Animated-Splash is developed to help the react-native developers in speeding-up their development process. This package leverages the developer in implementing native animations by using our builtin classes for animation with easy to use api, all the animations run on native thread for smooth performance.
##### Objective
The main objective or the edge of this module is that, splash animation runs in parallel with loading of javascript, which means when animation is running, javascript is being loaded in parallel behind the scenes, moreover componentDidMount can also be called for any api hits before calling hide function of splash from react-native side.

### Only available for Android, iOS will be available soon

### Installation
If you prefer **npm**,
```sh
$ npm install react-native-animated-splash --save
```

If you prefer **yarn**,
```sh
$ yarn add react-native-animated-splash
```


## USAGE

 ### Android
 >
 Following are the basic examples of using react-native-animated-splash. Go to your MainActivity.java file and add following code.
 
#### Example Animation 1
 
 ```sh
    
package com.example;

import android.os.Bundle;


import com.facebook.react.ReactActivity;
import com.blitzapp.animatedsplash.animation.GroupAnimation;
import com.blitzapp.animatedsplash.animation.AddImageView;
import static com.blitzapp.animatedsplash.animation.Splash.DIALOGSLIDEDOWN;
import static com.blitzapp.animatedsplash.animation.Splash.FADE;
import static com.blitzapp.animatedsplash.animation.Splash.performSingleAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.createSplashView;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;
import static com.blitzapp.animatedsplash.animation.Splash.setBackgroundColor;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideDelay;
import static com.blitzapp.animatedsplash.animation.Splash.splashShow;


public class MainActivity extends ReactActivity {

    @Override
    protected String getMainComponentName() {
        return "example";
    }

    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        initiateSplash();
    }

    public void initiateSplash() {
    
        // create dialog
        splash.createSplashView(MainActivity.this);

        //set background color to view
        setBackgroundColor("#101010");
        
        // set splash hide animation
        setSplashHideAnimation(DIALOGSLIDEDOWN);
        
        // set splash hide delay
        setSplashHideDelay(1500);
        
        // create and add images to view
        AddImageView logoimage = new AddImageView(R.drawable.logo, screenHeight * 0.24, screenWidth * 0.4, getCenterX(screenWidth * 0.41), getCenterY(screenHeight * 0.26), 0, FIT_CENTER, false);

        AddImageView image1 = new AddImageView(R.drawable.oval3, screenHeight * 0.39, screenWidth * 0.76, getCenterX(screenWidth * 0.76), getCenterY(screenHeight * 0.39), 0, FIT_XY, false);

        AddImageView image2 = new AddImageView(R.drawable.oval2, screenHeight * 0.537, screenWidth + screenWidth * 0.06, getCenterX(screenWidth + screenWidth * 0.06), getCenterY(screenHeight * 0.537), 0, FIT_XY, false);

        AddImageView image3 = new AddImageView(R.drawable.oval1, screenHeight * 0.676, screenWidth + screenWidth * 0.29, getCenterX(screenWidth + screenWidth * 0.29), getCenterY(screenHeight * 0.676), 0, FIT_XY, false);


        // add group animation
        GroupAnimation group1 = new GroupAnimation();
        group1.performGroupAnimation(logoimage, FADE, 400, 0f, 1f, false);
        group1.performGroupAnimation(logoimage, SCALE, 400, 0f, 1f, 0f, 1f, false);
        
        // add single animation
        performSingleAnimation(image1, FADE, 500, 0f, 1f);

        performSingleAnimation(image2, FADE, 400, 0f, 1f);

        performSingleAnimation(image3, FADE, 400, 0f, 1f);

        splashShow();

    }
}


```
Then call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 
![](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/master/example1.gif?raw=true)
>
>
#### Example Animation 2

```sh
package com.example;

import android.os.Bundle;


import com.blitzapp.animatedsplash.animation.AddImageView;
import com.blitzapp.animatedsplash.animation.GroupAnimation;
import com.facebook.react.ReactActivity;

import static com.blitzapp.animatedsplash.animation.Splash.DIALOGSLIDELEFT;
import static com.blitzapp.animatedsplash.animation.Splash.SCALE;
import static com.blitzapp.animatedsplash.animation.Splash.SLIDE;
import static com.blitzapp.animatedsplash.animation.Splash.createSplashView;
import static com.blitzapp.animatedsplash.animation.Splash.performSingleAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;
import static com.blitzapp.animatedsplash.animation.Splash.setBackgroundImage;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideAnimation;
import static com.blitzapp.animatedsplash.animation.Splash.setSplashHideDelay;
import static com.blitzapp.animatedsplash.animation.Splash.splashShow;


public class MainActivity extends ReactActivity {


    @Override
    protected String getMainComponentName() {
        return "example";
    }


    public void onCreate(Bundle saved) {
        super.onCreate(saved);
        initiateSplash();
    }

    public void initiateSplash() {
        
        //create dialog
        createSplashView(MainActivity.this);

        //set background
        setBackgroundImage(R.drawable.splashbg);
        
        // set splash hide animation
        setSplashHideAnimation(DIALOGSLIDELEFT);

        // set splash hide delay
        setSplashHideDelay(1500);

        // Create and add images to view
        AddImageView image1 = new AddImageView(R.drawable.header, screenHeight * 0.15, screenWidth, 0, 0, FIT_XY, false);
        AddImageView image2 = new AddImageView(R.drawable.footer, screenHeight * 0.15, screenWidth, 0, screenHeight - screenHeight * 0.15, FIT_XY, false);
        AddImageView logoimage = new AddImageView(R.drawable.logo2, screenHeight * 0.18, screenWidth * 0.45, getCenterX(screenWidth * 0.45), getCenterY(screenHeight * 0.18), FIT_XY, false);

        // add group animation
         GroupAnimation group1 = new GroupAnimation();
        group1.performGroupAnimation(image1, SLIDE, 780, 0f, 0f, -screenHeight * 0.15f, 0f);
        group1.performGroupAnimation(image2, SLIDE, 780, 0f, 0f, screenHeight * 0.15f, 0f);
        
        
        // add single animation
        performSingleAnimation(logoimage, SCALE, 780, 0.2f, 1f, 0.2f, 1f);

        splashShow();

    }
}
```
Then call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 
 ![](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/master/example2.gif?raw=true)
 >
 >
#### Important Note

> add respective images from your drawable else it will give error
>
> for some variables which appears not defined like "screenHeight", import them from library class.
>

>
>

### Methods Description

* createSplashView(context)
> creates a view for splash

  * context: determine the context of your app, give context like "MainActivity.this"
 
* setBackgroundColor(colorCode)
> sets background color on splash screen

  * colorCode: determine the color for background, give color value in string like this "#FFFFFF"

* setBackgroundImage(drawable)
> sets background image on splash screen

  * drawable: determine the image for background, give any drawble image.
  
* setSplashHideAnimation(animationType)
> set animation for hiding of splash

  * animationType: determine the animation on hide of splash, use any constant value given in Splash Hide Animation section in this document.
  
* setSplashHideDelay(delay)
> sets delay before splash hide

  * delay: determine the delay value before splash hide, enter value in milliseconds.
  
* splashShow()
> display splash and starts animations

* getCenterX(widthOfImage)
> sets the image to center of view at x-axis

  * widthOfImage: determines the center on splash view at x-axis with respect to width of image, enter width of image which you want to set in center.
  
* getCenterY(heightOfImage)
> sets the image to center of view at y-axis

  * heightOfImage: determines the center on splash view at y-axis with respect to height of image, enter height of image which you want to set in center.
  
### Splash Hide Animation Constants 
| Animation | Description |
| ------ | ------ |
| DIALOGSLIDELEFT | hides splash while sliding to left.|
| DIALOGSLIDERIGHT | hides splash while sliding to right.|
| DIALOGFADE | hides splash with fade effect.|
| DIALOGSLIDEDOWN | hides splash while sliding to down.|

 
 
### AddImageView Method Description

| Parameter | Description | Type |
| ------ | ------ | ------- |
| imageSource | drawable image that you need to add on splash screen| Integer(double) |
| height | height of image drawable| Double |
| width | width of image drawable| Double |
| positionX | position of image drawable on x-axis on splash screen| Double |
| positionY | position of image drawable on y-axis on splash screen| Double |
| scaleType | scaleType of image drawable. (possible options could be: FIT_XY, FIT_CENTER, FIT_END, FIT_START)| CONSTANTS (to be imported from AddImageView) |
| visibility | drawable image visiblity on splash screen initially. It will get visible as the animation on that image starts| Boolean |
| rotateDegree | drawable image initial rotate degree | Double |
| opacity | set initial opacity for image. Value ranges from 0-1 | Double |

* AddImageView(drawableImage, height, width) 
> Adding basic image to view with default options

  * drawableImage: determine the drawable image you need to add on splash view.
  * height: determines the height of drawble image.
  * width: determines the width of drawable image.

* AddImageView(drawableImage, height, width, positionX, positionY, visibility)
> Adding image with position values and set initial visibility of image.

  * positionX: determine position of image drawable on x-axis on splash screen.
  * positionY determine position of image drawable on y-axis on splash screen.
  * visibility:determine drawable image visiblity on splash screen initially. It will get visible as the animation for that image starts. Default value is true.

* AddImageView(drawableImage, height, width, positionX, positionY, scaleType, visibility)
> Adding image with scaleType for image.

  * scaleType: scaleType of image drawable. (possible options could be: FIT_XY, FIT_CENTER, FIT_END, FIT_START). These CONSTANTS (to be imported from AddImageView).
  
* AddImageView(drawableImage, height, width, positionX, positionY, rotateDegree, scaleType, visibility)
> Adding image with initial rotateDegree
 
  * rotateDegree: determeines image's initial rotate degree. Default value is 0.
 
* AddImageView(drawableImage, height, width, positionX, positionY, rotateDegree, opacity, scaleType, visibility)
> Adding image with initial opacity 
 
  * opacity: determeines image's initial opacity value. Default value is 1.




### Defining Animations

The animations you define works sequentially.
You can define animations of three types.

#### Type1 - Group Animation
You need to use group animation when you need to run two or more animations simultaneously.
Sample code for defining group animations:

```sh
GroupAnimation group1 = new GroupAnimation();
group1.performGroupAnimation(image1, SLIDE, 980, 0f, 0f, -screenHeight * 0.2f, 0f);
group1.performGroupAnimation(image2, SLIDE, 980, 0f, 0f, screenHeight * 0.2f, 0f);
```

#### Type2 - Single Animation
Single animation can be used to run an animation in sequence.

```sh
performSingleAnimation(imageview1, SCALE, 980, 0.2f, 1f, 0.2f, 1f);
performSingleAnimation(imageview2, SCALE, 980, 0.2f, 1f, 0.2f, 1f);
```

#### Type3 - Define Animation before hiding splash
You can use animation on certain object to perform just before hiding of splash
 ```sh
 performAnimationOnHide(imageview, SCALE, 980, 0.2f, 1f, 0.2f, 1f);
 ```
### Animation Methods Description

| Parameter | Description | Type |
| ------ | ------ | ------- |
| imageview | imageview you created and placed on splash that you want to perform animation on| CreateImageObject |
| typeofanimation | determines the type of animation you want to perform, you can read possible types CONSTANTS from Animation Type section.
| animationDuration | animation duration for specified animation| int |
| fromXDelta | if type is SLIDE or SCALE, initial point at x-axis to start slide from | float |
| toXDelta | if type is SLIDE or SCALE, final point at x-axis to end slide at| float |
| fromYDelta | if type is SLIDE or SCALE, initial point at y-axis to start slide from | float |
| toYDelta | if type is SLIDE or SCALE, final point at y-axis to end slide at| float |
| fromValue | if type is FADE or ROTATE, final point at y-axis to end slide at| float |
| toValue | if type is FADE or ROTATE, final point at y-axis to end slide at| float |
| isLoop | run animation in loop or continuously | boolean |

##### Defining SLIDE or SCALE animation

* performSingleAnimation(imageview, typeofanimation, animationDuration, fromXDelta, toXDelta, fromYDelta, toYDelta)
> for SLIDE or SCALE animation

  * imageview: determine the image view you already added to perform animation on.
  * typeofanimation: determines the type of animation you want to perform.
  * animationDuration: determines animation duration.
  * fromXDelta: initial point at x-axis to start animation.
  * toXDelta: final point at x-axis to end animation.
  * fromYDelta: initial point at y-axis to start animation.
  * toYDelta: final point at y-axis to end animation.
  
* performSingleAnimation(imageview, typeofanimation, animationDuration, fromXDelta, toXDelta, fromYDelta, toYDelta, isLoop)
> for SLIDE or SCALE animation continue looping

  * isLoop: run animation in loop or continuously.
  
##### Defining FADE or ROTATE animation

* performSingleAnimation(imageview, typeofanimation,  animationDuration, fromValue, toValue)
> for FADE or ROTATE animation

  * imageview: determine the image view you already added to perform animation on.
  * typeofanimation: determines the type of animation you want to perform.
  * animationDuration: determines animation duration.
  * fromValue: starting value for animation.
  * toValue: final value for animation

* performSingleAnimation(imageview, typeofanimation,  animationDuration, fromValue, toValue, isLoop)
> for FADE or ROTATE animation continue looping

  * isLoop: run animation in loop or continuously.

### Animation Types

| Animation | Description |
| ------ | ------ |
| SLIDE | slide image object to given x and y axis.|
| SCALE | scale image object starting from initial value to final value.|
| FADE | fade image object starting from initial value to final value. Value ranges from 0 - 1 (for fade in) or 1-0 (for fade out)|
| ROTATE | rotate image object starting from initial value to final value.|

### Hide Splash in your app

Call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 

### Todos
We aim to make this package even more robust and powerful by adding following features in the upcoming releases:
 - implement ios

License
MIT 
