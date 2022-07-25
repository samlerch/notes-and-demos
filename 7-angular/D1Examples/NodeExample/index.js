console.log("Hello Node")

function greeting(name){
    return `My name is ${name}`;
}

console.log(greeting("bryan"))

// ES6 gave us modules
// Actually being able to use modules is a great feature of node
// Modules are essentially a unit of js code that is meant to be reused by exporting then importing

module.exports = greeting;