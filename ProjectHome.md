This project is intended to develop a carpooling web application for employees of Sopra.
The application is implemented in Java EE.

Members :
DANG Hai An,
ROUVIER Philippe,
GOURRAUD Anthony,
JAUFFRET Pascal,
GRÉVIN Arthur, and
VEY Alexandre

# Discover our application in 5 minutes #

<a href='http://www.youtube.com/watch?feature=player_embedded&v=aTBKoviwRYU' target='_blank'><img src='http://img.youtube.com/vi/aTBKoviwRYU/0.jpg' width='425' height=344 /></a>


---


# SRS, SDD, and other information #

  * You can find the Javadoc [online](https://goo.gl/C9KTlJ) or in the _svn/trunk/SopRide/doc/_ folder
  * Feel free to check our wiki pages or [our google drive folder](https://drive.google.com/folderview?id=0B6P7k_xa0VHRVUFRX1R0WE92cmM&usp=drive_web)


---


# Check out the project #

Within Eclipse, check out our google code project
```
svn checkout http://sopra-carpooling-insa-4ir-i-tdb-1.googlecode.com/svn/trunk/ sopra-carpooling-insa-4ir-i-tdb-1-read-only
```


---


# Launch the web application #
  1. Once you have initialised the database, launched Eclipse Luna and checked out our project, press CTRL + F11 in Eclipse to Run the Application
  1. Go to [the Sopride homepage](http://localhost:8080/SopRide/) and start using the website.


---


# The softwares required for the project #

  * [JDK1.7](http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html)

  * [Eclipse Luna for JavaEE](https://eclipse.org/downloads/packages/eclipse-ide-java-ee-developers/lunar)

  * [Apache Tomcat 8.0.15](http://tomcat.apache.org/download-80.cgi) (Core)

  * The SVN plugin for eclipse ([detailed instructions here](https://eclipse.org/subversive/documentation/gettingStarted/aboutSubversive/install.php))

  * [EasyPHP](https://bitbucket.org/easyphp/easyphp-devserver/downloads/EasyPHP-DevServer-14.1VC11-install.exe) for local database administration


---


# Database initialisation #

You have to execute the SQL Script _svn/trunk/SopRide/db/setupDatabase.sql_ in order to initialise your database.

  1. Launch EasyPHP and then go to [EasyPHP Administration Modules](http://127.0.0.1/modules/)
  1. Click on PHPMyAdmin
  1. Then, click on the "SQL" button visible at the top of the interface.
  1. Paste the SQL queries from _svn/trunk/SopRide/db/setupDatabase.sql_ (you can access to a copy of the file on the dedicated wiki page)
