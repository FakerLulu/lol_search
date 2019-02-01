<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>롤 전적을 검색해보자</title>
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.2/css/bootstrap.min.css">

</head>
<body>	
    <div class="container">
        <form class = "form"> 
		소환사명 : 
		<input type="text" id="summonerId"></input><br>
		검색할 최근 경기 수 :
		<input type="number" id="matchCount" max = "10" min = "1" value ="1"></input><br>
		<input type="button" id="submit" value = "검색"></input>
	    </form>
     	<div class="smnInfo">
     	</div>
     	<ul class="list-group match-list">
     	</ul>
    </div>
</body>
    <script src="https://code.jquery.com/jquery-3.3.1.min.js"></script>    
    <script src="./js/main.js"></script>
</html>