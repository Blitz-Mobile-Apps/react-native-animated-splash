#import <React/RCTBridgeDelegate.h>
#import <UIKit/UIKit.h>
#import <RNAnimatedSplash/Splash.h>
@class Splash;
#import <RNAnimatedSplash/GroupAnimation.h>
@class GroupAnimation;
#import <RNAnimatedSplash/HideGroupAnimation.h>
@class HideGroupAnimation;
@interface AppDelegate : UIResponder <UIApplicationDelegate, RCTBridgeDelegate>

@property (nonatomic, strong) UIWindow *window;

@end
