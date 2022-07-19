console.log("Hello Functions");

// Let's take a look at == vs ===

var a = '23';
var b = 23;
var c = 23;

console.log(b === c);

console.log(b === a);

console.log(b == a);

// Let's take a look at truthy vs falsy

if (a){
    console.log("truthy");
} else{
    console.log("falsy");
}

// Let's look at a simple function that uses an if statement
function simpleIf(){
    if (5>6){
        console.log("yay");
    } else {
        console.log('boo');
    }
}

simpleIf();

// A function that uses a simple if else statement
function simpleElseIf(num){
    if (num < 0){
        console.log("Num is negative")
    } else if (num > 0){
        console.log("Num is positive")
    } else{
        console.log("Num is zero")
    }
}

simpleElseIf(-73);

// Let's create a function with a simple for loop inside
var arr = [1,2,3,4,5,6,7]

function sumOfArray(){
    var sum = 0;
    for (i = 0; i<arr.length; i++){
        sum += arr[i];
    }

    return sum;
}

console.log('The sum of the array is ', sumOfArray());

// A simple while loop
var num = 0;
while(num < 10){
    console.log(num);
    num++;
}

// Value of num is 10 at this point 

// A simple do while loop
do {
    console.log(num);
    num++;
} while (num <= 9) // Since this return false, we stop here

// There are some new loops that you have not seen yet
// For of loops are used for arrays and array like objetcs
for(num of arr){
    console.log(num);
}

// For in loops are used to access the keys of an object
var obj = {name: "bobo", age: 8};

for(property in obj){
    console.log(property + " : " + obj[property])
}

// Some more function stuff
// We can assign the return values of a function to a variable
function add(num1, num2){
    return num1 + num2;
}

var answer = add(10, 34);
console.log(answer);

// Functions can be directly assigned to variables as anon functions
var coolFunction = function(){
    console.log("I am anonymous");
}

coolFunction();

// Callback functions are used everywhere, Array methods like find(), map(), filter() and reduce()
// alll use callback functions to operate on data

// Array find returns the first element that satisfies the callback function
// Return the first number that it finds greater than 2
var greaterThan = arr.find(function(n){
    return n > 2; // Find will return the first element that satisfies this condition
});

console.log(greaterThan);

// Array.filter() works similarly to find()
// This one will returm an array with all the numbers greater than 3
var greaterThanFilter = arr.filter(function(n){
    return n > 3;
});

console.log(greaterThanFilter);

// Array.map() takes a callback and returns a new array that is the result of call the 
// callback function on the current element of the array

var squares = arr.map(function(n){
    return n*n;
});

console.log(squares);

// Default Parameters

function defaultParams(a, b=1){
    return a*b;
}

console.log('Inputting two parameters', defaultParams(2,3));

console.log('Inputting one parameter:', defaultParams(4));

// IIFE (Immediately invoked function expression)
(function(num){
    console.log("I am self invoked");
    console.log(num);
    // I could be doing other things here
})(5);

