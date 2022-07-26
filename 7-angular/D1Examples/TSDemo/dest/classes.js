"use strict";
// We create classes using the class keyword and an instance of the class is created with the new keyword
// TS supports getters and setter to access and set class members, getter and setters are created
// by using the get and set keywords
// Animal class
class Animal {
    // Constructor
    constructor(name, species) {
        this.name = name;
        this.species = species;
    }
    // Add in getters and setters
    get getSpecies() {
        return this.species;
    }
    set setSpecies(sp) {
        this.species = sp;
    }
    // We can also create some methods
    move(feet) {
        console.log(`The animal ${this.name} moved a total of ${feet} feet`);
    }
}
// Create a new instance of this class
let an = new Animal("Perry", "Platypus");
an.move(5);
// Instead of using our mutators (getters and setters) as methods, we actually
// set them like properties
// In java it would look like "an.setSpecies("Dog")"
an.setSpecies = 'Dog';
console.log(an.getSpecies);
// name is readonly so we cannot change it once it is set in the constructor
// an.name = "peri";
// Implement inheritance through the extends keyword
class Dog extends Animal {
    bark() {
        console.log("Arf arf");
    }
    move(feet) {
        console.log(`The dog ran ${feet} feet`);
    }
}
let d = new Dog("Sadie", "Weimaraner");
d.bark();
d.move(50);
// We can also create abstract classes
class Car {
    alarm() {
        console.log("BEEEEEEEEEEEEEEEEEEEEEEEEEEEEP");
    }
}
class SportsCar extends Car {
    drive() {
        console.log("Vrooom");
    }
}
let sc = new SportsCar();
sc.drive();
sc.alarm();
let user1;
user1 = {
    username: 'Steve',
    password: 'I mine blocks',
    phone: 1112223334,
    login: () => { return true; }
};
let user2;
user2 = {
    username: 'Leroy',
    password: 'Jenkins',
    login: () => { return true; }
};
class Example {
    constructor(user) {
        this.user = user;
    }
    get getUser() {
        return this.user;
    }
}
let ex = new Example(user1);
console.log(ex.getUser);
