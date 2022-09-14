//
//  SplashMViewController.m
//  splashmoduleios
//
//  Created by Smith Charles on 02/09/2020.
//

#import "Splash.h"
#import "AnimateObject.h"
#import "GroupAnimation.h"
#import "HideGroupAnimation.h"
#import "AnimatedObject.h"
#import "AnimationsList.h"
#import "HideAnimationsList.h"
#import <UIKit/UIKit.h>
#import "ObjectAnimation.h"
#import <CoreGraphics/CoreGraphics.h>
@class AnimateObject;
@class AnimatedObject;
@class AnimationList;
@class HideAnimationsList;
@interface Splash ()

@end

@implementation Splash
CGSize screenSize;
UIView *background;
UIImageView *bgimage;
NSMutableArray *animatedObjectList;
NSMutableArray *hideanimatedObjectList;

bool hidingfinal = false;
int const SLIDE = 1;
int const ROTATE = 2;
int const SCALE = 3;
int const FADE = 4;

int const FIT_CENTER = 1;
int const FIT_XY = 2;
int const FIT_START = 3;
int const FIT_END = 4;

int const SPLASH_FADE = 1;
int const SPLASH_SLIDE_DOWN = 2;
int const SPLASH_SLIDE_LEFT = 3;
int const SPLASH_SLIDE_RIGHT = 4;
float screenWidth = 0;
float screenHeight = 0;
int counter = 0;
int hidecounter = 0;
Splash *splashClassInstance = nil;
int splashHideAnimationType;
int priority=0;
int hidePriority = 0;
bool jsCalled = false;
bool shouldHide = false;
bool allExecuted = false;
int animatedObjectLength =0;
int hideanimatedObjectLength;
-(id)init {
    if(self = [super init]){
        splashClassInstance = self;
        _splashHideDelay =1;
        _isHideOnDialogAnimation = false;
        [AnimationsList initializeDictionary];
        [HideAnimationsList initializeDictionary];
        
    }
    
    return self;
}
- (void)viewWillAppear:(BOOL)animated {
    
}
- (void)viewDidLoad {
    [super viewDidLoad];
    
    animatedObjectList = [NSMutableArray new];
    hideanimatedObjectList = [NSMutableArray new];
    screenSize = [UIScreen mainScreen].bounds.size;
    screenWidth = screenSize.width;
    screenHeight = screenSize.height;
    background = [[UIView alloc] initWithFrame:CGRectMake(0, 0, screenSize.width, screenSize.height)];
    background.backgroundColor=UIColor.whiteColor;
    [self.view addSubview:background];
    
}

-(void)addAnimation:(AnimatedObject *)object priority:(int)priority{
    [AnimationsList appendInAnimationList:object];
}

+(void)setInstance:(Splash*)splashinstance{
    splashClassInstance = splashinstance;
}
- (void) createSplashView:(UIWindow *)window {
    self.modalPresentationStyle = UIModalPresentationOverFullScreen;
    [window.rootViewController presentViewController:self animated:NO completion:nil];
}
-(void) setBackgroundColor:(NSString *)color{
    
    UIColor *uicolorcode = [Splash colorWithHexString:color];
    background.backgroundColor = uicolorcode;
    
}
-(void) setBackgroundImage:(NSString *)bgimg{
    bgimage = [[UIImageView alloc] initWithFrame:CGRectMake(0, 0, screenSize.width, screenSize.height)];
    
    bgimage.image = [UIImage imageNamed:bgimg];
    [background addSubview:bgimage];
    
}

-(void)setHideDelay:(int)delay{
    _splashHideDelay = delay;
}

-(void)setSplashHideAnimation:(int)splashHideAnimation{
    splashHideAnimationType = splashHideAnimation;
    
}
-(void)splashShow{
    
    [self runAnimation];
}

+(void) addImagetoView:(AnimatedObject *)object {
    //  UIView *view =  ;
    NSLog(@"in view color");
    [background addSubview: [object initializeObject]];
}

-(void)runAnimation{
    if([AnimationsList getLength]>0){
        ObjectAnimation *obj = [AnimationsList getItem:[AnimationsList getHead]];
        [self runSpecificAnimation:obj];
    }else{
        shouldHide = true;
        return;
    }
    
    
}

-(void)runSpecificAnimation:(AnimatedObject*)imageobject :(int)animationType :(AnimateObject*)animation :(AnimatedObject*)nextObject :(bool)isLoop{
    switch (animationType) {
        case 1:
            [animation slideAnimation:imageobject :nextObject :isLoop];
            break;
        case 2:
            [animation rotateAnimation:imageobject :nextObject :isLoop];
            break;
        case 3:
            [animation scaleAnimation:imageobject :nextObject :isLoop];
            break;
        case 4:
            [animation fadeAnimation:imageobject :nextObject :isLoop];
            break;
        default:
            break;
    }
}

-(void)runSpecificAnimation:(ObjectAnimation*)object{
    
    switch (object.animationType) {
        case 1:
            [object slideAnimation:object];
            break;
        case 2:
            [object rotateAnimation:object];
            break;
        case 3:
            [object scaleAnimation:object];
            break;
        case 4:
            [object fadeAnimation:object];
            break;
        default:
            break;
    }
}

-(void)runSpecificHideAnimation:(ObjectAnimation*)object{
    switch (object.animationType) {
        case 1:
            [object slideHideAnimation:object];
            break;
        case 2:
            [object rotateHideAnimation:object];
            break;
        case 3:
            [object scaleHideAnimation:object];
            break;
        case 4:
            [object fadeHideAnimation:object];
            break;
        default:
            break;
    }
}
-(void)hide{
    jsCalled = true;
    NSLog(@"in splash hide");
    if(shouldHide == true){
        if(splashClassInstance){
            [self dismissSplashDialog];
        }
        
    }
    
}

-(void)dismissSplashDialog{
    if(hidingfinal == false){
        
        [UIView animateWithDuration:1.1 delay:_splashHideDelay/1000 options:nil animations:^{
            if(splashHideAnimationType == 1){
                self.view.alpha = 0;
            }
            else if(splashHideAnimationType == 2){
                self.view.transform = CGAffineTransformTranslate(self.view.transform,0, screenSize.height);
            }
            else if(splashHideAnimationType == 3){
                self.view.transform = CGAffineTransformTranslate(self.view.transform,-screenSize.width, 0);
            }
            else if(splashHideAnimationType == 4){
                self.view.transform = CGAffineTransformTranslate(self.view.transform,screenSize.width, 0);
            }
            else {
                self.view.alpha = 0;
            }
        } completion:^(BOOL finished){
            
            [self dismissViewControllerAnimated:NO completion:nil];
        }];
        
    }else{
        hidingfinal = true;
    }
}

+(UIColor*)colorWithHexString:(NSString*)hex
{
    NSString *cString = [[hex stringByTrimmingCharactersInSet:[NSCharacterSet whitespaceAndNewlineCharacterSet]] uppercaseString];
    
    // String should be 6 or 8 characters
    if ([cString length] < 6) return [UIColor grayColor];
    
    // strip 0X if it appears
    if ([cString hasPrefix:@"0X"]) cString = [cString substringFromIndex:2];
    
    if ([cString length] != 6) return  [UIColor grayColor];
    
    // Separate into r, g, b substrings
    NSRange range;
    range.location = 0;
    range.length = 2;
    NSString *rString = [cString substringWithRange:range];
    
    range.location = 2;
    NSString *gString = [cString substringWithRange:range];
    
    range.location = 4;
    NSString *bString = [cString substringWithRange:range];
    
    // Scan values
    unsigned int r, g, b;
    [[NSScanner scannerWithString:rString] scanHexInt:&r];
    [[NSScanner scannerWithString:gString] scanHexInt:&g];
    [[NSScanner scannerWithString:bString] scanHexInt:&b];
    
    return [UIColor colorWithRed:((float) r / 255.0f)
                           green:((float) g / 255.0f)
                            blue:((float) b / 255.0f)
                           alpha:1.0f];
}

@end

