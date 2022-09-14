//
//  HideGroupAnimation.m
//  splashmoduleios
//
//  Created by Smith Charles on 22/09/2020.
//

#import "HideGroupAnimation.h"
#import "HideAnimationsList.h"
#import "Splash.h"

@implementation HideGroupAnimation

-(instancetype)init:(int)priority{
    _priority = priority;
  return self;
}

-(void)addAnimation:(ObjectAnimation*)object{
    [object setHidePriority:_priority];
    [HideAnimationsList appendInAnimationList:object];
}

@end
