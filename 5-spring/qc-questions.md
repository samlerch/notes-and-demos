### REST: Representational State Transfer
- What is [REST](https://www.codecademy.com/articles/what-is-rest)?

REST, or REpresentational State Transfer, is an architectural style for providing standards between computer systems on the web, making it easier for systems to communicate with each other. REST-compliant systems, often called RESTful systems, are characterized by how they are stateless and separate the concerns of client and server.

- What makes an API RESTful?
  - *i.e **What are the 6 constraints of REST?***
  - Uniform Interface
  - Client-Server
  - Stateless
  - Cacheable
  - Layered System
  - Code on Demand (Optional)

- What is the [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html)?

A model (developed by Leonard Richardson) that breaks down the principal elements of a REST approach into three steps. These introduce resources, http verbs, and hypermedia controls.

<br>

### Spring Core

1.  What are Spring Projects and Spring Modules?

Within the Spring Framework, there are a variety of different Spring modules — JDBC, AOP, Beans, and Context. All Spring Modules share the same release version as the Spring Framework. They are part of the same project.

Apart from the Spring Framework and its various modules, there are other frameworks called Spring Projects. These projects provide solutions to other issues faced by enterprise applications.
    
2.  What is IOC and what does the IOC Container do?

An IoC container is a common characteristic of frameworks that implement IoC (Inversion of Control).

In the Spring framework, the interface ApplicationContext represents the IoC container. The Spring container is responsible for instantiating, configuring and assembling objects known as beans, as well as managing their life cycles.
    
3.  What is dependency injection and what are some of the benefits of using dependency injection?

As the name suggests, Dependency Injection is a design patters that removes dependencies of a program by providing the configuration in an external source, such as an ML file. This loosely coupled design then makes code easier to test, and implement in a wider variety of environments.
    
4.  What types of dependency injection does Spring support?

- Constructor injection
- Setter Injection
    
5.  What are some differences between BeanFactory and ApplicationContext? Which one eagerly instantiates your beans?

As the `ApplicationContext` includes all functionality of the `BeanFactory`, it is generally recommended that it be used in preference to the `BeanFactory`, except in applications where memory consumption might be critical and a few extra kilobytes might make a difference. However, for most 'typical' enterprise applications and systems, the `ApplicationContext` is what you will want to use.

**`BeanFactory` features:**
- bean instantiation/wiring

**`ApplicationContext` features:**
- bean instantiation/wiring
- `ApplicationEvent` publication
- Convenient `MessageSource` access (for internationalization)
    - internationalization is the process of designing a software application so that it can potentially be adapted to various languages and regions without engineering changes.
- Eagerly instantiates beans
    
6.  What is the Spring Bean lifecycle?

The management of Beans, conducted by the BeanFactory or Application Context, includes instantiation, configuration and the eventual removal (or destruction) of beans. As a high-level overview:

- Beans are first instantiated.
- Their properties are set.
- Any associated interfaces or objects are made aware of their existence.
- The bean is made aware of any associated interfaces as well.
- Any other methods, particularly custom created methods, are invoked.
- Then the bean is ready for use.
- Once the bean is no longer used, it is marked for removal and a destroy method is invoked for the bean
- Custom destroy methods are invoked, if any.
- Bean is the destroyed.
    
7.  What is bean wiring? What about autowiring?

- Combining together beans within the Spring container is known as bean wiring or wiring. When wiring beans, you should tell the container what beans are needed and how the container should use dependency injection to tie them together.

- The Spring framework enables automatic dependency injection. In other words, by declaring all the bean dependencies in a Spring configuration file, Spring container can autowire relationships between collaborating beans. This is called Spring bean autowiring
    
8.  What are the different ways that Spring can wire beans?

Springs beans can be manually wired in two different ways. Either based on an XML configuration file or a Java configuration file that registers the specific beans that should be wired. The Spring container can auto wire on the basis of the following parameters:
byName, byType, constructor, autodetect
    
9.  What are the scopes of Spring beans? Which is default?

- Singleton(default)
- Prototype
- Request
- Session
- Application
- Websocket
    
10.  What is the concept of component scanning and how would you set it up?

When working with Spring, we can annotate our classes in order to make them into Spring beans. Furthermore, we can tell Spring where to search for these annotated classes, as not all of them must become beans in this particular run. With Spring, we use the @ComponentScan annotation along with the @Configuration annotation to specify the packages that we want to be scanned. @ComponentScan without arguments tells Spring to scan the current package and all of its sub-packages.
    
11.  What are the benefits and limitations of Java configuration?
    
12.  What does the @Configuration and @Bean annotations do?
    
13.  What is @Value used for?
    
14.  What is Spring Expression Language? What can you reference using SpEL? What is the difference between $ and # in @value expressions?
    
<br>

### Spring MVC

15.  Explain the MVC architecture and how HTTP requests are processed in the architecture
    
16.  What is the role of the DispatcherServlet? What about the ViewResolver?
    
17.  List some stereotype annotations. What are the differences between these?
    
18.  How would you declare which HTTP requests you’d like a controller to process?
    
19.  What is the difference between @RequestMapping and @GetMapping?
    
20.  How to declare the data format your controller expects from requests or will create in responses?
    
21.  What annotation would you use to bypass the ViewResolver?
    
22.  How would you extract query and path parameters from a request URL in your controller?
    
23.  What concerns is the controller layer supposed to handle vs the service layer?
    
24.  How would you specify HTTP status codes to return from your controller?
    
25.  How do you handle exceptions thrown in your code from your controller? What happens if you don’t set up any exception handling?
    
26.  How would you consume an external web service using Spring?
    
27.  What are the advantages of using RestTemplate?
    
<br>

### Spring AOP

28.  What is “aspect-oriented programming”? Define an aspect.
    
29.  Give an example of a cross-cutting concern you could use AOP to address
    - The crosscutting concern is a concern which is applicable throughout the application and it affects the entire application.
    - For example: logging, security and data transfer are the concerns which are needed in almost every module of an application, hence they are cross-cutting concerns.

30.  Define the following:
    

*  Join point
    
*  Pointcut
    
*  Advice
    

31.  What are the different types of advice? What is special about the @Around advice? How is the ProceedingJoinPoint used?
    
33.  Explain the pointcut expression syntax
    
34.  What visibility must Spring bean methods have to be proxied using Spring AOP?
    
<br>

### Spring Data

34.  What is Spring ORM and Spring Data?
    
35.  What is the Template design pattern and what is the JDBC template?
    
36.  What does @Transactional do? What is the PlatformTransactionManager?
    
37.  What is a PersistenceContext?
    
38.  Explain how to integrate Spring and Hibernate using ContextualSession
    
39.  What interfaces are available in Spring Data JPA?
    
40.  What is the difference between JPARepository and CrudRepository?
    
41.  What is the naming conventions for methods in Spring Data repositories?
    
42.  How are Spring repositories implemented by Spring at runtime?
    
43.  What is @Query used for?
    
<br>

### Spring Boot

44.  How is Spring Boot different from legacy Spring applications? What does it mean that it is “opinionated”?
    
45.  What does “convention over configuration” mean?
    
46.  What annotation would you use for Spring Boot apps? What does it do behind the scenes?
    
47.  How does Boot’s autoconfiguration work?
    
48.  What is the advantage of having an embedded Tomcat server?
    
49.  What is the significance of the Spring Boot starter POM?
    
50.  What is the Spring Boot actuator? What information can it give you?
    
51.  What files would you use to configure Spring Boot applications?
    
52.  What is the benefit of using Spring Boot profiles?