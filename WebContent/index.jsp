<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="s" uri="/struts-tags"%>
<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" href="index.css"/>
<meta charset="ISO-8859-1">
<title>Game Manager</title>
</head>
<body>
	<h2> Game Manager </h2><hr/>
	<h3> <b>Insert new Game </b> </h3>
	<form action="insertGame">
		<fieldset>
			<legend> Add new game </legend><br/>
			<s:textfield name="name" label="Name of the Game : "/><br/>
			<s:textfield name="price" label="Price of the Game : "/>
			<s:submit/>
		</fieldset>
	</form>
	<h3> <b>Update old Game </b> </h3>
	<form action="updateGame">
		<fieldset>
			<legend> Update old game </legend><br/>
			<s:textfield name="id" label="Game id : "/><br/>
			<s:textfield name="name" label="Name of the Game : "/><br/>
			<s:textfield name="price" label="Price of the Game : "/>
			<s:submit/>
		</fieldset>
	</form>
	<h3> <b>Delete Game </b> </h3>
	<form action="deleteGame">
		<fieldset>
			<legend> Delete game </legend><br/>
			<s:textfield name="id" label="Game id : "/>
			<s:submit/>
		</fieldset>
	</form>
	<h3> <b>Find Game </b> </h3>
	<form action="findById">
		<fieldset>
			<legend> Find game </legend><br/>
			<s:textfield name="id" label="Game id : "/>
			<s:submit/>
		</fieldset>
	</form>
	<h3> <b>List games </b> </h3>
	<form action="listAll">
		<fieldset>
			<legend> List all games </legend>
			<s:submit/>
		</fieldset>
	</form>
</body>
</html>