//
//  SingleAnimation.m
//  RNAnimatedSplash
//
//  Created by Ethan Gray on 8/23/22.
//

#import <Foundation/Foundation.h>
#import "SingleAnimation.h"
#import "AnimateObject.h"
#import "AnimationsList.h"


@implementation SingleAnimation

-(instancetype)init:(ObjectAnimation *)object  priority:(int)priority{
    [object setPriority:priority];
    [AnimationsList appendInAnimationList:object];
    return self;
}


@end
