using ReactNative.Bridge;
using System;
using System.Collections.Generic;
using Windows.ApplicationModel.Core;
using Windows.UI.Core;

namespace Animated.Splash.RNAnimatedSplash
{
    /// <summary>
    /// A module that allows JS to share data.
    /// </summary>
    class RNAnimatedSplashModule : NativeModuleBase
    {
        /// <summary>
        /// Instantiates the <see cref="RNAnimatedSplashModule"/>.
        /// </summary>
        internal RNAnimatedSplashModule()
        {

        }

        /// <summary>
        /// The name of the native module.
        /// </summary>
        public override string Name
        {
            get
            {
                return "RNAnimatedSplash";
            }
        }
    }
}
