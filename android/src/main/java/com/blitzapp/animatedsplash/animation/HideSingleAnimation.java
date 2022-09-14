package com.blitzapp.animatedsplash.animation;

import static com.blitzapp.animatedsplash.animation.Constants.SINGLE;

import com.blitzapp.animatedsplash.AnimationsList;
import com.blitzapp.animatedsplash.HideAnimationList;

public class HideSingleAnimation {

    public String type = SINGLE;
    public int priority = 0;
    public HideSingleAnimation(ObjectAnimation object,int priority) {
        object.hidePriority = priority;
        HideAnimationList.appendInAnimationList(object);
    }
}
