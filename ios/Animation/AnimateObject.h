//
//  AnimateObject.h
//  splashmoduleios
//
//  Created by Smith Charles on 21/09/2020.
//

#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import "AnimatedObject.h"
#import "Splash.h"
@class Splash;
@class AnimatedObject;
NS_ASSUME_NONNULL_BEGIN

@interface AnimateObject : NSObject
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


-(id)initimage:(AnimatedObject *)image animationType:(int)animationtype duration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY :(int)priority;
-(id)initimage:(AnimatedObject *)image :(int) animationtype :(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal :(int)priority;
-(id)initimage:(AnimatedObject *)image :(int) animationtype :(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal loop:(bool)isLoop :(int)priority;
-(id)initimage:(AnimatedObject *)image :(int) animationtype :(float)animationDuration scaleX:(CGFloat)fromVal scaleY:(CGFloat)toVal :(int)priority;
-(id)initimage:(AnimatedObject *)image :(int) animationtype :(float)animationDuration scaleX:(CGFloat)fromVal scaleY:(CGFloat)toVal loop:(bool)isLoop :(int)priority;
-(id)initimage:(AnimatedObject *)image animationType:(int)animationtype duration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(bool)isLoop :(int)priority;

//Animations
-(void)slideAnimation:(AnimatedObject *)imageobject :(AnimatedObject *)nextObject;
-(void)scaleAnimation:(AnimatedObject *)imageobject :(AnimatedObject *)nextObject;
-(void)rotateAnimation:(AnimatedObject *)imageobject :(AnimatedObject *)nextObject;
-(void)fadeAnimation:(AnimatedObject *)imageobject :(AnimatedObject *)nextObject;

//Animations With Loop
-(void)slideAnimation:(AnimatedObject *)imageobject :(AnimatedObject *)nextObject :(bool)isLoop;
-(void)scaleAnimation:(AnimatedObject *)imageobject :(AnimatedObject *)nextObject :(bool)isLoop;
-(void)rotateAnimation:(AnimatedObject *)imageobject :(AnimatedObject *)nextObject :(bool)isLoop;
-(void)fadeAnimation:(AnimatedObject *)imageobject :(AnimatedObject *)nextObject :(bool)isLoop;

//Adding Hiding Animations

-(AnimatedObject *)getObject;
-(int)getAnimationtype;
-(int)getPriority;
-(bool)getisLoop;
@end

NS_ASSUME_NONNULL_END
