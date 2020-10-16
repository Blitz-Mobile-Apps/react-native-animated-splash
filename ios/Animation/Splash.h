//
//  SplashMViewController.h
//  splashmoduleios
//
//  Created by Smith Charles on 02/09/2020.
//

#import <UIKit/UIKit.h>
#import <CoreGraphics/CoreGraphics.h>
#import "AddImageView.h"
@class AddImageView;
NS_ASSUME_NONNULL_BEGIN
//extern UIView *background;
@interface Splash : UIViewController
{

//  AppDelegate *app;
}
@property (nonatomic) int priority;
@property (nonatomic) int hidePriority;
+(void)addImagetoView:(AddImageView *)object;
//-(void)addImageView:(NSString *)name :(CGFloat)positionX :(CGFloat)positionY :(CGFloat)width :(CGFloat)height;

-(void)createSplashView:UIViewController;
-(void)setBackgroundColor:NSString;
-(void)setBackgroundImage:NSString;
-(void)setSplashHideAnimation:(int)splashHideAnimation;
-(void)setHideDelay:(int)delay;
-(void)hideSplashDialog;
-(void)splashShow;

-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY;
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue;
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(bool)isLoop;
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue loop:(bool)isLoop;
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY loop:(bool)isLoop;
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY;
//-(void)animateGroupObject:(AddImageView *)object :(int)typeOfAnimation :(int)duration :(CGFloat)toX :(CGFloat)toY :(int)groupCount;
//-(void)animateGroupObject:(AddImageView *)object :(int)typeOfAnimation :(int)duration :(CGFloat)toValue :(int)groupCount;

-(void)animateGroupObject:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY :(int)groupCount loop:(bool)isLoop;
-(void)animateGroupObject:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue :(int)groupCount loop:(bool)isLoop;
-(void)animateGroupObject:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY :(int)groupCount;
-(void)animateGroupObject:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue :(int)groupCount;

-(void)performHideSingleAnimation:(AddImageView *)object :(int)typeOfAnimation :(int)duration :(CGFloat)toX :(CGFloat)toY;
-(void)performHideSingleAnimation:(AddImageView *)object :(int)typeOfAnimation :(int)duration :(CGFloat)toValue;

-(void)performGroupAnimationOnHide:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY :(int)groupCount;
-(void)performGroupAnimationOnHide:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue :(int)groupCount;


-(void)hide;
-(void)runAnimation;
+(void)setInstance:(Splash*)splashinstance;
-(void)dismissSplashDialog;
extern Splash *splashClassInstance;

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
extern int const SLIDE;
extern int const ROTATE;
extern int const SCALE;
extern int const FADE;
extern int const FIT_XY;
extern int const FIT_CENTER;
extern int const FIT_END;
extern int const FIT_START;
extern int const SPLASHFADE;
extern int const SPLASHSLIDEDOWN;
extern int const SPLASHSLIDELEFT;
extern int const SPLASHSLIDERIGHT;
extern int splashHideAnimationType;

-(CGFloat)getCenterX:(CGFloat)width;
-(CGFloat)getCenterY:(CGFloat)height;
@end

NS_ASSUME_NONNULL_END
