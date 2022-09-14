//
//  AnimatedObject.m
//  RNAnimatedSplash
//
//  Created by Ethan Gray on 8/19/22.
//

#import <Foundation/Foundation.h>
#import "AnimatedObject.h"
#import "ObjectAnimation.h"
#import "Splash.h"
@implementation AnimatedObject

bool visibility = true;
float opacity = 1;

-(id)init {
    if(self = [super init]){
        _positionX = 0;
        _positionY = 0;
        _visibility = true;
        _scaleType = FIT_XY;
        _opacity = 1;
        _rotateDegree = 0;
    }
    return self;
}

-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height{
    
    
    _positionX = [self getCenterX:width];
    _positionY = [self getCenterY:height];
    _visibility = true;
    _scaleType = FIT_XY;
    _opacity = 1;
    _rotateDegree = 0;
    _imagename = image;
    _height = height;
    _width = width;
    
    NSLog(@"in initwithimg");
    //    [Splash addImagetoView:self];
    
    return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY{
    
    _visibility = true;
    _scaleType = FIT_XY;
    _opacity = 1;
    _rotateDegree = 0;
    _imagename = image;
    _height = height;
    _width = width;
    _positionX = positionX;
    _positionY = positionY;
    
    NSLog(@"in initwithimg");
    //    [Splash addImagetoView:self];
    
    
    return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility{
    
    _opacity = 1;
    _scaleType = FIT_XY;
    _rotateDegree = 0;
    _imagename = image;
    _height = height;
    _width = width;
    _positionX = positionX;
    _positionY = positionY;
    _visibility = visibility;
    NSLog(@"in initwithimg");
    //    [Splash addImagetoView:self];
    
    return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType{
    
    _opacity = 1;
    _rotateDegree = 0;
    _imagename = image;
    _height = height;
    _width = width;
    _positionX = positionX;
    _positionY = positionY;
    _visibility = visibility;
    _scaleType = scaleType;
    NSLog(@"in initwithimg");
    //    [Splash addImagetoView:self];
    
    
    return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType opacity:(float)opacity{
    
    _rotateDegree = 0;
    _imagename = image;
    _height = height;
    _width = width;
    _positionX = positionX;
    _positionY = positionY;
    _visibility = visibility;
    _scaleType = scaleType;
    _opacity = opacity;
    NSLog(@"in initwithimg");
    //    [Splash addImagetoView:self];
    
    
    return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType opacity:(float)opacity rotateDegree:(float)rotateDegree{
    
    _imagename = image;
    _height = height;
    _width = width;
    _positionX = positionX;
    _positionY = positionY;
    _visibility = visibility;
    _scaleType = scaleType;
    _opacity = opacity;
    _rotateDegree = rotateDegree;
    NSLog(@"in initwithimg");
    //    [Splash addImagetoView:self];
    
    return self;
}

-(void) addToSplash{
    [Splash addImagetoView:self];
}

-(UIImageView *)getImageView{
    return _imageobject;
}


-(UIImageView *)initializeObject{
    
    _imageobject = [[UIImageView alloc] initWithFrame:CGRectMake(_positionX, _positionY, _width, _height)];
    
    _imageobject.image = [UIImage imageNamed:_imagename];
    
    switch (_scaleType) {
        case 1:
            _imageobject.contentMode = UIViewContentModeScaleAspectFit;
            break;
        case 2:
            _imageobject.contentMode = UIViewContentModeScaleToFill;
            break;
        case 3:
            _imageobject.contentMode = UIViewContentModeTopLeft;
            break;
        case 4:
            _imageobject.contentMode = UIViewContentModeBottomRight;
            break;
        default:
            _imageobject.contentMode = UIViewContentModeScaleAspectFit;
            break;
    }
    _imageobject.transform = CGAffineTransformRotate(_imageobject.transform,_rotateDegree);

    
    _imageobject.alpha = _opacity;
    if(_visibility == true){
        _imageobject.hidden = NO;
    }else{
        _imageobject.hidden = YES;
    }
    return _imageobject;
    
}

-(CGFloat)getCenterX: (float) width{
    CGFloat position = (screenWidth- width)/2;
    return position;
}
-(CGFloat)getCenterY: (float)height{
    CGFloat position = (screenHeight- height)/2;
    return position;
}

//Written By Ayesh
-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue{
    _animation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration fromVal:fromValue toVal:toValue];
}

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY{
    _animation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration scaleX:scaleX scaleY:scaleY];
}
-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY{
    
    _animation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration fromX:fromX toX:toX fromY:fromY toY:toY];
}

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration rotateDegree:(float)rotateDegree{
    
    _animation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration rotateDegree:rotateDegree];
}

//With Loop
-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue loop:(BOOL)loop{
    _animation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration fromVal:fromValue toVal:toValue loop:loop];
}

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY loop:(BOOL)loop{
    _animation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration scaleX:scaleX scaleY:scaleY loop:loop];
}
-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(BOOL)loop{
    
    _animation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration fromX:fromX toX:toX fromY:fromY toY:toY loop:loop];
}

-(void) addAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration rotateDegree:(float)rotateDegree loop:(BOOL)loop{
    
    _animation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration rotateDegree:rotateDegree loop:loop];
}

// Hiding Animations
-(void) addHideAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue{
    _hideAnimation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration fromVal:fromValue toVal:toValue];
}

-(void) addHideAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY{
    _hideAnimation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration scaleX:scaleX scaleY:scaleY];
}
-(void) addHideAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY{
    
    _hideAnimation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration fromX:fromX toX:toX fromY:fromY toY:toY];
}

-(void) addHideAnimationWithAnimationtType:(AnimatedObject*)object animationType:(int)animationType duration:(int)duration rotateDegree:(float)rotateDegree{
    
    _hideAnimation = [[ObjectAnimation alloc] initimage:object animationtype:animationType animationDuration:duration rotateDegree:rotateDegree];
}

@end
