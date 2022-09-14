//
//  HideSingleAnimation.m
//  RNAnimatedSplash
//
//  Created by Ethan Gray on 8/23/22.
//

#import <Foundation/Foundation.h>
#import "HideSingleAnimation.h"
#import "AnimateObject.h"
#import "HideAnimationsList.h"


@implementation HideSingleAnimation

-(instancetype)init:(ObjectAnimation *)object priority:(int)priority{
    [object setHidePriority:priority];
    [HideAnimationsList appendInAnimationList:object];
    return self;
}


@end
