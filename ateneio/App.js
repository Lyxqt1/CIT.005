import {ImageBackground, SafeAreaView, StyleSheet} from 'react-native';
import {useState} from "react";
import SplashScreen from "./src/screens/opening";
import HomeScreen from "./src/screens/home";
import {DarkTheme} from "@react-navigation/native";
import {Text, View} from "react-native";
const styles = StyleSheet.create({
    container: {
        flex: 1,
        alignItems: 'center',
        justifyContent: 'center',
        width: '100%'
    },
    button: {
        backgroundColor: '#21252b',
        color:"#5095b9",
        margin: 3,
        padding: 10, // add padding to the flex items
        alignItems: 'center',
        justifyContent: 'center',
        borderRadius:4
    },
    text:{
        color:"#5095b9",
        fontSize:26,
    }
});

export default function App() {
    const [showSplash, setShowSplash] = useState(true);
    const [showHome, setShowHome] = useState(false);
    const [playing, setPlaying] = useState(false);
    const pStyle = styles
    function handleSplashFinished() {
        // The splash screens have finished, so we can hide them and show the main app screen
        setShowSplash(false);
        setShowHome(true);
    }
    function handleClickPlay(){
        setShowHome(false);
        setPlaying(true);
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
                    <HomeScreen onPlaying={handleClickPlay} styles={pStyle} testing="yes"/>
                </SafeAreaView>
            </ImageBackground>
        )
    }else if(playing){
        return (
            <ImageBackground theme={DarkTheme}
                             source={require('./assets/ingame.jpg')}
                             style={{flex: 1, backgroundColor:'black'}}
            >
                <SafeAreaView style={styles.container}>

                </SafeAreaView>
            </ImageBackground>
        )
    }
    return (
        <SafeAreaView style={styles.container}>

        </SafeAreaView>
    );
}
