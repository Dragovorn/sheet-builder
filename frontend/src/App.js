import React, { Component } from 'react';
import './App.css';
import Grid from './Grid';
import Login from './Login';
import Home from './Home';
import ReactDOM from 'react-dom';

class App extends Component {
  render() {
    return (
      <div className="Main">
        <NavBar></NavBar>
        <div id="Page"></div>
      </div>
      
    );
  }
}

class NavBar extends Component {
  render() {
    return (
        <div className="NavBar">
          <p>Sheet Builder</p>
          <button onClick={this.goToHome}>Home</button>
          <button onClick={this.goToGrid}>Grid</button>
          <button onClick={this.goToLogin}>Login and Sign Up</button>
        </div>
    );
  }

  goToGrid() {
    const grid = <Grid></Grid>;
    ReactDOM.render(grid, document.getElementById('Page'));
  }
  
  goToHome() {
    return 5;
  }
  
  goToLogin() {
    const login = <Login></Login>;
    ReactDOM.render(login, document.getElementById('Page'));
  }
}



class Page extends Component {
  render() {
    return (
      <div className="Page"></div>
    );
  }
}

export default App;
