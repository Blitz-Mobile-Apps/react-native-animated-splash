//
//  HideAnimationsList.h
//  Pods
//
//  Created by Ethan Gray on 8/23/22.
//

#import "AnimationsList.h"
#import <Foundation/Foundation.h>
#import "ObjectAnimation.h"
NS_ASSUME_NONNULL_BEGIN

@interface HideAnimationsList : NSObject

+(void)  appendInAnimationList:(ObjectAnimation*) object;
+(ObjectAnimation *)  getItem:(NSString*) key;
+(NSString*) getHead;
+(void)  initializeDictionary;
+(int) getLength;

@end

NS_ASSUME_NONNULL_END

