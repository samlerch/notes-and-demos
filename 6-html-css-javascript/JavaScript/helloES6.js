console.log("Hello ES6");

// Scopes
// Anything out here is going to be global
var sc1 = 'I am global scope';

// Anything inside of a block of code is local scope
function scopes(){
    var sc2 = 'I am functional scope';
    if (sc2){
        let sc3 = 'I am block scope';
    }

    // console.log(sc3);
}

scopes();

// Hoist a function

hoistEx();

function hoistEx(){
    console.log("I hoisted myself");
}

// Any variable without let or const will be hoisted out of block scope
function hoistVar(){
    if (1>0){
        var hoistMe = "I got hoisted out of the if block"
    }

    console.log(hoistMe);
}

hoistVar();

// We can create disembodied functions with the arrow notation since ES6
// A simple arrow function

var simpleArrow = () => console.log("Hello I am an arrow function");

simpleArrow();

var paramArrow = (num) => {
    console.log("We were given the number: ", num)
    console.log("The square of ", num, "is", num*num);
    return num*num;
}

var storage = paramArrow(3);

console.log(storage);

// We can refactor our paramArrow function with template literals

var template = (num) =>{
    console.log(`We were given the number ${num}`);
    console.log(`The square of ${num} is ${num*num}`);
}

template(3);

template(5);

// Another great thing about arrow functions is that they make great callback functions
/*
let squares = arr.map(function(n){
    return n*n;
})
*/

let arr = [1,2,3,4,5,6,7]

let squares = arr.map((n) => n*n);
console.log(squares);

