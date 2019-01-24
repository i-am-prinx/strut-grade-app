<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>


<%@ taglib uri="http://struts.apache.org/tags-bean" prefix="bean" %>
<%@ taglib uri="http://struts.apache.org/tags-html" prefix="html" %>
<%@ taglib uri="http://struts.apache.org/tags-logic" prefix="logic" %>

<html:html lang="true">
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Grade App</title>
        <link rel="stylesheet" href="styles.css"/>
        <html:base/>
    </head>
    <body>
        <section class="wrapper">
            <h1> Grade application </h1>     
            <html:form styleClass="form-wrap" method="post" action="/report">
                <div class  ="form-field">
                    <label>Name: </label> <br/>
                    <html:text property="name"/>
                </div>
                <div class="form-field">
                    <label>Math: </label> <br/>
                    <html:text property="math"/>
                </div>
                <div class="form-field">
                    <label>English: </label> <br/>
                    <html:text property="english"/>
                </div>
                <div class="form-field">
                    <label>Science: </label> <br/>
                    <html:text property="science"  />
                </div>
                <div class="form-field">
                    <label>Language: </label> <br>
                    <html:text property="language" />
                </div>
                <html:submit styleClass="submit-btn" >Generate report</html:submit>
            </html:form>
                    
            <small class="notice"><b>Note:</b> score cannot be lesser than 0 and greater than 100</small>
        </section>
    </body>
</html:html>