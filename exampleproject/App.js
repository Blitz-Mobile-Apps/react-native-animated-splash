/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  SafeAreaView,
  StyleSheet,
  ScrollView,
  View,
  Text,
  Image,
  StatusBar,
  Button,
  TouchableHighlight,
  ImageBackground,
  TextInput,
} from 'react-native';

import {
  Header,
  LearnMoreLinks,
  Colors,
  DebugInstructions,
  ReloadInstructions,
} from 'react-native/Libraries/NewAppScreen';
import AnimatedSplash from "react-native-animated-splash";
class App extends React.Component {
  componentDidMount() {
    AnimatedSplash.hide()
  }
  render() {
    return (
      <View style={styles.background}>
        <View style={styles.header}>
        {/* <Image source={require('./src/assets/images/menu.png')} style={{height:25,width:30, resizeMode:"contain",left:25,top:30,position:"absolute"}}/> */}

        <Image source={require('./src/assets/images/logo2.png')} style={{height:140,width:140, resizeMode:"contain"}}/>
        </View>
      <View style={styles.subview}>
      <Text style={styles.text}>WELCOME TO MUSIC</Text>
      <TextInput style={styles.input}
      placeholderTextColor="#CBCBCB"
      placeholder="Enter email"
      />
       <TextInput style={styles.input}
      placeholderTextColor="#CBCBCB"
      placeholder="Enter password"
      />
      <View style={styles.button}>
      <Text style={styles.buttonText}>LOGIN</Text>
      </View>
        </View>

      </View>
      // <ImageBackground style={styles.background2} source={require('./src/assets/images/splashbg.png')}>
      //   <Image source={require('./src/assets/images/logo2.png')} style={{height:150,width:150, marginTop:100,resizeMode:"contain"}}/>
      // <Text style={styles.text}>WELCOME TO KATTY</Text>
      // <View style={styles.button2}>
      // <Text style={styles.buttonText}>LOGIN</Text>

      //   </View>

      // </ImageBackground>
    //   <View style={styles.background}>
    //   <View style={styles.header2}>
    //   {/* <Image source={require('./src/assets/images/menu.png')} style={{height:25,width:30, resizeMode:"contain",left:25,top:30,position:"absolute"}}/> */}

    //   <Image source={require('./src/assets/images/logo2.png')} style={{height:140,width:140, resizeMode:"contain"}}/>
    //   </View>
    // <View style={styles.subview}>
    // <Text style={styles.text}>WELCOME TO KATTY</Text>
    // <TextInput style={styles.input}
    // placeholder="Enter email"
    // />
    //  <TextInput style={styles.input}
    // placeholder="Enter password"
    // />
    // <View style={styles.button2}>
    // <Text style={styles.buttonText}>LOGIN</Text>
    // </View>
    //   </View>

    // </View>
    )
  }
}

const styles = StyleSheet.create({
  header:{
    backgroundColor:"#007D94",
    width:"100%",
    alignItems:"center",
    justifyContent:"center",
    height:230,
    borderBottomEndRadius:50,
    borderBottomStartRadius:50,
  },
  header2:{
    backgroundColor:"#33C1B2",
    width:"100%",
    alignItems:"center",
    justifyContent:"center",
    height:230,
    borderBottomEndRadius:45,
    borderBottomStartRadius:45,
  },
  background: {
    backgroundColor: "#FFF",
    flex:1,
    alignItems:"center",
    // justifyContent:"center"
  },
  subview:{
    width:"90%",
    alignItems:"flex-start"
  },
  text:{
    marginTop:40,
    color:"#333333",
    fontSize:18,
    fontWeight:"bold",
   
  },
  input:{
    borderColor:"#CCC",
    borderWidth:1,
    width:"100%",
    fontSize:14,
    marginTop:30,
    borderRadius:4,
    paddingHorizontal:10,
    paddingVertical:10
  },
  button:{
    width:180,
    marginTop:40,
    paddingVertical:16,
    paddingHorizontal:8,
    borderRadius:4,
    elevation:3,
    alignItems:"center",
    justifyContent:"center",
    backgroundColor:"#007D94"
  },
  buttonText:{
    color:"#FFF",
    fontSize:15,
    fontWeight:"bold"
  },
  button2:{
    width:180,
    marginTop:40,
    paddingVertical:16,
    paddingHorizontal:8,
    borderRadius:4,
    elevation:3,
    alignItems:"center",
    justifyContent:"center",
    backgroundColor:"#33C1B2"
  },
  background2: {
    flex:1,
    alignItems:"center",
    // justifyContent:"center"
  },
});

export default App;
