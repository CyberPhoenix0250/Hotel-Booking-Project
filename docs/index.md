
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Online Hotel Booking</title>
</head>
<body align='justify'>
    <center><h1>Online Hotel Booking Client Application</h1></center>
    <h2><u>About</u></h2>
        Online Hotel Booking application is a client side application developed using java and Oracle database,
<br>
In order to install this you need the following software:-<br>
1. Eclipse IDE<br>
2. Oracle Database software (either 10g or 11g).<br>
3. SQL Developer<br>
<br>
STEPS:<br>
1. First install all the above given softwares.<br>
2. import the provided Auberge java project into the eclipse IDE.<br>
3. After importing you may see a RED exclaimation mark on the Auberge project.<br>
   (this mark means that your jdbc driver was unable to load successfully and needs to be imported again.)<br>
4. ojdbc6.jar file is provided in the archive, In the eclipse IDE right click on the Auberge Project icon,<br>
   and click properties, now remove the previous ojdbc6.jar file and import the new one which is provided in the archive.<br>
5. after doing this the RED exclaimation mark will be gone, which means your application is ready to go.<br><br>

before launching it you have to setup the database, Create a user with username = "admin", password = "admin"(IMPORTANT) <br>
into the Oracle database, after creating just open that database with SQL developer and import the SQL file <br>
and execute the Script, when the Script executed successfully now you are ready to launch the application.<br><br>

before launching just make sure that the Oracle Database service is running.<br>
if you are getting an Error as "Error in Resolving Driver Class Name" then it means that there is some trouble with the <br>
jdbc/odbc driver which you imported.<br><br>

if you are getting an Error as "Program was Unable to establish a connection with the Database. Please check whether <br>
the Database service is running or not." then either your Database service is not running or the username and password <br>
of the database is incorrect.<br>
<br>
    <h2><u>Quick Glance</u></h2>
    <center><p>
        <video width="350" height="350" controls>
         <source src="res/Auberge-1.webm" type="video/webm">
       Your browser does not support the video tag.
       </video> 
    </p></center>
</body>
</html>
