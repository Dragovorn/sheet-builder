(function() {

    "use strict";
    window.addEventListener("load", initialize);

    let NUMBOXES = 10;
    let BOB = {
        "name": "Bob",
        "health": 5,
        "details": {
            "backstory": "bob is cool",
            "alignment": "Lawful Good"
        },
        "class": "Dad",
        "race": "Human"
        
    };

    function initialize() {
        genBoxes();
    }


    function genBoxes() {
        let box = document.getElementById("box");
        

        console.log(BOB["details"]);
        for (let key in BOB) {
            let x = document.createElement("div");
            x.classList.add("block");
            let y = document.createElement("p");
            y.classList.add(key)
            box.appendChild(x);
        }
    }

    function randNum(a,b) {
        return Math.random()*(b-a) + a;
    }


})();