<%-- 
    Document   : editnote
    Created on : Feb 2, 2021, 4:24:01 PM
    Author     : WCour
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Simple Note Keeper</title>
    </head>
    <body>
        <h1>Simple Note Keeper</h1>
        <h2>Edit Note</h2>
        <form method="post" >
            Title: <textarea name="eTitle" value="">${eTitle}</textarea>

            Contents: <textarea  name="eContent" value="">${eContent}</textarea>

            <input type="submit" value="Save">   
        </form>


    </body>
</html>
