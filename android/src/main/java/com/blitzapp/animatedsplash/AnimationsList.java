package com.blitzapp.animatedsplash;

import com.blitzapp.animatedsplash.animation.AnimatedObject;
import com.blitzapp.animatedsplash.animation.ObjectAnimation;

import java.util.HashMap;
import java.util.UUID;

public  class AnimationsList {

    public static HashMap<String, ObjectAnimation> animationsList = new HashMap<>();
    public static String animationListTail = null;
    public static String animationListHead = null;

    public static void appendInAnimationList(ObjectAnimation object){
        String uniqueID = UUID.randomUUID().toString();
        if(animationsList.isEmpty()){
            animationListHead = uniqueID;
        }else{
            animationsList.get(animationListTail).setNext(uniqueID);
        }
        animationsList.put(uniqueID,object);
        animationListTail = uniqueID;
    }
}
