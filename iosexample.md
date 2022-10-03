
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
#import <RNAnimatedSplash/SingleAnimation.h>
@class SingleAnimation;
#import <RNAnimatedSplash/HideGroupAnimation.h>
@class HideGroupAnimation;
#import <RNAnimatedSplash/HideSingleAnimation.h>
@class HideSingleAnimation;
#import <RNAnimatedSplash/ObjectAnimation.h>
@class ObjectAnimation;
 ```
 
 Go to your AppDelagate.m file and add following code in its didFinishLaunchingWithOptions method.
 
 ```sh

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
  ...
  ...
// add splash code here
  
  static Splash *splash = [[Splash alloc] init];
  
  [splash createSplashView:self.window];
  [splash setBackgroundColor:@"101010"];
  [splash setSplashHideAnimation:SPLASH_SLIDE_RIGHT];
  [splash setSplashHideDelay:1000];
  
  AnimatedObject *logo1 = [[AnimatedObject alloc] initImage:@"logo1" width:screenWidth*0.08 height:screenHeight*0.04];
  [logo1 setVisibility:(bool) false];
  [logo1 setScaleType:(int) FIT_CENTER];
  
  [logo1 addToSplash];
  
  AnimatedObject *circle1 = [[AnimatedObject alloc] initImage:@"circle1" width:screenWidth*0.76 height:screenHeight*0.39];
  [circle1 setVisibility:(bool) false];
  [circle1 setScaleType:(int) FIT_CENTER];
  
  [circle1 addToSplash];
  
  AnimatedObject *circle2 = [[AnimatedObject alloc] initImage:@"circle2" width:screenWidth + screenWidth * 0.12 height:screenHeight * 0.53];
  [circle2 setVisibility:(bool) false];
  [circle2 setScaleType:(int) FIT_CENTER];
  
  [circle2 addToSplash];
  
  AnimatedObject *circle3 = [[AnimatedObject alloc] initImage:@"circle3" width:screenWidth + screenWidth * 0.29 height:screenHeight * 0.676];
  [circle3 setVisibility:(bool) false];
  [circle3 setScaleType:(int) FIT_CENTER];
  
  [circle3 addToSplash];
  
  ObjectAnimation *logo1Animation1 = [[ObjectAnimation alloc] initimage:logo1 animationtype:FADE animationDuration:800 fromVal:0 toVal:1];
  ObjectAnimation *logo1Animation2 = [[ObjectAnimation alloc] initimage:logo1 animationtype:SCALE animationDuration:400 scaleX:4.9 scaleY:4.9];
  
  ObjectAnimation *circle1Animation = [[ObjectAnimation alloc] initimage:circle1 animationtype:FADE animationDuration:500 fromVal:0 toVal:1];
  
  ObjectAnimation *circle2Animation = [[ObjectAnimation alloc] initimage:circle2 animationtype:FADE animationDuration:400 fromVal:0 toVal:1];
  
  ObjectAnimation *circle3Animation = [[ObjectAnimation alloc] initimage:circle3 animationtype:FADE animationDuration:400 fromVal:0 toVal:1];
  
  
  GroupAnimation *ga1 = [[GroupAnimation alloc] init:1];
  [ga1 addAnimation:logo1Animation1];
  [ga1 addAnimation:logo1Animation2];
  
  SingleAnimation *sa1 = [[SingleAnimation alloc] init:circle1Animation priority:2];
  SingleAnimation *sa2 = [[SingleAnimation alloc] init:circle2Animation priority:3];
  SingleAnimation *sa3 = [[SingleAnimation alloc] init:circle3Animation priority:4];

  

  [splash splashShow];
  
  
  // Add all the code right before the return statement
  return YES;
}

```
Then call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 
![](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/v2/example1ios.gif?raw=true)
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
#import <RNAnimatedSplash/SingleAnimation.h>
@class SingleAnimation;
#import <RNAnimatedSplash/HideGroupAnimation.h>
@class HideGroupAnimation;
#import <RNAnimatedSplash/HideSingleAnimation.h>
@class HideSingleAnimation;
#import <RNAnimatedSplash/ObjectAnimation.h>
@class ObjectAnimation;
 ```
 
 Go to your AppDelagate.m file and add following code in its didFinishLaunchingWithOptions method.

```sh

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
  ...
  ...
  static Splash *splash = [[Splash alloc] init];
  
  [splash createSplashView:self.window];
  [splash setBackgroundImage:@"splashBg"];
  [splash setSplashHideAnimation:SPLASH_SLIDE_LEFT];
  [splash setSplashHideDelay:1500];
  
  AnimatedObject *headerImage = [[AnimatedObject alloc] initImage:@"header" width:screenWidth height:screenHeight*0.18];
  [headerImage setVisibility:(bool) false];
  [headerImage setScaleType:(int) FIT_XY];
  [headerImage setPositionX:0];
  [headerImage setPositionY:-screenHeight*0.18];
  
  [headerImage addToSplash];
  
  AnimatedObject *footerImage = [[AnimatedObject alloc] initImage:@"footer" width:screenWidth height:screenHeight*0.18];
  [footerImage setVisibility:(bool) false];
  [footerImage setScaleType:(int) FIT_XY];
  [footerImage setPositionX:0];
  [footerImage setPositionY:screenHeight];
  
  [footerImage addToSplash];
  
  AnimatedObject *logoImage = [[AnimatedObject alloc] initImage:@"logo2" width:screenWidth*0.095 height:screenHeight * 0.05];
  [logoImage setVisibility:(bool) false];
  [logoImage setScaleType:(int) FIT_CENTER];
  
  [logoImage addToSplash];
  
  
  ObjectAnimation *headerAnimation = [[ObjectAnimation alloc] initimage:headerImage animationtype:SLIDE animationDuration:800 fromX:0 toX:0 fromY:0 toY:screenHeight*0.18];
  
  ObjectAnimation *footerAnimation = [[ObjectAnimation alloc] initimage:footerImage animationtype:SLIDE animationDuration:800 fromX:0 toX:0 fromY:0 toY:-screenHeight*0.18];
  
  ObjectAnimation *logoAnimation = [[ObjectAnimation alloc] initimage:logoImage animationtype:SCALE animationDuration:800 scaleX:5.5 scaleY:4];
  
  GroupAnimation *ga1 = [[GroupAnimation alloc] init:1];
  [ga1 addAnimation:headerAnimation];
  [ga1 addAnimation:footerAnimation];

  SingleAnimation *s1 = [[SingleAnimation alloc] init:logoAnimation priority:2];

  [splash splashShow];
  
   // Add all the code right before the return statement
  return YES;

}
```
Then call hide function of splash in your app, from react native side like this:
 
 ```sh
 import AnimatedSplash from "react-native-animated-splash";
 
 AnimatedSplash.hide()
 ```  
 
 ![](https://github.com/Blitz-Mobile-Apps/react-native-animated-splash/blob/v2/example2ios.gif?raw=true)
 >
 >
#### Important Note

> add respective images in your project's imageassets otherwise it will give error
>
> for some variables which appears not defined like "screenHeight", import them from library class.
>

