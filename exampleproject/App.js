/**
 * Sample React Native App
 * https://github.com/facebook/react-native
 *
 * @format
 * @flow strict-local
 */

import React from 'react';
import {
  StyleSheet,
  View,
  Text,
  Image,
} from 'react-native';

import splash from './Splash';

class App extends React.Component {
  componentDidMount() {
    splash.hide()
  }
  render() {
    return (
      <View style={styles.background}>
        <Image source={require('./src/assets/images/logo.png')} style={{height:150,width:150, marginTop:100,resizeMode:"contain"}}/>
      <Text style={styles.text}>WELCOME TO MUSIC</Text>
      <View style={styles.button}>
      <Text style={styles.buttonText}>LOGIN</Text>

        </View>

      </View>

    )
  }
}

const styles = StyleSheet.create({
 
  background: {
    backgroundColor: "rgba(16,16,16,0.94)",
    flex:1,
    alignItems:"center",
  },
  text:{
    marginTop:60,
    color:"#FFF",
    fontSize:20,
    fontWeight:"bold"
  },
  button:{
    width:180,
    marginTop:60,
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

});

export default App;
