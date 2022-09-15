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
  UIView *rootView = RCTAppSetupDefaultRootView(bridge, @"AnimatedSplashExample2", initProps);

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
