//
//  GroupAnimation.m
//  splashmoduleios
//
//  Created by Smith Charles on 22/09/2020.
//

#import "GroupAnimation.h"
#import "AnimationsList.h"
#import "Splash.h"

@implementation GroupAnimation

-(instancetype)init:(int)priority{
    _priority = priority;
  return self;
}

-(void)addAnimation:(ObjectAnimation*)object{
    [object setPriority:_priority];
    [AnimationsList appendInAnimationList:object];
}

@end
