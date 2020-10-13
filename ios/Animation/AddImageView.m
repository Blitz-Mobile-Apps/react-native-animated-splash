//
//  AddImageView.m
//  splashmoduleios
//
//  Created by Smith Charles on 21/09/2020.
//

#import "AddImageView.h"
#import "Splash.h"
@implementation AddImageView

bool visibility = true;
float opacity = 1;

-(id)init {
  if(self = [super init]){
    _thispositionX = 0;
    _thispositionY = 0;
    _thisvisibility = true;
    _thisscaleType = FIT_XY;
    _thisopacity = 1;
    _thisrotateDegree = 0;
  }
  return self;
}

-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height{

  
  _thispositionX = 0;
  _thispositionY = 0;
  _thisvisibility = true;
  _thisscaleType = FIT_XY;
  _thisopacity = 1;
  _thisrotateDegree = 0;
  _imagename = image;
  _thisheight = height;
  _thiswidth = width;
  
    NSLog(@"in initwithimg");
    [Splash addImagetoView:self];
  
  return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY{

  _thisvisibility = true;
  _thisscaleType = FIT_XY;
  _thisopacity = 1;
  _thisrotateDegree = 0;
  _imagename = image;
  _thisheight = height;
  _thiswidth = width;
  _thispositionX = positionX;
  _thispositionY = positionY;

    NSLog(@"in initwithimg");
    [Splash addImagetoView:self];
  

  return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility{

  _thisopacity = 1;
  _thisscaleType = FIT_XY;
  _thisrotateDegree = 0;
  _imagename = image;
  _thisheight = height;
  _thiswidth = width;
  _thispositionX = positionX;
  _thispositionY = positionY;
  _thisvisibility = visibility;
    NSLog(@"in initwithimg");
    [Splash addImagetoView:self];

  return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType{

  _thisopacity = 1;
  _thisrotateDegree = 0;
  _imagename = image;
  _thisheight = height;
  _thiswidth = width;
  _thispositionX = positionX;
  _thispositionY = positionY;
  _thisvisibility = visibility;
  _thisscaleType = scaleType;
    NSLog(@"in initwithimg");
    [Splash addImagetoView:self];
  

  return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType opacity:(float)opacity{

  _thisrotateDegree = 0;
  _imagename = image;
  _thisheight = height;
  _thiswidth = width;
  _thispositionX = positionX;
  _thispositionY = positionY;
  _thisvisibility = visibility;
  _thisscaleType = scaleType;
  _thisopacity = opacity;
    NSLog(@"in initwithimg");
    [Splash addImagetoView:self];
  

  return self;
}
-(instancetype)initImage:(NSString *)image width:(CGFloat)width height:(CGFloat)height positionX:(CGFloat)positionX positionY:(CGFloat)positionY visibility:(bool)visibility scaleType:(int)scaleType opacity:(float)opacity rotateDegree:(float)rotateDegree{

  _imagename = image;
  _thisheight = height;
  _thiswidth = width;
  _thispositionX = positionX;
  _thispositionY = positionY;
  _thisvisibility = visibility;
  _thisscaleType = scaleType;
  _thisopacity = opacity;
  _thisrotateDegree = rotateDegree;
    NSLog(@"in initwithimg");
    [Splash addImagetoView:self];
  
  return self;
}
-(UIImageView *)getImageView{
  return _imageobject;
}
-(UIImageView *)initializeObject{
   
  _imageobject = [[UIImageView alloc] initWithFrame:CGRectMake(_thispositionX, _thispositionY, _thiswidth, _thisheight)];
  
    _imageobject.image = [UIImage imageNamed:_imagename];

  switch (_thisscaleType) {
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
  _imageobject.transform = CGAffineTransformRotate(_imageobject.transform,_thisrotateDegree);
//  _imageobject.contentMode = UIViewContentModeScaleAspectFit; //FITCENTER
//  _imageobject.contentMode = UIViewContentModeScaleAspectFill; // FITXY
//  _imageobject.contentMode = UIViewContentModeTopLeft; //FITSTART
//  _imageobject.contentMode = UIViewContentModeBottomRight; //FITEND
  
  _imageobject.alpha = _thisopacity;
  if(_thisvisibility == true){
    _imageobject.hidden = NO;
  }else{
    _imageobject.hidden = YES;
  }
  return _imageobject;
  
}

@end
