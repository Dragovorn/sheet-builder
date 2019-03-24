import React, { Component } from 'react';
import './Login.css';

let URL = "https://api.sheetbuilder.net/"

export default class Login extends Component {
  render() {
    return (
      <div className="Login">
        <SignIn></SignIn>
        <SignUp></SignUp>
      </div>
    )
  }
}

class SignIn extends Component {
  constructor(props) {
    super(props);
    this.state = {value: ''};

    this.handleChange = this.handleChange.bind(this);
    this.handleSubmit = this.handleSubmit.bind(this);
  }

  handleChange(event) {
    this.setState({value: event.target.value});
  }

  handleSubmit(event) {
    alert('Submitted: ' + this.state.value);
    event.preventDefault();
  }

  render() {
    return (
      <form className="SignIn" onSubmit={this.handleSubmit}>
        <h1>Sign In!</h1>
        <label>
          Email: 
          <input type="text" value={this.state.value} onChange={this.handleChange} />
        </label>
        <label>
          Password: 
          <input type="text" value={this.state.value} onChange={this.handleChange} />
        </label>
        <input type="submit" value="Submit" />
      </form>
    );
  }
}

class SignUp extends Component {
  constructor(props) {
    super(props);
    this.state = {value: ''};
    this.postSend = this.postSend.bind(this);
  }
  render() { 
    return (
      /* <form className="SignUp" action="https://api.sheetbuilder.net/accounts/create" method="post"> */
        <div className="SignUp">
        <h1>Sign Up!</h1>

        <label>First Name:</label>
        <input name="firstName" id="firstName"/>
        
        <label>Last Name: </label>
        <input name="lastName" id="lastName"/>

        <label>Email Address: </label>
        <input name="email" id="email"/>

        <label>Password: </label>
        <input name="password" id="password"/>

        {/* <input type="submit" value="Submit" /> */} 
        <button onClick={this.postSend}>Submit!</button>
        </div>
      //</form>
    );
    
  }

  postSend() {
    let params =  new FormData();
    params.append("firstName", document.getElementById("firstName").value);
    params.append("lastName", document.getElementById("lastName").value);
    params.append("email", document.getElementById("email").value);
    params.append("password", document.getElementById("password").value);
    let url = URL + "accounts/create";
    /* fetch(url, {method: "POST", body: params})
      .then(checkStatus)
      .then(JSON.parse)
      .then(response => console.log(response))
      .catch(response => console.log(response)); */

      var xhr = new XMLHttpRequest();
      xhr.open("POST", url, true);
      console.log("TEST!!!!");
      //Send the proper header information along with the request
      xhr.setRequestHeader("Content-Type", "application/x-www-form-urlencoded");

      xhr.onreadystatechange = function() { // Call a function when the state changes.
          if (this.readyState === XMLHttpRequest.DONE && this.status === 200) {
              // Request finished. Do processing here.
          }
      }
      xhr.send(params);
  }

}

function checkForError(response) {
  if (response[0].toLowerCase() == "error") {
    alert("ERROR!");
  }
}

function checkStatus(response) { 
  if (response.status >= 200 && response.status < 300 || response.status == 0) {  
    return response.text();
  } else {  
    return Promise.reject(new Error(response.status + ": " + response.statusText)); 
  }
}

