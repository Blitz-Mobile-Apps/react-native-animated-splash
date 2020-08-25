# [react-native-animated-splash](https://www.npmjs.com/package/react-native-animated-splash)
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
![Supports Android and iOS](https://img.shields.io/badge/platforms-android%20|%20ios-lightgrey.svg?style=flat-square)
[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
[![NPM](https://img.shields.io/npm/dm/react-native-animated-splash)](https://www.npmjs.com/package/react-native-animated-splash)
[![Version](https://img.shields.io/npm/v/react-native-animated-splash)](https://www.npmjs.com/package/react-native-animated-splash)


React-Native-Animated-Splash is developed to help the react-native developers in speeding-up their development process. This package leverages the developer from implementing native animations by using our builtin classes for animation with easy to use api, all the animations run on native thread for smooth performance

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
 Following is the basic example of using react-native-animated-splash. Go to your MainActivity.java file and add following code.
 
 ```sh
    
package com.example;

import android.os.Bundle;


import com.facebook.react.ReactActivity;
import com.blitzapp.animatedsplash.animation.AddGroupObject;
import com.blitzapp.animatedsplash.animation.CreateImageObject;
import static com.blitzapp.animatedsplash.animation.Splash.DIALOGSLIDEDOWN;
import static com.blitzapp.animatedsplash.animation.Splash.FADE;
import static com.blitzapp.animatedsplash.animation.Splash.animateSingleObject;
import static com.blitzapp.animatedsplash.animation.Splash.createDialog;
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
    
        //create dialog
        splash.createDialog(MainActivity.this);

        //set background color to view
        setBackgroundColor("#101010");
        
        // set splash hide animation
        setSplashHideAnimation(DIALOGSLIDELEFT);
        
        // set splash hide delay
        setSplashHideDelay(1000);
        
        // create and add images to view
        CreateImageObject addObject1 = new CreateImageObject(R.drawable.oval1, screenHeight * 0.64, screenWidth + screenWidth*0.32, CreateImageObject.getCenterX(screenWidth + screenWidth*0.32), CreateImageObject.getCenterY(screenHeight * 0.64), 0, CreateImageObject.FIT_XY, false);

        CreateImageObject addObject2 = new CreateImageObject(R.drawable.oval2, screenHeight * 0.51, screenWidth + screenWidth*0.07, CreateImageObject.getCenterX(screenWidth + screenWidth*0.07), CreateImageObject.getCenterY(screenHeight * 0.51), 0, CreateImageObject.FIT_XY, false);

        CreateImageObject addObject3 = new CreateImageObject(R.drawable.oval3, screenHeight * 0.385, screenWidth *0.8 , CreateImageObject.getCenterX(screenWidth *0.8), CreateImageObject.getCenterY(screenHeight * 0.385), 0, CreateImageObject.FIT_XY, false);

        CreateImageObject addObject4 = new CreateImageObject(R.drawable.logo, screenHeight * 0.26, screenWidth *0.41 , CreateImageObject.getCenterX(screenWidth *0.41), CreateImageObject.getCenterY(screenHeight * 0.26), 0, CreateImageObject.FIT_CENTER, false);
        

        // add single animation
        animateSingleObject(addObject1, FADE, 500, 0f, 1f,false);

        animateSingleObject(addObject2, FADE, 400, 0f, 1f,false);
        
        animateSingleObject(addObject3, FADE, 400, 0f, 1f,false);

        animateSingleObject(addObject4, FADE, 400, 0f, 1f,true);

        splashShow();

    }
}

```

#### Important Note

> add respective images from your drawable else it will give error
>
> for some variables which appears not defined like "screenHeight", import them from library class.
>


### Methods Description
| Methods | Description | Prameters | Import from |
| ------ | ------ | ------- | ------- |
| createDialog | creates a view for splash | context (MainActivity.this) | Splash |
| setBackgroundColor | sets background color on splash screen | string (Enter color hex code) | Splash |
| setBackgroundImage | sets background image on splash screen| Integer (Enter drawable)| Splash |
| setSplashHideAnimation | set animation for hide splash | CONSTANT (given for splash hide animation) | Splash |
| setSplashHideDelay | sets delay before splash hide | Integer (Enter value in milliseconds) | Splash |
| splashShow | display splash and starts animations | none | Splash |
| getCenterX | sets the image to center of view at x-axis | float (width of image)  | Splash |
| getCenterY | sets the image to center of view at y-axis  | float (height of image) | Splash |
### Splash Hide Animation Constants 
| Animation | Description |
| ------ | ------ |
| DIALOGSLIDELEFT | hides splash while sliding to left.|
| DIALOGSLIDERIGHT | hides splash while sliding to right.|
| DIALOGFADE | hides splash with fade effect.|
| DIALOGSLIDEDOWN | hides splash while sliding to down.|

 
 
### CreateImageObject Parameters Description

| Parameter | Description | Type |
| ------ | ------ | ------- |
| imageSource | drawable image that you need to add on splash screen| Integer(double) |
| height | height of image drawable| Double |
| width | width of image drawable| Double |
| positionX | position of image drawable on x-axis on splash screen| Double |
| positionY | position of image drawable on y-axis on splash screen| Double |
| scaleType | scaleType of image drawable. (possible options could be: FIT_XY, FIT_CENTER, FIT_END, FIT_START)| CONSTANTS (to be imported from CreateImageObject) |
| visibility | drawable image visiblity on splash screen initially. It will get visible as the animation on that image starts| Double |
| rotateDegree | drawabloe image initial rotate degree | Double |


### Defining Animations

The animations you define works sequentially.
You can define animations of three types.

#### Type1 - Group Animation
You need to use group animation when you need to run two or more animations simultaneously.
Sample code for defining group animations:

```sh
AddGroupObject gObject1 = new AddGroupObject();
gObject1.add(addObject1, SLIDE, 980, 0f, 0f, -screenHeight * 0.2f, 0f,false, false);
gObject1.add(addObject2, SLIDE, 980, 0f, 0f, screenHeight * 0.2f, 0f,false, false);
```

#### Type2 - Single Animation
Single animation can be used to run an animation in sequence.

```sh
splash.animateSingleObject(addObject3, SCALE, 980, 0.2f, 1f, 0.2f, 1f,false,true);
splash.animateSingleObject(addObject4, SCALE, 980, 0.2f, 1f, 0.2f, 1f,false,true);
```

#### Type3 - Define Animation before hiding splash
You can use animation on certain object to perform just befor hiding of splash
 ```sh
 splash.animateObjectOnHide(addObject4, SCALE, 980, 0.2f, 1f, 0.2f, 1f,false,true);
 ```
### Animation parameters description

| Parameter | Description | Type |
| ------ | ------ | ------- |
| object | object you created and placed on splash that you want to perform animation on| CreateImageObject |
| animationType | hieght of image drawble| Double |
| animationDuration | animation duration for specified animation| int |
| fromXDelta | if type is SLIDE, initial point at x-axis to start slide from | float |
| toXDelta | if type is SLIDE, final point at x-axis to end slide at| float |
| fromYDelta | if type is SLIDE, initial point at y-axis to start slide from | float |
| toYDelta | if type is SLIDE, final point at y-axis to end slide at| float |
| fromValue | if type is SCALE,FADE,ROTATE, final point at y-axis to end slide at| float |
| toValue | if type is SCALE,FADE,ROTATE, final point at y-axis to end slide at| float |
| isLoop | run animation in loop or continuously | boolean |
| isLastObject | set to true if animation is last one | boolean |


### Animation Types

| Animation | Description |
| ------ | ------ |
| SLIDE | slide image object to given x and y axis.|
| SCALE | scale image object starting from initial value to final value.|
| FADE | fade image object starting from initial value to final value. Value ranges from 0 - 1 (for fade in) or 1-0 (for fade out)|
| ROTATE | rotate image object starting from initial value to final value.|


### Todos
We aim to make this package even more robust and powerful by adding following features in the upcoming releases:
 - implement ios

License
MIT 
