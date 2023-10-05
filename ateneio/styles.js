import {StyleSheet} from "react-native";
export const styles = StyleSheet.create({
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
    },
    money:{
        backgroundColor:"rgba(0,0,0,0.51)",
        position:'absolute',
        top:30,
        width:"100%",
        flex: 1,
        flexDirection:'row',
        justifyContent:"space-around"
    },
    touchable:{
            flex: 1,
            alignItems: 'center',
            justifyContent: 'center',
            width: '100%'
    }
});
