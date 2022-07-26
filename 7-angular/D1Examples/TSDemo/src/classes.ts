// We create classes using the class keyword and an instance of the class is created with the new keyword
// TS supports getters and setter to access and set class members, getter and setters are created
// by using the get and set keywords

// Animal class
class Animal{
    // Fields
    readonly name: string;
    private species: string;

    // Constructor
    constructor(name:string, species:string){
        this.name = name;
        this.species = species;
    }

    // Add in getters and setters

    get getSpecies(): string{
        return this.species;
    }

    set setSpecies(sp: string){
        this.species = sp;
    }

    // We can also create some methods
    move(feet:number):void{
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
class Dog extends Animal{
    bark():void{
        console.log("Arf arf");
    }

    move(feet:number):void{
        console.log(`The dog ran ${feet} feet`)
    }
}

let d = new Dog("Sadie", "Weimaraner")

d.bark();

d.move(50);


// We can also create abstract classes
abstract class Car{

    abstract drive():void;

    alarm():void{
        console.log("BEEEEEEEEEEEEEEEEEEEEEEEEEEEEP")
    }
}

class SportsCar extends Car{
    drive(): void {
        console.log("Vrooom")
    }
}

let sc = new SportsCar();

sc.drive();
sc.alarm();

// Interfaces allow us to create contracts that classes or objects must implement

interface User{
    username: string;
    password: string;
    phone?:number;
    login() : boolean;
}

let user1:User;

user1 = {
    username:'Steve',
    password: 'I mine blocks',
    phone: 1112223334,
    login: () => {return true}
}


let user2:User;

user2 = {
    username: 'Leroy',
    password: 'Jenkins',
    login: () => {return true}
}


class Example implements User{

    username: string;
    password: string;

    email:string;

    age:number = 0;

    constructor(username:string, password:string, email:string){
        this.username = username;
        this.password = password;
        this.email = email; 
    }

    
    login():boolean{
        return false;
    }
  
}



