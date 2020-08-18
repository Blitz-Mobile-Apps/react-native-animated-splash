using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Animated.Splash.Screen.RNAnimatedSplashScreen
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNAnimatedSplashScreenModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNAnimatedSplashScreenModule"/>.
        /// </summary>
        internal RNAnimatedSplashScreenModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNAnimatedSplashScreen";
            }
        }
    }
}
