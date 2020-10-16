//
//  HideGroupAnimation.m
//  splashmoduleios
//
//  Created by Smith Charles on 29/09/2020.
//

#import "HideGroupAnimation.h"

@implementation HideGroupAnimation
int hidegroupCount = 0;
-(id)init {
  if(self = [super init]){

  }
 
  hidegroupCount++;
  NSLog(@"group count %d",hidegroupCount);
  return self;
 
}

-(void)performHideGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY{
  
//  [splashClassInstance performGroupAnimationOnHide:object :typeOfAnimation :duration :toX :toY :groupcount];
  [splashClassInstance performGroupAnimationOnHide:object animationType:typeOfAnimation duration:duration fromX:fromX toX:toX fromY:fromY toY:toY :hidegroupCount];

}
-(void)performHideGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue{

//  [splashClassInstance performGroupAnimationOnHide:object :typeOfAnimation :duration :toX :groupcount];
  [splashClassInstance performGroupAnimationOnHide:object animationType:typeOfAnimation duration:duration fromValue:fromValue toValue:toValue :hidegroupCount];

}
-(void)performHideGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY{

//  [splashClassInstance performGroupAnimationOnHide:object :typeOfAnimation :duration :toX :groupcount];
  [splashClassInstance performGroupAnimationOnHide:object animationType:typeOfAnimation duration:duration scaleX:scaleX scaleY:scaleY :hidegroupCount];

}
@end
