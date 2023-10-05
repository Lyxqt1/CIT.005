import {ImageBackground, SafeAreaView, StyleSheet} from 'react-native';
import {useState} from "react";
import SplashScreen from "./src/screens/opening";
import HomeScreen from "./src/screens/home";
import {DarkTheme} from "@react-navigation/native";
import {Text, View} from "react-native";
import {styles} from './styles'
import Playing from './src/screens/playing.js';

export default function App() {
    const [showSplash, setShowSplash] = useState(true);
    const [showHome, setShowHome] = useState(false);
    const [isPlaying, setIsPlaying] = useState(false);
    const pStyle = styles
    function handleSplashFinished() {
        // The splash screens have finished, so we can hide them and show the main app screen
        setShowSplash(false);
        setShowHome(true);
    }
    function handleClickPlay(){
        setShowHome(false);
        setIsPlaying(true);
    }
    if (showSplash) {
        // Show the splash screen component
        return (
            <SplashScreen onSplashFinished={handleSplashFinished} theme={DarkTheme} style={{backgroundColor:'black'}}/>
        );
    } else if (showHome) {
        return (
            <ImageBackground theme={DarkTheme}
                source={require('./assets/main_menu.jpg')}
                style={styles.container}
            >
                <SafeAreaView style={styles.container}>
                    <HomeScreen onPlaying={handleClickPlay} styles={styles} testing="yes"/>
                </SafeAreaView>
            </ImageBackground>
        )
    }else if(isPlaying){
        return (
            <ImageBackground theme={DarkTheme}
                             source={require('./assets/ingame.jpg')}
                             style={{flex: 1, backgroundColor:'black'}}
            >
                <Playing styles={styles}/>
            </ImageBackground>
        )
    }
    return (
        <SafeAreaView style={styles.container}>

        </SafeAreaView>
    );
}
