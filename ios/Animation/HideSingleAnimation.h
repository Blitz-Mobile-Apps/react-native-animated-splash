//
//  HideSingleAnimation.h
//  Pods
//
//  Created by Ethan Gray on 8/23/22.
//

#import "AnimatedObject.h"

NS_ASSUME_NONNULL_BEGIN

@interface HideSingleAnimation : NSObject

-(instancetype)init:(ObjectAnimation *)object priority:(int)priority;

@end
NS_ASSUME_NONNULL_END
