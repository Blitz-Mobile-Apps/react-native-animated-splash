
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
  ...
  ...
  
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
  
  [group1 performGroupAnimation:logoimage typeofanimation:SCALE duration:400 scaleX:4.9 scaleY:4.9];
      
  
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
  ...
  ...
  
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
     
   [splash performSingleAnimation:logoImage animationType:SCALE duration:500 scaleX:5.5 scaleY:4];
    
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

