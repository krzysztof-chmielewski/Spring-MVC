<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internet Radio</title>
</head>
<body>
<form action="playSong" method="post">
    <!-- TODO: look how errors are presented -->
    <label>Artist <form:errors path="song.artist" />: <input type="text" name="artist" /></label>
    <label>Album <form:errors path="song.title" />: <input type="text" name="album" /></label>
    <label>Title <form:errors path="song.album" />: <input type="text" name="title" /></label>
    <input type="submit" />
</form>
</body>
</html>
