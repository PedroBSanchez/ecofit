import * as React from 'react';

import { Text, View, StyleSheet, Image } from 'react-native';

import saladbowl from '../assets/saladbowl.png';
import frescalis from '../assets/frescalis.png';




export default function restaurant({restaurantName, taxaEntrega, restaurantImageUrl }) {
  return (
    <View style={styles.card}>
      <Image
          style={{ width: 70, height: 70 }}
          source={{ uri: restaurantImageUrl }}
        />
      <Text style={(styles.text, styles.textTittle)}>{restaurantName}</Text>
      <Text style={(styles.text, styles.textFrete)}>Frete: R${taxaEntrega},00</Text>
    </View>
  );
}

const styles = StyleSheet.create({
  card: {
    borderRadius: '20px',
    height: '212.41px',
    width: '156px',
    alignContent: 'center',
    justifyContent: 'center',
    textAlign: 'center',
    alignItems: 'center',
    backgroundColor: '#FFFFFF',
    shadowOffset: { width: 3, height: 6 },
    shadowColor: '#444',
    shadowOpacity: 0.5,
  },
  text: {
    fontFamily: 'Quicksand',
  },
  textTittle: {
    fontSize: '22px',
    fontFamily: 'Quicksand',
  },
  textFrete: {
    color: '#0A723A',
    fontSize: '17px',
    fontFamily: 'Quicksand',
  },
});