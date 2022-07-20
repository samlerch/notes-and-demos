// Let's first take a look at creating a closure
const Book = function(t,a){
    let title = t;
    let author = a;

    return{
        summary: () => {
            console.log(`${title} written by ${author}`);
        }
    }
}

const book1 = new Book('HP and the sorceror\'s stone', 'J.K.Rowling');
book1.summary();

book1.t = 'HP and the chamber of secrets';
book1.summary();

// Let's take a look at pre js class inheritance
// This is the prototypical inheritance 

let animal = {
    eats: true,
    walk: () => {
        console.log('Animal walking!');
    }
}

console.log(animal)

// Let's create a child object
let rabbit = {
    jumps: true,
    __proto__: animal
}

console.log(rabbit)

console.log(rabbit.jumps);
console.log(rabbit.eats);

// Since ES6 we can now create classes as sort of templates for objects
class Animal{

    constructor(name){
        this.name = name
    }

    static breath(){
        console.log('Breathes')
    }

    speak(){
        console.log(`Hello my name is ${this.name}`)
    }
}


// Inherit the animal class

class Cat extends Animal{
    constructor(name, color){
        super(name);
        this.color = color
    }

    // We can also override methods
    speak(){
        console.log('Meow')
    }
}

let a2 = new Animal('Dog');
console.log(a2);
a2.speak();
Animal.breath();

console.log(a2 instanceof Animal);
console.log(a2 instanceof Cat);

let cat = new Cat('Tigger', 'Orange');
console.log(cat);
cat.speak();
Cat.breath();

console.log(cat instanceof Cat);
console.log(cat instanceof Animal);

