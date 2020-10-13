
#if __has_include("RCTBridgeModule.h")
#import "RCTBridgeModule.h"
#else
#import <React/RCTBridgeModule.h>
#endif
#import "Animation/Splash.h"
@interface RNAnimatedSplash : NSObject <RCTBridgeModule>
@property (nonatomic, strong) UIWindow *window;

@end
  
