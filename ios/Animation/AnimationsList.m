//
//  AnimationsList.m
//  RNAnimatedSplash
//
//  Created by Ethan Gray on 8/23/22.
//

//
//  HideGroupAnimation.m
//  splashmoduleios
//
//  Created by Smith Charles on 29/09/2020.
//

#import "AnimationsList.h"
#import "ObjectAnimation.h"
@class ObjectAnimation;
@implementation AnimationsList

static NSMutableDictionary<NSString *,ObjectAnimation *> *animationsList;

static NSString *animationListHead = NULL;
static NSString *animationListTail = NULL;

+(void) initializeDictionary{
    animationsList = [[NSMutableDictionary alloc] init];
}

+(void) appendInAnimationList:(ObjectAnimation*) object{
    
    NSUUID *uuid = [NSUUID UUID];
    NSString *str = [uuid UUIDString];

    if([animationsList count] == 0){
        animationListHead = str;
    }
    
    [animationsList setObject:object forKey:str];
    animationsList[animationListTail].next = str;
    animationListTail = str;
    animationsList[str] = object;
    
}

+(ObjectAnimation*) getItem:(NSString*) key{
    return animationsList[key];
}

+(NSString*) getHead{
    return animationListHead;
}

+(int) getLength{
    return [animationsList count];
}
@end

//
//#import "AnimationsList.h"
//#import <Foundation/Foundation.h>
//#import "AnimatedObject.h"
//@class AnimatedObject;
//
//@implementation AnimationsList
//
//static NSDictionary<NSString *, NSNumber *> *animationsList;
//static NSString *animationListHead = NULL;
//static NSString *animationListTail = NULL;
//
////public static void appendInAnimationList(AnimatedObject object){
////        String uniqueID = UUID.randomUUID().toString();
////        if(animationsList.isEmpty()){
////            animationListHead = uniqueID;
////        }else{
////            animationsList.get(animationListTail).setNext(uniqueID);
////        }
////        animationsList.put(uniqueID,object);
////        animationListTail = uniqueID;
////        object.setNext(null);
////    }
//+(void)  appendInAnimationList:(AnimatedObject*) object{
//    NSUUID *uuid = [NSUUID UUID];
//    NSString *str = [uuid UUIDString];
//
//    if([animationsList count] == 0){
//        animationListHead = str;
//    }
//    [animationsList setValue:object forKey:str];
//    animationListTail = str;
//    [object setNext:str];
//
//
//}
//
//
//@end
//
//
