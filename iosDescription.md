
  

  

## React-Native-Animated-Splash -- iOS Description

Check the [Example Application](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/master/iosexample.md) for reference.

  

## Usage

  

AppDelegate.h

```sh
...
#import <RNAnimatedSplash/Splash.h>
@class Splash;
#import <RNAnimatedSplash/GroupAnimation.h>
@class GroupAnimation;
#import <RNAnimatedSplash/SingleAnimation.h>
@class SingleAnimation;
#import <RNAnimatedSplash/HideGroupAnimation.h>
@class HideGroupAnimation;
#import <RNAnimatedSplash/HideSingleAnimation.h>
@class HideSingleAnimation;
...

```

## Methods Description

  

### Splash
AppDelegate.m
```
// Create Splash
static Splash *splash = [[Splash alloc] init];
[splash createSplashView:self.window];

//Set Background Color To View
[splash setBackgroundColor:@"101010"];

//Set Hiding Animation for Splash
 [splash setSplashHideAnimation:SPLASH_SLIDE_DOWN];

//Set Delay for Splash to hide
[splash setSplashHideDelay:10000];
```
> Add all the code just above the return statement in the didFinishLaunchingWithOptions method.

**setBackgroundColor**

| Prop | Description | Type|
|--|--|--|
| colorString | Background color of your splash, give color value in Hex String (@"101010") |String|

  

**setBackgroundImage**

| Prop | Description | Type|
|--|--|--|
| String | Background image of your splash, give any name of image from resources|String| Any image name from resources.|

  

**setSplashHideAnimation**

| Prop | Description | Type|
|--|--|--|
| animationType | Background Image of your splash, use constants provided in the library |Int|

**setSplashHideDelay**

| Prop | Description | Type|
|--|--|--|
| delay | Duration of the splashscreen after animations are done rendering, Provide delay time in milliseconds |Int|

  

**splashShow()**

Renders the native splash screen and runs the animations.

  
  

### Splash Hide Animation Constants

  

| Animation | Description |
| ------ | ------ |
| SPLASH_SLIDE_LEFT | Hides splash sliding left.|
| SPLASH_SLIDE_RIGHT | Hides splash sliding right.|
| SPLASH_SLIDE_DOWN | Hides splash sliding down.|
| SPLASH_FADE | Hides splash with fade effect.|

  

## AnimatedObject

##### Initializing new Object
```sh
  AnimatedObject *square = [[AnimatedObject alloc] initImage:@"square" width:screenWidth + screenWidth * 0.29 height:screenHeight * 0.676];
```

| Parameter | Description | Type |
| ------ | ------ | ------- |
| imageSource | Image that you want to add on splash screen from assets in iOS| Integer |
| height | Height of image drawable| Double |
| width | Width of image drawable| Double |

  

#### Setter Functions
```
  [square setPositionX:(float) 0];
  [square setPositionY:(float) 0];
  [square setVisibility:(bool) false];
  [square setScaleType:(int) FIT_CENTER];
  [square addAnimationWithAnimationtType:square animationType:FADE duration:2000 fromValue:0 toValue:1];
  [square addHideAnimationWithAnimationtType:square animationType:FADE duration:2000 fromValue:1 toValue:0];
```
| Method | Description | Type |
| ------ | ------ | ------- |
| setPositionX | Set position of image drawable on X-Axis on Splash Screen| Double |
| setPositionY | Set position of image drawable on Y-Axis on Splash Screen| Double |
| setScaleType | Set scaleType of image drawable. (possible options could be: FIT_XY, FIT_CENTER, FIT_END, FIT_START)| String (To be importted from Constants class) |
| setVisibility | Set visiblity of the image on splash screen initially.| Boolean |
| setRotateDegree | Set initial rotate degree of image| Double |
| setOpacity | Set initial opacity of image. Value ranges from 0-1 | Double |

## Animation Types

| Animation | Description |
| ------ | ------ |
| SLIDE | Slide image object to given x and y axis.|
| SCALE | Scale image object starting from initial value to final value.|
| FADE | Fade image object starting from initial value to final value. Value ranges from 0 - 1 (for fade in) or 1-0 (for fade out)|
| ROTATE | Rotate image object starting from initial value to final value.|


## ObjectAnimation

### Note
> Looping is not available in the "setHideAnimation".



#### Initializing new Animation
```sh

ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:FADE animationDuration:800 fromVal:0 toVal:1];
```
  


### Slide Animation
```sh
//Without Loop
ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:SLIDE animationDuration:2000 fromX:0 toX:screenWidth-screenWidth*0.5 fromY:0 toY:0];
// With Loop
ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:SLIDE animationDuration:2000 fromX:0 toX:screenWidth-screenWidth*0.5 fromY:0 toY:0 loop:true];
```
| Attribute | Description | Type
| ------ | ------ | ------- |
| imageSource | Add the source image itself | AnimatedObject |
| animationType | Type of animation | Int (Constant) |
| animationDuration | Duration of animation in milliseconds | Int |
| fromX | Initial position of object on X-Axis| Float |
| toX | Final position of object on X-Axis | Float|
| fromY | Initial position of object on Y-Axis | Float|
| toY | Final position of object on Y-Axis | Float|
| loop | Loop the animation (Default value is false) | Boolean|

  

### Scale Animation

```sh
//Without Loop
ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:SCALE animationDuration:2000 scaleX:2 scaleY:2];
// With Loop
ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:SCALE animationDuration:2000 scaleX:2 scaleY:2 loop:true];
```

| Attribute | Description | Type
| ------ | ------ | ------- |
| imageSource | Add the source image itself | AnimatedObject |
| animationType | Type of animation | Int (Constant) |
| animationDuration | Duration of animation in milliseconds | Int |
| scaleX | Final mulitple size of object on X-Axis | Float|
| scaleY | Final mulitple position of object on Y-Axis | Float|
| loop | Loop the animation (Default value is false) | Boolean|

**Note:**
> 2 means the size of image is multiplied by 2.

  

### Fade Animation

```sh
//Without Loop
ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:FADE animationDuration:2000 fromValue:0 toValue:1];
// With Loop
ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:FADE animationDuration:2000 fromValue:0 toValue:1 loop:true];

```

| Attribute | Description | Type
| ------ | ------ | ------- |
| imageSource | Add the source image itself | AnimatedObject |
| animationType | Type of animation | Int (Constant) |
| animationDuration | Duration of animation in milliseconds | Int |
| fromValue | Initial opacity of object or image| Float |
| toValue | Final opacity of object or image | Float|
| loop | Loop the animation (Default value is false) | Boolean|

### Rotate Animation
```sh
//Without Loop
ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:FADE animationDuration:2000 rotateDegree:180];
// With Loop
ObjectAnimation *squareAnimation1 = [[ObjectAnimation alloc] initimage:square animationtype:FADE animationDuration:2000 rotateDegree:180 loop:true];
```
| Attribute | Description | Type
| ------ | ------ | ------- |
| imageSource | Add the source image itself | AnimatedObject |
| animationType | Type of animation | Int (Constant) |
| duration | Duration of animation in milliseconds | Int |
| rotateDegree | Rotation degree of object or image| Float |
| loop | Loop the animation (Default value is false) | Boolean|
  

## Group Animations  

> Animations added in the group will run simultaneously. Animation with lesser priority will run after all the objects in the group are done animating.


```
GroupAnimation *groupAnimation1 = [[GroupAnimation alloc] init:1];
  [groupAnimation1 addAnimation:square1];
  [groupAnimation1 addAnimation:square2];
```
| Parameter | Description | Type |
| ------ | ------ | ------- |
| priority | priority or the sequence of animation | Int |



| Method | Description | Type |
| ------ | ------ | ------- |
| addAnimation | Adds the given image or object in the group | ObjectAnimation |
  

## Single Animations

> Single Animations will animate the object one at a time and the next animation will run after it's animation is completed.

```
SingleAnimation *singleAnimation1 = [[SingleAnimation alloc] init:square priority:1];
```

| Parameter | Description | Type |
| ------ | ------ | ------- |
| object | Single object or image that will animate one at a time | ObjectAnimation |
| priority | priority or the sequence of animation | Int |

### Note 
> These animations will run just before the splash starts to hide. 
## Hiding Group Animations  

> Animations added in the group will run simultaneously. Animation with lesser priority will run after all the objects in the group are done animating.


```
 HideGroupAnimation *hideGroupAnimation1 = [[HideGroupAnimation alloc] init: 2];
  [hideGroupAnimation1 addAnimation:square];
  [hideGroupAnimation1 addAnimation:square];
```
| Parameter | Description | Type |
| ------ | ------ | ------- |
| priority | priority or the sequence of animation | Int |



| Method | Description | Type |
| ------ | ------ | ------- |
| addAnimation | Adds the given image or object in the group | ObjectAnimation |
  

## Hiding Single Animations

> Single Animations will animate the object one at a time and the next animation will run after it's animation is completed.

```
 HideSingleAnimation *h = [[HideSingleAnimation alloc] init:square priority:1];
```

| Parameter | Description | Type |
| ------ | ------ | ------- |
| object | Single object or image that will animate one at a time | ObjectAnimation |
| priority | priority or the sequence of animation | Int |

  
  ## Show Splash in your app
> After all the objects and their animations are added, add this line before return statement

AppDelegate.m
```sh
  [splash splashShow];
  return;
```  

## Hide Splash in your app
> Call hide function of splash in your app, from react native like this:

```sh
import AnimatedSplash from "react-native-animated-splash";
AnimatedSplash.hide()
```  

License
MIT
