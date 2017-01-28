<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<html>
<head>
<script type="text/javascript"
	src="http://code.jquery.com/jquery-1.10.2.js">
	
</script>
<script type="text/javascript"
	src="http://code.jquery.com/ui/1.10.3/jquery-ui.js">
	
</script>
<link rel="stylesheet"
	href="http://code.jquery.com/ui/1.10.2/themes/smoothness/jquery-ui.css" />

<script type="text/javascript" src="./resources/js/autoComplete.js"></script>
</head>
<body>

	<div class="search-container">
		<div class="ui-widget">
			<input type="text" id="employee" name="employee" class="employee" />
			<button type="button" onclick="myFunction()">Submit</button>
		</div>
	</div>




	<script type="text/javascript">
		function myFunction() {
			var x = document.getElementById("employee").value;
			try {
				if (x == "")
					throw "empty";
				document.getElementById("demo").innerHTML = "You Have Selected: "
						+ x;
			} catch (err) {
				alert("Cannot be Empty!!!");
			}
		}
	</script>
	<p id="demo"></p>
</body>
</html>