
#import "RNAnimatedSplash.h"
#import "Animation/Splash.h"
@implementation RNAnimatedSplash

- (dispatch_queue_t)methodQueue
{
    return dispatch_get_main_queue();
}
RCT_EXPORT_MODULE();
RCT_EXPORT_METHOD(hide){

  NSLog(@"in hide splash react");
    [splashClassInstance hide];

}
@end
  
