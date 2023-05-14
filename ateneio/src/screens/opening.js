// SplashScreen.js

import React, { useState, useEffect } from 'react';
import { View, Image } from 'react-native';
import {DarkTheme} from "@react-navigation/native";
function SplashScreen({ onSplashFinished }) {
    const [showSplash1, setShowSplash1] = useState(true);
    const [showSplash2, setShowSplash2] = useState(false);

    useEffect(() => {
        // Wait for 3 seconds, then show the second splash screen
        const timer1 = setTimeout(() => {
            setShowSplash1(false);
            setShowSplash2(true);
        }, 1500);

        // Wait for another 3 seconds, then hide the second splash screen
        const timer2 = setTimeout(() => {
            setShowSplash2(false);
            onSplashFinished(); // Call the onSplashFinished callback to notify the parent component
        }, 3000);

        // Clear the timeouts when the component unmounts
        return () => {
            clearTimeout(timer1);
            clearTimeout(timer2);
        };
    }, []);

    if (showSplash1) {
        // Show the first splash screen
        return (
            <View theme={DarkTheme} style={{ flex: 1, justifyContent: 'center', alignItems: 'center', backgroundColor:'#282c34' }}>
                <Image source={require('../../assets/whitelogo.png')} />
            </View>
        );
    } else if (showSplash2) {
        // Show the second splash screen
        return (
            <View theme={DarkTheme} style={{ flex: 1, justifyContent: 'center', alignItems: 'center',backgroundColor:'#282c34'}}>
                <Image source={require('../../assets/logo.png')} style ={{width:'90%', height:'90%'}} />
            </View>
        );
    }

    // If we get here, the splash screens have finished and we should render nothing
    return null;
}

export default SplashScreen;
