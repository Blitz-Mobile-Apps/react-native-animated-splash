
# react-native-animated-splash-screen

## Getting started

`$ npm install react-native-animated-splash-screen --save`

### Mostly automatic installation

`$ react-native link react-native-animated-splash-screen`

### Manual installation


#### iOS

1. In XCode, in the project navigator, right click `Libraries` ➜ `Add Files to [your project's name]`
2. Go to `node_modules` ➜ `react-native-animated-splash-screen` and add `RNAnimatedSplashScreen.xcodeproj`
3. In XCode, in the project navigator, select your project. Add `libRNAnimatedSplashScreen.a` to your project's `Build Phases` ➜ `Link Binary With Libraries`
4. Run your project (`Cmd+R`)<

#### Android

1. Open up `android/app/src/main/java/[...]/MainActivity.java`
  - Add `import com.reactlibrary.RNAnimatedSplashScreenPackage;` to the imports at the top of the file
  - Add `new RNAnimatedSplashScreenPackage()` to the list returned by the `getPackages()` method
2. Append the following lines to `android/settings.gradle`:
  	```
  	include ':react-native-animated-splash-screen'
  	project(':react-native-animated-splash-screen').projectDir = new File(rootProject.projectDir, 	'../node_modules/react-native-animated-splash-screen/android')
  	```
3. Insert the following lines inside the dependencies block in `android/app/build.gradle`:
  	```
      compile project(':react-native-animated-splash-screen')
  	```

#### Windows
[Read it! :D](https://github.com/ReactWindows/react-native)

1. In Visual Studio add the `RNAnimatedSplashScreen.sln` in `node_modules/react-native-animated-splash-screen/windows/RNAnimatedSplashScreen.sln` folder to their solution, reference from their app.
2. Open up your `MainPage.cs` app
  - Add `using Animated.Splash.Screen.RNAnimatedSplashScreen;` to the usings at the top of the file
  - Add `new RNAnimatedSplashScreenPackage()` to the `List<IReactPackage>` returned by the `Packages` method


## Usage
```javascript
import RNAnimatedSplashScreen from 'react-native-animated-splash-screen';

// TODO: What to do with the module?
RNAnimatedSplashScreen;
```
  