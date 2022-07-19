// This is a single line comment

/* This is a multiline comment
*/

// We can start by printing to the console so we can see how information appears
console.log("Hello JavaScript");

/*
JavaScript Datatypes
Javascript is loosely typed sp you can the variables to any type that you want
*/

// Numbers

// Integers
var n1 = 21;
console.log(n1);

// Floating point
var n2 = 15.5;
console.log(n2);

// Exponential Notation
var n3 = 1.5e-4; // 1.5 * 10 ^ -4
console.log(n3);
var n4 = 1.5e4; // 1.5 * 10 ^ 4
console.log(n4);

// What happens when we do something like this?
var n5 = 6/0;
console.log(n5);

// There is also a number called bigInt which stores number larger that 2^53
var bigInt = 12345678901234567890n; // the n at the end denotes this as a big int

// Variable type switching
var a = 12;

console.log(a);

a = null;

console.log(a);

a = undefined;
// var a;

console.log(a);

// Strings 

a = "a String";

console.log(a);

// We can use single or double quotes for strings
var name = 'Spongebob';

var last = "Squarepants";

// console.log(name, last)

// Single quotes inside of a string
var c = "Let's go on an adventure"

// You can put quotes inside of strings
var d = 'He said "Hello" and then left';

// Or you can use escape quotes to make sure nothing goes wrong
var e = 'We\'ll never give up';

var g = 'He\'ll just say \"no\" or something'

console.log(name, last, c, d, e, g);

// Booleans can be true or false
var t = true;
var f = false;

// Objects in JS
// Follow the JSON (JavaScript Object Notation) format

var obj = {
    name: "Bryan",
    occupation: "Trainer",
    DaysWaitingForUPS: 5
}

console.log(obj);
// We can access the values inside of the object
// object.key notation

console.log('name: ', obj.name);

// object['key'] notation

console.log('DaysWaitingForUPS: ', obj['DaysWaitingForUPS']);

// We can also create a "blank" object with the constructor
var obj2 = new Object();

// The we can manually assign in two ways
obj2.name = 'Patrick';
obj2['last'] = 'Star';
console.log(obj2);

// Arrays
// You can create an array by predefining its indexes
var arr1 = ['Bob', 'Shirley', 'Tim'];

// You can also use the new keyword

var arr2 = new Array(1,2,3,4,5);

// You can also mix and match datatypes
var arr3 = ['Bob', false, 23, {name: 'Bob'}]

console.log(arr1);
console.log(arr2);
console.log(arr3);

// You can access indexes with bracket notations
console.log(arr3[0])

// You can add elements to the array at a given index
// We can also change the value at a given index
arr3[4] = 'new element';
arr3[1] = true;
console.log(arr3);

// You can also use the .push() method provided by the array abject to
// add elements at the end
arr3.push(53);
console.log(arr3);

// arr3[7] = "test element";
// console.log(arr3);

// console.log(typeof(arr3[6]));

// shift method will remove the first element of the array
arr3.shift();
console.log(arr3);


var arr4 = [100, 11, 13, 10];

arr4.sort();
console.log(arr4);

// indexOf and last IndexOF will search for an item in the array
console.log(arr4.indexOf(100));
arr4.push(11);
console.log(arr4.lastIndexOf(11));

var index = arr4.indexOf(11);
console.log(arr4.indexOf(11, index+1));




