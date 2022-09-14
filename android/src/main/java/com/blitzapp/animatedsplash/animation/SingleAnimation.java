package com.blitzapp.animatedsplash.animation;

import static com.blitzapp.animatedsplash.AnimationsList.animationsList;
import static com.blitzapp.animatedsplash.animation.Constants.SINGLE;
import static com.blitzapp.animatedsplash.animation.Splash.animatedObjectList;
import static com.blitzapp.animatedsplash.animation.Splash.priority;

import com.blitzapp.animatedsplash.AnimationsList;
import com.blitzapp.animatedsplash.ListItem;

import java.util.ArrayList;
import java.util.List;


public class SingleAnimation {

    public String type = SINGLE;
    public int priority = 0;
    public SingleAnimation(ObjectAnimation object,int priority) {
        object.priority = priority;
        AnimationsList.appendInAnimationList(object);
    }
}
