<%-- 
    Document   : timetable
    Created on : Oct 30, 2023, 2:43:53 PM
    Author     : THINKPAD
--%>

<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <script>
        function submitForm() {
            document.getElementsByTagName('form')[0].submit();
        }
    </script>
    <body>
        <div>
            <table border ="1px">
                <tr>
                    <td>
                        <form action="schedule" method="get">
                            Date
                            <input type="date" id="date" name="date" value="${requestScope.date}" onchange="submitForm()"><br/>
                        </form>
                    </td>
                    <c:forEach items="${requestScope.week}" var="d">
                        <td>
                            <%--format dạng thứ--%>
                            <fmt:formatDate value="${d}" pattern="EEEE"/> <br>
                            <fmt:formatDate value="${d}" pattern="dd-MM"/>
                        </td>
                    </c:forEach>    
                </tr>
            </table>
        </div>
    </body>
</html>
