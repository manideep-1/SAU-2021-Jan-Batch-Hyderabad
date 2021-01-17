import React, { Component } from 'react'

import {Stylesheet,SafeAreaView,FlatList, ScrollView,TouchableOpacity, View, Text, StatusBar, Image} from 'react-native';
export default class index extends Component {
    constructor(props) {
        super(props)
        this.Mid = this.props.route.params.Mid;
        console.log(this.Mid);
        this.state = {
            // 'movieId':this.Mid,
            isLoading: true,
            item:{}
        };
        // this.state = {
        //      item:{"adult":false,
        //      "backdrop_path":"/srYya1ZlI97Au4jUYAktDe3avyA.jpg",
        //      "genre_ids":[14,28,12],
        //      "id":464052,
        //      "original_language":"en",
        //      "original_title":"Wonder Woman 1984",
        //      "overview":"Wonder Woman comes into conflict with the Soviet Union during the Cold War in the 1980s and finds a formidable foe by the name of the Cheetah.",
        //      "popularity":3342.686,
        //      "poster_path":"/8UlWHLMpgZm9bx6QYh0NFoq67TZ.jpg",
        //      "release_date":"2020-12-16",
        //      "title":"Wonder Woman 1984",
        //      "video":false,
        //      "vote_average":7.2,
        //      "vote_count":2641}
        // }
    }
    async getApi(){
        let fetchUrl="https://api.themoviedb.org/3/movie/"+this.Mid+"?api_key=2f5f4b92c5bf9a11b168797aa7a7491b"
        console.log(fetchUrl);
        try{
            let response = await fetch(fetchUrl);
            let json = await response.json();
            // return json = {...json, 'isValid':true};
            this.setState({
                item:json
            })
        }catch(error){
            console.log(error);
            // return {'isValid':false};
        }
    }
    componentDidMount(){
        this.getApi();
    }
    render() {
        return (
            <ScrollView>
            <View style={{
                flex:1,
                backgroundColor:'#fff',
                alignItems:'center',
                justifyContent:'center',
                marginHorizontal:'7%',
                marginVertical:20,
                paddingBottom:100,
            }}>
                {/* <Text>{this.Mid}</Text> */}
                
                <View style={{ width:'100%', height:200, borderRadius:6, elevation:1, }}>
                <Image source={{uri:'https://image.tmdb.org/t/p/w500/'+this.state.item.backdrop_path}} 
                style = {{ width: '100%', height: '100%', borderRadius:25, justifyContent:'flex-start' }}
                />
                 </View> 
                 
                <View>
                    <Text style={{fontSize:30, fontWeight:'500'}}>{this.state.item.title}</Text>
                </View>

                <Text></Text>
                <View>
                    <Text style={{fontSize:15, padding:5 ,fontWeight:'200'}}>Overview:{this.state.item.overview}</Text>
                </View>
                <Text></Text>
                <View style={{flex:1,justifyContent:'center',alignContent:'center', marginTop:10, paddingHorizontal:5, paddingVertical:10, height:30}}>
                    <Text style={{ fontSize:15 ,fontWeight:'300', paddingHorizontal:15, paddingVertical:10 , backgroundColor:'#FF5733',color:'white', borderRadius:8 }} >
                        Release Date : {this.state.item.release_date} {'     '}
                        
                        </Text>
                </View>
                <Text></Text>
                {/* <View style={{flex:1,justifyContent:'center',alignContent:'center', marginTop:10, paddingHorizontal:5, paddingVertical:10, height:30}}>
                    <Text style={{ fontSize:15 ,fontWeight:'300', paddingHorizontal:15, paddingVertical:10 , backgroundColor:'#FF5733',color:'white', borderRadius:8 }} >
                        <FlatList
                    data={this.state.item.genre} 
                    horizontal = {true}
                    showsHorizontalScrollIndicator = {true}
                    keyExtractor={(item,index)=>index.toString()}
                    renderItem={ ({item,index}) => ( <Text style={{ fontSize:17, padding:5, fontWeight:'200'}}>{' '+item.name} </Text> )} 
                />
                </Text>
                </View>
                <Text></Text> */}
                <View style={{flex:1,justifyContent:'center',alignContent:'center', marginTop:10, paddingHorizontal:5, paddingVertical:10, height:30}}>
                    <Text style={{ fontSize:15 ,fontWeight:'300', paddingHorizontal:15, paddingVertical:10 , backgroundColor:'#FF5733',color:'white', borderRadius:8 }} >
                        
                        RunTime : {this.state.item.runtime} mins
                        </Text>
                </View>
                <Text></Text>
                
                <View style={{flex:1,justifyContent:'center',alignContent:'center', marginTop:10, paddingHorizontal:5, paddingVertical:10, height:30}}>
                    <Text style={{ fontSize:15 ,fontWeight:'300', paddingHorizontal:15, paddingVertical:10 , backgroundColor:'#FF5733',color:'white', borderRadius:8 }} >
                        Language : {this.state.item.original_language}
                    </Text>
                </View>
                <Text></Text>
                <Text></Text>
                <View style={{flex:1,justifyContent:'center',alignContent:'center', marginTop:10, paddingHorizontal:5, paddingVertical:10, height:30}}>
                    <Text style={{ fontSize:15 ,fontWeight:'300', paddingHorizontal:15, paddingVertical:10 , backgroundColor:'#FF5733',color:'white', borderRadius:8 }} >
                        Rating : {this.state.item.vote_average}/10 &nbsp;({this.state.item.vote_count} votes)
                </Text>
                <Text></Text>
                <Text></Text>
                </View>
                <View style={{flex:1,justifyContent:'center',alignContent:'center', marginTop:10, paddingHorizontal:5, paddingVertical:10, height:30}}>
                    <Text style={{ fontSize:15 ,fontWeight:'300', paddingHorizontal:15, paddingVertical:10 , backgroundColor:'#FF5733',color:'white', borderRadius:8 }} >
                        Popularity : {this.state.item.popularity}</Text>
                </View>
                
            </View>
            </ScrollView>
            
        )
    }
}
// const styles=Stylesheet.create({
//     container:{
        // flex:1,
        // backgroundColor:'#fff',
        // alignItems:'center',
        // justifyContent:'center'
//     }
// })