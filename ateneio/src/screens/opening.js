// SplashScreen.js

import React, { useState, useEffect } from 'react';
import { View, Image } from 'react-native';

function SplashScreen({ onSplashFinished }) {
    const [showSplash1, setShowSplash1] = useState(true);
    const [showSplash2, setShowSplash2] = useState(false);

    useEffect(() => {
        // Wait for 3 seconds, then show the second splash screen
        const timer1 = setTimeout(() => {
            setShowSplash1(false);
            setShowSplash2(true);
        }, 3000);

        // Wait for another 3 seconds, then hide the second splash screen
        const timer2 = setTimeout(() => {
            setShowSplash2(false);
            onSplashFinished(); // Call the onSplashFinished callback to notify the parent component
        }, 6000);

        // Clear the timeouts when the component unmounts
        return () => {
            clearTimeout(timer1);
            clearTimeout(timer2);
        };
    }, []);

    if (showSplash1) {
        // Show the first splash screen
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Image source={require('../../assets/logo.png')} />
            </View>
        );
    } else if (showSplash2) {
        // Show the second splash screen
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Image source={require('../../assets/icon.png')} />
            </View>
        );
    }

    // If we get here, the splash screens have finished and we should render nothing
    return null;
}

export default SplashScreen;
