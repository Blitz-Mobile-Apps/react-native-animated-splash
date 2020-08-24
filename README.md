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
        splash.setBackgroundImage(R.drawable.splashbg);
        
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

### Methods Description
| Methods | Description | Prameters | Import from |
| ------ | ------ | ------- | ------- |
| createDialog | creates a view for splash | context (MainActivity.this) | Splash |
| setBackgroundColor | sets background color on splash screen | string (Enter color hex code) | Splash |
| setBackgroundImage | sets background image on splash screen| Integer (Enter drawable)| Splash |
| setSplashHideAnimation | set animation for hide splash | CONSTANT (given for splash hide animation) | Splash |
| setSplashHideDelay | sets delay before splash hide | Integer (Enter value in milliseconds) | Splash |
| show | display splash and starts animations | none | Splash |


### Splash Hide Animation Constants 
| Animation | Description |
| ------ | ------ |
| DIALOGSLIDELEFT | hides splash while sliding to left.|
| DIALOGSLIDERIGHT | hides splash while sliding to right.|
| DIALOGFADE | hides splash with fade effect.|
| DIALOGSLIDEDOWN | hides splash while sliding to down.|

 
 
#### CreateImageObject available parameters

| Parameter | Description | Type |
| ------ | ------ | ------- |
| imageSource | drawable image that you need to add on splash screen| Integer(double) |
| height | height of image drawable| Double |
| width | width of image drawable| Double |
| positionX | position of image drawable on x-axis on splash screen| Double |
| positionY | position of image drawable on y-axis on splash screen| Double |
| scaleType | scaleType of image drawable. (possible options could be: FIT_XY, FIT_CENTER, FIT_END, FIT_START)| CONSTANTS (to be imported from CreateImageObject) |
| visibility | drawable image visiblity on splash screen initially. It will get visible as the animation on that image starts| Double |
| rotateDegree | drawabloe image initial rotate degree | Double |

#### Important Note

> add respective images from your drawable else it will give error
>
> for some variables which appears not defined like "screenHeight", import them from library class.
>



### Defining Animations

The animations you define works sequentially.
You can define animations of two types.

#### Type1 - Group Animation
You need to use group animation when you need to run two or more animations simultaneously.
Sample code for defining group animations:

```sh
AddGroupObject gObject1 = new AddGroupObject();
gObject1.add(addObject1, SLIDE, 980, 0f, 0f, -screenHeight * 0.2f, 0f,false, false);
gObject1.add(addObject2, SLIDE, 980, 0f, 0f, screenHeight * 0.2f, 0f,false, false);
```

#### Type2 - Single Animation
Single animation can be used to run an animation in sequence.

```sh
splash.animateSingleObject(addObject3, SCALE, 980, 0.2f, 1f, 0.2f, 1f,false,true);
splash.animateSingleObject(addObject4, SCALE, 980, 0.2f, 1f, 0.2f, 1f,false,true);
```

#### Define Animation before hiding splash
You can use animation on certain object to perform just befor hiding of splash
 ```sh
 splash.animateSingleObject(addObject4, SCALE, 980, 0.2f, 1f, 0.2f, 1f,false,true);
 ```
### Animation parameters description

| Parameter | Description | Type |
| ------ | ------ | ------- |
| object | object you created and placed on splash that you want to perform animation on| CreateImageObject |
| animationType | hieght of image drawble| Double |
| animationDuration | animation duration for specified animation| int |
| fromXDelta | if type is SLIDE, initial point at x-axis to start slide from | float |
| toXDelta | if type is SLIDE, final point at x-axis to end slide at| float |
| fromYDelta | if type is SLIDE, initial point at y-axis to start slide from | float |
| toYDelta | if type is SLIDE, final point at y-axis to end slide at| float |
| fromValue | if type is SCALE,FADE,ROTATE, final point at y-axis to end slide at| float |
| toValue | if type is SCALE,FADE,ROTATE, final point at y-axis to end slide at| float |

### Animation Types

| Animation | Description |
| ------ | ------ |
| SLIDE | slide image object to given x and y axis.|
| SCALE | scale image object starting from initial value to final value.|
| FADE | fade image object starting from initial value to final value. Value ranges from 0 - 1 (for fade in) or 1-0 (for fade out)|
| ROTATE | rotate image object starting from initial value to final value.|


<!-- ### Todos
We aim to make this package even more robust and powerful by adding following features in the upcoming releases:
 - implement ios

License
---- -->

MIT 
