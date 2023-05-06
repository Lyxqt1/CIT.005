import {StatusBar} from 'expo-status-bar';
import {StyleSheet, Text, View, Image, SafeAreaView, Button, Alert} from 'react-native';
import {useEffect, useState} from "react";

export default function App() {
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
                <Text>MNU...</Text>
            </View>
        );
    } else if (showSplash2) {
        // Show the second splash screen
        return (
            <View style={{ flex: 1, justifyContent: 'center', alignItems: 'center' }}>
                <Text>Loading...</Text>
            </View>
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
