//
//  AnimateObject.h
//  splashmoduleios
//
//  Created by Smith Charles on 21/09/2020.
//

#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import "AddImageView.h"
#import "Splash.h"
@class Splash;
@class AddImageView;
NS_ASSUME_NONNULL_BEGIN

@interface AnimateObject : NSObject
@property (nonatomic, strong) Splash *splash;
@property (nonatomic, strong) AddImageView *imageview;
@property (nonatomic) CGFloat fromXDelta;
@property (nonatomic) CGFloat fromYDelta;
@property (nonatomic) CGFloat fromValue;
@property (nonatomic) CGFloat toXDelta;
@property (nonatomic) CGFloat toYDelta;
@property (nonatomic) CGFloat toValue;
@property (nonatomic) int animationType;
@property (nonatomic) bool isLoop;
@property (nonatomic) float animationDuration;
@property (nonatomic) int priority;

-(id)initimage:(AddImageView *)image animationType:(int)animationtype duration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY :(int)priority;
-(id)initimage:(AddImageView *)image :(int) animationtype :(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal :(int)priority;
-(id)initimage:(AddImageView *)image :(int) animationtype :(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal loop:(bool)isLoop :(int)priority;
-(id)initimage:(AddImageView *)image animationType:(int)animationtype duration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(bool)isLoop :(int)priority;

-(void)slideAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject;
-(void)scaleAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject;
-(void)rotateAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject;
-(void)fadeAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject;

-(void)slideAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject :(bool)isLoop;
-(void)scaleAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject :(bool)isLoop;
-(void)rotateAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject :(bool)isLoop;
-(void)fadeAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject :(bool)isLoop;
-(AddImageView *)getObject;
-(int)getAnimationtype;
-(int)getPriority;
-(bool)getisLoop;
@end

NS_ASSUME_NONNULL_END
