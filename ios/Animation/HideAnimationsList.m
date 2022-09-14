//
//  HideAnimationsList.m
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

#import "HideAnimationsList.h"
#import "ObjectAnimation.h"
@class ObjectAnimation;
@implementation HideAnimationsList

static NSMutableDictionary<NSString *,ObjectAnimation *> *hideAnimationsList;

static NSString *hideAnimationListHead = NULL;
static NSString *hideAnimationListTail = NULL;

+(void) initializeDictionary{
    hideAnimationsList = [[NSMutableDictionary alloc] init];
}

+(void) appendInAnimationList:(ObjectAnimation*) object{
    
    NSUUID *uuid = [NSUUID UUID];
    NSString *str = [uuid UUIDString];

    if([hideAnimationsList count] == 0){
        hideAnimationListHead = str;
    }
    
    [hideAnimationsList setObject:object forKey:str];
    hideAnimationsList[hideAnimationListTail].hideNext = str;
    hideAnimationListTail = str;
    hideAnimationsList[str] = object;
}

+(ObjectAnimation*) getItem:(NSString*) key{
    return hideAnimationsList[key];
}

+(NSString*) getHead{
    return hideAnimationListHead;
}

+(int) getLength{
    return  [hideAnimationsList count];
}
@end

