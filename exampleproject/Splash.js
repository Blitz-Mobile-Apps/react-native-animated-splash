import {
    NativeModules,
    Platform
} from 'react-native'
import AnimatedSplash from "react-native-animated-splash";
var Splash = {
    hide:()=> {
        if(Platform.OS == "android"){
        if(AnimatedSplash){
            AnimatedSplash.hide()
        }else{
            console.warn('Please link library again')
        }}
        else{
            if(NativeModules.splash){
                NativeModules.splash.hide()
            }else{
                console.warn('Please link library again')
            }
        }
    },
    navigate:()=> {
        if(NativeModules.splash){
            NativeModules.splash.hide()
        }else{
            console.warn('Please link library again')
        }
    },
}

export default Splash