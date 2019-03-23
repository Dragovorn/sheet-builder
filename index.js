(function() {

    "use strict";
    window.addEventListener("load", initialize);

    let NUMBOXES = 20;

    function initialize() {

        genBoxes();
    }


    function genBoxes() {
        let box = document.getElementById("box");
        for (let i = 0; i < NUMBOXES; i++) {
            console.log(i + " loops");
            let x = document.createElement("div");
            x.style = "height: " + randNum(100,200) + "px; width: " + randNum(200,400) + "px;";
            x.classList.add("block");
            console.log(x.style);
            box.appendChild(x);
        }
    }

    function randNum(a,b) {
        return Math.random()*(b-a) + a;
    }

})();