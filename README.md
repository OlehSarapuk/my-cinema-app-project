<h1><img src="https://img.freepik.com/premium-vector/illustration-negative-film-reel-roll-tapes-movie-cinema-video-logo_468322-1105.jpg?w=740" alt="Cinema Image" width="50" height="50"/> Cinema Application <img src="https://img.freepik.com/premium-vector/illustration-negative-film-reel-roll-tapes-movie-cinema-video-logo_468322-1105.jpg?w=740" alt="Cinema Image" width="50" height="50"/></h1>

This project is a RESTful web application that serves as a simplified version of a real cinema app. Built on the Hibernate and Spring frameworks, the application allows users to register or login as either a User or an Admin, each with their own set of permissions. Users can view the movie schedule, purchase tickets, and access information on available movies, including movie descriptions. Admins have additional permissions, allowing them to create movies, cinema halls, and movie sessions based on them. They can also update or delete existing movie sessions.

## Functionality
<ul>
  <li>Registration of new user with creating personal shopping cart</li>
  <li>Authentication</li>
  <ul>
    <li>USER</li>
    <ul>
      <li>view your orders</li>
      <li>view your shopping cart</li>
      <li>view users by email</li>
      <li>complete order</li>
      <li>add movie session to your shopping cart</li>
    </ul>
  </ul>
  <ul>
    <li>ADMIN</li>
    <ul>
      <li>create cinema halls</li>
      <li>create movies</li>
      <li>create, update and delete movie sessions</li>
    </ul>
  </ul>
  <ul>
    <li>USER and ADMIN</li>
    <ul>
      <li>view cinema halls</li>
      <li>view movies</li>
      <li>view available movie sessions</li>
    </ul>
  </ul>
</ul>

## How to run
<ul>
  <li>Clone the project repository onto your local machine</li>
  <li>Install MySQL if needed</li>
  <li>Create new empty schema in your DB via command <code>CREATE SCHEMA `cinema` DEFAULT CHARACTER SET utf8;</code></li>
  <li>Replace the values of the <code>YOUR_DRIVER</code>, <code>YOUR_DATABASE_URL</code>, <code>YOUR_USERNAME</code> and <code>YOUR_PASSWORD</code> properties 
  with the appropriate values for your database setup in [db.properties](src/main/resources/db.properties)</li>
  <li>Build the project using Maven: <code>mvn clean install</code></li>
  <li>Configure Apache Tomcat, select war-exploded artifact and set application context: "/"</li>
  <li>You can log in with an existing accounts<li>
  <ul>
    <li>login:admin@i.ua, password:admin1234 with ADMIN permissions</li> 
    <li>login:user@i.ua, password:user1234 with USER permissions</li>
  </ul>
  <li>Or register a new user</li>
</ul>

## Technologies
<ul>
  <li>Java <code>17.0.6</code></li>
  <li>Apache Maven<code>3.9.1</code></li>
  <li>Apache Tomcat<code>9.0.73</code></li>
  <li>MySQL Connector<code>8.0.32</code></li>
  <li>Hibernate<code>5.6.14.Final</code></li>
  <li>Spring Core<code>5.3.20</code></li>
  <li>Spring Web MVC<code>5.3.20</code></li>
  <li>Spring Security<code>5.6.10</code></li>
  <li>Hibernate Validator<code>6.1.6.Final</code></li>
  <li>Javax Servlets<code>4.0.1</code></li>
  <li>Javax Annotations<code>1.3.2</code></li>
</ul>

## Structure
<ul>
  <li>CONFIG: configure Spring</li>
  <li>CONTROLLER (endpoints): </li>
  <ul>
    <li>Registration - <code>POST /register</code> - registration of new user <code>ALL</code></li>
    <li>Login - <code>POST /login</code> - authentication <code>ALL</code></li>
    <li>Logout - <code>GET /logout</code> - invalidate current session</li>
    <li>Cinema Halls: 
      <ul>
        <li><code>GET /cinema-halls/</code> - show all available cinema halls <code>USER and ADMIN</code></li>
        <li><code>POST /cinema-halls/</code> - adds a new cinema hall <code>ADMIN</code></li>
      </ul>
    <li>Movie: 
      <ul>
        <li><code>GET /movies/</code> - show all available movies <code>USER and ADMIN</code></li>
        <li><code>POST /movies/</code> - adds a new movie <code>ADMIN</code></li>
      </ul>
    <li>Movie Sessions: 
      <ul>
        <li><code>GET /movie-sessions/available/</code> - show all available movie sessions <code>USER and ADMIN</code></li>
        <li><code>POST /movie-sessions/</code> - adds a new movie session <code>ADMIN</code></li>
        <li><code>PUT /movie-sessions/${id}/</code> - update movie session by ID <code>ADMIN</code></li>
        <li><code>DELETE /movie-sessions/${id}</code> - delete movie session by ID <code>ADMIN</code></li>
      </ul>
    <li>Shopping Cart: 
      <ul>
        <li><code>GET /shopping-carts/by-user/</code> - show all tickets added to user's shopping cart <code>USER</code></li>
        <li><code>PUT /shopping-carts/movie-sessions/</code> - update shopping cart by movie session ID <code>USER</code></li>
      </ul>
    <li>Order: 
      <ul>
        <li><code>GET /orders/</code> - show user's order history <code>USER</code></li>
        <li><code>POST /orders/complete</code> - complete order <code>USER</code></li>
      </ul>
    <li>User: 
      <ul>
        <li><code>GET /users/by-email/</code> - show user's information by email <code>USER</code></li>
      </ul>
  </ul>
  <li>DAO: Data Access Object interfaces and their implementations</li> 
  <li>DTO: Data Transfer Object - wrapper for model objects to unify the requests and responses in controllers</li>
  <li>EXCEPTION: custom exception classes</li>
  <li>LIB: contains email and password validators with custom annotations</li>
  <li>MODEL: POJOs that represent data</li>
  <li>SECURITY: JWT configuration and CustomUserDetailsService</li>
  <li>SERVICE: Service interfaces and their implementations that perform business logic</li>
  <li>UTIL: Utility class used in a project to save DateTime pattern and initialize default users</li>
  <li>RESOURCES: Non-Java files that save database configurations</li>
</ul>

## Entity Structure

<img src="https://raw.githubusercontent.com/mate-academy/hibernate-configuration-hw/master/Hibernate_Cinema_Uml.png" alt="Entity Structure"/>

## Features employed in project
<ul>
  <li>Three-level architecture</li>
  <li>RESTful</li>
  <li>Stateless</li>
  <li>SOLID</li>
  <li>Custom exceptions</li>
  <li>JSON</li>
  <li>Role-based authorization</li>
</ul>

## Author
Oleh Sarapuk
