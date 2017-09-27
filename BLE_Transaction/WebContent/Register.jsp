<!DOCTYPE html>
<html>
<head>
    <title>Register</title>
    <link rel="stylesheet" href="css/bootstrap.min.css">
    <link href="css/Register.css" rel="stylesheet" type="text/css" />
</head>

<body>
    <div class="container">
        <div class="row">
            <div class="col-xs-8 col-md-offset-2">
                <div class="BOX">
                    <h1>Welcome To Join Us</h1>
                    <form action="register.do" method="post">
                        <p>
                            <label><b>UserName</b></label><br>
                            <input type="text" class="form-control" placeholder="Username" name="username" required>
                        </p>
                        <p>
                            <label><b>Password</b></label><br>
                            <input type="password" class="form-control" placeholder="Password" name="password" required>
                        </p>
                        <p>
                            <label><b>Verify Password</b></label><br>
                            <input type="password" class="form-control" placeholder="Verify Password" name="pwd_again" required>
                        </p>
                        <p>
                            <label><b>Identity Card Number</b></label><br>
                            <input type="password" class="form-control" placeholder="Enter Identity card number" name="IDnumber" required>
                        </p>
                        <p>
                            <label><b>E-mail</b></label>
                            <input type="email" class="form-control" placeholder="Enter E-mail" name="email" required>
                        </p>
                        <p>
                            <label><b>Category</b></label><br>
                            <select class="form-control" name="category">
                                <option value="1">Buyer</option>
                                <option value="2">Store</option>
                            </select>
                        </p>
                        <p>
                            <button type="submit" class="btn btn-success btn-block">submit</button>
                            <button type="reset" class="btn btn-danger btn-block">Reset</button>
                            <label><b>Already have a account? </b></label><br>
                            <a href="Login.jsp" class="btn btn-primary btn-block">Return To Login</a>                                              
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
