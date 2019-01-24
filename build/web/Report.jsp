<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>

<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>


<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Report Page</title>
        <link rel="stylesheet" href="styles.css"/>
        <html:base/>
    </head>
    
    <body>
        <c:set var="name" value="${sessionScope.name}"/>
        <c:set var="math" value="${sessionScope.math}"/>
        <c:set var="math_gc" value="${sessionScope.math_gc}"/>
        <c:set var="english" value="${sessionScope.english}"/>
        <c:set var="english_gc" value="${sessionScope.english_gc}"/>
        <c:set var="science" value="${sessionScope.science}" />
        <c:set var="science_gc" value="${sessionScope.science_gc}"/>
        <c:set var="language" value="${sessionScope.language}" />
        <c:set var="language_gc" value="${sessionScope.language_gc}" />
        <c:set var="total" value="${sessionScope.total_points}" />
        <c:set var="grade" value="${sessionScope.grade}" />
        
        <section class="wrapper">
            <h1>Grade Report For <c:out value="${name}" /></h1>
            
            <div class="reports">
                <div class="report-field math">
                    <h1 id="title">Math: </h1>
                    <p class="value">
                        <b><c:out value="${math}"/></b> &emsp; -- &emsp;  
                        <c:out value="${math_gc}"/>
                    </p>
                </div>

                <div class="report-field english">
                    <h1 id="title">English: </h1>
                    <p class="value">
                        <b><c:out value="${english}"/></b> &emsp; -- &emsp;
                        <c:out value="${english_gc}"/>
                    </p>
                </div>

                <div class="report-field science">
                    <h1 id="title">Science: </h1>
                    <p class="value">
                        <b><c:out value="${science}"/></b> &emsp; -- &emsp;
                        <c:out value="${science_gc}"/>
                    </p>
                </div>

                <div class="report-field language">
                    <h1 id="title">Language: </h1>
                    <p class="value">
                        <b><c:out value="${language}"/></b> &emsp; -- &emsp;
                        <c:out value="${language_gc}"/>
                    </p>
                </div>
            </div>
            
            
            <div class="totaling">
                <p>
                    Total Point: &emsp; 
                    <span class="t">
                        <c:out value="${total_points}"/>
                    </span>
                </p>
                <p>Grade: &emsp; <span class="t"><c:out value="${grade}"/></span></p>
            </div>
            
        </section>
    </body>
</html:html>
