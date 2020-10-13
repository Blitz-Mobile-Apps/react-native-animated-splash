//
//  GroupAnimation.h
//  splashmoduleios
//
//  Created by Smith Charles on 22/09/2020.
//
#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import "AddImageView.h"
@class AddImageView;
#import <Foundation/Foundation.h>
#import "Splash.h"
@class Splash;
NS_ASSUME_NONNULL_BEGIN

@interface GroupAnimation : NSObject

@property (nonatomic, strong) Splash *splash;
@property (nonatomic, strong) AddImageView *imageview;
@property (nonatomic) CGFloat toXDelta;
@property (nonatomic) CGFloat toYDelta;
@property (nonatomic) CGFloat toValue;
@property (nonatomic) int animationType;
@property (nonatomic) int animationDuration;
extern int groupcount;

-(instancetype) init;
-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY;
-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue;
-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(bool)isLoop;

-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue loop:(bool)isLoop;
@end

NS_ASSUME_NONNULL_END
