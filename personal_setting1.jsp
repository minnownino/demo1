<!DOCTYPE html>
<html lang="en">
<head>
  <meta charset="utf-8">
  <title>Bootstrap 3, from LayoutIt!</title>
  <meta name="viewport" content="width=device-width, initial-scale=1.0">
  <meta name="description" content="">
  <meta name="author" content="">

	<!--link rel="stylesheet/less" href="less/bootstrap.less" type="text/css" /-->
	<!--link rel="stylesheet/less" href="less/responsive.less" type="text/css" /-->
	<!--script src="js/less-1.3.3.min.js"></script-->
	<!--append ‘#!watch’ to the browser URL, then refresh the page. -->
	
	<link href="css/bootstrap.min.css" rel="stylesheet">
	<link href="css/style.css" rel="stylesheet">

  <!-- HTML5 shim, for IE6-8 support of HTML5 elements -->
  <!--[if lt IE 9]>
    <script src="js/html5shiv.js"></script>
  <![endif]-->

  <!-- Fav and touch icons -->
  <link rel="apple-touch-icon-precomposed" sizes="144x144" href="img/apple-touch-icon-144-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="114x114" href="img/apple-touch-icon-114-precomposed.png">
  <link rel="apple-touch-icon-precomposed" sizes="72x72" href="img/apple-touch-icon-72-precomposed.png">
  <link rel="apple-touch-icon-precomposed" href="img/apple-touch-icon-57-precomposed.png">
  <link rel="shortcut icon" href="img/favicon.png">
  
	<script type="text/javascript" src="js/jquery.min.js"></script>
	<script type="text/javascript" src="js/bootstrap.min.js"></script>
	<script type="text/javascript" src="js/scripts.js"></script>
</head>

<body>
<div class="container">
	
	<div class="row clearfix">
		<div class="col-md-4 column">
		</div>
		<div class="col-md-4 column">
		</div>
		<div class="col-md-4 column">
		</div>
	</div>
	<div class="row clearfix">
		<div class="col-md-3 column">
		</div>
		<div class="col-md-6 column">
			<form role="form" method ="post" action = "StorepersonInfo">
				<div class="form-group">
					 <label for="exampleInputEmail1">Nickname</label><input type="name" class="form-control" id="exampleInputName" name="name">
				</div>
				<div class="form-group">
                                    <label for="exampleInputGender">Gender</label>
                                        <fieldset type="gender" class="form-control" id="exampleInputGender">                                
                                          <label for="male">male</label>
                                          <input type="radio" name="gender"  value="male" >
                                          <label for="female">female</label>
                                          <input type="radio" name="gender" value="female">         
                                        </fieldset> 					 
				</div>
                                <div class="form-group">
					 <label for="exampleInputBirthday">Birthday</label><input type="date" class="form-control" id="exampleInputBirthday" name="birthday">
                                         
				</div>
                                <div>
                                    <label for="exampleInputAddress">Address</label><select type="address" class="form-control" id="exampleInputAddress" name="address">
                                    <option value="Arlington">Arlington</option>
                                    <option value="ArlingtonHouse">Arlington House</option>
                                    <option value="Highmont">Highmont</option>
                                    <option value="Malabar">Malabar</option>
                                    <option value="Dakota">Dakota</option>
                                    <option value="Pennsylvania">Pennsylvania</option>
                                    <option value="Morrowfield">Morrowfield</option>
                                    <option value="Wendover">Wendover</option>
                                    <option value="Parklane">Parklane</option>
                                    <option value="Kingsford">Kingsford</option>
                                            </select>
                                </div>
                                
                                <div class="form-group">
                                    <label for="exampleInputEmail">Email</label><input type="email" class="form-control"  id="exampleInputEmail" name="email"> 
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputCellphone">Cellphone</label><input type="cellphone" class="form-control" id="exampleInputCellphone" name="cellphone">
                                </div>
                                <div class="form-group">
                                    <label for="exampleInputCellphone">Comments</label>
                                    <textarea name="introduction" rows="4" cols="20" class="form-control" id="exampleInputIntroduction" name="sosmessage">
                                    </textarea>
                                </div>
                            
				<div class="checkbox">
					 <label><input type="checkbox"> Check me out</label>
				</div> <button type="submit" class="btn btn-default">Submit</button>
			</form>
		</div>
		<div class="col-md-3 column">
		</div>
	</div>
</div>
</body>
</html>
