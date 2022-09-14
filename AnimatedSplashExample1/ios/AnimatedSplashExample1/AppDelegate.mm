#import "AppDelegate.h"

#import <React/RCTBridge.h>
#import <React/RCTBundleURLProvider.h>
#import <React/RCTRootView.h>
#import <React/RCTAppSetupUtils.h>

#if RCT_NEW_ARCH_ENABLED
#import <React/CoreModulesPlugins.h>
#import <React/RCTCxxBridgeDelegate.h>
#import <React/RCTFabricSurfaceHostingProxyRootView.h>
#import <React/RCTSurfacePresenter.h>
#import <React/RCTSurfacePresenterBridgeAdapter.h>
#import <ReactCommon/RCTTurboModuleManager.h>

#import <react/config/ReactNativeConfig.h>

static NSString *const kRNConcurrentRoot = @"concurrentRoot";


@interface AppDelegate () <RCTCxxBridgeDelegate, RCTTurboModuleManagerDelegate> {
  RCTTurboModuleManager *_turboModuleManager;
  RCTSurfacePresenterBridgeAdapter *_bridgeAdapter;
  std::shared_ptr<const facebook::react::ReactNativeConfig> _reactNativeConfig;
  facebook::react::ContextContainer::Shared _contextContainer;
}
@end
#endif

@implementation AppDelegate

- (BOOL)application:(UIApplication *)application didFinishLaunchingWithOptions:(NSDictionary *)launchOptions
{
  RCTAppSetupPrepareApp(application);
  
  RCTBridge *bridge = [[RCTBridge alloc] initWithDelegate:self launchOptions:launchOptions];
  
#if RCT_NEW_ARCH_ENABLED
  _contextContainer = std::make_shared<facebook::react::ContextContainer const>();
  _reactNativeConfig = std::make_shared<facebook::react::EmptyReactNativeConfig const>();
  _contextContainer->insert("ReactNativeConfig", _reactNativeConfig);
  _bridgeAdapter = [[RCTSurfacePresenterBridgeAdapter alloc] initWithBridge:bridge contextContainer:_contextContainer];
  bridge.surfacePresenter = _bridgeAdapter.surfacePresenter;
#endif
  
  NSDictionary *initProps = [self prepareInitialProps];
  UIView *rootView = RCTAppSetupDefaultRootView(bridge, @"AnimatedSplashExample1", initProps);
  
  if (@available(iOS 13.0, *)) {
    rootView.backgroundColor = [UIColor systemBackgroundColor];
  } else {
    rootView.backgroundColor = [UIColor whiteColor];
  }
  
  self.window = [[UIWindow alloc] initWithFrame:[UIScreen mainScreen].bounds];
  UIViewController *rootViewController = [UIViewController new];
  rootViewController.view = rootView;
  self.window.rootViewController = rootViewController;
  [self.window makeKeyAndVisible];
  
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
  
  return YES;
}

/// This method controls whether the `concurrentRoot`feature of React18 is turned on or off.
///
/// @see: https://reactjs.org/blog/2022/03/29/react-v18.html
/// @note: This requires to be rendering on Fabric (i.e. on the New Architecture).
/// @return: `true` if the `concurrentRoot` feture is enabled. Otherwise, it returns `false`.
- (BOOL)concurrentRootEnabled
{
  // Switch this bool to turn on and off the concurrent root
  return true;
}

- (NSDictionary *)prepareInitialProps
{
  NSMutableDictionary *initProps = [NSMutableDictionary new];
  
#ifdef RCT_NEW_ARCH_ENABLED
  initProps[kRNConcurrentRoot] = @([self concurrentRootEnabled]);
#endif
  
  return initProps;
}

- (NSURL *)sourceURLForBridge:(RCTBridge *)bridge
{
#if DEBUG
  return [[RCTBundleURLProvider sharedSettings] jsBundleURLForBundleRoot:@"index"];
#else
  return [[NSBundle mainBundle] URLForResource:@"main" withExtension:@"jsbundle"];
#endif
}

#if RCT_NEW_ARCH_ENABLED

#pragma mark - RCTCxxBridgeDelegate

- (std::unique_ptr<facebook::react::JSExecutorFactory>)jsExecutorFactoryForBridge:(RCTBridge *)bridge
{
  _turboModuleManager = [[RCTTurboModuleManager alloc] initWithBridge:bridge
                                                             delegate:self
                                                            jsInvoker:bridge.jsCallInvoker];
  return RCTAppSetupDefaultJsExecutorFactory(bridge, _turboModuleManager);
}

#pragma mark RCTTurboModuleManagerDelegate

- (Class)getModuleClassFromName:(const char *)name
{
  return RCTCoreModulesClassProvider(name);
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const std::string &)name
jsInvoker:(std::shared_ptr<facebook::react::CallInvoker>)jsInvoker
{
  return nullptr;
}

- (std::shared_ptr<facebook::react::TurboModule>)getTurboModule:(const std::string &)name
initParams:
(const facebook::react::ObjCTurboModule::InitParams &)params
{
  return nullptr;
}

- (id<RCTTurboModule>)getModuleInstanceFromClass:(Class)moduleClass
{
  return RCTAppSetupDefaultModuleFromClass(moduleClass);
}

#endif

@end
