# Step 1: Correction From Yesterday

I'm not entirely sure at this point why I had us put in the maven WAR plugin, as it clearly created some confusion, especially considering the fact that you can get away with not necessarily having it in there, even though the pom.xml File is not happy. We can see what we originally had below, note that the build plugin is not yet commented out, meaning that when we package our WAR file it'll have the name "check"

![img1](./images/img1.png)

This was causing an issue on the front end where we could only access the page by going to http://localhost:8080/check but we can solve this in a couple of ways. Probably the simplest is to just change the final name to HelloServlets so when our project is packaged it's called that. See below:

<img src = "../images/img2.png" >

Note that by changing the final name and rebuilding allows for us to just have the name HelloServlets appear at the bottom as the name of our WAR file. Don't forget to restart your server so then you can access it at the right URL. Sometimes this doesn't work so there's some additional steps you may need to do. One could be an `mvn clean package` on your project to remove the old files and repackage it. Another thing you may need to do is simply unadd the servlet and readd it to the Tomcat server at the bottom. This should allow for you to see our index.html page at the appropriate address.

# Step 2: Create a Post Request on Servlet

Returning to our DirectServlet class will allow us to add in a new method that is designed to handle a POST request sent to the same mapping we had before (/dirserv). To handle POST requests we need to Override the doPost method and add some functionality. Before we can do this however, let's create a class that we'll return a JSON object of in the response of the POST request. Make a new package at com.revature.models and create a class called SuperVillain. It should be a basic POJO with the fields and methods specified

<img src = "../images/img3.png" >

Before we get too excited and attempt to add in our doPost method we need to come up with some way to transform a Java object to a JSON object and back. Converting a Java Object to a JSON object is called marshalling and the reverse process is unmarshalling. To do these operations, we're going to use Jackson, which is a very popular and efficient java based library used to serialize or map java objects to JSON and vice versa. So let's import this in from the maven respository

<img src = "../images/img4.png" >

We'll use 2.13.3 for this instance and add it to our pom.xml. Save and update the project like whenever we add a dependency

<img src = "../images/img5.png" >

<img src = "../images/img6.png" >

Now that we finally have all that, let's head over to our DirectServlet Class and add in our new method to handle a post request. Note that we need to import for both the SuperVillain class as well as the Object Mapper. The latter comes from Jackson Databind and allows us to convert an object to a JSON.

<img src = "../images/img7.png" >

Now that we have our POST handler let's add a button to our html to simulate a POST request being sent. Normally this would be used with data taken in from the user (don't worry we'll get there) and let's see the response

<img src = "../images/img8.png" >

<img src = "../images/img9.png" >

<img src = "../images/img10.png" >

Looking here, we can see that it converted our Java object into a JSON one. Note that the object is in curly braces and consists of key value pairs seperated by commas. Remember that this is useful for translating and passing data between different sources in different languages. Since JSON is language independent I could send this object over to a .NET server or to a Python one and we could still interact with it just fine.

Before we get too far ahead of ourselves, let's add some stlying and maybe an error page to make things look a little more appealing. First, let's create a css folder inside of our webapp and create a style.css file. Don't worry too much about the information going in here, we'll cover CSS (Cascading Style Sheets) in a few weeks just know that it allows us to change how our html appears

<img src = "../images/img11.png" >

Right now this isn't doing anything, so we need to go inside our index.html file and link this up. From there the form stuff should work automatically, but we're going to also create a div element to store all our forms in. Don't forget to close your div tag at the bottom

<img src = "../images/img12.png" >

Now let's reload our page and see what it looks like

<img src = "../images/img13.png" >

Sure, it's not perfect but it's better than it was. Good Styling using CSS and other tools like BootStrap can really make html pages come to life, so don't be afraid to explore and learn some new things. If you're curious I highly recommed the resources on W3 schools for HTML and CSS, go explore and have fun. Next for us now though is an error page. For this, we'll just make a simple HTML page that appears if there is an error. So we'll create an Error.html page and go from there. 

<img src = "../images/img14.png" >

Next, we need to add this to our page mapping inside of our web.xml file like so

<img src = "../images/img15.png" >

Doing this means whenever we run into a 404 error meaning a resource was not found, we'll instead be redirected to this page and can continue going from there, visually it would look like this.

<img src = "../images/img16.png" >

# Step 3: Creating an indirect Servlet
Sometimes in your coding career you may find that you want to go from one request and redirect to another for whatever various reasons. You have two main ways of doing this, the sendRedirect method or the forward method. To examine these let's create an indirect servlet package and an IndirectServlet class to handle this. Don't forget to extend the HttpServlet class.

<img src = "../images/img17.png" >

From here we'll create a constructor and override the doGet and doPost methods to showcase off the sendRedirect and Forward methods

<img src = "../images/img18.png" >

<img src = "../images/img19.png" >

Next, we need to add our mappings to web.xml file

<img src = "../images/img20.png" >

Now let's add some forms to our HTML page and take a look

<img src = "../images/img21.png" >

<img src = "../images/img22.png" >

<img src = "../images/img23.png" >

# Step 4: Working with Sessions

So these Http requests we've been sending are stateless if you remember, so they can't necessarily affect one another without us getting involved. The way this can be done is with session management. Using sessions allows us to store information in a variety of ways, today however, we'll only be covering the HttpSession Interface. Let's look at some notes on what all this means and how we go from there. Now that we've seen different kinds of session management, let's take a look at creating some sessions and managing them. First, let's create a basic session class with two methods, doGet and doPost. This class will be in a seperate package called sessionservlet. 

<img src = "../images/img24.png" >

<img src = "../images/img25.png" >

<img src = "../images/img26.png" >


Next, let's create a HelperSessionServlet class in the same package. This will be used to fetch the Villain object we stored to the session so we only need to implement the doGet method, though we'll introduce a stub for doPost in case we change our mind later on.

<img src = "../images/img27.png" >

<img src = "../images/img28.png" >

Now that we have our servlets setup, we need to map them and then add some functionality to our web page to allow us to do things

<img src = "../images/img29.png" >

Now let's add some stuff to our index.html

<img src = "../images/img30.png" >

