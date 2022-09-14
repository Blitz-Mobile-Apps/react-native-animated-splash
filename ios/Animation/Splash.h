//
//  SplashMViewController.h
//  splashmoduleios
//
//  Created by Smith Charles on 02/09/2020.
//

#import <UIKit/UIKit.h>
#import <CoreGraphics/CoreGraphics.h>
#import "AnimatedObject.h"
@class AnimatedObject;
#import "ObjectAnimation.h"
@class ObjectAnimation;
NS_ASSUME_NONNULL_BEGIN
//extern UIView *background;
@interface Splash : UIViewController
{

//  AppDelegate *app;
}
@property (nonatomic) int priority;
@property (nonatomic) int hidePriority;
+(void)addImagetoView:(AnimatedObject *)object;
//-(void)addImageView:(NSString *)name :(CGFloat)positionX :(CGFloat)positionY :(CGFloat)width :(CGFloat)height;

-(void)createSplashView:UIViewController;
-(void)setBackgroundColor:NSString;
-(void)setBackgroundImage:NSString;
-(void)setSplashHideAnimation:(int)splashHideAnimation;
-(void)setHideDelay:(int)delay;
-(void)hideSplashDialog;
-(void)splashShow;

-(void)addAnimation:(AnimatedObject *)object priority:(int)priority;

-(void)hide;
-(void)runAnimation;
+(void)setInstance:(Splash*)splashinstance;
-(void)dismissSplashDialog;
-(void)addImageToView:(AnimatedObject*)object;
extern Splash *splashClassInstance;

-(void)runSpecificAnimation:(ObjectAnimation*)object;
-(void)runSpecificHideAnimation:(ObjectAnimation*)object;

@property (nonatomic, strong) UIWindow *window;
@property (nonatomic) int splashHideDelay;
@property (nonatomic) bool isHideOnDialogAnimation;
extern int counter;
extern float screenWidth;
extern float screenHeight;
extern int hidecounter;
extern bool hidingfinal;
extern int animatedObjectLength;
extern int hideanimatedObjectLength;
extern bool jsCalled;
extern bool shouldHide;
extern bool allExecuted;
extern int const SLIDE;
extern int const ROTATE;
extern int const SCALE;
extern int const FADE;
extern int const FIT_XY;
extern int const FIT_CENTER;
extern int const FIT_END;
extern int const FIT_START;
extern int const SPLASH_FADE;
extern int const SPLASH_SLIDE_DOWN;
extern int const SPLASH_SLIDE_LEFT;
extern int const SPLASH_SLIDE_RIGHT;
extern int splashHideAnimationType;

-(CGFloat)getCenterX:(CGFloat)width;
-(CGFloat)getCenterY:(CGFloat)height;
-(void)hide;
@end

NS_ASSUME_NONNULL_END
