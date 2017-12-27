<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Category</title>
<!-- Latest compiled and minified CSS -->
<link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css">
<!-- jQuery library -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>

<!-- Latest compiled JavaScript -->
<script src="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<style>
	body {
		
	}
	
	header {
		height: 40px;
		background-color: black !important
	}
	
	#container {
		width: 1200px;
		margin: 0 auto;
	}
</style>
<header>
</header>
<body onload="load();">
	<div id="container">
		<input type="hidden" id="id" name="id">
		<div class="form-group">
			<div class="col-md-2"><lable>Name:</lable></div>
			<div class="col-md-10"><input type="text" id="name" required="required" name="name"></div>
		</div>
		<div class="form-group">
			<div class="col-md-2"><lable>Summary:</lable></div>
			<div class="col-md-10"><input type="text" id="summary" required="required" name="summary"></div>
		</div>
		<button onclick="submit();">Submit</button>
	
		<table id="table" border=1 class="table table-striped table-bordered table-hover table-condensed">
			<tr> <th> Name </th> <th> Summary </th> <th> Edit </th> <th> Delete </th> </tr>
		
		</table>
			
	
		<script type="text/javascript">
		data = "";
		submit = function(){
			 
				$.ajax({
					url:'saveOrUpdate',
					type:'POST',
					data:{id:$("#id").val(),name:$('#name').val(),summary:$('#summary').val()},
					success: function(response){
							alert(response.message);
							load();		
					}				
				});			
		}
		
		delete_ = function(id){		 
			 $.ajax({
				url:'delete',
				type:'POST',
				data:{id:id},
				success: function(response){
						alert(response.message);
						load();
				}				
			});
	}
		
	
		edit = function (index){
			$("#id").val(data[index].id);
			$("#name").val(data[index].name);
			$("#summary").val(data[index].summary);
		}
		
		
		load = function(){	
			$.ajax({
				url:'list',
				type:'POST',
				success: function(response){
						data = response.data;
						$('.tr').remove();
						for(i=0; i<response.data.length; i++){	
							$("#table").append("<tr class='tr'> <td> "+response.data[i].name+" </td> <td> "+response.data[i].summary+" </td> <td> <a href='#' onclick= edit("+i+");> Edit </a>  </td> </td> <td> <a href='#' onclick='delete_("+response.data[i].id+");'> Delete </a>  </td> </tr>");
						}			
				}				
			});
			
		}
			
		</script>
	</div>
</body>
</html>