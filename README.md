# 3rd-Year-Project-

## Table of Content
Introduction

Project Idea and Development

Technology Used

User Guide

Development Methodology

Limitations and Known Bugs

Conclusion

References

# Introduction
My intention for my final year project was to create a Note Storing System for  students so they could have all their notes all in one place, I want to use eclipse to make a JSF style project written in java with a SQL database to store all the data. I had intended to allow students add their notes, and to search through the database for their notes. There is a list of all subjects that the student can use and then develop the notes from then on.
I have some understanding of JSF from previous years in college but I think I should develop it a bit more to do my project. Java has been one of my core languages for the last three years, and SQL. This project has helped me develop SQL queries and how to build a database. The database that I am using I created myself. I am using apache tomcat 8.5 for a server to show the application on localhost. The information will be stored in a SQL database and kept, the database is the key factor for this application. 
When I finish this project, I expect to have better understanding of JSF and SQL. My Final finish application gives you a listing of all subjects in the database, allows you to create, read, update and delete notes from the system. Also provides extra information about GMIT and their online facilities for students to use. 

# Project Idea and Research


My idea for this project came from writing out notes that teachers give us or notes they handout and not being able to keep them organized or even losing them after sometime.

I started looking up best way fo going about the project, I did lot of research how note systems work and whats the best way to build note system that is very simple and easy to use for students. Beging of project I messed around with pages creting them and getting them to display data after that I slowly added database basics for that I created another page with capabilities to add text in database and display on web page, doing that simple tasks help me to understand how database and xml pages work and how to process to my main goal.
After that I took my time to learn have to make pages more professional looking and I decided to add Boostrap to help me with styling. 
I designed this project as a single-user system for one user at a time, all they need to do is look up for the subject they want to add notes for, then add Notes to their Subject topic ID. After that they can read their notes in numerical order ascending by subject id. There is a page there with more information which will give you direct links to useful pages for students.






# Technology Used
The technology I used in my project are the following:
•	Java\ Eclipse
•	SQL \ wampserver
•	JSF
#### Eclipse
Is defined as a platform that has been designed for building integrated web and application development tooling. The design of the platform doesn’t have a lot for the user in functionality and design, the overall platform promotes rapid development of integrated system features based upon plugins. It delivers a UI/ user interface mode with working tools. It can handle and run numerous OS/ operating systems despite the fact offering a strong integration operating system. Eclipse offers multiple plugins and APIs which are supported on its operating system. Eclipse has a very dynamic architecture structure for discovery, loading and running of their plugins. The platform handles the logistics of finding and running the right code. The platform UI provides a standard user navigation model. Each individual plugin can concentrate on their appointed task(s). Their task are mainly testing, animating, publishing, compiling, debugging and much more.
#### Java
Java is a general purpose, high level programming language developed by Sun Microsystems. It was initially started back in 1991 and originally called OAK, at the time it was created it was designed to handheld devices. It was developed in 1995 for the budding new World Wide Web\Internet and it changed its name to java. Is defined as an Object-Oriented Language and it is very like C++, the source code files with a .java extension are compiled into a format called bytecode files with a .class extension.
#### WampServer
It is a web development platform on windows that allows you to make dynamic web applications with Apache, PHP and of course mysql. The wampserver automatically installs everything you need to develop databases and web applications.
#### MySQL
Is most popular and in demand open source SQL database management systems and was acquired by Oracle back in January 2010 which is developed, distributed and supported by their corporation now. MySQL is a relational database which stores data in separate table instead of placing all the data in one big unordered table. Its database structures are organized to optimize for speed in the physical layer. The logical layer deals with tables, views and rows and columns. Also, it’s software is open sourced. The MySQL Database Server is very fast, reliable, scalable, and easy to use.
#### Database Design
I used a wampserver to create the studybuddy database, I then create three tables and then I called them “subjects”, “topics”, “subject_topics”. Here are the sql commands I used to create the database and tables.

#### Creating Database

###### Create Database ‘notedude’;

###### Creating Subject Table
DROP TABLE IF EXISTS `subjects`;
CREATE TABLE IF NOT EXISTS `subjects` (
  `id` int(3) NOT NULL,
  `name` text NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

###### Creating Subject Topic Table
DROP TABLE IF EXISTS `subject_topics`;
CREATE TABLE IF NOT EXISTS `subject_topics` (
  `subjectID` int(3) NOT NULL,
  `topicID` int(11) NOT NULL,
  PRIMARY KEY (`subjectID`,`topicID`),
  KEY `topicID` (`topicID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

###### Creating Topics Table
DROP TABLE IF EXISTS `topics`;
CREATE TABLE IF NOT EXISTS `topics` (
  `topicID` int(11) NOT NULL,
  `topicName` text NOT NULL,
  `details` mediumtext NOT NULL,
  PRIMARY KEY (`topicID`),
  KEY `topicID` (`topicID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;


# User Guide

## Installation
1)Download wampserver - it containes new versions of apache, php and mysql.

2)Download tomcat - Select type of Installation Normal, click Next, click next on the Configuration Options screen, set the JRE (Java Runtime Environment) Path e.g. C:\Program Files\Java\jre1.8.0_101 and click next and finally click Install.

3)Install Eclupse IDE for jave EE developers

## Starting application
When everything is installed open project in eclipse and run with tomcat server if everything installed right should be able to open app
 on this web page http://localhost:8080/NoteDude/faces/Index.xhtml



# How to Use Application
### Homepage
The homepage is the navigation tool to go through the main pages of the project. Here are the mains of the Application.

![welcome](https://user-images.githubusercontent.com/16356275/38364862-1ec70778-38d2-11e8-808a-e28391065096.png)

### Subject Listing

Displays all the subjects that are stored in the database.
![subject listing](https://user-images.githubusercontent.com/16356275/38365255-82b7e33c-38d3-11e8-92ad-a6a161ec48e6.png)

### Notes
The Notes page displays all the notes in the database and they are ordered in numerical order by Subject ID. You can navigate through the pages here to add Subject topic id, notes, update and delete notes as well. Click on Add Subject Topic to begin.

![notes](https://user-images.githubusercontent.com/16356275/38365349-e00ce8e8-38d3-11e8-8235-be92e5e7189b.png)


### Add Notes
Enter the name of the topic and content of the topic you wish to create and click add. Now return to the Notes page and it has been added to the table in the database.
![addnotes](https://user-images.githubusercontent.com/16356275/38365445-3f0ae520-38d4-11e8-875a-19209ea52cfc.png)

### Add Subject Topic ID
After you add notes you will need to asign note to subject topic id.
![addsubjecttopic](https://user-images.githubusercontent.com/16356275/38936616-1a01315e-4319-11e8-861e-c927558e5e70.png)


### Update Not
To update your notes, you must look for the topic id of which note you wish to change. Enter the selected id, you can now change the name and details of the topic.
![updatenotes](https://user-images.githubusercontent.com/16356275/38936765-71905c24-4319-11e8-9920-aa27316a56f2.png)

### Delete Notes
Deleting notes are very easy, find the topic id of which note\topic you wish to delete. Enter the id and execute it by clicking delete, now return to your notes its deleted.
![delete](https://user-images.githubusercontent.com/16356275/38940506-291c4bf2-4322-11e8-9b07-54780a7ebe01.png)

### More information
This page has all the helpfull information links that students can use.
![moreinformation](https://user-images.githubusercontent.com/16356275/38940676-af771e84-4322-11e8-9b8c-0ce2dbb4271f.png)


# Limitations and Known Bugs
The projects minor limitation is that sometimes it cuts out.


# Conclusion
What I learned from this project, that it is very dependent on the java layer so that it can access, read from the Database. The java layer controls all the activity that goes on in the application. The xhtml pages are simply to display, take in, update and delete values in the database which is all controlled by the java files. I researched how to create a database and it was quite easy, I can now develop and manage this database.

I run into few problems with trying to addd/Add subject topic id and delete features, when i tried to add note it would add in database but not in web page and it would desplay, i had same proble with delete but in this case app would stop working all togehtere and had to restart it. to fix this problmes i made this cjanges.
  1)	After adding SubjectTopic and Notes, the program was not directed to legitimate page rather it was returning to non-existing page.       I redirected it to legitimate page by changing the return type.
  2)	For deleting Notes, it was not deleting the children/foreign-key tables’ record. For this purpose, I deleted the children first         then the note.
  
If I could enhance this project in any way I would have added a login feature to allow more than one user to store notes on this system, and to be able to upload pictures and save it.

# References
Youtube

MySQL documentation : https://dev.mysql.com/doc/refman/5.7/en/introduction.html

Eclipse

Tomcat

Wampserver

JSF Documentation

JSF tutorials

Bootstrap styling

SQL tutorial

Tomcat Documentation

Eclipse Documentation
