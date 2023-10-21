<%-- 
    Document   : login
    Created on : Oct 13, 2023, 11:41:36 PM
    Author     : THINKPAD
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <link rel="stylesheet" href="css/homepage.css"/>
        <title>FPT University</title>
    </head>
    <body>
        <div class="bg" style="background-image: url(image/login.jpg);">         
        </div>
        <div class="container">
            <div class="left-side">
                <div class="form-container sign-in-container">
                    <form action="login" method="POST">
                        <h1>Sign in</h1>                                
                        <input type="text" name="email" placeholder="Email" required=""/><br />
                        <input type="password" name="password" placeholder="Password" required=""/><br />                    
                        <button>Sign In</button>
                    </form>
                </div>
            </div>
            <div class="right-side">
                <div class="overlay-container">                
                    <div class="overlay-right">
                        <h1>Hello, Friend!</h1>
                        <p>Sign up if you don't have an account already</p>
                        <button class="right">Sign Up</button>
                    </div>
                </div>
            </div>
        </div>
    </body>
</html>
