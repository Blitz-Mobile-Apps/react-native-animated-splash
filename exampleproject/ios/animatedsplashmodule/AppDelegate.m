#import "AppDelegate.h"

#import <React/RCTBridge.h>
#import <React/RCTBundleURLProvider.h>
#import <React/RCTRootView.h>

#if DEBUG
#import <FlipperKit/FlipperClient.h>
#import <FlipperKitLayoutPlugin/FlipperKitLayoutPlugin.h>
#import <FlipperKitUserDefaultsPlugin/FKUserDefaultsPlugin.h>
#import <FlipperKitNetworkPlugin/FlipperKitNetworkPlugin.h>
#import <SKIOSNetworkPlugin/SKIOSNetworkAdapter.h>
#import <FlipperKitReactPlugin/FlipperKitReactPlugin.h>

static void InitializeFlipper(UIApplication *application) {
  FlipperClient *client = [FlipperClient sharedClient];
  SKDescriptorMapper *layoutDescriptorMapper = [[SKDescriptorMapper alloc] initWithDefaults];
  [client addPlugin:[[FlipperKitLayoutPlugin alloc] initWithRootNode:application withDescriptorMapper:layoutDescriptorMapper]];
  [client addPlugin:[[FKUserDefaultsPlugin alloc] initWithSuiteName:nil]];
  [client addPlugin:[FlipperKitReactPlugin new]];
  [client addPlugin:[[FlipperKitNetworkPlugin alloc] initWithNetworkAdapter:[SKIOSNetworkAdapter new]]];
  [client start];
}
#endif

@implementation AppDelegate

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

- (NSURL *)sourceURLForBridge:(RCTBridge *)bridge
{
#if DEBUG
  return [[RCTBundleURLProvider sharedSettings] jsBundleURLForBundleRoot:@"index" fallbackResource:nil];
#else
  return [[NSBundle mainBundle] URLForResource:@"main" withExtension:@"jsbundle"];
#endif
}

@end
