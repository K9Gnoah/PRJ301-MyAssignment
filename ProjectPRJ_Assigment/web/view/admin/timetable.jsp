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
        <title>Attendence Page</title>
        <link rel="stylesheet" href="../css/style_2.css"/>
    </head>
    <script>
        function submitForm() {
            document.getElementsByTagName('form')[0].submit();
        }
    </script>
    <body>
        <div class="main-container">
            <nav >
                <div class="menu-items">
                    <ul class = "nav-links">
                        <li >
                            <a href="schedule?id=1">
                                <span class="link-names">Schedule</span>
                            </a>
                        </li>
                        <li>
                            <a href="absentsum">
                                <span class="link-names">Absent Sum</span>
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
            
            <div class="dashboard">   
                <form action="schedule" method="GET">          
                                    Input id instructor<input type="text" name="id" value="${param.id}" >
                                    Date <input type="date" name="date">                                    
                                    <input type="submit" value="view">   
                </form>
                <table border ="1px" class="schedule-table">
                    <thead class="schedule-header">
                        <tr>
                            <td>
                                
                            </td>
                            <c:forEach items="${requestScope.week}" var="d">
                                <td>
                                    <%--format dạng thứ--%>
                                    <fmt:formatDate value="${d}" pattern="EEEE"/> <br>
                                    <fmt:formatDate value="${d}" pattern="dd-MM"/>
                                </td>
                            </c:forEach>    
                        </tr>
                    </thead>
                    <c:forEach items="${requestScope.slots}" var="s" varStatus="loop">
                        <tr>                        
                            <td>Slot: ${s.id}<br>(${s.description})</td>
                                <c:forEach items = "${requestScope.week}" var="d">
                                <td>
                                    <c:forEach items="${requestScope.sessions}" var="k">
                                        <c:if test="${k.date eq d and k.slot.id eq s.id}">
                                            <a href="att?id=${k.id}">
                                                ${k.group.name}-${k.group.subject.name}<br>
                                                at ${k.room.id}<br>
                                                <c:if test="${k.isAtt}">
                                                    (attended)
                                                </c:if>
                                                <c:if test="${!k.isAtt}">
                                                    (not yet)
                                                </c:if>
                                            </a>
                                        </c:if>
                                    </c:forEach>
                                </td>
                            </c:forEach>
                        </tr>
                    </c:forEach>
                </table>
            </div>  
        </div>
    </body>
</html>
