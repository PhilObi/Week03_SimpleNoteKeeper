<%-- 
    Document   : viewnote
    Created on : Jan 27, 2020, 10:30:28 AM
    Author     : Phillip Obiora
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h3>View Note</h3>
        <div>
            <b>Title</b>:${Note.title}<br>
            <b>Contents</b>:<br> ${Note.contents}<br>

            <a href="note?edit='true'">Edit</a>
        </div>
    </body>
</html>
