//
//  GroupAnimation.m
//  splashmoduleios
//
//  Created by Smith Charles on 22/09/2020.
//

#import "GroupAnimation.h"
#import "Splash.h"

@implementation GroupAnimation
int groupcount = 0;
-(id)init {
  if(self = [super init]){

  }
 
  groupcount++;
  NSLog(@"group count %d",groupcount);
  return self;
 
}

-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY{
  [splashClassInstance animateGroupObject:object animationType:typeOfAnimation duration:duration fromX:fromX toX:toX fromY:fromY toY:toY :groupcount loop:false];
//  [splashClassInstance animateGroupObject:object :typeOfAnimation :duration :toX :toY :groupcount loop:false];

}
-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue {

  [splashClassInstance animateGroupObject:object animationType:typeOfAnimation duration:duration fromValue:fromValue toValue:toValue :groupcount loop:false];

}
-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromX:(CGFloat)fromX toX:(CGFloat)toX fromY:(CGFloat)fromY toY:(CGFloat)toY loop:(bool)isLoop{
  
  [splashClassInstance animateGroupObject:object animationType:typeOfAnimation duration:duration fromX:fromX toX:toX fromY:fromY toY:toY :groupcount loop:isLoop];

}
-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration fromValue:(CGFloat)fromValue toValue:(CGFloat)toValue loop:(bool)isLoop{
  [splashClassInstance animateGroupObject:object animationType:typeOfAnimation duration:duration fromValue:fromValue toValue:toValue :groupcount loop:isLoop];


}
-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY {

  [splashClassInstance animateGroupObject:object animationType:typeOfAnimation duration:duration scaleX:scaleX scaleY:scaleY :groupcount loop:false];

}
-(void)performGroupAnimation:(AddImageView *)object typeofanimation:(int)typeOfAnimation duration:(int)duration scaleX:(CGFloat)scaleX scaleY:(CGFloat)scaleY loop:(bool)isLoop{
  [splashClassInstance animateGroupObject:object animationType:typeOfAnimation duration:duration scaleX:scaleX scaleY:scaleY :groupcount loop:isLoop];


}
@end
