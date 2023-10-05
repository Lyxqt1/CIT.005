import {AsyncStorage, Image, SafeAreaView, Text, TouchableOpacity, View} from "react-native";
import React, {useEffect, useState} from "react";
import darkTheme from "@react-navigation/native/src/theming/DarkTheme";

export default function Playing(props) {
    const [currMoney, setCurrMoney] = useState('')
    useEffect(() => {
        retrieveData();
    }, []);

    const retrieveData = async () => {
        try {
            const data = await AsyncStorage.getItem('money');
            if (data !== null) {
                console.log('Retrieved data:', data);
                setCurrMoney(data)
            }
            return data
        } catch (error) {
            try {
                await AsyncStorage.setItem('money', '0');
                console.log('Data saved successfully!');
            } catch (error) {
                console.log('Error saving data:', error);
            }
        }
    };
    const saveData = async (newData) => {
        try {
            await AsyncStorage.setItem('money', newData.toString());
            console.log('Data saved successfully!');
        } catch (error) {
            console.log('Error saving data:', error);
        }
    };
    console.log(props.styles.money)
    const handleImagePress = async () => {
        // Handle image press action here
        const nowData = await retrieveData()
        let newData = parseInt(nowData, 10)
        newData += 1
        await saveData(newData)
        let current = await retrieveData()
        console.log({current});
    };
    return (
        <SafeAreaView style={props.styles.container} theme={darkTheme}>
            <SafeAreaView
                style={props.styles.money}
            >
                <Text style={props.styles.text}>${currMoney}</Text>
                <Text style={props.styles.text}>Level 1</Text>
            </SafeAreaView>
            <View styles={props.styles.container}>
                <TouchableOpacity activeOpacity={0.8} style={props.styles.touchable} onPress={handleImagePress}>
                    <Image source={require('../../assets/schoollvl1.png')} style={{
                        width: "75%",
                        height: "75%",
                        position: 'absolute',
                        bottom: '-10%'
                    }
                    }/>
                </TouchableOpacity>
            </View>

        </SafeAreaView>
    )
}
