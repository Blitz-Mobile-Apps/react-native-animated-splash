//
//  HideGroupAnimation.h
//  splashmoduleios
//
//  Created by Smith Charles on 29/09/2020.
//


#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import "AddImageView.h"
@class AddImageView;
#import <Foundation/Foundation.h>
#import "Splash.h"
@class Splash;
NS_ASSUME_NONNULL_BEGIN

@interface HideGroupAnimation : NSObject

@property (nonatomic, strong) Splash *splash;
@property (nonatomic, strong) AddImageView *imageview;
@property (nonatomic) CGFloat toXDelta;
@property (nonatomic) CGFloat toYDelta;
@property (nonatomic) CGFloat toValue;
@property (nonatomic) int animationType;
@property (nonatomic) int animationDuration;
extern int hidegroupCount;

-(instancetype) init;
-(void)performHideGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY;
-(void)performHideGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue;
-(void)performHideGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY;
@end

NS_ASSUME_NONNULL_END

