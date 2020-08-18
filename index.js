
import { NativeModules } from 'react-native';
const { RNAnimatedSplash } = NativeModules;
const AnimatedSplash = {
    hide:()=>{
        if(RNAnimatedSplash.hide){
            RNAnimatedSplash.hide()
        }
    }
}

export default AnimatedSplash