let bubbleElements = document.getElementsByClassName('bubble');
console.log(bubbleElements);

for(el of bubbleElements){
    el.addEventListener('click', bubble);
    el.addEventListener('click', viewTarget);
    el.addEventListener('click', stopProp)
}

function bubble(){
    alert(`Bubbling ${this.tagName}`)
}

let captureElements = document.getElementsByClassName('capture')
for (el of captureElements){
    el.addEventListener('click', capture, true);
    el.addEventListener('click', stopProp, true);
}

function capture(){
    alert(`Captured ${this.tagName}`)
}

// We can also view the target from the event
function viewTarget(event){
    console.log(event.target);
}

// We can also stop propogation to prevent this bubbling or capturing
function stopProp(event){
    event.stopPropagation();
}

// Let's create the function printPressed otherwise chrome gets mad at us
function printPressed(event){
    console.log(`Key pressed in the username field: ${event.key}`)
}

// Let's add an event listener to the password input
let passwordField = document.getElementById('password');
passwordField.addEventListener('keydown', passwordPress);

function passwordPress(event){
    console.log(`Key pressed in the password field: ${event.key}`);
}

// If we want to do some custom logic before sending out data away,
// we can prevent the form from doing its default action like so

let login = document.getElementById('form');
login.addEventListener('submit', submitForm)

function submitForm(event){
    event.preventDefault();
    // We could do some form logic here (maybe send a post request at some point with this info)
    console.log("We are preventing the default functionality of the form");
    console.log(`The username entered was ${document.getElementById('username').value}`);
    console.log(`The username entered was ${document.getElementById('password').value}`);
    login.reset();
}