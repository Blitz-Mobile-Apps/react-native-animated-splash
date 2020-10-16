#import "AppDelegate.h"

#import <React/RCTBridge.h>
#import <React/RCTBundleURLProvider.h>
#import <React/RCTRootView.h>

#ifdef FB_SONARKIT_ENABLED
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
     
    [splash performSingleAnimation:logoImage typeofanimation:SCALE duration:500 scaleX:5.5 scaleY:4];
     
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
