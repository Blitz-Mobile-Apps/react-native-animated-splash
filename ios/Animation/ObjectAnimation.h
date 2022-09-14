//
//  ObjectAnimation.h
//  Pods
//
//  Created by Ethan Gray on 8/24/22.
//

#ifndef ObjectAnimation_h
#define ObjectAnimation_h


#endif /* ObjectAnimation_h */

#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import "AnimatedObject.h"
#import "Splash.h"
@class Splash;
@class AnimatedObject;
NS_ASSUME_NONNULL_BEGIN

@interface ObjectAnimation : NSObject
@property (nonatomic, strong) Splash *splash;
@property (nonatomic, strong) AnimatedObject *imageview;
@property (nonatomic) CGFloat fromXDelta;
@property (nonatomic) CGFloat fromYDelta;
@property (nonatomic) CGFloat fromValue;
@property (nonatomic) CGFloat toXDelta;
@property (nonatomic) CGFloat toYDelta;
@property (nonatomic) CGFloat toValue;
@property (nonatomic) CGFloat scaleX;
@property (nonatomic) CGFloat scaleY;
@property (nonatomic) int animationType;
@property (nonatomic) bool isLoop;
@property (nonatomic) float animationDuration;
@property (nonatomic) int priority;
@property (nonatomic) NSString *next;
@property (nonatomic) int hidePriority;
@property (nonatomic) NSString *hideNext;
@property (nonatomic) bool executed;
@property (nonatomic) bool hideExecuted;


//Written By Ayesh
-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal;

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY;

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration rotateDegree:(float)rotateDegree;

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY;

// With Loop
-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal loop:(Boolean)loop;

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(Boolean)loop;

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration rotateDegree:(float)rotateDegree loop:(Boolean)loop;

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY loop:(Boolean)loop;

-(void)slideAnimation:(ObjectAnimation *)imageobject;
-(void)fadeAnimation:(ObjectAnimation *)imageobject;
-(void)rotateAnimation:(ObjectAnimation *)imageobject;
-(void)scaleAnimation:(ObjectAnimation *)imageobject;

-(void)slideHideAnimation:(ObjectAnimation *)imageobject;
-(void)fadeHideAnimation:(ObjectAnimation *)imageobject;
-(void)rotateHideAnimation:(ObjectAnimation *)imageobject;
-(void)scaleHideAnimation:(ObjectAnimation *)imageobject;









-(AnimatedObject *)getObject;
-(int)getAnimationtype;
-(int)getPriority;
-(bool)getisLoop;
@end

NS_ASSUME_NONNULL_END

