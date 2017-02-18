<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internet Radio</title>
</head>
<body>
<form action="playSong" method="post">
    <!-- notice how messages are displayed in .jsp file -->
    <label><spring:message code="music.player.view.playSong.artist" /> <form:errors path="song.artist" />: <input type="text" name="artist" /></label>
    <!-- do the same for album and title -->
    <label>Album <form:errors path="song.album" />: <input type="text" name="album" /></label>
    <label>Title <form:errors path="song.title" />: <input type="text" name="title" /></label>
    <input type="submit" />
</form>
</body>
</html>
