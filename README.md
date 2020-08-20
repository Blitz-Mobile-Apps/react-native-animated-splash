# [react-native-animated-splash](https://www.npmjs.com/package/react-native-animated-splash)
[![Build Status](https://travis-ci.org/joemccann/dillinger.svg?branch=master)](https://travis-ci.org/joemccann/dillinger)
![Supports Android and iOS](https://img.shields.io/badge/platforms-android%20|%20ios-lightgrey.svg?style=flat-square)
[![License](http://img.shields.io/:license-mit-blue.svg?style=flat-square)](http://badges.mit-license.org)
[![NPM](https://img.shields.io/npm/dm/react-native-animated-splash)](https://www.npmjs.com/package/react-native-animated-splash)
[![Version](https://img.shields.io/npm/v/react-native-animated-splash)](https://www.npmjs.com/package/react-native-animated-splash)


React-Native-Animated-Splash-Screen is developed to help the react-native developers in speeding-up their development process. This package leverages the developer from implementing native animations by using our builtin classes for animation with easy to use api, all the animations run on native thread for smooth performance

### Installation
If you prefer **npm**,
```sh
$ npm install react-native-animated-splash --save
```

If you prefer **yarn**,
```sh
$ yarn add react-native-animated-splash
```


## USAGE

 ### Android
 Following is the basic example of using react-native-animated-splash. Go to your MainActivity.java file and add following code.
 
 ```sh
 
   public static Context context;
  
   public void onCreate(Bundle saved) {
        super.onCreate(saved);
        context = this.getApplicationContext();
        initiateSplash();
    }

    public void initiateSplash() {
        Splash splash = new Splash();
        //create dialog
        splash.createDialog(MainActivity.this);

        //set background image to view
        splash.setBackgroundColor(R.drawable.splashbg);
        
        // set splash hide animation
        splash.setSplashHideAnimation(DIALOGSLIDELEFT);
        
        // set splash hide delay
        splash.setSplashHideDelay(1000);
        
        // create and add images to view
        CreateImageObject addObject1 = new CreateImageObject(R.drawable.header, screenHeight * 0.2, screenWidth, 0, 0, 0, FIT_XY, true);

        CreateImageObject addObject2 = new CreateImageObject(R.drawable.footer, screenHeight * 0.2, screenWidth, 0, screenHeight - screenHeight * 0.2, 0, FIT_XY, true);

        CreateImageObject addObject3 = new CreateImageObject(R.drawable.logo, screenHeight * 0.13, screenWidth * 0.4, (screenWidth - screenWidth * 0.4) / 2, (screenHeight - screenHeight * 0.13) / 2, 0, FIT_CENTER, false);

        // add animations with type
        
        // add group animation (animations added in group will run in parallel)
        AddGroupObject gObject1 = new AddGroupObject();
        gObject1.add(addObject1, SLIDE, 980, 0f, 0f, -screenHeight * 0.2f, 0f,false, false);

        gObject1.add(addObject2, SLIDE, 980, 0f, 0f, screenHeight * 0.2f, 0f,false, false);

         // add single animation (animations added in singleObject will run in sequentially)
        splash.animateSingleObject(addObject3, SCALE, 980, 0.2f, 1f, 0.2f, 1f,false,true);

        splash.show();

    }
```
#### CreateImageObject available parameters

 ```sh
 CreateImageObject(imageSource, double height, double width)

 CreateImageObject(imageSource, double height, double width, double positionX, double positionY, boolean visibility)
 
 CreateImageObject(imageSource, double height, double width, double positionX, double positionY, String scaleType, boolean visibility)
 
 CreateImageObject(imageSource, double height, double width, double positionX, double positionY, double rotateDegree, String scaleType, boolean visibility)
```

#### Important Note

> add respective images from your drawable else it will give error
>
> for some variables which appears not defined like "screenHeight", import them from library class.
>

<!-- ### Todos
We aim to make this package even more robust and powerful by adding following features in the upcoming releases:
 - implement ios

License
---- -->

MIT 
