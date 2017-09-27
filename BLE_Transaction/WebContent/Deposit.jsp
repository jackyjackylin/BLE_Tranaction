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
                    <h1>Let's Deposit it !</h1>
                    <form action="deposit.do" method="post">
                        <p>
                            <label><b>Serial Number</b></label><br>
                            <input type="text" class="form-control" placeholder="Serial_Number" name="Serial_Number" required>
                        </p>
                        <p>
                            <button type="submit" class="btn btn-success btn-block">submit</button>
                            <a href="AccountTable.jsp" class="btn btn-primary btn-block">Back</a>                                              
                        </p>
                    </form>
                </div>
            </div>
        </div>
    </div>
</body>
</html>
