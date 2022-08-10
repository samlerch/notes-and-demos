# Java

- What is Java?
    * Y

- What is an object, and a class?
    * yes

- What is the JVM?
    * Java Virtual Machine. The JVM is a runtime environment that allows Java to run anywhere platform independent
- What are the primitive types in Java
    * boolean
    * int
    * double
    * char
    * short
    * float
    * long
    * byte
- Types of Constructors
    * No args, All args, some mix. No args is the default constructor inherited from the object class. If you do not define a constructor you will have a no args one
    * Defining a constructor will get rid of the no args one unless you explicitly define a no args constructor
    * Constructors should have no return type. The name should be the class name.
- What is the difference between string, string builder, and string buffer?
    * String is a java object that is a collection of text. They are stored in a specific area on the heap called the String Pool. Strings take up a large amount of memory. As such a string with the exact same content will only be stored once. This can be avoided by explicitly using the String constructor with the new keyword
    * String Builder is a class most commonly used when you need to frequently modify a string.
    * StringBuilder is not threadsafe while StringBuffer is threadsafe
    * StringBuilder and StringBuffer are muteable. Strings are immuteable.
    - StringBuilder sb = new StringBuilder();
- What are the types of memory in Java
    * The heap and the stack
    * Objects are stored on the heap along with the string pool
    * method invocations and local variables are stored on the stack. Each thread of exeuction gets its own stack
- Difference between abstract classes and interfaces?
    * Abstract classes can be 0 to 100% abstract and should be extended. They can have concrete or abstract methods. 
    * Interfaces are 100% abstract and must be implemented
- What is exception handling? How would you implement it?
    * Exception handling is when the JVM throws an exception and you catch the exception or duck it. 
    * To duck an exception in a method it should use the throws keyword to indicate it may throw that exception. It should still be handled later with a try/catch block
- How to handle class not found exception?
    * It depends on the root cause. If the class doesn't  exist make it. If it does exist check if it is imported.
- What is the difference between Throw and Throws?

- Tell me about access modifiers

- Tell me about the static keyword

- Can you do static overriding?

- What are the 4 pillars of OOP? Tell me about them

- What is Encapsulation and Abstraction?

- What is Polymorphism?

- How did you connect your database to java?

- How does the driver work in JDBC?

- What interfaces are associated with JDBC?

- What are generics?

- Tell me about Arraylists

- Difference between ArrayList and Vector

- What is the difference between List and Set in collections API?

- Tell me about Hashmaps

- Give me an example of a Java 8 specific feature? What does that feature entail?

- What is Java streaming?

- Difference between comparable and comparator

- Tell me about functional interface?

- What are lambda expressions?

- Do you know Method References?

- Difference between lambda expression and method reference?

- What is TDD?

- Are Unit tests mandatory

- What is boilerplate?

# Git

- Merge conflict and how you handle this?

# SQL/Persistence

- What is Relational Database Management Services (RDMS)?

- What is SQL?

- Do you know the difference between char and varchar datatype?

- What is CRUD? Which SQL keywords are associated with these operations?

- How to select top 15% employees base on salary

- How to fetch top 10 salaried employees?

- What are joins?

- What is the difference between a view and a table?

- What is DAO?

# Spring/Spring Boot

- What is dependencies Injection?

- How many types of beans in spring?

- What annotations that are use in Spring?

- Where would you do the configuration in a spring project?

- How to handle exception in Spring project?

- What is the difference between Spring and Spring Data?

- Tell me about transaction management in a Spring Project

- What are the annotations that you know for spring jpa and what do they mean?

- Differences between JPA/Hibernate/JDBC?

- Do you know what stereotypes annotations are?

- Describe annotation for each of the MVC application layers?

- How you create Rest API in Spring boot?

- What is @RestController?

- Tell me about the Spring Boot Actuator

- Why do we use Spring Boot

- What are Spring Boot Annotations?

- What is the difference between spring and springboot?

# SDLC

- What is Agile?

- What is Waterfall?

- What is the difference between Waterfall and Agile?

# Http/REST

- What is Http?

- What is an Http client?

- What is an Http session?

- What is the difference between a session and a cookie?

- What are the HTTP status codes?

- List some of the Http Verbs

- Difference between Put and Post

- Do you know REST? Can you tell me about what it is?

- What is stateless

- What are the HTTP methods supported by REST?

- RESTController vs Controller

# AWS/Cloud

- What is platform as a service?

- What are cloud services and some known platforms?

- What are 5 different common cloud services/platforms?

- Which AWS services did you use in your projects?

- What is EC2 and S3 in AWS?

- How do you configure a AWS S3?

- Explain the security and permissions utilized in your project?

- What is the initial layer in AWS before gaining access via IP? (Firewall)

- What are security roles, security groups?

- Are you familiar with Identity Access Manager (IAM)?

# DevOps

- What is CI/CD?

- What is Sonar Cloud? 

- What is Docker?

# HTML/CSS/JavaScript

- What is HTML

- Do you know the types of lists in HTML?

- What is CSS

- How many ways can you specify CSS styles for HTML elements?

- What is JavaScript?

- What are the datatypes in JavaScript?

- What are undeclared and undefined variables in JavaScript?

- Talk to me about JavaScript Functions

# Angular/TypeScript

- What is TypeScript?

- What is the Angular framework?

- How to create new project in Angular?

- What is a directive in Angular?

- What bindings do you know in Angular?

- What is a service in angular?

- How to inject services in Angular Component?

- Differences between JavaScript and TypeScript?

# Personal/Behavioral/Soft Skills

- Tell me about yourself

- What led you to Revature

- Talk about your projects overall

- Tell me about your project roles and responsibilities

- What technologies did you used for your projects?

- Tell me about a time when you had a person that was hampering your progress as a team for a project

- What are your strengths and weaknesses?

- How do you react to challenges such as prioritizing parts of project?

- Tell me about your experience working with a team

- How to resolve conflicts between team members?

- If you had a superpower what would it be and why?

- Are you more of a front end or backend developer

- How would you describe Java and Angular in a non-technical way?

- What coding language are you most comfortable in

