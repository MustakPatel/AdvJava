
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Sign Up Form by Colorlib</title>

    <!-- Font Icon -->
    <link rel="stylesheet" href="fonts/material-icon/css/material-design-iconic-font.min.css">

    <!-- Main css -->
    <link rel="stylesheet" href="css/style.css">
</head>
<body>
<!-- Sing in  Form -->
        <section class="sign-in">
            <div class="container">
                <div class="signin-content">
                    <div class="signin-image">
                        <figure><img src="images/signin-image1.jpg" alt="sing up image"></figure>
                    </div>

                    <div class="signin-form">
                        <h2 class="form-title">Sign in</h2>
                        <form action="login" method="get" class="register-form" id="login-form">
                            <div class="form-group">
                                <label><i class="zmdi zmdi-account material-icons-name"></i></label>
                                <input type="email" name="email" placeholder="Email address" required/>
                            </div>
                            <div class="form-group">
                                <label> <i class="zmdi zmdi-lock"></i></label>
                                <input type="password" name="password" placeholder="Password" required/>
                            </div>

                            <div class="form-group form-button">
                            <a href="SignUp.html" class="signup-image-link">Create an account</a>
                                <input type="submit" name="signin" id="signin" class="form-submit" value="Log in"/>
                            </div>
                        </form>

                    </div>
                </div>
            </div>
        </section>

 <!-- JS -->
    <script src="vendor/jquery/jquery.min.js"></script>
    <script src="js/main.js"></script>
</body>
</html>
