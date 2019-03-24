import React, { Component } from 'react';
import './Grid.css';
export default class Grid extends Component {
  render() {
    return (
      <div className="Grid">
        <Card></Card>
      </div>
    );
  }
}

class Card extends Component {
  render() {
    return (
      <div className="Card"></div>
    );
  }
}
