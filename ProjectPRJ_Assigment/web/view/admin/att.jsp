<%-- 
    Document   : att
    Created on : Nov 8, 2023, 1:37:08 AM
    Author     : THINKPAD
--%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Attendence Class</title>
        <link rel="stylesheet" href="../css/style_2.css"/>
    </head>
    <body>
        <div class="main-container">
            <nav >
                <div class="menu-items">
                    <ul class = "nav-links">
                        <li >
                            <a href="schedule">
                                <span class="link-names">Schedule</span>
                            </a>
                        </li>
                    </ul>
                    <ul class ="logout-mode">
                        <li>
                            <a href="../logout">
                                <span class="link-names">LOG OUT</span>
                            </a>
                        </li>
                    </ul>
                </div>
            </nav>
            <div class="dashboard" >
                ${requestScope.ses.group.name}-${requestScope.ses.group.subject.name}-${requestScope.ses.room.id}
                <form action="att" method = "POST">
                    <table border ="1px" class="att-table">
                        <thead class="att-header">
                            <tr>
                                <td>Student</td>
                                <td>Status</td>
                                <td>Description</td>
                                <td>Taking Time</td>
                            </tr>
                        </thead>
                        <c:forEach items="${requestScope.atts}" var="a">
                            <tr>
                                <td>                            
                                    ${a.student.name}
                                    <input type="hidden" name="stuid" value="${a.student.id}"/>
                                </td>     
                                <td>
                                    <input type="radio"
                                           <c:if test="${!a.status}">
                                               checked="checked"
                                           </c:if>
                                           name="status${a.student.id}" value="absent" /> absent
                                    <input type="radio"
                                           <c:if test="${a.status}">
                                               checked="checked"
                                           </c:if>
                                           name="status${a.student.id}" value="present" /> present
                                </td>
                                <td><input type="text" value="${a.description}" name="description${a.student.id}"/></td>
                                <td>${a.datetime}</td>
                            </tr>
                        </c:forEach>
                    </table>
                    <input type="hidden" value="${requestScope.ses.id}" name="sesid"/>
                    <div class="finish-form">
                        <input type="submit" value="Save"/>
                        <input type="reset" value ="Reset"/>
                    </div>
                </form>
            </div>
        </div>
    </body>
</html>
