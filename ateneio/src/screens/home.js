import {Alert, Button, View, ImageBackground, StyleSheet, Pressable, Text} from "react-native";
import React from "react";
import {DarkTheme} from "@react-navigation/native";

function HomeScreen(props) {
    return (
            <View theme={DarkTheme}>
                <Pressable
                    onPress={props.onPlaying}
                    style={props.styles.button}
                >
                    <Text style={props.styles.text}>Play</Text>
                </Pressable>
                <View>
                    <Pressable
                        style={props.styles.button}
                        onPress={() =>
                            Alert.alert("About", "Atene.Io is a idle game which lorem ipsum")}
                    ><Text style={props.styles.text}>About</Text></Pressable>
                    <Pressable
                        style={props.styles.button}
                    >
                        <Text style={props.styles.text}>Help</Text>
                    </Pressable>
                </View>
            </View>
    )
}


export default HomeScreen