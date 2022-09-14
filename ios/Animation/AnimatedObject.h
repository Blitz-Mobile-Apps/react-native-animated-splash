//
//  AnimatedObject.h
//  Pods
//
//  Created by Ethan Gray on 8/19/22.
//


#import "AnimatedObject.h"
#import "Splash.h"
#import <Foundation/Foundation.h>
#import <UIKit/UIKit.h>
@class Splash;
#import <CoreGraphics/CoreGraphics.h>
@class ObjectAnimation;

NS_ASSUME_NONNULL_BEGIN

@interface AnimatedObject : NSObject


@property (nonatomic, strong) NSString *imagename;
@property (nonatomic) int height;
@property (nonatomic) int width;
@property (nonatomic) float positionX;
@property (nonatomic) float positionY;
@property (nonatomic) bool visibility;
@property (nonatomic) int scaleType;
@property (nonatomic) float rotateDegree;
@property (nonatomic) float opacity;
@property (nonatomic, strong) UIImageView *imageobject;
@property (nonatomic, strong) ObjectAnimation *animation;
@property (nonatomic, strong) ObjectAnimation *hideAnimation;




-(instancetype) init;

//Written By Ayesh
-(instancetype) initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height;
-(instancetype) initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY;

-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility;
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType;
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType opacity:(float)opacity;
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType opacity:(float)opacity rotateDegree:(float)rotateDegree;

//Written By Ayesh

//Adding Animations
-(void) addAnimationWithAnimationtType:(AnimatedObject *)object animationType:(int)animationType duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue;

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY;

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration rotateDegree:(float)rotateDegree;

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY;

// Adding Animations With Loop

-(void) addAnimationWithAnimationtType:(AnimatedObject *)object animationType:(int)animationType duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue loop:(BOOL)loop;

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY  loop:(BOOL)loop;

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration rotateDegree:(float)rotateDegree  loop:(BOOL)loop;

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY  loop:(BOOL)loop;

//Adding Hiding Animations
-(void) addHideAnimationWithAnimationtType:(AnimatedObject *)object animationType:(int)animationType duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue;

-(void) addHideAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY;

-(void) addHideAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration rotateDegree:(float)rotateDegree;

-(void) addHideAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY;

-(void) addToSplash;

-(CGFloat)getCenterX;
-(CGFloat)getCenterY;

-(UIImageView *) initializeObject;

-(UIImageView *)getImageView;
@end

NS_ASSUME_NONNULL_END

