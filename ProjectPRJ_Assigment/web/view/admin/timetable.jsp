<%-- 
    Document   : timetable
    Created on : Oct 30, 2023, 2:43:53 PM
    Author     : THINKPAD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <div>
            <table border ="1px">
                <tr>
                    <td>
                        <form action="admin/schedule" method="get">
                            Date
                            <input type="date" id="date" name="date" value="${requestScope.date}" onchange="submitForm()"><br/>
                        </form>
                    </td>
                </tr>
            </table>
        </div>
    </body>
</html>
