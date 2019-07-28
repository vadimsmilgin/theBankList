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
        <sql:setDataSource var = "data" driver = "com.mysql.jdbc.Driver"
                                 url = "jdbc:mysql://localhost:3306/example"
                                 user = "root"  password = "esc.pro1009117"/>

        <sql:query dataSource = "${data}" var = "theRichestUser">
            select concat(u.name,' ',u.sureName) as fullName from user u
                join account a on u.userid = a.userid
                    where account = (select max(account) from account);
        </sql:query>

        <sql:query dataSource = "${data}" var = "SumOfAccounts">
                    select sum(account) as fullSum from account;
        </sql:query>

        <div>
             <c:forEach var="row" items="${theRichestUser.rows}">
                <input type="hidden" id="hidden1" value="${row.fullName}"/>
             </c:forEach>
             <c:forEach var="row" items="${SumOfAccounts.rows}">
                <input type="hidden" id="hidden2" value="${row.fullSum}"/>
             </c:forEach>
        </div>
        <div>
            <input type="text" placeholder="richest user" id="valueUser" />
            <input type="button"
                   name="richer"
                   value="Get"
                   onclick="document.getElementById('valueUser').value = document.getElementById('hidden1').value;"/>
        </div>
        <br>
        <div>
            <input type="text" placeholder="accounts sum" id="valueSum"/>
            <input type="button"
                   name="sum"
                   value="Get"
                   onclick="document.getElementById('valueSum').value = document.getElementById('hidden2').value;"/>
        </div>
        </form>
    </body>
</html>