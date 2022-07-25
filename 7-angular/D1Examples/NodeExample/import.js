let greeting = require('./index.js');
// This is basically going to pull this in as an import file and allow us to utilize the function greeting

console.log(greeting('bob'));

// Besides utilizing import and export there are some cool built in packages that we can utilize with node
// One such package is the os package
let oss = require('os');

console.log(oss.totalmem());
console.log(oss.freemem());

// We can also use things like setTimeout and setInterval in node with global

global.setTimeout(()=>{
    console.log("Hello after 3 seconds")
}, 3000);

// We used npm init to create the package.json
// npm instaLL: will install any packages that are listed in the package.json
// npm install packagename: install a specific package
// npm install -g packagename: install a package gloablly
// npm install -D packagename: Install a package as a Dev Dependency