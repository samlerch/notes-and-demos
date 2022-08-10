# Java

- What is Java?
    * Java is a strongly, statically typed high level OOP language. It is platform indpendent.

- What is an object, and a class?
    * An object is a virtualization of a real life object. A class is the blueprint to build that. Classes can have methods, fields, constructors, and other classes inside of them.

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
    * Abstract classes can be 0 to 100% abstract and should be extended. They can have concrete or abstract methods. A subclass must implement all abstract methods unless it is also abstract.
    * Interfaces are 100% abstract and must be implemented. Interface methods are implicitly public and abstract. Interface variables are implicitly public, static, and final. 
- What is exception handling? How would you implement it?
    * Exception handling is when the JVM throws an exception and you catch the exception or duck it. 
    * To duck an exception in a method it should use the throws keyword to indicate it may throw that exception. It should still be handled later with a try/catch block
- How to handle class not found exception?
    * It depends on the root cause. If the class doesn't  exist make it. If it does exist check if it is imported.
- What is the difference between Throw and Throws?
   * Throw is used to actually create an exception and pass it up the stack. Throws is used to indicate in a method signature that the method may throw a certain exception.
- Tell me about access modifiers
   * Public - anywhere
   * Protected - package and subclass
   * Default - package
   * private - only this class
- Tell me about the static keyword
   * The static keyword indicates that a variable should only have one instance no matter how many objects are created. When used on a method it denotes the method can be executed without an instance of the class. A static class is a nested class that can be instantiated without instantiating the outer class.
- Can you do static overriding?
   * Static methods cannot be overriden but you can hide a method. Method hiding is essentially overriding a static method replacing the parent class implementation with the child class. Method hiding is done at compile time while overriding is done at runtime.
- What are the 4 pillars of OOP? Tell me about them

- What is Encapsulation and Abstraction?

- What is Polymorphism?
   * One of the pillars of OOP. The ability for something to be many things. Runtime polymorphism is achieved throw overriding and compile time is achieved with overloading.
- How did you connect your database to java?
   * In the application.yml file of our SpringBoot Project we defined the
   * DB url
   * DB username
   * DB password
   * DB driver
- How does the driver work in JDBC?

- What interfaces are associated with JDBC?
   * DriverManager
   * Connection
   * Statement
   * PreparedStatement - safe against sql injection. Precompiled by the jvm before being sent
   * CallableStatement - used to execute stored procedures
   * ResultsSet - set iterated through with results
- What are generics?

- Tell me about Arraylists
   * ArrayList is a class that implements the List interface. It is a resizeable array that will grow and shrink as needed. It is index based. and part of the collections framework
- Difference between ArrayList and Vector
   * An ArrayList is not threadsafe and grows by 50%. A vector is thredsafe and doubles in size
- What is the difference between List and Set in collections API?
   * Set cannot have duplicates
- Tell me about Hashmaps
   * HashMap is part of the collection framework but does not implement the iterable or Collection interface. A hash map is a Key Value pair collection of values. To iterate through one you could use the EntrySet<>
- Give me an example of a Java 8 specific feature? What does that feature entail?
   * Java 8 introduced streams. Streams are a way to iterate through a collection and perform certain operations
   * There are 2 types of operations, terminal and non-terminal. Terminal creates some output and ends the stream. An example is Collect
- What is Java streaming?
   * See above
- Difference between comparable and comparator
   * Comparable interface allows you to compare objects by overriding the compareTo() method. Note that you can only override this once. If you want multiple ways to compare you should use compartors instead
   * Comparotor is another interface which can be implemented in multiple classes. Those classes can be passed to Collections.sort as a comparator object.
- Tell me about functional interface?
   * Functional interfaces are an interface with a single abstract method that is commonly implemented using lambdas
- What are lambda expressions?
   * lambda expressions are a short block of code that takes in paramaters and return a value. They are denoted using the arrow notation. You can use {} to denote a code block but then you must use a return statement at the end.
- Do you know Method References?
   * Using :: you can refer to a static method. for example System.out::println . This could be passed to say, queue.forEach(System.out::println);
- Difference between lambda expression and method reference?
   * method references could be expressed as lambda expressions. It comes down to readability and reuseablility which one to use.
- What is TDD?

- Are Unit tests mandatory

- What is boilerplate?

# Git

- Merge conflict and how you handle this?

# SQL/Persistence

- What is Relational Database Management Services (RDMS)?
   * The software used to execute CRUD operations. For example SQL, PostgreSQL, MySQL
- What is SQL?
   * Structured Query Language
- Do you know the difference between char and varchar datatype?
   * char is a static size while varchar is resizeable
- What is CRUD? Which SQL keywords are associated with these operations?

- How to select top 15% employees base on salary

- How to fetch top 10 salaried employees?

- What are joins?

- What is the difference between a view and a table?
   * Materialized view is a static image of the table at certain time.
- What is DAO?

# Spring/Spring Boot

- What is dependencies Injection?
   * A design pattern to remove dependenies by providing the config in an external source. two types constructor and setter. 
   * Setter occurs after
- How many types of beans in spring?
   * 6 types, Singleton, prototype, request, session, application, websocket
- What annotations that are use in Spring?

- Where would you do the configuration in a spring project?
   * Utilize the @SpringBootApplication, which contains the @EnableAutoConfiguration
   * You can override properties in application.yml or application.properties
- How to handle exception in Spring project?
   * @ExceptionHandler 
- What is the difference between Spring and Spring Data?

- Tell me about transaction management in a Spring Project

- What are the annotations that you know for spring jpa and what do they mean?
   @Transactional, @Query, @Modifying, @Id, @Entity, @ManyToMany, @OneToMany, @ManyToOne, @Column,
- Differences between JPA/Hibernate/JDBC?

- Do you know what stereotypes annotations are?
   * Stereotype annotations are annotations that tell the compiler information about how to wire components
   * There are 4 total stereotypes which inherit from @Component. @Controller, @Service, @Repository
- Describe annotation for each of the MVC application layers?
   * There are 3 layers in a MVC application
   * Persistence layer which uses the @Repository annotation
   * Service layer which uses the @Service annotation
   * Presentation layer which uses the @Controller annotation
- How you create Rest API in Spring boot?
   * Uniform interface
   * Client-Server model
   * Stateless
   * Cacheable (mark requests as cacheable or non-cacheable)
   * Layered system
- What is @RestController?
   * Implicitly puts at @ResponseBody on any methods and marks the class with @Controller
- Tell me about the Spring Boot Actuator

- Why do we use Spring Boot

- What are Spring Boot Annotations?
   * provide meta data for the compiler. Tells the compiler how to link certain objects together
- What is the difference between spring and springboot?
   * Springboot is an opinionated version of Spring framework. It uses common settings that most developers would want to allow us to quicklky build enterprise level applications. 
# SDLC

- What is Agile?

- What is Waterfall?

- What is the difference between Waterfall and Agile?

# Http/REST

- What is Http?

- What is an Http client?

- What is an Http session?

- What is the difference between a session and a cookie? 
   * cookies persist when you close your browser and expire after a set time stored client side. 
   * Sessions close when you close your browser. Sessions are stored server side.
- What are the HTTP status codes?

- List some of the Http Verbs

- Difference between Put and Post
   * Put is idempotent (if you send the same request nothing will happen) post is not.
- Do you know REST? Can you tell me about what it is?

- What is stateless

- What are the HTTP methods supported by REST?
   * PATCH, PUT, POST, GET, DELETE
   * PATCH is a partial update to a resource
   * PUT is idempotent
- RESTController vs Controller
   * @RestController Includes the Controller annotation and the @ResponseBody annotation
# AWS/Cloud

- What is platform as a service?
   * Computing resources are provided
- What are cloud services and some known platforms?
   * AWS, Azure, 
- What are 5 different common cloud services/platforms?

- Which AWS services did you use in your projects?

- What is EC2 and S3 in AWS?

- How do you configure a AWS S3?

- Explain the security and permissions utilized in your project?

- What is the initial layer in AWS before gaining access via IP? (Firewall)

- What are security roles, security groups?

- Are you familiar with Identity Access Manager (IAM)?
   * allows you to manage who can access your services and resources in AWS.
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

