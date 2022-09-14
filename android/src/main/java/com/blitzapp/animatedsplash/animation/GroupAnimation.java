package com.blitzapp.animatedsplash.animation;


import static com.blitzapp.animatedsplash.animation.Constants.GROUP;
import static com.blitzapp.animatedsplash.animation.Splash.animatedObjectList;

import com.blitzapp.animatedsplash.AnimationsList;

import java.util.ArrayList;
import java.util.List;

public class GroupAnimation {

    public String type = GROUP;
    public int priority = 0;
    private List<ObjectAnimation> group = new ArrayList<>();

    public GroupAnimation(int priority) {
        this.priority = priority;
    }

    public void addAnimation(ObjectAnimation object){
        object.priority = priority;
        AnimationsList.appendInAnimationList(object);
    }

  }