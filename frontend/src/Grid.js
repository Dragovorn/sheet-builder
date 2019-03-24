import React, { Component } from 'react';
import './Grid.css';

export default class Grid extends Component {
  render() {
    return (
      <div className="Grid">
        {this.genCards}
      </div>
    );
  }

  genCards() {
    for(let i = 0; i < 100; i++) {
      let card = <Card></Card>;
      
    }
  }
}

class Card extends Component {
  render() {
    return (
      <div className="Card"></div>
    );
  }
}
