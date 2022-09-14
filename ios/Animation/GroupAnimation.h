//
//  GroupAnimation.h
//  splashmoduleios
//
//  Created by Smith Charles on 22/09/2020.
//
#import <Foundation/Foundation.h>
#import <CoreGraphics/CoreGraphics.h>
#import "AddImageView.h"
@class AddImageView;
#import <Foundation/Foundation.h>
#import "Splash.h"
@class Splash;
NS_ASSUME_NONNULL_BEGIN

@interface GroupAnimation : NSObject

@property (nonatomic) int priority;


-(instancetype) init:(int)priority;\

-(void)addAnimation:(ObjectAnimation*)object;

@end

NS_ASSUME_NONNULL_END
