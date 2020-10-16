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
#import "AddImageView.h"
#import <UIKit/UIKit.h>
#import <CoreGraphics/CoreGraphics.h>
@class AnimateObject;
@class AddImageView;
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

int const SPLASHFADE = 1;
int const SPLASHSLIDEDOWN = 2;
int const SPLASHSLIDELEFT = 3;
int const SPLASHSLIDERIGHT = 4;
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
int animatedObjectLength =0;
int hideanimatedObjectLength;
-(id)init {
  if(self = [super init]){
    splashClassInstance = self;
    _splashHideDelay =1;
    _isHideOnDialogAnimation = false;
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

+(void) addImagetoView:(AddImageView *)object {
//  UIView *view =  ;
//  NSLog(@"in view color");
  [background addSubview: [object initializeObject]];
}
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY{
//  NSLog(@"in perform anim %@",object);
//  NSLog(@"Groupo count splash %d",groupcount);
  priority++;
  groupcount = priority;
//  [animatedObjectList addObject:[[AnimateObject alloc] initWithImage:object :typeOfAnimation :duration :toX :toY loop:false :priority]];
  [animatedObjectList addObject:[[AnimateObject alloc] initimage:object animationType:typeOfAnimation duration:duration fromX:fromX toX:toX fromY:fromY toY:toY loop:false :priority]];
}
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue{
//  NSLog(@"in perform anim %@",object);
//  NSLog(@"Groupo count splash %d",groupcount);
  priority++;
  groupcount = priority;
//  [animatedObjectList addObject:[[AnimateObject alloc] initWithImage:object :typeOfAnimation :duration :toValue loop:false :priority]];
  [animatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration fromVal:fromValue toVal:toValue loop:false :priority]];
}
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(bool)isLoop{
//  NSLog(@"in perform anim %@",object);
//  NSLog(@"Groupo count splash %d",groupcount);
  priority++;
  groupcount = priority;
  [animatedObjectList addObject:[[AnimateObject alloc] initimage:object animationType:typeOfAnimation duration:duration fromX:fromX toX:toX fromY:fromY toY:toY loop:isLoop :priority]];
}
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue loop:(bool)isLoop{
//  NSLog(@"in perform anim %@",object);
//  NSLog(@"Groupo count splash %d",groupcount);
  priority++;
  groupcount = priority;
  [animatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration fromVal:fromValue toVal:toValue loop:isLoop :priority]];
}

-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY{
      priority++;
      groupcount = priority;
    //  [animatedObjectList addObject:[[AnimateObject alloc] initWithImage:object :typeOfAnimation :duration :toValue loop:false :priority]];
      [animatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration scaleX:scaleX scaleY:scaleY loop:false :priority]];
}
-(void)performSingleAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(float)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY loop:(bool)isLoop{
    priority++;
    groupcount = priority;
    [animatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration scaleX:scaleX scaleY:scaleY loop:isLoop :priority]];
}

-(void)animateGroupObject:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY :(int)groupCount loop:(bool)isLoop{
//  NSLog(@"Groupo count splash %d",groupcount);
  // NSLog(@"in perform anim group %@",object);
  priority = groupcount;
  [animatedObjectList addObject:[[AnimateObject alloc] initimage:object animationType:typeOfAnimation duration:duration fromX:fromX toX:toX fromY:fromY toY:toY loop:isLoop :priority]];
}
-(void)animateGroupObject:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue :(int)groupCount loop:(bool)isLoop{

//  NSLog(@"Groupo count splash val %d",groupcount);
  // NSLog(@"in perform anim fade %@",object);
  priority = groupcount;
  [animatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration fromVal:fromValue toVal:toValue loop:isLoop :priority]];
}
-(void)animateGroupObject:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY :(int)groupCount loop:(bool)isLoop{

//  NSLog(@"Groupo count splash val %d",groupcount);
  // NSLog(@"in perform anim fade %@",object);
  priority = groupcount;
  [animatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration scaleX:scaleX scaleY:scaleY loop:isLoop :priority]];
}

-(void)performHideSingleAnimation:(AddImageView *)object animationType:(int)typeOfAnimation duration:(float)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY{
//  NSLog(@"in perform anim %@",object);
//  NSLog(@"Groupo count splash %d",groupcount);
  _isHideOnDialogAnimation = true;
  hidePriority++;
  hidegroupCount = hidePriority;
  [hideanimatedObjectList addObject:[[AnimateObject alloc] initimage:object animationType:typeOfAnimation duration:duration fromX:fromX toX:toX fromY:fromY toY:toY :hidePriority]];
}
-(void)performHideSingleAnimation:(AddImageView *)object animationType:(int)typeOfAnimation duration:(float)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue{
//  NSLog(@"in perform anim %@",object);
//  NSLog(@"Groupo count splash %d",groupcount);
  _isHideOnDialogAnimation = true;
  hidePriority++;
  hidegroupCount = hidePriority;
  [hideanimatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration fromVal:fromValue toVal:toValue :hidePriority]];
}

-(void)performHideSingleAnimation:(AddImageView *)object animationType:(int)typeOfAnimation duration:(float)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY{
//  NSLog(@"in perform anim %@",object);
//  NSLog(@"Groupo count splash %d",groupcount);
  _isHideOnDialogAnimation = true;
  hidePriority++;
  hidegroupCount = hidePriority;
  [hideanimatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration scaleX:scaleX scaleY:scaleY :hidePriority]];
}

-(void)performGroupAnimationOnHide:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY :(int)groupCount{
//  NSLog(@"Groupo count splash %d",groupcount);
//  NSLog(@"in perform anim %@",object);
  _isHideOnDialogAnimation = true;
  hidePriority = groupcount;
//  [hideanimatedObjectList addObject:[[AnimateObject alloc] initWithImage:object :typeOfAnimation :duration :toX :toY :hidePriority]];
  [hideanimatedObjectList addObject:[[AnimateObject alloc] initimage:object animationType:typeOfAnimation duration:duration fromX:fromX toX:toX fromY:fromY toY:toY :hidePriority]];
}
-(void)performGroupAnimationOnHide:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue :(int)groupCount{

//  NSLog(@"Groupo count splash val %d",groupcount);
//  NSLog(@"in perform anim %@",object);
  _isHideOnDialogAnimation = true;
  hidePriority = groupcount;
//  [hideanimatedObjectList addObject:[[AnimateObject alloc] initWithImage:object :typeOfAnimation :duration :toValue :hidePriority]];
  [hideanimatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration fromVal:fromValue toVal:toValue :hidePriority]];
}
-(void)performGroupAnimationOnHide:(AddImageView *)object animationType:(int)typeOfAnimation duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY :(int)groupCount{

//  NSLog(@"Groupo count splash val %d",groupcount);
//  NSLog(@"in perform anim %@",object);
  _isHideOnDialogAnimation = true;
  hidePriority = groupcount;
//  [hideanimatedObjectList addObject:[[AnimateObject alloc] initWithImage:object :typeOfAnimation :duration :toValue :hidePriority]];
  [hideanimatedObjectList addObject:[[AnimateObject alloc] initimage:object :typeOfAnimation :duration scaleX:scaleX scaleY:scaleY :hidePriority]];
}

-(void)runAnimation{
  animatedObjectLength = [animatedObjectList count];
  int listlength = [animatedObjectList count];
 
  for (int i=counter; i<listlength; i++) {
//  NSLog(@"if1");
    if(i < animatedObjectLength -1 && [[animatedObjectList objectAtIndex:counter]getPriority] == [[animatedObjectList objectAtIndex:counter+1]getPriority]){
        // NSLog(@"if11");
      [self runSpecificAnimation:[[animatedObjectList objectAtIndex:i]getObject] :[[animatedObjectList objectAtIndex:i]getAnimationtype] :[animatedObjectList objectAtIndex:i] :nil :[[animatedObjectList objectAtIndex:i]getisLoop]];
      counter++;
    }
    else if(i < animatedObjectLength -1){
      [self runSpecificAnimation:[[animatedObjectList objectAtIndex:i]getObject] :[[animatedObjectList objectAtIndex:i]getAnimationtype] :[animatedObjectList objectAtIndex:i] :[[animatedObjectList objectAtIndex:i+1]getObject] :[[animatedObjectList objectAtIndex:i]getisLoop]];
      counter++;
      break;
    }
    else {
      [self runSpecificAnimation:[[animatedObjectList objectAtIndex:i]getObject] :[[animatedObjectList objectAtIndex:i]getAnimationtype] :[animatedObjectList objectAtIndex:i] :[[animatedObjectList objectAtIndex:i]getObject] :[[animatedObjectList objectAtIndex:i]getisLoop]];
      counter++;
    }
 
  }
 
  
}

-(void)runSpecificAnimation:(AddImageView*)imageobject :(int)animationType :(AnimateObject*)animation :(AddImageView*)nextObject :(bool)isLoop{
  NSLog(@"ifspecific1");
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
            // NSLog(@"ifspecific4");
      [animation fadeAnimation:imageobject :nextObject :isLoop];
      break;
    default:
      break;
  }
}
-(void)runSpecificHideAnimation:(AddImageView*)imageobject :(int)animationType :(AnimateObject*)animation :(AddImageView*)nextObject{
  switch (animationType) {
    case 1:
      [animation slideAnimation:imageobject :nextObject];
      break;
      case 2:
      [animation rotateAnimation:imageobject :nextObject];
      break;
      case 3:
      [animation scaleAnimation:imageobject :nextObject];
      break;
      case 4:
      [animation fadeAnimation:imageobject :nextObject];
      break;
    default:
      break;
  }
}
-(void)hide{
  jsCalled = true;
  NSLog(@"in splash hide");
  if(shouldHide == true){
    dispatch_after(dispatch_time(DISPATCH_TIME_NOW, _splashHideDelay * NSEC_PER_MSEC), dispatch_get_main_queue(), ^{
    [self hideSplashDialog];
    });
  }

}
-(void) hideSplashDialog {
  if(shouldHide == true && jsCalled == true){
    if(_isHideOnDialogAnimation == true){
      hideanimatedObjectLength = [hideanimatedObjectList count];
     
      for (int i=hidecounter; i<hideanimatedObjectLength; i++) {
        
        if(i < hideanimatedObjectLength -1 && [[hideanimatedObjectList objectAtIndex:hidecounter]getPriority] == [[hideanimatedObjectList objectAtIndex:hidecounter+1]getPriority]){
       
          [self runSpecificHideAnimation:[[hideanimatedObjectList objectAtIndex:i]getObject] :[[hideanimatedObjectList objectAtIndex:i]getAnimationtype] :[hideanimatedObjectList objectAtIndex:i] :nil];
          hidecounter++;
        }
        else if(i < hideanimatedObjectLength -1){
          [self runSpecificHideAnimation:[[hideanimatedObjectList objectAtIndex:i]getObject] :[[hideanimatedObjectList objectAtIndex:i]getAnimationtype] :[hideanimatedObjectList objectAtIndex:i] :[[hideanimatedObjectList objectAtIndex:i+1]getObject]];
          hidecounter++;
          break;
        }
        else {
          [self runSpecificHideAnimation:[[hideanimatedObjectList objectAtIndex:i]getObject] :[[hideanimatedObjectList objectAtIndex:i]getAnimationtype] :[hideanimatedObjectList objectAtIndex:i] :[[hideanimatedObjectList objectAtIndex:i]getObject]];
          hidecounter++;
        }
     
      }
    }
    else {
      [self dismissSplashDialog];
    }
  }
}
-(void)dismissSplashDialog{
  hidingfinal = true;
    [UIView animateWithDuration:1.1 delay:0 options:nil animations:^{
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

  dispatch_after(dispatch_time(DISPATCH_TIME_NOW, 1.2 * NSEC_PER_SEC), dispatch_get_main_queue(), ^{
//    NSLog(@"in splash hide5");
    [self dismissViewControllerAnimated:NO completion:nil];
  });
}
   ];
  
}
-(CGFloat)getCenterX:(CGFloat)width{
  CGFloat position = (screenWidth- width)/2;
  return position;
}
-(CGFloat)getCenterY:(CGFloat)height{
  CGFloat position = (screenHeight- height)/2;
  return position;
}
- (void)addView{
    NSLog(@"in add view");

  
//  CGAffineTransform scale =
//  logo.alpha=0.3;
  // alpha animation
//  [UIView animateWithDuration:1.3 animations:^{
//    logo.alpha = 1;
//  }];
//     dispatch_async(dispatch_get_main_queue(), ^{
//  logo.transform = CGAffineTransformRotate(logo.transform, 60);
//  [UIView animateWithDuration:1.3 animations:^{
//     logo.transform = CGAffineTransformRotate(logo.transform,180);
//  }];
//     });
//  [UIView animateWithDuration:1.3 animations:^{
//    logo.transform = CGAffineTransformScale(logo.transform,0.2, 0.2);
//  } completion:^(BOOL finished){
//    [UIView animateWithDuration:1.3 animations:^{
//      logo.transform = CGAffineTransformTranslate(logo.transform,100, 100);
//    }];
//
//  }
//  ];
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

