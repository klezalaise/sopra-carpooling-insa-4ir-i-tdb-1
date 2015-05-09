# The softwares needed #

  * Download and install (if not already) [JDK1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)

  * Download and install [Eclipse Luna for JavaEE](https://eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunar)

  * Download and install [Apache Tomcat 8.0.15](http://tomcat.apache.org/download-80.cgi) (Core)

  * Install SVN plugin for eclipse ([detailed instructions here](https://eclipse.org/subversive/documentation/gettingStarted/aboutSubversive/install.php))

  * Download and install [EasyPHP](https://bitbucket.org/easyphp/easyphp-devserver/downloads/EasyPHP-DevServer-14.1VC11-install.exe) for local database administration


---


# Check out the project #

Within Eclipse, check out our google code project
```
svn checkout http://sopra-carpooling-insa-4ir-i-tdb-1.googlecode.com/svn/trunk/ sopra-carpooling-insa-4ir-i-tdb-1-read-only
```


---


# Database initialisation #

You have to execute the SQL Script _svn/trunk/SopRide/db/setupDatabase.sql_ in order to initialise your database.

  1. Launch EasyPHP and then go to [EasyPHP Administration Modules](http://127.0.0.1/modules/)
  1. Click on PHPMyAdmin
  1. Then, click on the "SQL" button visible at the top of the interface.
  1. Paste the SQL queries from _svn/trunk/SopRide/db/setupDatabase.sql_ (you can access to a copy of the file on the dedicated wiki page)



---


# Launch the web application #
  1. Once you have launched Eclipse Luna and you have checked out our project, press CTRL + F11 to Run the Application
  1. Go to [the Sopride homepage](http://localhost:8080/SopRide/) and start using the website.


---


# Discover all the features included #

<a href='http://www.youtube.com/watch?feature=player_embedded&v=aTBKoviwRYU' target='_blank'><img src='http://img.youtube.com/vi/aTBKoviwRYU/0.jpg' width='425' height=344 /></a>


---



# Web development : Useful sources #

http://openclassrooms.com/courses/creez-votre-application-web-avec-java-ee/outils-et-environnement-de-developpement

http://openclassrooms.com/courses/creez-votre-application-web-avec-java-ee/introduction-a-mysql-et-jdbc