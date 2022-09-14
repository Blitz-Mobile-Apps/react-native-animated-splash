
  

  

## React-Native-Animated-Splash -- iOS Description

Check the [Example Application](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/master/androidexample.md) for reference.

  

## Usage

  

MainActivity.java

```sh
...
import static com.blitzapp.animatedsplash.animation.Constants.FADE;
import static com.blitzapp.animatedsplash.animation.Constants.SCALE;
import static com.blitzapp.animatedsplash.animation.Constants.SPLASH_SLIDE_RIGHT;
import static com.blitzapp.animatedsplash.animation.Splash.screenHeight;
import static com.blitzapp.animatedsplash.animation.Splash.screenWidth;
import com.blitzapp.animatedsplash.animation.AnimatedObject;
import com.blitzapp.animatedsplash.animation.GroupAnimation;
import com.blitzapp.animatedsplash.animation.ObjectAnimation;
import com.blitzapp.animatedsplash.animation.SingleAnimation;
import com.blitzapp.animatedsplash.animation.Splash;
...
```

## Methods Description

  

### Splash
MainActivity.java
Run the lines in the onCreate method
```
// Create Splash
    Splash splash = new Splash(getContext());
//Set Background Color To View
    splash.setBackgroundColor("#101010");
//Set Hiding Animation for Splash
    splash.setSplashHideAnimation(SPLASH_SLIDE_RIGHT);
//Set Delay for Splash to hide
    splash.setSplashHideDelay(1500);
```
> Add all the code just above the return statement in the didFinishLaunchingWithOptions method.

**setBackgroundColor**

| Prop | Description | Type|
|--|--|--|
| colorString | Background color of your splash, give color value in Hex String ("#101010") |String|

  

**setBackgroundImage**

| Prop | Description | Type|
|--|--|--|
| drawable | Hiding animation of your splash, give any drawable image from resources|Int| any drawable image from resources.|

  

**setSplashHideAnimation**

| Prop | Description | Type|
|--|--|--|
| animationType | Background Image of your splash, use constants provided in the library |Int|

**setSplashHideDelay**

| Prop | Description | Type|
|--|--|--|
| delay | Duration of the splashscreen, Provide delay time in milliseconds |Int|

  

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
AnimatedObject square = new AnimatedObject(R.drawable.square, screenWidth * 0.4f, screenHeight * 0.24f);
```

| Parameter | Description | Type |
| ------ | ------ | ------- |
| imageSource | Image that you want to add on splash screen from assets in iOS| Integer |
| height | Height of image drawable| Double |
| width | Width of image drawable| Double |

  

#### Setter Functions
```
    logoimage.setPositionY(12);
    logoimage.setPositionX(12);
    logoimage.setVisibility(true);
    logoimage.setScaleType(FIT_CENTER);
    logoimage.setRotateDegree(180);
    logoimage.setOpacity(0.5f);
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
ObjectAnimation logoimageAnimation1 = new ObjectAnimation(logoimage, FADE, 1000, 0f, 1f, false);
```
### Slide Animation
```sh
//Without Loop
ObjectAnimation image2Animation = new ObjectAnimation(image2, SLIDE, 500, 0f, 100, 0f,100);
// With Loop
ObjectAnimation image2Animation = new ObjectAnimation(image2, SLIDE, 500, 0f, 100, 0f,100, true);
            
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
ObjectAnimation logoimageAnimation2 = new ObjectAnimation(logoimage, SCALE, 1000, 0f, 1f, 0f, 1f);
// With Loop
ObjectAnimation logoimageAnimation2 = new ObjectAnimation(logoimage, SCALE, 1000, 0f, 1f, 0f, 1f, true);
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
ObjectAnimation logoimageAnimation1 = new ObjectAnimation(logoimage, FADE, 1000, 0f, 1f, false);
// With Loop
ObjectAnimation logoimageAnimation1 = new ObjectAnimation(logoimage, FADE, 1000, 0f, 1f, true);

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
| fromValue | Initial rotation degree of object or image| Float |
| toVlaue | Final rotation degree of object or image| Float |
| loop | Loop the animation (Default value is false) | Boolean|
  

## Group Animations  

> Animations added in the group will run simultaneously. Animation with lesser priority will run after all the objects in the group are done animating.


```
GroupAnimation group1 = new GroupAnimation(1);
group1.addAnimation(logoimageAnimation1);
group1.addAnimation(logoimageAnimation2);
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
SingleAnimation single1  = new SingleAnimation(image1Animation,2);
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
HideGroupAnimation hideGroup1 = new HideGroupAnimation(1);
hideGroup1.addAnimation(logoimageHideAnimation1);
hideGroup1.addAnimation(logoimageHideAnimation2);
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
HideSingleAnimation hideSingle1 = new HideSingleAnimation(image1HideAnimation,2);
```

| Parameter | Description | Type |
| ------ | ------ | ------- |
| object | Single object or image that will animate one at a time | ObjectAnimation |
| priority | priority or the sequence of animation | Int |

  
  ## Show Splash in your app
> After all the objects and their animations are added, add this line before return statement

MainActivity.java
```sh
  splash.ShowSplash();
```  

## Hide Splash in your app
> Call hide function of splash in your app, from react native like this:

```sh
import AnimatedSplash from "react-native-animated-splash";
AnimatedSplash.hide()
```  

License
MIT
