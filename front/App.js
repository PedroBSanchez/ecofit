import React, { useState, useEffect } from 'react';
import { Text, View, StyleSheet, Image, Button } from 'react-native';
import Constants from 'expo-constants';

// You can import from local files
import AssetExample from './components/AssetExample';
import Restaurant from './components/Restaurant';

// or any pure javascript modules available in npm
import { Card } from 'react-native-paper';
import axios from 'axios';

export default function App() {
  const apiUrl =
    'https://8081-lucascamposs-aulapubsub-ur545iskued.ws-us47.gitpod.io';

  const [restaurants, setRestaurants] = useState([
    {
      restaurantName: 'Salad Bowl',
      restaurantImageUrl: 'https://i.imgur.com/hsIyWOL.png',
      taxaEntrega: 4,
    },
    {
      restaurantName: 'frescalis',
      restaurantImageUrl: 'https://i.imgur.com/fuK8tft.png',
      taxaEntrega: 5,
    },
  ]);

  let restaurantsOpt = [];

  useEffect(() => {
    handleGet();
  }, []);

  const handleGet = () => {
    axios(`${apiUrl}/estabelecimento`, {
      method: 'GET',
      mode: 'no-cors',
      headers: {
        'Access-Control-Allow-Origin': '*',
        Accept: 'application/json',
        'Content-Type': 'application/json',
      },
    })
      .then((response) => {
        setRestaurants(response.data.content);
      })
      .catch((error) => {
        console.log(error.message);
      });
  };

  return (
    <View style={styles.container}>
      <View style={styles.topContainer}>
        <Image source={require('./assets/list.png')} style={styles.listIcon} />
        <View style={styles.textTopContainer}>
          <Text>Restaurantes na sua região</Text>
        </View>
      </View>
      <View style={styles.results}>6 Resultados</View>
      <View style={styles.allRestaurants}>
        <View style={(styles.saladBowl, styles.firstRestaurant)}>
          {restaurants.map((restaurant, index) => (
            <View style={styles.restaurantContainer}>
              <Restaurant
                key={index}
                restaurantName={restaurant.restaurantName}
                restaurantImageUrl={restaurant.restaurantImageUrl}
                taxaEntrega={restaurant.taxaEntrega}
              />
            </View>
          ))}
        </View>
      </View>
    </View>
  );
}

const styles = StyleSheet.create({
  container: {
    flex: 1,
    paddingTop: Constants.statusBarHeight,
    backgroundColor: '#F9F9F9',
    padding: 8,
  },

  topContainer: {
    flexDirection: 'row',
  },

  textTopContainer: {
    marginLeft: '20%',
  },

  listIcon: {
    height: '20px',
    width: '20px',
  },

  results: {
    marginTop: "20px",
    marginLeft: "40%",
  },
  allRestaurants: {
    marginTop: "30px",
    backgroundColor: "gray",
  },
  restaurantContainer: {
    marginTop: '15px',
  },
});
