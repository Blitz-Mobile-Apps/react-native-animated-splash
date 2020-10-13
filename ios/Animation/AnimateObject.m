//
//  AnimateObject.m
//  splashmoduleios
//
//  Created by Smith Charles on 21/09/2020.
//

#import "AnimateObject.h"
#import "AddImageView.h"
#import <UIKit/UIKit.h>
#import <CoreGraphics/CoreGraphics.h>
#import "Splash.h"
@class Splash;
@class AddImageView;
@implementation AnimateObject




-(id)initimage:(AddImageView *)image animationType:(int)animationtype duration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY :(int)priority{
 
    _imageview = image;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _toXDelta = toX;
    _toYDelta = toY;
    _priority = priority;
  
  return self;
}
-(id)initimage:(AddImageView *)image :(int) animationtype :(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal :(int)priority{

    _imageview = image;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _toValue = toVal;
    _fromValue = fromVal;
    _priority = priority;
  
  return self;
}
-(id)initimage:(AddImageView *)image animationType:(int)animationtype duration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(bool)isLoop :(int)priority{

    _imageview = image;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _toXDelta = toX;
    _toYDelta = toY;
    _priority = priority;
    _isLoop = isLoop;
  
  return self;
}
-(id)initimage:(AddImageView *)image :(int) animationtype :(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal loop:(bool)isLoop :(int)priority{
 
    _imageview = image;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _fromValue = fromVal;
    _toValue = toVal;
    _priority = priority;
    _isLoop = isLoop;
  
  return self;
}
-(AddImageView *)getObject{
  return _imageview;
}
-(int)getAnimationtype{
  return _animationType;
}
-(int)getPriority{
  return _priority;
}
-(bool)getisLoop{
  return _isLoop;
}
-(void)slideAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject{ 
  
  NSLog(@"priority %d",_priority);
   dispatch_async(dispatch_get_main_queue(), ^{
  UIImageView *imagev = imageobject.getImageView;
     imagev.transform = CGAffineTransformTranslate(imagev.transform,_fromXDelta, _fromYDelta);
     imagev.hidden = NO;
     [UIView animateWithDuration:_animationDuration delay:0.0 options:nil animations:^{
        imagev.transform = CGAffineTransformTranslate(imagev.transform,_toXDelta, _toYDelta);
  } completion:^(BOOL finished){
    if (nextObject != nil && hidecounter < hideanimatedObjectLength) {
      [splashClassInstance runAnimation];
    }
    else{
      if(hidecounter == hideanimatedObjectLength){
    
        [splashClassInstance dismissSplashDialog];
      
      }
    }

  }];
   });
}
-(void)scaleAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject{
  NSLog(@"priority %d",_priority);
   dispatch_async(dispatch_get_main_queue(), ^{
  UIImageView *imagev = imageobject.getImageView;
     imagev.hidden = NO;
     imagev.transform = CGAffineTransformScale(imagev.transform,_fromXDelta, _fromYDelta);
     [UIView animateWithDuration:_animationDuration delay:0.0 options:nil animations:^{
        imagev.transform = CGAffineTransformScale(imagev.transform,_toXDelta, _toYDelta);
  } completion:^(BOOL finished){
    if (nextObject != nil && hidecounter < hideanimatedObjectLength) {
      [splashClassInstance runAnimation];
    }
    else{
      if(hidecounter == hideanimatedObjectLength){
    
        [splashClassInstance dismissSplashDialog];
      
      }
    }

  }];
   });
}
-(void)rotateAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject{
  NSLog(@"priority %d",_priority);
  NSLog(@"in perform anima %@",imageobject);
  
   dispatch_async(dispatch_get_main_queue(), ^{
  UIImageView *imagev = imageobject.getImageView;
     
     imagev.hidden = NO;
     imagev.transform = CGAffineTransformRotate(imagev.transform,_fromValue * M_PI/360.0);
     [UIView animateWithDuration:_animationDuration delay:0.0 options:nil animations:^{
        imagev.transform = CGAffineTransformRotate(imagev.transform,_toValue * M_PI/360.0);
  } completion:^(BOOL finished){
    if (nextObject != nil && hidecounter < hideanimatedObjectLength) {
      [splashClassInstance runAnimation];
    }
    else{
      if(hidecounter == hideanimatedObjectLength){
    
        [splashClassInstance dismissSplashDialog];
      
      }
    }

  }];
   });
}
-(void)fadeAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject{

  
   dispatch_async(dispatch_get_main_queue(), ^{
  UIImageView *imagev = imageobject.getImageView;
     imagev.alpha = _fromValue;
     imagev.hidden = NO;
     [UIView animateWithDuration:_animationDuration delay:0.0 options:nil animations:^{
        imagev.alpha = _toValue;
  } completion:^(BOOL finished){

    if (nextObject != nil && hidecounter < hideanimatedObjectLength) {
      [splashClassInstance runAnimation];
    }
    else{
      if(hidecounter == hideanimatedObjectLength){
    
        [splashClassInstance dismissSplashDialog];
      
      }
    }
  }
      ];
   });
}

// loop event
-(void)slideAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject :(bool)isLoop{
  

   dispatch_async(dispatch_get_main_queue(), ^{
  UIImageView *imagev = imageobject.getImageView;
     imagev.hidden = NO;
     imagev.transform = CGAffineTransformTranslate(imagev.transform,_fromXDelta, _fromYDelta);
     [UIView animateWithDuration:_animationDuration delay:0.0 options:isLoop?UIViewAnimationOptionCurveLinear:nil animations:^{
        imagev.transform = CGAffineTransformTranslate(imagev.transform,_toXDelta, _toYDelta);
  } completion:^(BOOL finished){
    if(nextObject != nil && counter < animatedObjectLength){
    [splashClassInstance runAnimation];
    }
    if(isLoop == true && hidingfinal != true){
      NSLog(@"in loop rotate");
      [self slideAnimation:imageobject :nil :isLoop];
    }
    else{
      if(counter == animatedObjectLength){
      shouldHide = true;
      if(jsCalled == true){
        [splashClassInstance hide];
      }
      }
    }

  }];
   });
}
-(void)scaleAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject :(bool)isLoop{

   dispatch_async(dispatch_get_main_queue(), ^{
  UIImageView *imagev = imageobject.getImageView;
     imagev.hidden = NO;
     imagev.transform = CGAffineTransformScale(imagev.transform,_fromXDelta, _fromYDelta);
     [UIView animateWithDuration:_animationDuration delay:0.0 options:isLoop?UIViewAnimationOptionCurveLinear:nil animations:^{
        imagev.transform = CGAffineTransformScale(imagev.transform,_toXDelta, _toYDelta);
  } completion:^(BOOL finished){
    if(nextObject != nil && counter < animatedObjectLength){
    [splashClassInstance runAnimation];
    }
    if(isLoop == true && hidingfinal != true){
      NSLog(@"in loop rotate");
      [self scaleAnimation:imageobject :nil :isLoop];
    }
    else{
      if(counter == animatedObjectLength){
      shouldHide = true;
      if(jsCalled == true){
        [splashClassInstance hide];
      }
      }
    }

  }];
   });
}
-(void)rotateAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject :(bool)isLoop{
  
   dispatch_async(dispatch_get_main_queue(), ^{
  UIImageView *imagev = imageobject.getImageView;
     imagev.hidden = NO;
     imagev.transform = CGAffineTransformRotate(imagev.transform,_fromValue * M_PI/360.0);
     [UIView animateWithDuration:_animationDuration delay:0.0 options:isLoop?UIViewAnimationOptionCurveLinear:nil animations:^{
        imagev.transform = CGAffineTransformRotate(imagev.transform,_toValue * M_PI/360.0);
  } completion:^(BOOL finished){
   
    if (nextObject != nil && counter < animatedObjectLength) {
     
      [splashClassInstance runAnimation];
      
    }
    if(isLoop == true && hidingfinal != true){
      NSLog(@"in loop rotate");
      [self rotateAnimation:imageobject :nil :isLoop];
    }
    else{
      if(counter == animatedObjectLength){
      shouldHide = true;
      if(jsCalled == true){
        [splashClassInstance hide];
      }
      }
    }

  }];
   });
}
-(void)fadeAnimation:(AddImageView *)imageobject :(AddImageView *)nextObject :(bool)isLoop{
 
  
   dispatch_async(dispatch_get_main_queue(), ^{
  UIImageView *imagev = imageobject.getImageView;
     imagev.alpha = _fromValue;
     imagev.hidden = NO;
     [UIView animateWithDuration:_animationDuration delay:0.0 options:isLoop?UIViewAnimationOptionCurveLinear:nil animations:^{
        imagev.alpha = _toValue;
  } completion:^(BOOL finished){

    if(nextObject != nil && counter < animatedObjectLength){
    [splashClassInstance runAnimation];
    }
    if(isLoop == true && hidingfinal != true){
      NSLog(@"in loop rotate");
      [self fadeAnimation:imageobject :nil :isLoop];
    }
    else{
      if(counter == animatedObjectLength){
      shouldHide = true;
      if(jsCalled == true){
        [splashClassInstance hide];
      }
      }
    }
  }
      ];
   });
}

@end
//options:UIViewAnimationOptionRepeat|UIViewAnimationOptionAutoreverse|UIViewAnimationOptionBeginFromCurrentState
