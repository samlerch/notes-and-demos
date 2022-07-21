# Demo Course Enrollment System

The goal for today is to create a fullstack application that will emulate a basic course enrollment system. This means
that we'll have some amount of users and courses that those users can enroll in. We should be able to enroll in courses and view our user profile. Today will be focused on development and then we'll deploy tomorrow (probably)

## User Stories

- As a user I can create an account
- As a user I can login into my account
- As a user I can view all courses (whether I'm logged in or not)
- As a user I should be able to enroll in available courses when logged in
- As a user I should be able to create/maintain a user profile page

# The thought Process
As I go through this demo I'll detail my thought process for creating this application. The first thing I generally do is plan my models and then attempt to "big picture" my controllers and work down from there when I'm constructing my backend.

Thinking through this, I think I need two major models: Courses and Users. 

## Courses
When thinking about my courses, this could have any number of pieces of information. But to keep it simple, we'll break it down into 
- Course Number (like MATH101, READ202, etc.)
- Course Name (Intro to Math, Learning to Read, etc.)
- A slightly longer description perhaps ("Learning the basics of mathematics", "developing reading with short stories")
- Number of Available Seats (generally when you register for a course, they don't want it to be overbooked so there is a limit on how many students can join a course)

## Users
I imagine a user will have some basic information that is generally required for most websites. This may include things like 

- First Name
- Last Name
- Username
- Password
- Email
- List of Courses

### Additional things to consider
Since I plan to use Spring Data I'll want to add some primary keys as well as making sure to utilize a many to many relationship for my list of courses

# Setting up my Spring Boot project
Time to consider the dependencies I may want to add for my spring boot project. I know for a fact I'll want Spring Web, Data, and Project Lombok. I may also want the devtools for auto restarting and I should probably add in the postgres driver as well. If I wanted to, I could also implement validation and maybe Spring Security, though I imagine I'll save those for another time

## Models

Now that I have my project ready I can make a models package and add in my models. In the end I had classes that looked like this:

### Course

```java
package com.revature.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "courses")
public class Course {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String courseNum;
	
	private String name;
	
	private String description;
	
	private int availableSeats;

	public Course(String courseNum, String name, String description, int availableSeats) {
		super();
		this.courseNum = courseNum;
		this.name = name;
		this.description = description;
		this.availableSeats = availableSeats;
	}
	
	

}

```

### User

```java
package com.revature.models;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;
	
	private String first;
	
	private String last;
	
	private String username;
	
	private String password;
	
	private String email;

	@ManyToMany
	private List<Course> courses;

	public User(String first, String last, String username, String password, String email, List<Course> courses) {
		super();
		this.first = first;
		this.last = last;
		this.username = username;
		this.password = password;
		this.email = email;
		this.courses = courses;
	}

	public User(String first, String last, String username, String password, String email) {
		super();
		this.first = first;
		this.last = last;
		this.username = username;
		this.password = password;
		this.email = email;
	}
	
	

}
```

# Next Phase of Planning
From here I could work from the bottom up (Data layer, Service Layer, Controller Layer) but for this instance I think it may be more advantageous to go from the top down. By doing this I can consider exactly what endpoints I want and then can think of the building blocks I need for those pieces.

Starting with my course controller I'll need endpoints for
- Getting All Courses
- Posting a New Course
- Getting all available courses
- Other helpful endpoints for future implementations:
    - Getting a specific course
    - Update Course
    - Delete Course

From here it's easy to chunk my methods into things I'll need in my service layer:
- Finding All Courses
- Adding a Course
- Updating a course
- Deleting a course
- Finding a course by id
- Finding a course by courseNum (incase id decides to be finicky)
- Finding all the available courses

All that leaves is the data layer, by looking at my service methods I can tell that the first 5 can be done with basic operations already provided to us by Spring Data so that means I only need methods stubs for the following in my data layer:

- Finding a course by courseNum
- Finding all available courses (This means available seats > 0)

Thus, now that I've planned from the top down, I construct from the bottom up, remembering to add my stereotype annotations as well as anything else I may need

## Course Repo

```java
package com.revature.data;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.revature.models.Course;

@Repository
public interface CourseRepository extends JpaRepository<Course, Integer> {
	
	@Query("FROM Course WHERE availableSeats > 0")
	public List<Course> getAvailableCourses();
	
	public Course getByCourseNum(String courseNum);

}

```

## Course Service

```java
package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.CourseRepository;
import com.revature.models.Course;

@Service
public class CourseService {
	
	@Autowired
	CourseRepository cr;
	
	public Course add(Course c) {
		return cr.save(c);
	}
	
	public boolean delete(Course c) {
		cr.delete(c);
		return(cr.existsById(c.getId()) ? false : true);
	}
	
	public Course update(Course c) {
		return cr.save(c);
	}
	
	public List<Course> findAll(){
		return cr.findAll();
	}
	
	public Course findById(int id) {
		return cr.getReferenceById(id);
	}
	
	public List<Course> getAllAvailable(){
		return cr.getAvailableCourses();
	}
	
	public Course getByCourseNum(String courseNum) {
		return cr.getByCourseNum(courseNum);
	}

}

```

## Course Controller

```java
package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.Course;
import com.revature.services.CourseService;

@RestController
@RequestMapping("courses")
@CrossOrigin("*")
public class CourseController {
	
	@Autowired
	CourseService cs;
	
	@PostMapping
	public Course addCourse(@RequestBody Course c) {
		return cs.add(c);
	}
	
	@GetMapping
	public List<Course> getAllCourses(){
		return cs.findAll();
	}
	
	@GetMapping("available")
	public List<Course> getAllAvailableCourses(){
		return cs.getAllAvailable();
	}
	
	@GetMapping("{courseNum}")
	public Course getCourse(@PathVariable("courseNum") String courseNum) {
		
		return cs.getByCourseNum(courseNum);
	}
	
	@PutMapping
	public Course update(@RequestBody Course c) {
		return cs.update(c);
	}
	
	@DeleteMapping
	public boolean delete(@RequestBody Course c) {
		return cs.delete(c);
	}
 
}

```

Don't worry too much about the CrossOrigin annotation for now, it's to prevent some problems we'll run into later

## Users
With Users I can do a similar thing as courses. So starting at the controller layer I'll need endpoints for
- Creating a new user
- Getting a specific user (by username)
- Login
- Enroll
- Other helpful endpoints could be
    - Getting all users
    - Updating a user
    - Deleting a user

Thus this relies on the service layer. Now this one is slightly more complicated because when I enroll I have to be cognizant of the fact that I will also need to update the course in some capacity {removing 1 from the available seats and also pulling the course from the repo}. This means I'll need these methods in the service layer
- Add
- Update
- Delete
- FindAll users
- GetByUsername
- Login
- Enroll

Note that the actual logic for enrolling and logging in will be done in my service layer, not my controller layer. The controller's job is simply to handle the interactions with HTTP requests where the logic for what to do with the information extracted happens in the service layer. Finally, we can start considering how we want to handle our data layer. Most of these are just basic crud operations with the exclusion of getByUsername. Note that we can do enroll and login utilizing getByUsername and some other basic crud methods meaning the only method we need to have in our service layer is 

- GetByUsername

Now this is the time where we can start playing around with some backend data validation like adding in optionals and some exceptions to print out custom error messages and then we can utilize reponseEntities on the front end to deal with all the fuss that comes with status codes and the like, but for simplicity we're going to avoid that for now, maybe we'll refactor later.

Thus, time for construction from the bottom up

## User Repo

```java
package com.revature.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.revature.models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer>{
	
	public User getByUsername(String username);

}

```

## User Service

```java
package com.revature.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.revature.data.CourseRepository;
import com.revature.data.UserRepository;
import com.revature.models.Course;
import com.revature.models.User;

@Service
public class UserService {
	
	@Autowired
	UserRepository ur;
	
	@Autowired
	CourseRepository cr;
	
	public List<User> findAll(){
		return ur.findAll();
	}
	
	public User add(User u) {
		return ur.save(u);
	}
	
	public User update(User u) {
		return ur.save(u);
	}
	
	public boolean delete(User u) {
		ur.delete(u);
		return (ur.existsById(u.getId()) ? false : true);
	}
	
	public User getByUsername(String username) {
		return ur.getByUsername(username);
	}
	
	public User login(String username, String password) {
		User u = ur.getByUsername(username);
		
		if (u == null || (!u.getPassword().equals(password))){
			return null;
		}
		
		return u;
	}
	
	public User enroll(int id, String courseNum) {
		User u = ur.findById(id).get();
		Course c = cr.getByCourseNum(courseNum);
		
		for (Course course : u.getCourses()) {
			if (course.equals(c)) {
				return null;
			}
		}
		
		if (c.getAvailableSeats()>=1) {
			List<Course> courses = u.getCourses();
			courses.add(c);
			u.setCourses(courses);
			c.setAvailableSeats(c.getAvailableSeats() - 1);
			cr.save(c);
			ur.save(u);
		}
		
		return u;
	}

}

```

## User Controller

```java
package com.revature.controller;

import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.models.User;
import com.revature.services.UserService;

@RestController
@RequestMapping("users")
@CrossOrigin("*")
public class UserController {
	
	static String sessionId = "";

	@Autowired
	UserService us;
	
	@GetMapping
	public List<User> getAll(){
		return us.findAll();
	}
	
	@PostMapping
	public User createNewUser(@RequestBody User u) {
		return us.add(u);
	}
	
	@PutMapping
	public User updateUser(@RequestBody User u) {
		return us.update(u);
	}
	
	@DeleteMapping
	public boolean deleteUser(@RequestBody User u) {
		return us.delete(u);
	}
	
	@GetMapping("{username}")
	public User getUser(@PathVariable("username") String username) {
		return us.getByUsername(username);
	}
	
	@PostMapping("login")
	public ResponseEntity<User> login(@RequestBody LoginObj loginObj) {
		
		
		User u = us.login(loginObj.username, loginObj.password);
		if(u == null) {
			return null;
		}
		return new ResponseEntity<User>(u, HttpStatus.OK);
	}
	
	@PostMapping("enroll/{courseNum}")
	public User enrollUser(@PathVariable("courseNum") String courseNum, @RequestHeader("userId") int id) {
		User u = us.enroll(id, courseNum);
		return u;
		
	}
}
class LoginObj{
	public String username;
	public String password;
}

```

Make sure you noticed I created the additional class at the bottom to call upon for my login endpoint

## Setting Up Application.properties
At this point the backend is almost essentially done, though we should add in our application.properties file to accurately manage how we want things (we'll probably play around with this tomorrow and maybe beyond to see what happens)

```properties
spring.datasource.password=postgres
spring.datasource.url=jdbc:postgresql://localhost:5432/postgres
spring.datasource.username=postgres

spring.jpa.hibernate.ddl-auto=create
spring.jpa.properties.hibernate.dialect= org.hibernate.dialect.PostgreSQLDialect
```
### Postman Testing
Now would be a great time to start playing around with postman and trying to get things to work, testing the endpoints before you get to the front end is going to save you a mountain of headaches down the line.

# Frontend Time
So I'm not going to lie this is gonna jump around a lot and definitely isn't the cleanest bunch of pages in the world but it should give you a basic representation of what we have going on. We'll start by thinking about pages we may want to have 

- Main Home page to introduce the school
- Page with all courses offered by the school
- Login Page
- Enrollment page (this should only show available courses)
- User Page with an update form

Beyond this, we should probably have it to where every one of these pages has at least one css file and a js file (though the main page probably doesn't need the latter since it will be essentially static)

## Main Home Page

So on this page I'm going to start off with the navbar we created yesterday as well as just a basic header introducing the school, maybe with a logo blown up and maybe some like lorem ipsum (random text) underneath to emulate a school motto or something. First let's think of the navbar. Since this is going to be used frequently we'll probably want to store all the css in one file and just have everything link to it. Then we can create a new style sheet for each page for specifics and go from there

### Navbar CSS
(No I'm not changing the navbar to semantic tags, maybe I'll do it tomorrow but I'm on a bit of a time crunch and really just don't want to)

```CSS
.navbar {
    background-color: #115740;
    height: 80px;
    position: fixed;
    top: 0;
    left: 0;
    width: 100%;
    text-align: center;
    z-index: 1;
}

.nav-list {
    list-style-type: none;
    width: 100%;
    margin: auto;
}

.nav-item{
    float: left;
    display: block;
    height: 80px;
    line-height: 80px;
}

.nav-link{
    color: black;
    text-align: center;
    text-decoration: none;
    margin-left: 10px;
    margin-right: 10px;
    font-size: 1.5rem;
}

#logo {
    height: 60px;
    width: 60px;
    border-radius: 100%;
    object-fit: cover;
    position: relative;
    top: 12%;
}

#login-button {
    background-color: #CFC493;
    border: none;
    padding: 15px 32px;
    text-align: center;
    text-decoration: none;
    border-radius: 4px;
    font-size: 16px;
}
```

### Main Page CSS
Some none navbar CSS for some additional styling
```CSS
#main {
    margin-top: 100px;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}
```

### Main Page HTML
This is the HTML I went with for the main page, note that items in the navbar vary from what they were yesterday.

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='../CSS/navbar.css'>
    <link rel="stylesheet" href = "../CSS/home.css">
    <title>Home</title>
</head>
<body>
    <!-- It is very common for lists to be used for nav bars -->
    <div class='navbar'>
    
        <ul class='nav-list'>
            <li class="nav-item">
                <a class='nav-link' href='home.html'>
                    <img class='logo'
                    src='https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/South_Florida_Bulls_logo.svg/800px-South_Florida_Bulls_logo.svg.png'
                    height='60px' width='60px'/>
                </a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='courses.html'>Courses</a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='user.html'>Profile Page</a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='enroll.html'>Enroll!</a>
            </li>
            <li class='nav-item'>
                <button id='login-button' onclick="window.location.href = 'login.html'">Student or Faculty Login</button>
            </li>
        </ul>
        </div>
        <div id = "main">
            <h1 id = "header">Welcome to our school</h1>
            <img class = "logo" src = "https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/South_Florida_Bulls_logo.svg/800px-South_Florida_Bulls_logo.svg.png"
            style = "height: 400px; width: 400px;">
            <p>Lorem ipsum dolor sit amet consectetur, adipisicing elit. Nostrum doloremque inventore repellendus, dicta eligendi ex incidunt atque, rerum itaque autem voluptatum aut aliquam fugit eveniet! Enim iste nulla amet quaerat?</p>
        </div>
    
</body>
</html>
```
### Main Page JS
There is no JS page here since it wasn't necessary for the static main page

## All Courses Page
This Should be the page we're the most familiar with since we worked on it yesterday. This is going to be a little break time since we're basically going to take what we refactored yesterday and change the way it loads the courses. The final versions of all the associated files will be here

### Courses CSS

```CSS
#header {
    margin-top: 100px;
}

#main {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

#courses-container{
    width: 800px;
    height: 100px;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    flex-wrap: wrap;
}

.course{
    margin: 50px;
    padding: 10px;
    border: solid black 2px;
    border-radius: 10px;
    text-align: center;
}
```

### Courses HTML

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>All Courses Offered</title>
    <link rel='stylesheet' href='../CSS/navbar.css'>
        <link rel='stylesheet' href='../CSS/courses.css'>
    </head>

    <body>

        <body>

            <!-- It is very common for lists to be used for nav bars -->
            <div class='navbar'>
    
                <ul class='nav-list'>
                    <li class="nav-item">
                        <a class='nav-link' href='home.html'>
                            <img class='logo'
                            src='https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/South_Florida_Bulls_logo.svg/800px-South_Florida_Bulls_logo.svg.png'
                            height='60px' width='60px'/>
                        </a>
                    </li>
                    <li class='nav-item'>
                        <a class='nav-link' href='courses.html'>Courses</a>
                    </li>
                    <li class='nav-item'>
                        <a class='nav-link' href='user.html'>Profile Page</a>
                    </li>
                    <li class='nav-item'>
                        <a class='nav-link' href='enroll.html'>Enroll!</a>
                    </li>
                    <li class='nav-item'>
                        <button id='login-button' onclick="window.location.href = 'login.html'">Student or Faculty Login</button>
                    </li>
                </ul>
                </div>
            <div id='main'>
                <h1 id = "header">Courses available at our school</h1>
             
                <div id="courses-container">
    
                </div>
                
    
            </div>
            <script src="../JS/courses.js"></script>
        </body>


</html>
```

### Courses JS

```javascript
/*
let courses = [
    {
        course: 'MATH110',
        name: 'Intro to math',
        description: 'Learn the basics of math'
    },
    {
        course: 'READ110',
        name: 'Intro to reading',
        description: 'Learn to read'
    },
    {
        course: 'MATH110',
        name: 'Intro to math',
        description: 'Learn the basics of math'
    },
    {
        course: 'READ110',
        name: 'Intro to reading',
        description: 'Learn to read'
    },
    {
        course: 'SCI110',
        name: 'Intro to science',
        description: 'Learn to science'
    }
];
*/
let courses;

//We can grab the element of the div we want to store the courses in
let courseContainer = document.getElementById('courses-container');
console.log(courseContainer);

//We want to add all of our courses to the webpage, so we will loop through the list of courses
function populateCourses(courses){
    for(course of courses){
        //For each course in the course list, create a new div
        let cDiv = document.createElement('div');
        console.log(cDiv);

        //set the innerHTML of the new div
        cDiv.innerHTML = `
            <h2>${course.courseNum}</h2>
            <h3>${course.name}</h3>
            <p>${course.description}</p>
            <p>Available Seats: ${course.availableSeats}</p>
        `;

        console.log(cDiv);
        cDiv.setAttribute('class', 'course');

        //Finally we can append the courses to the container
        courseContainer.append(cDiv);
    }
}

const URL = 'http://localhost:8080';

(async () => {
    let req = await fetch(`${URL}/courses`);
    let res = await req.json();
    console.log(res);
    courses = res;
    courseContainer.innerHTML="";
    populateCourses(courses);
})();
```

## Login Page

This page is responsible for having two different forms on it, one for logging in and one for registering, let's take a look at the files

### Login CSS

No CSS was necessary so we're good on this front

### Login HTML
```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='../CSS/navbar.css'>
    <title>Login Page</title>
</head>
<body>
    <div class='navbar'>
    
        <ul class='nav-list'>
            <li class="nav-item">
                <a class='nav-link' href='home.html'>
                    <img class='logo'
                    src='https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/South_Florida_Bulls_logo.svg/800px-South_Florida_Bulls_logo.svg.png'
                    height='60px' width='60px'/>
                </a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='courses.html'>Courses</a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='user.html'>Profile Page</a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='enroll.html'>Enroll!</a>
            </li>
            <li class='nav-item'>
                <button id='login-button' onclick="window.location.href = 'login.html'">Student or Faculty Login</button>
            </li>
        </ul>
        </div>
        <div class = "main" style = "margin-top: 100px; align-items: center;">
            <div id = "login">
                <h1>Please Login Below</h1>
                <form id = "login-form">
                    <label for="login-username">Username: </label>
                    <input id="login-username" type="text" name="login-username" maxlength="50"/>
                    <label for="login-password">Password: </label>
                    <input id="login-password" type="password" name="login-password" minlength="8" required/>
                    <input type="submit" value="login"/>        
                </form>
            </div>

            <div id = "register">
                <button  onclick="toggleForm()">Not a member? Register Now!</button>
                <form id = "register-form" hidden>
                    <label for="first">First Name: </label>
                    <input id="first" type="text" name="first" maxlength="50"/>
                    <label for="last">Last Name: </label>
                    <input id="last" type="text" name="last" maxlength="50">
                    <label for="username">Username: </label>
                    <input id="username" type="text" name="username" maxlength="50"/>
                    <label for="password">Password: </label>
                    <input id="password" type="password" name="password" minlength="8" required/>
                    <label for="email">Email: </label>
                    <input id="email" type="email" name="email" maxlength="50">
                    <input type="submit" value="Update"/>        
                </form>
            </div>
            <div id="user">

            </div>

        </div>
    <script src="../JS/login.js"></script>
</body>
</html>
```

### Login JS
```javascript
function toggleForm(){
    let registerForm = document.getElementById("register-form");
    if (registerForm.hasAttribute("hidden")){
        registerForm.removeAttribute("hidden");
    } else {
        registerForm.setAttribute("hidden", "true")
    }
}



let postLogin = async () => {
        let username = document.getElementById('login-username').value;
        let password = document.getElementById('login-password').value;
    
        let loginObj = {
            username,
            password
        };

        console.log(loginObj);
    
        let req = await fetch(`http://localhost:8080/users/login`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(loginObj)
        })
       
        let res = await req.json();

        sessionStorage.setItem("id", `${res.id}`)
        sessionStorage.setItem("username", `${res.username}`)

        console.log(res);

        console.log(sessionStorage.getItem("id"));
        window.location.href= "home.html";

        
    };

    let postRegister = async () => {
        let first = document.getElementById('first').value;
        let last = document.getElementById('last').value;
        let username = document.getElementById('username').value;
        let password = document.getElementById('password').value;
        let email = document.getElementById('email').value;
    
        let registerObj = {
            first,
            last,
            username,
            password,
            email
        };

        console.log(registerObj);
    
        let req = await fetch(`http://localhost:8080/users`, {
            method: 'POST',
            headers: {'Content-Type': 'application/json'},
            body: JSON.stringify(registerObj)
        })
       
        let res = await req.json();

        sessionStorage.setItem("id", `${res.id}`)
        sessionStorage.setItem("username", `${res.username}`)

        console.log(res);

        console.log(sessionStorage.getItem("id"));
        alert("Successfully Registered")
        window.location.href= "home.html";
    };


function submitLogin(event){
    event.preventDefault();
    postLogin();
}

function submitRegister(event){
    event.preventDefault();
    postRegister();
}

let loginButton = document.getElementById("login-form").addEventListener('submit', submitLogin);

let registerButton = document.getElementById("register-form").addEventListener('submit', submitRegister);
```

## Enrollment Page
This page should be just like the courses page from before but should include some slightly different logic as well as adding in a form to make it all work together

### Enrollment CSS

```CSS
#header {
    margin-top: 100px;
}

#main {
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

#courses-container{
    width: 800px;
    height: 100%;
    display: flex;
    justify-content: space-evenly;
    align-items: center;
    flex-wrap: wrap;
}

.course{
    margin: 50px;
    padding: 10px;
    border: solid black 2px;
    border-radius: 10px;
    text-align: center;
}
```

### Enrollment HTML

```HTML
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Enroll</title>
    <link rel='stylesheet' href='../CSS/navbar.css'>
    <link rel='stylesheet' href='../CSS/enroll.css'>
</head>

<body>

    <body>
        <div class='navbar'>

            <ul class='nav-list'>
                <li class="nav-item">
                    <a class='nav-link' href='home.html'>
                        <img class='logo'
                        src='https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/South_Florida_Bulls_logo.svg/800px-South_Florida_Bulls_logo.svg.png'
                        height='60px' width='60px'/>
                    </a>
                </li>
                <li class='nav-item'>
                    <a class='nav-link' href='courses.html'>Courses</a>
                </li>
                <li class='nav-item'>
                    <a class='nav-link' href='user.html'>Profile Page</a>
                </li>
                <li class='nav-item'>
                    <a class='nav-link' href='enroll.html'>Enroll!</a>
                </li>
                <li class='nav-item'>
                    <button id='login-button' onclick="window.location.href = 'login.html'">Student or Faculty Login</button>
                </li>
            </ul>
            </div>
        <div id='main'>
            <h1 id = "header">Courses available at our school</h1>
         
            <div id="courses-container">

            </div>
            
            <form id = "enroll-form">
                <label for="course">Course Number: </label>
                <input id="course" type="text" name="course" maxlength="7">
                <input type="submit" value="Enroll"/>
            </form>
            
        </div>

        <script src="../JS/enroll.js"></script>
    </body>


</html>
```

### Enrollment JS

```javascript
let courseContainer = document.getElementById('courses-container');
console.log(courseContainer);

let courseNames = [];

//We want to add all of our courses to the webpage, so we will loop through the list of courses
function populateCourses(courses){
    for(course of courses){
        courseNames.push(course.courseNum);
        //For each course in the course list, create a new div
        let cDiv = document.createElement('div');
        console.log(cDiv);

        //set the innerHTML of the new div
        cDiv.innerHTML = `
            <h2>${course.courseNum}</h2>
            <h3>${course.name}</h3>
            <p>${course.description}</p>
            <p>Available Seats: ${course.availableSeats}</p>
        `;

        console.log(cDiv);
        cDiv.setAttribute('class', 'course');

        //Finally we can append the courses to the container
        courseContainer.append(cDiv);
    }
}

const URL = 'http://localhost:8080';



(async () => {
    if (sessionStorage.getItem("username") == null) {
        window.location.href = "login.html"
    }
    let req = await fetch(`${URL}/courses/available`);
    let res = await req.json();
    console.log(res);
    courses = res;
    courseContainer.innerHTML="";
    populateCourses(courses);
})();

let postCourse = async () => {
    
    let id = sessionStorage.getItem("id")


    let req = await fetch(`http://localhost:8080/users/enroll/${document.getElementById("course").value}`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json',
                    'userId': `${id}` }
    })

    let res = await req.json();

    console.log(res);

    console.log(sessionStorage.getItem("id"));
    location.reload();
};

function enroll(event){
    event.preventDefault();
    console.log(courseNames)
    for (course of courseNames){
        console.log(course);
        console.log(document.getElementById("course").value);
        if (course == document.getElementById("course").value){
            return postCourse();
        }
    }
    console.log("No such course found")
    
}

document.getElementById("enroll-form").addEventListener('submit', enroll)
```

## Finally, the User Page
This is the last major page we did for this demo, we could add in a lot more error handling and stuff like that to make sure everything plays nice and gives us nice messages when things aren't right but for now we should be good wrapping up here then we'll talk about deployment tomorrow

### User Page CSS
```CSS
#main {
    margin-top: 100px;
    width: 100%;
    height: 100%;
    display: flex;
    flex-direction: column;
    justify-content: center;
    align-items: center;
}

#update{
    display:flex;
    flex-direction: column;
}

input{
    width: 100%;
    padding: 12px 20px;
    margin: 8px 0;
    display: block;
    border: 1px solid #ccc;
    border-radius: 4px;
    box-sizing: border-box;
}
```

### User Page HTML
```HTML
<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <link rel='stylesheet' href='../CSS/navbar.css'>
    <link rel='stylesheet' href="../CSS/user.css">
    <title>User Profile</title>
</head>

<body>
    <div class='navbar'>

        <ul class='nav-list'>
            <li class="nav-item">
                <a class='nav-link' href='home.html'>
                    <img class='logo'
                        src='https://upload.wikimedia.org/wikipedia/en/thumb/c/c1/South_Florida_Bulls_logo.svg/800px-South_Florida_Bulls_logo.svg.png'
                        height='60px' width='60px' />
                </a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='courses.html'>Courses</a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='user.html'>Profile Page</a>
            </li>
            <li class='nav-item'>
                <a class='nav-link' href='enroll.html'>Enroll!</a>
            </li>
            <li class='nav-item'>
                <button id='login-button' onclick="window.location.href = 'login.html'">Student or Faculty
                    Login</button>
            </li>
        </ul>
    </div>
    <div id="main">
        <h1 id="header">Account Information</h1>
        <div id="user-container">
        </div>
        <button id="update-form-toggle" onclick="toggleUpdateForm()">Update User Info</button>
        <br>
        <div id="update">
            
            <form id="update-form" hidden>
                <label for="first">First Name: </label>
                <input id="first" type="text" name="first" maxlength="50" />
                <label for="last">Last Name: </label>
     
```

### User Page JS

```javascript

let personContainer = document.getElementById("user-container");

(async () => {
    if (sessionStorage.getItem("username") == null) {
        window.location.href = "login.html"
    }
    let req = await fetch(`http://localhost:8080/users/${sessionStorage.getItem("username")}`);
    let res = await req.json();
    personContainer.innerHTML = "";
    populatePerson(res);
    populateUpdate(res);
})();

function populatePerson(person) {
    let courseInfo = "";
    for (course of person.courses) {
        courseInfo += `<h3>${course.courseNum}</h3>
                        <h4>${course.name}</h4>
                        <br>`
    }
    personContainer.innerHTML = `
    <h1>Name: ${person.first} ${person.last}</h1>
    <h2>Username: ${person.username}</h2>
    <h2>Email: ${person.email}</h2>
    <h2> Courses Enrolled: </h2>
    <br>
    ${courseInfo}
    `
}

function toggleUpdateForm() {
    let form = document.getElementById("update-form");
    if (form.hasAttribute("hidden")) {
        form.removeAttribute("hidden");
    } else {
        form.setAttribute("hidden", "true")
    }
}

function populateUpdate(person) {
    document.getElementById("first").setAttribute("value", `${person.first}`);
    document.getElementById("last").setAttribute("value", `${person.last}`)
    document.getElementById("username").setAttribute("value", `${person.username}`)
    document.getElementById("password").setAttribute("value", `${person.password}`)
    document.getElementById("email").setAttribute("value", `${person.email}`)
}


let putUser = async () => {
    let id = sessionStorage.getItem("id");
    let first = document.getElementById('first').value;
    let last = document.getElementById('last').value;
    let username = document.getElementById('username').value;
    let password = document.getElementById('password').value;
    let email = document.getElementById('email').value;

    let updateObj = {
        id,
        first,
        last,
        username,
        password,
        email
    };

    console.log(updateObj);

    let req = await fetch(`http://localhost:8080/users`, {
        method: 'PUT',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify(updateObj)
    })

    let res = await req.json();

    sessionStorage.setItem("id", `${res.id}`)
    sessionStorage.setItem("username", `${res.username}`)

    console.log(res);

    console.log(sessionStorage.getItem("id"));
    location.reload();
};

function update(event){
    event.preventDefault();
    putUser();
}

document.getElementById("update-form").addEventListener('submit', update)
```