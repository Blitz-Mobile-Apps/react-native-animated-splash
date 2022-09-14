//
//  ObjectAnimation.m
//  RNAnimatedSplash
//
//  Created by Ethan Gray on 8/24/22.
//

#import "ObjectAnimation.h"
#import "AnimatedObject.h"
#import <UIKit/UIKit.h>
#import <CoreGraphics/CoreGraphics.h>
#import "Splash.h"
#import "AnimationsList.h"
#import "HideAnimationsList.h"
@class Splash;
@class AnimatedObject;
@class AnimationList;
@implementation ObjectAnimation


//Written By Ayesh

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal{
    _imageview = object;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _toValue = toVal;
    _fromValue = fromVal;
    return self;
}

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY{
    _imageview = object;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _fromXDelta = fromX;
    _toXDelta = toX;
    _fromYDelta = fromY;
    _toYDelta = toY;
    return self;
}

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration rotateDegree:(float)rotateDegree{
    _imageview = object;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _fromValue = 0;
    _toValue = rotateDegree;
    return self;
}

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY{
    _imageview = object;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _fromValue = 0;
    _scaleX = scaleX;
    _scaleY = scaleY;
    return self;
}


//With Loop
-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration fromVal:(CGFloat)fromVal toVal:(CGFloat)toVal loop:(Boolean)loop{
    _imageview = object;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _toValue = toVal;
    _fromValue = fromVal;
    _isLoop = loop;
    return self;
}

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(Boolean)loop{
    _imageview = object;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _fromXDelta = fromX;
    _toXDelta = toX;
    _fromYDelta = fromY;
    _toYDelta = toY;
    _isLoop = loop;
    return self;
}

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration rotateDegree:(float)rotateDegree loop:(Boolean)loop{
    _imageview = object;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _fromValue = 0;
    _toValue = rotateDegree;
    _isLoop = loop;
    return self;
}

-(id)initimage:(AnimatedObject *)object animationtype:(int) animationtype animationDuration:(float)animationDuration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY loop:(Boolean)loop{
    _imageview = object;
    _animationType = animationtype;
    _animationDuration = animationDuration/1000;
    _fromValue = 0;
    _scaleX = scaleX;
    _scaleY = scaleY;
    _isLoop = loop;
    return self;
}

-(AnimatedObject *)getObject{
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

-(void) runNextAnimation:(ObjectAnimation *)object {
    if (object.next != NULL) {
        if([AnimationsList getItem:object.next].executed == false){
            [splashClassInstance runSpecificAnimation: [AnimationsList getItem:object.next]];
        }
    }else{
        allExecuted = true;
        if([HideAnimationsList getLength]>0){
            ObjectAnimation *obj = [HideAnimationsList getItem:[HideAnimationsList getHead]];
            [splashClassInstance runSpecificHideAnimation:obj];
        }else{
            if(splashClassInstance){
                [splashClassInstance dismissSplashDialog];
            }
        }
        
        
        
    }
}

-(void) runNextHideAnimation:(ObjectAnimation *)object {
    if (object.hideNext != NULL) {
        if([HideAnimationsList getItem:object.hideNext].hideExecuted == false){
            [splashClassInstance runSpecificHideAnimation: [HideAnimationsList getItem:object.hideNext]];
        }
    }else{
        
        shouldHide = true;
        if([HideAnimationsList getLength] > 0){
            if(splashClassInstance){
                [splashClassInstance dismissSplashDialog];
            }
        }else{
            return;
        }
        
        
    }
}

-(void)slideAnimation:(ObjectAnimation *)imageobject{
    
    NSLog(@"priority %d",_priority);
    dispatch_async(dispatch_get_main_queue(), ^{
        UIImageView *imagev = imageobject.imageview.getImageView;
        //        imagev.transform = CGAffineTransformTranslate(imagev.transform,_fromXDelta, _fromYDelta);
        imagev.hidden = NO;
        [UIView animateWithDuration:imageobject.animationDuration delay:0.0 options:(imageobject.isLoop?UIViewAnimationOptionRepeat| UIViewKeyframeAnimationOptionAutoreverse:nil ) animations:^{
            imagev.transform = CGAffineTransformTranslate(imagev.transform,_toXDelta, _toYDelta);
        } completion:^(BOOL finished){
            [imageobject setExecuted:true];
            [self runNextAnimation:imageobject];
        }
        ];
        if ([AnimationsList getItem:imageobject.next].priority == imageobject.priority){
            [imageobject setExecuted:true];
            [self runNextAnimation:imageobject];
        }
        else if(imageobject.isLoop){
            dispatch_time_t delay = dispatch_time(DISPATCH_TIME_NOW, NSEC_PER_SEC * imageobject.animationDuration);
            dispatch_after(delay, dispatch_get_main_queue(), ^(void){
                // do work in the UI thread here
                [self runNextAnimation:imageobject];
            });
            
        }
    });
}
-(void)scaleAnimation:(ObjectAnimation *)imageobject{
    NSLog(@"priority %d",_priority);
    dispatch_async(dispatch_get_main_queue(), ^{
        UIImageView *imagev = imageobject.imageview.getImageView;
        imagev.hidden = NO;
        //     imagev.transform = CGAffineTransformScale(imagev.transform,_fromXDelta, _fromYDelta);
        [UIView animateWithDuration:imageobject.animationDuration delay:0.0 options:(imageobject.isLoop?UIViewAnimationOptionRepeat| UIViewKeyframeAnimationOptionAutoreverse:nil ) animations:^{
            imagev.transform = CGAffineTransformScale(imagev.transform,_scaleX, _scaleY);
        } completion:^(BOOL finished){
            [imageobject setExecuted:true];
            [self runNextAnimation:imageobject];
        }];
        if ([AnimationsList getItem:imageobject.next].priority == imageobject.priority){
            [imageobject setExecuted:true];
            [self runNextAnimation:imageobject];
        }
        else if(imageobject.isLoop){
            dispatch_time_t delay = dispatch_time(DISPATCH_TIME_NOW, NSEC_PER_SEC * imageobject.animationDuration);
            dispatch_after(delay, dispatch_get_main_queue(), ^(void){
                // do work in the UI thread here
                [self runNextAnimation:imageobject];
            });
            
        }
    });
}
-(void)rotateAnimation:(ObjectAnimation *)imageobject{
    dispatch_async(dispatch_get_main_queue(), ^{
        
        UIImageView *imagev = imageobject.imageview.getImageView;
        
        imagev.hidden = NO;
        imagev.transform = CGAffineTransformRotate(imagev.transform,_fromValue * M_PI/360.0);
        [UIView animateWithDuration:imageobject.animationDuration delay:0.0 options:(imageobject.isLoop?UIViewAnimationOptionRepeat| UIViewKeyframeAnimationOptionAutoreverse:nil ) animations:^{
            imagev.transform = CGAffineTransformRotate(imagev.transform,_toValue * M_PI/360.0);
        } completion:^(BOOL finished){
            [imageobject setExecuted:true];
            [self runNextAnimation:imageobject];
        }];
        if ([AnimationsList getItem:imageobject.next].priority == imageobject.priority){
            [imageobject setExecuted:true];
            [self runNextAnimation:imageobject];
        }
        else if(imageobject.isLoop){
            dispatch_time_t delay = dispatch_time(DISPATCH_TIME_NOW, NSEC_PER_SEC * imageobject.animationDuration);
            dispatch_after(delay, dispatch_get_main_queue(), ^(void){
                // do work in the UI thread here
                [self runNextAnimation:imageobject];
            });
            
        }
    });
}
-(void)fadeAnimation:(ObjectAnimation *)imageobject{
    dispatch_async(dispatch_get_main_queue(), ^{
        UIImageView *imagev = imageobject.imageview.getImageView;
        imagev.alpha = self->_fromValue;
        imagev.hidden = NO;
        [UIView animateWithDuration:imageobject.animationDuration delay:0.0 options:(imageobject.isLoop?UIViewAnimationOptionRepeat| UIViewKeyframeAnimationOptionAutoreverse:nil) animations:^{
            imagev.alpha = self->_toValue;
        } completion:^(BOOL finished){
            [imageobject setExecuted:true];
            [self runNextAnimation:imageobject];
        }
        ];
        if ([AnimationsList getItem:imageobject.next].priority == imageobject.priority){
            [imageobject setExecuted:true];
            [self runNextAnimation:imageobject];
        }
        else if(imageobject.isLoop){
            dispatch_time_t delay = dispatch_time(DISPATCH_TIME_NOW, NSEC_PER_SEC * imageobject.animationDuration);
            dispatch_after(delay, dispatch_get_main_queue(), ^(void){
                // do work in the UI thread here
                [self runNextAnimation:imageobject];
            });
            
        }
        
    });
}


-(void)slideHideAnimation:(ObjectAnimation *)imageobject{
    
    dispatch_async(dispatch_get_main_queue(), ^{
        UIImageView *imagev = imageobject.imageview.getImageView;
        imagev.transform = CGAffineTransformTranslate(imagev.transform,_fromXDelta, _fromYDelta);
        imagev.hidden = NO;
        [UIView animateWithDuration:imageobject.animationDuration delay:0.0 options:nil animations:^{
            imagev.transform = CGAffineTransformTranslate(imagev.transform,_toXDelta, _toYDelta);
        } completion:^(BOOL finished){
            [imageobject setHideExecuted:true];
            [self runNextHideAnimation:imageobject];
        }
        ];
        if ([HideAnimationsList getItem:imageobject.hideNext].hidePriority == imageobject.hidePriority){
            [imageobject setHideExecuted:true];
            [self runNextHideAnimation:imageobject];
        }
    });
}
-(void)scaleHideAnimation:(ObjectAnimation *)imageobject{
    dispatch_async(dispatch_get_main_queue(), ^{
        UIImageView *imagev = imageobject.imageview.getImageView;
        imagev.hidden = NO;
        //     imagev.transform = CGAffineTransformScale(imagev.transform,_fromXDelta, _fromYDelta);
        [UIView animateWithDuration:imageobject.animationDuration delay:0.0 options:nil animations:^{
            imagev.transform = CGAffineTransformScale(imagev.transform,_scaleX, _scaleY);
        } completion:^(BOOL finished){
            [imageobject setHideExecuted:true];
            [self runNextHideAnimation:imageobject];
        }];
        if ([HideAnimationsList getItem:imageobject.hideNext].hidePriority == imageobject.hidePriority){
            [imageobject setHideExecuted:true];
            [self runNextHideAnimation:imageobject];
        }
        
    });
}
-(void)rotateHideAnimation:(ObjectAnimation *)imageobject{
    dispatch_async(dispatch_get_main_queue(), ^{
        
        UIImageView *imagev = imageobject.imageview.getImageView;
        
        imagev.hidden = NO;
        imagev.transform = CGAffineTransformRotate(imagev.transform,_fromValue * M_PI/360.0);
        [UIView animateWithDuration:imageobject.animationDuration delay:0.0 options:nil animations:^{
            imagev.transform = CGAffineTransformRotate(imagev.transform,_toValue * M_PI/360.0);
        } completion:^(BOOL finished){
            [imageobject setHideExecuted:true];
            [self runNextHideAnimation:imageobject];
        }];
        if ([HideAnimationsList getItem:imageobject.hideNext].hidePriority == imageobject.hidePriority){
            [imageobject setHideExecuted:true];
            [self runNextHideAnimation:imageobject];
        }
    });
}
-(void)fadeHideAnimation:(ObjectAnimation *)imageobject{
    dispatch_async(dispatch_get_main_queue(), ^{
        UIImageView *imagev = imageobject.imageview.getImageView;
        imagev.alpha = self->_fromValue;
        imagev.hidden = NO;
        [UIView animateWithDuration:imageobject.animationDuration delay:0.0 options:nil animations:^{
            imagev.alpha = self->_toValue;
        } completion:^(BOOL finished){
            [imageobject setHideExecuted:true];
            [self runNextHideAnimation:imageobject];
        }
        ];
        if ([HideAnimationsList getItem:imageobject.hideNext].hidePriority == imageobject.hidePriority){
            [imageobject setHideExecuted:true];
            [self runNextHideAnimation:imageobject];
        }
    });
}


@end
