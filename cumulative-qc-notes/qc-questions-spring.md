### REST: Representational State Transfer
- What is [REST](https://www.codecademy.com/articles/what-is-rest)?

- What makes an API RESTful?
  - *i.e **What are the 6 constraints of REST?***

- What is the [Richardson Maturity Model](https://martinfowler.com/articles/richardsonMaturityModel.html)?


<br>

### Spring Core

1.  What are Spring Projects and Spring Modules?
    - Spring projects are frameworks that provide solutions to other issues faces by enterprise applications
    - Spring Modules are modules that handle specific programatical tasks
    
2.  What is IOC and what does the IOC Container do?
    - IoC stands for Inversion of Control and it is the core of Spring Framework.  IoC Creates the objects, configures and assembles their dependencies, manages their        entire life cycle.  <b>Since the Controlling of Java objects and their lifecycle is not done by the developers, hence the name Inversion Of Control</b>
    - The IoC Container uses dependency Injection (DI) to manage the components that make up the application.  It gets the information about the objects from a configuration file(XML) or Java Code or Java Annotations and Java POJO class.  These objects are called Beans
    
3.  What is dependency injection and what are some of the benefits of using dependency injection?
    
4.  What types of dependency injection does Spring support?
    
5.  What are some differences between BeanFactory and ApplicationContext? Which one eagerly instantiates your beans?
    https://www.tutorialspoint.com/difference-between-application-context-and-beanfactory-in-spring-framework
    - BeanFactory does not support Annotation-based configuration <b>whereas</b> ApllicationContext does.
    - ApplicationContext is the sub-interface of BeanFactory
    - XMLBeanFactory implements BeanFactory <b>whereas</b> FileSystemXmlAPplicationContext, ClassPathXmlApplicationContext and AnnotationConfigWebApplicationContext implements ApplicationContext.
    - BeanFactory instantiate beans when getBean() methods gets called <b>whereas</b> ApplicationContext instantiate bean at the time container start
    - Bean factory does not have the ability to push events to the beans <b>whereas</b> Application Context have the ability to push events to the beans
    - BeanFactory uses Lazy loading <b>whereas</b> ApplicationContext uses Aggressive Loading
    
6.  What is the Spring Bean lifecycle?
    https://www.geeksforgeeks.org/bean-life-cycle-in-java-spring/
    - The bean life cycle refers to when & how the bean is instantiated, what action it performs while it lives, and when & how it dies.
    - The flow of the bean life cycle is:
        - Container Started
        - Bean Instantiated
        - Dependencies injected
            - Custom init()
            - Custom utility method
        - Custom destroy
    
7.  What is bean wiring? What about autowiring?
    https://www.javainterviewpoint.com/autowiring-in-spring/#:~:text=Autowiring%20is%20a%20feature%20of%20Spring%20framework%20which,be%20used%20to%20inject%20primitive%20and%20string%20values.
    - Configuring beans and their properties for dependency injection in spring configuration file (.xml) and attaching it to its corresponding object is known as      <b>Bean Wiring</b>.
    - Autowiring is a feature of Spring framework which lets you Inject Dependency implicitly. Basically it will use Setter Injection / Constructor Injection internally.
    
8.  What are the different ways that Spring can wire beans?
    https://www.javainterviewpoint.com/autowiring-in-spring/#:~:text=Autowiring%20is%20a%20feature%20of%20Spring%20framework%20which,be%20used%20to%20inject%20primitive%20and%20string%20values.
    Spring can wire beans by:
    - node which is the default one, it means not aotowiring by default
    - byName
    - byType
    - constructor
    - autodetect which useseither of two modes i.e. constructor or byType modes.  First it tries to autowire by constructor if it doesn't work then it autowire byType
    
9.  What are the scopes of Spring beans? Which is default?
    https://howtodoinjava.com/spring-core/spring-bean-scopes/
    Spring Bean Scope Types are:
    - singleton (default) Single bean object instance per spring IoC container
    - prototype - Opposite to singleton, it produces a new instance each and every time a bean is requested
    - request - A single instance will be created and available during complete lifecycle of an <b>HTTP request</b>.  Only valid in web-aware Spring <b>ApplicationContext</b>
    - session - A single instance will be created and available during complete lifecycle of an <b>HTTP Session</b>.  Only valid in web-aware Spring <b>ApplicationContext</b>
    - application - A single instance will be created and available during complete lifecycle of <b>ServletContext</b>.
Only valid in web-aware Spring <b>ApplicationContext</b>
    - websocket - A single instance will be created and available during complete lifecycle of <b>WebSocket</b>.
Only valid in web-aware Spring <b>ApplicationContext</b>.
    
10.  What is the concept of component scanning and how would you set it up?
     https://zetcode.com/spring/componentscan/#:~:text=Component%20scanning%20enables%20auto-detection%20of%20beans%20by%20Spring,as%20%40Component%2C%20%40Configuration%2C%20%40Service%20are%20auto-detected%20by%20Spring.
     - Component scanning enables auto-detection of beans by Spring container.
     - Using stereotype @ComponentScan annotation enables component scanning in Spring.
    
11.  What are the benefits and limitations of Java configuration?
    
12.  What does the @Configuration and @Bean annotations do?
     https://www.geeksforgeeks.org/spring-bean-annotation-with-example/#:~:text=One%20of%20the%20most%20important%20annotations%20in%20spring,also%20a%20part%20of%20the%20spring%20core%20framework.
     - Spring @Configuration annotation is part of the spring core framework. Spring Configuration annotation indicates that the class has @Bean definition methods. So Spring container can process the class and generate Spring Beans to be used in the application.
     - One of the most important annotations in spring is the @Bean annotation which is applied on a method to specify that it returns a bean to be managed by Spring context. Spring Bean annotation is usually declared in Configuration classes methods
13.  What is @Value used for?
     - Spring @Value annotation is used to inject values into variables and method arguments. We can either read spring environment variables or system variables. It also supports SpEL.
     
14.  What is Spring Expression Language? What can you reference using SpEL? What is the difference between $ and # in @value expressions?
     - SpEL is a scripting language that allows you to query and manipulate an object graph in real-time. JSP EL, OGNL, MVEL, and JBoss EL are just a few of the expression languages accessible.
     - What can you reference using SpEL?
     - $ in @value expressions:
        - $ is used to read Property Value in Properties File; t can only be used to dereference properties, Ex: @Value("${proxy.host}")
        - ${} can only do get
      - (#) in @value expressions:
        - "#" is used to run Spring Expression
        - #{} can do get an dset
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
