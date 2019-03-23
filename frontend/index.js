(function() {

    "use strict";
    window.addEventListener("load", initialize);

    let NUMBOXES = 10;

    function initialize() {

        genBoxes();
    }


    function genBoxes() {
        let box = document.getElementById("box");
        for (let i = 1; i <= NUMBOXES; i++) {
            //let width = prompt("width "+i+":");
            //let height = prompt("height "+i+":");
            let x = document.createElement("div");
            x.style = "grid-column: span "+ parseInt(randNum(1,4))+"; grid-row: span "+ parseInt(randNum(1,4))+";";
            x.classList.add("block");
            box.appendChild(x);
            
        }
    }

    function randNum(a,b) {
        return Math.random()*(b-a) + a;
    }

})();