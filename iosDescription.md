

### React-Native-Animated-Splash -- Ios Description

### Installation
If you prefer **npm**,
```sh
$ npm install react-native-animated-splash --save
```

If you prefer **yarn**,
```sh
$ yarn add react-native-animated-splash
```
#### Add this line in your podfile
```sh
pod 'RNAnimatedSplash', :path => '../node_modules/react-native-animated-splash'
```

## USAGE

 ###  IOS
 >
 Following are the basic examples of using react-native-animated-splash. 
 
 #### Example Animation 1
 
 Go to your AppDelagate.h file and import following files.
 
 ```sh
 ...
#import <RNAnimatedSplash/Splash.h>
@class Splash;
#import <RNAnimatedSplash/GroupAnimation.h>
@class GroupAnimation;
#import <RNAnimatedSplash/HideGroupAnimation.h>
@class HideGroupAnimation;
 ```
 
 Go to your AppDelagate.m file and add following code in its didFinishLaunchingWithOptions method.
 
 ```sh

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
#if DEBUG
  InitializeFlipper(application);
#endif

  RCTBridge *bridge = [[RCTBridge alloc] initWithDelegate:self launchOptions:launchOptions];
  RCTRootView *rootView = [[RCTRootView alloc] initWithBridge:bridge
                                                   moduleName:@"animatedsplashmodule"
                                            initialProperties:nil];

  rootView.backgroundColor = [[UIColor alloc] initWithRed:1.0f green:1.0f blue:1.0f alpha:1];

  self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
  UIViewController *rootViewController = [UIViewController new];
  rootViewController.view = rootView;
  self.window.rootViewController = rootViewController;
  [self.window makeKeyAndVisible];
  
  // add splash code here
    
  Splash *splash = [[Splash alloc] init];
  
  [splash createSplashView:self.window];
  
  [splash setBackgroundColor:@"101010"];
  
  [splash setSplashHideAnimation:SPLASHSLIDEDOWN];
  
  [splash setSplashHideDelay:1500];
  
   AddImageView *logoimage = [[AddImageView alloc] initImage:@"logo1" width:screenWidth*0.08 height:screenHeight*0.04 positionX:[splash getCenterX:screenWidth*0.08] positionY:[splash getCenterY:screenHeight*0.04] visibility:false scaleType:FIT_CENTER];
  
      AddImageView *circle1 = [[AddImageView alloc] initImage:@"oval1" width:screenWidth*0.76 height:screenHeight*0.39 positionX:[splash getCenterX:screenWidth*0.76] positionY:[splash getCenterY:screenHeight*0.39] visibility:false scaleType:FIT_CENTER];
  
  AddImageView *circle2 = [[AddImageView alloc] initImage:@"oval2" width:screenWidth + screenWidth * 0.12 height:screenHeight * 0.53 positionX:[splash getCenterX:screenWidth + screenWidth * 0.12] positionY:[splash getCenterY:screenHeight * 0.53] visibility:false scaleType:FIT_CENTER];
  
  AddImageView *circle3 = [[AddImageView alloc] initImage:@"oval3" width:screenWidth + screenWidth * 0.29 height:screenHeight * 0.676 positionX:[splash getCenterX:screenWidth + screenWidth * 0.29] positionY:[splash getCenterY:screenHeight * 0.676] visibility:false scaleType:FIT_CENTER];
  
  
  GroupAnimation *group1 = [[GroupAnimation alloc] init];
  
  [group1 performGroupAnimation:logoimage typeofanimation:FADE duration:800 fromValue:0 toValue:1];
  
  [group1 performGroupAnimation:logoimage typeofanimation:SCALE duration:400 fromX:0 toX:4.9 fromY:0 toY:4.9];
      
  
  [splash performSingleAnimation:circle1 animationType:FADE duration:500 fromValue:0 toValue:1];
  
  [splash performSingleAnimation:circle2 animationType:FADE duration:400 fromValue:0 toValue:1];
  
  [splash performSingleAnimation:circle3 animationType:FADE duration:400 fromValue:0 toValue:1];
  
  [splash splashShow];
  
  return YES;
}

```
Then call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 
![](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/master/example1ios.gif?raw=true)
>
>
 #### Example Animation 2
 
 Go to your AppDelagate.h file and import following files.
 
 ```sh
 ...
#import <RNAnimatedSplash/Splash.h>
@class Splash;
#import <RNAnimatedSplash/GroupAnimation.h>
@class GroupAnimation;
#import <RNAnimatedSplash/HideGroupAnimation.h>
@class HideGroupAnimation;
 ```
 
 Go to your AppDelagate.m file and add following code in its didFinishLaunchingWithOptions method.

```sh

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
#ifdef FB_SONARKIT_ENABLED
  InitializeFlipper(application);
#endif

  RCTBridge *bridge = [[RCTBridge alloc] initWithDelegate:self launchOptions:launchOptions];
  RCTRootView *rootView = [[RCTRootView alloc] initWithBridge:bridge
                                                   moduleName:@"exampleproject2"
                                            initialProperties:nil];

  rootView.backgroundColor = [[UIColor alloc] initWithRed:1.0f green:1.0f blue:1.0f alpha:1];

  self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
  UIViewController *rootViewController = [UIViewController new];
  rootViewController.view = rootView;
  self.window.rootViewController = rootViewController;
  [self.window makeKeyAndVisible];
  
  
  // add splash code here
  Splash *splash = [[Splash alloc] init];
    
    
  [splash createSplashView:self.window];

  [splash setBackgroundImage:@"splashBg"];
    
  [splash setSplashHideAnimation:SPLASHSLIDELEFT];
    
  [splash setSplashHideDelay:1500];

   AddImageView *headerImage = [[AddImageView alloc] initImage:@"header" width:screenWidth height:screenHeight*0.18 positionX:0 positionY:-screenHeight*0.18 visibility:false scaleType:FIT_XY];
      
   AddImageView *footerImage = [[AddImageView alloc] initImage:@"footer" width:screenWidth height:screenHeight*0.18 positionX:0 positionY:screenHeight visibility:false scaleType:FIT_XY];
   
   AddImageView *logoImage = [[AddImageView alloc] initImage:@"logo2" width:screenWidth * 0.095 height:screenHeight * 0.05 positionX:[splash getCenterX:screenWidth * 0.095] positionY:[splash getCenterY:screenHeight * 0.05]  visibility:false scaleType:FIT_XY];
    

   GroupAnimation *group1 = [[GroupAnimation alloc] init];
      
   [group1 performGroupAnimation:headerImage typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:screenHeight*0.18];
     
   [group1 performGroupAnimation:footerImage typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:-screenHeight * 0.18];
     
   [splash performSingleAnimation:logoImage animationType:SCALE duration:500 fromX:0 toX:5.5 fromY:0 toY:4];
    
   [splash splashShow];
   
   return YES;
}
```
Then call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 
 ![](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/master/example2ios.gif?raw=true)
 >
 >
#### Important Note

> add respective images in your project's imageassets otherwise it will give error
>
> for some variables which appears not defined like "screenHeight", import them from library class.
>

>
>

### Methods Description

* createSplashView:`currentView`  
  creates a view for splash 

  * `currentView`: determine the current view of your app, give view like "self.window"
 
* setBackgroundColor:`colorCode`    
  sets background color on splash screen

  * `colorCode`: determine the color for background, give color value in string like this @"FFFFFF"

* setBackgroundImage:`imageAsset`  
  sets background image on splash screen

  * `imageAsset`: determine the image for background, give any image asset that is in you project.
  
* setSplashHideAnimation:`animationType`  
  set animation for hiding of splash

  * `animationType`: determine the animation on hide of splash, use any constant value given in Splash Hide Animation section in this document.
  
* setSplashHideDelay:`delay`    
  sets delay before splash hide

  * `delay`: determine the delay value before splash hide, enter value in milliseconds.
  
* splashShow  
  display splash and starts animations

* getCenterX:`widthOfImage`   
  sets the image to center of view at x-axis

  * `widthOfImage`: determines the center on splash view at x-axis with respect to width of image, enter width of image which you want to set in center.
  
* getCenterY:`heightOfImage`  
  sets the image to center of view at y-axis

  * `heightOfImage`: determines the center on splash view at y-axis with respect to height of image, enter height of image which you want to set in center.
  
### Splash Hide Animation Constants 
| Animation | Description |
| ------ | ------ |
| `SPLASHSLIDELEFT` | hides splash while sliding to left.|
| `SPLASHSLIDERIGHT` | hides splash while sliding to right.|
| `SPLASHFADE` | hides splash with fade effect.|
| `SPLASHSLIDEDOWN` | hides splash while sliding to down.|

 
 
### AddImageView Method Description

| Parameter | Description | Type |
| ------ | ------ | ------- |
| `imageAsset` | drawable image that you need to add on splash screen| Integer(double) |
| `height` | height of image drawable| Double |
| `width` | width of image drawable| Double |
| `positionX` | position of image drawable on x-axis on splash screen| Double |
| `positionY` | position of image drawable on y-axis on splash screen| Double |
| `scaleType` | scaleType of image drawable. (possible options could be: FIT_XY, FIT_CENTER, FIT_END, FIT_START)| CONSTANTS (to be imported) |
| `visibility` | drawable image visiblity on splash screen initially. It will get visible as the animation on that image starts| Boolean |
| `rotateDegree` | drawable image initial rotate degree | Double |
| `opacity` | set initial opacity for image. Value ranges from 0-1 | Double |

*  AddImageView `*`imagename = [[AddImageView alloc] initImage:`imageAsset` width:`float` height:`float`];   
   Adding basic image to view with default options

   * imageAsset: determine the drawable image you need to add on splash view.
   * height: determines the height of drawble image.
   * width: determines the width of drawable image.

* AddImageView `*`imagename = [[AddImageView alloc] initImage:`imageAsset` width:`float` height:`float` positionX:`float` positionY:`float` visibility:`bool`];  
  Adding image with position values and set initial visibility of image.

  * positionX: determine position of image drawable on x-axis on splash screen.
  * positionY determine position of image drawable on y-axis on splash screen.
  * visibility:determine drawable image visiblity on splash screen initially. It will get visible as the animation for that image starts. Default value is true.

* AddImageView `*`imagename = [[AddImageView alloc] initImage:`imageAsset` width:`float` height:`float` positionX:`float` positionY:`float` visibility:`bool` scaleType:CONSTANT];  
  Adding image with scaleType for image.

  * scaleType: scaleType of image drawable. (possible options could be: FIT_XY, FIT_CENTER, FIT_END, FIT_START). These CONSTANTS (to be imported).
  
* AddImageView `*`imagename = [[AddImageView alloc] initImage:`imageAsset` width:`float` height:`float` positionX:`float` positionY:`float` visibility:`bool` scaleType:`CONSTANT` opacity:`float`];  
  Adding image with initial opacity 
 
  * opacity: determines image's initial opacity value. Default value is 1.
  
 
* AddImageView `*`imagename = [[AddImageView alloc] initImage:`imageAsset` width:`float` height:`float` positionX:`float` positionY:`float` visibility:`bool` scaleType:`CONSTANT` opacity:`float` rotateDegree:`float`];  
  Adding image with initial rotateDegree
 
  * rotateDegree: determines image's initial rotate degree. Default value is 0.




### Defining Animations

The animations you define works sequentially.
You can define animations of four types.

#### Type1 - Group Animation
You need to use group animation when you need to run two or more animations simultaneously.
Sample code for defining group animations:

```sh
GroupAnimation *group1 = [[GroupAnimation alloc] init];
[group1 performGroupAnimation:imagename1 typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:screenHeight*0.18];
[group1 performGroupAnimation:imagename2 typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:-screenHeight * 0.18];
```

#### Type2 - Single Animation
Single animation can be used to run an animation in sequence.

```sh
[splash performSingleAnimation:imagename1 animationType:FADE duration:500 fromValue:0 toValue:1];

[splash performSingleAnimation:imagename2 typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:-screenHeight * 0.18];
```

#### Type3 - Define Animation before hiding splash
You can use animation on certain object to perform just before hiding of splash.
This type of animation is intersting, you can use this animation to make a last glance of animation just before hiding of splash view.
 ```sh
[splash performHideSingleAnimation:logoImage animationType:SLIDE duration:500 fromX:0 toX:5.5 fromY:0 toY:4];
 ```
 
 #### Type4 - Define Group Animation before hiding splash
You need to use group animation when you need to run two or more animations simultaneously.
You can use this animation to animate group of images together just before hiding of splash.

```sh
HideGroupAnimation *group1 = [[HideGroupAnimation alloc] init];
      
[group1 performHideGroupAnimation:headerImage typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:screenHeight*0.18];
     
[group1 performHideGroupAnimation:footerImage typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:-screenHeight * 0.18];
```
### Animation Methods Description

| Parameter | Description | Type |
| ------ | ------ | ------- |
| imageview | imageview you created and placed on splash that you want to perform animation on| CreateImageObject |
| typeofanimation | determines the type of animation you want to perform, you can read possible types CONSTANTS from Animation Type section.
| animationDuration | animation duration for specified animation| int |
| fromX | if type is SLIDE or SCALE, initial point at x-axis to start slide from | float |
| toX | if type is SLIDE or SCALE, final point at x-axis to end slide at| float |
| fromY | if type is SLIDE or SCALE, initial point at y-axis to start slide from | float |
| toY | if type is SLIDE or SCALE, final point at y-axis to end slide at| float |
| fromValue | if type is FADE or ROTATE, final point at y-axis to end slide at| float |
| toValue | if type is FADE or ROTATE, final point at y-axis to end slide at| float |
| loop | run animation in loop or continuously | boolean |

##### Defining SLIDE or SCALE animation

* `[splash performSingleAnimation:imagename1 typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:-screenHeight * 0.18];`

  * imageview: determine the image view you already added to perform animation on.
  * typeofanimation: determines the type of animation you want to perform.
  * animationDuration: determines animation duration.
  * fromXDelta: initial point at x-axis to start animation.
  * toXDelta: final point at x-axis to end animation.
  * fromYDelta: initial point at y-axis to start animation.
  * toYDelta: final point at y-axis to end animation.
  
* `[splash performSingleAnimation:imagename2 typeofanimation:SLIDE duration:800 fromX:0 toX:0 fromY:0 toY:-screenHeight * 0.18 loop:true];`

  * loop: run animation in loop or continuously.
  
##### Defining FADE or ROTATE animation

* `[splash performSingleAnimation:imagename1 animationType:FADE duration:500 fromValue:0 toValue:1];`

  * imageview: determine the image view you already added to perform animation on.
  * typeofanimation: determines the type of animation you want to perform.
  * animationDuration: determines animation duration.
  * fromValue: starting value for animation.
  * toValue: final value for animation

* `[splash performSingleAnimation:imagename1 animationType:FADE duration:500 fromValue:0 toValue:1 loop:true];` 
  for FADE or ROTATE animation continue looping

  * isLoop: run animation in loop or continuously.

##### Note

> The above animation mehtod description is same for all four types of animation. Either you are doing group animations, single animations or animations before hide of splash view.

>

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
 

License
MIT 
