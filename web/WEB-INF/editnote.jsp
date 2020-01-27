<%-- 
    Document   : editnote
    Created on : Jan 27, 2020, 10:30:46 AM
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
        <h3>Edit Note</h3>
        <div>
            <form action="note" method="POST">
                <b>Title</b>:<input type="text" name="ntitle" value="${Note.title}"><br>
                <b>Contents</b>:<textarea>hello</textarea><br>
                <input type="submit" value="Save"><br>
            </form>
            <a href="note?edit='true'">Edit</a>
        </div>
    </body>
</html>
