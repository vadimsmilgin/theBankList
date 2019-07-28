<%@ page import = "java.io.*,java.util.*,java.sql.*"%>
<%@ page import = "javax.servlet.http.*,javax.servlet.*" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/sql" prefix = "sql"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix = "c"%>

<!DOCTYPE html>
<html>
    <head>
        <title>JSP</title>
    </head>
    <body>

        <form method="post" action="ServletForJSP">
            <div>
                <input type="text" placeholder="richest user" value="${valueUser}" name="valueUser"/>
                <input type="submit" name="richer" value="Get"/>
            </div>
        <br>
        <div>
            <input type="text" placeholder="accounts sum" value="${valueSum}" name="valueSum"/>
            <input type="submit" name="sum" value="Get"/>
        </div>
        </form>
    </body>
</html>
