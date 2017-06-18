<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<html>
<head>
<title>AngularJS Random Sequence Sorter</title>

<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.5/css/bootstrap.min.css">
<link href='static/css/app.css' rel="stylesheet"></link>
<script
		src="https://ajax.googleapis.com/ajax/libs/angularjs/1.4.4/angular.js"></script>
	<script src='static/js/app.js' /></script>
	<script src='static/js/service/record_service.js' /></script>
	<script
		src='static/js/controller/record_controller.js' /></script>
</head>
<body ng-app="myApp" class="ng-cloak">
	<div ng-controller="RecordController as ctrl">
		<div id="app">
			<header>Random Sequence Generator</header>
			<I style="font-size: 13px;">App generates Five numbers
				between[1-100] randomly at any given time</I>
			<div id="main">
				<div>
					<I style="font-size: 12px;">Click the button to trigger a
						sequence </I> &nbsp;&nbsp;
					<button ng-click="generateRandomNumber()">
						<b style="font-size: 160%;">Generate</b>
					</button>
				</div>
				<div id="task-list">
					<span> <label for="new-task-name">Generated numbers
							are shown in the box below:: </label><input type="text" id="demo"
						ng-model="numericalArr" style="font-size: 160%;" value="" readonly />
					</span>
				</div>
			</div>
			<footer></footer>
		</div>
		<hr>
		<section>
			<button ng-click="sort()">
				<b style="font-size: 15px;">Sort</b>
			</button>
			<br>
			<aside ng-show="sortRequested">
				<h4>Stastics of Ordering</h4>
				<p style="font-size: 12px">Number of position changes required::{{count}}</p>
				<br>
				<p style="font-size: 12px">Time taken to process::</p>
				{{ }}
			</aside>
			
			<center ng-show="sortRequested">
				<h4>Sorted Table</h4>
				<center>
					<center>
						<table>
							<tr>
								<th>Value</th>
							</tr>
							<tr ng-repeat="x in sortArr track by $index">
								<td>{{ x}}</td>
							</tr>
						</table>
						<center>
		</section>
	</div>
</body>
</html>