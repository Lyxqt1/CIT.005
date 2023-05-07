import {StatusBar} from 'expo-status-bar';
import {StyleSheet, Text, View, Image, SafeAreaView, Button, Alert} from 'react-native';
import {useEffect, useState} from "react";
import SplashScreen from "./src/screens/opening";

export default function App() {
    const [showSplash, setShowSplash] = useState(true);

    function handleSplashFinished() {
        // The splash screens have finished, so we can hide them and show the main app screen
        setShowSplash(false);
    }

    if (showSplash) {
        // Show the splash screen component
        return (
            <SplashScreen onSplashFinished={handleSplashFinished} />
        );
    }
    return (
        <SafeAreaView style={styles.container}>
            <Image
                source={{
                width: 200,
                height: 200,
                uri: "https://picsum.photos/200"}}/>
            <Text>enned!</Text>
            {HomeScreen()}
        </SafeAreaView>
    );
}


const HomeScreen = function (){
    return(
        <View>
            <Button title={'Play'}/>
            <View>
                <Button
                    title={'About'}
                    onPress={()=>
                Alert.alert("About","Atene.Io is a idle game which lorem ipsum")}
                />
                <Button title={'Help'}/>
            </View>
        </View>
    )
}
const styles = StyleSheet.create({
    container: {
        flex: 1,
        backgroundColor: '#fff',
        alignItems: 'center',
        justifyContent: 'center',
    },
});
