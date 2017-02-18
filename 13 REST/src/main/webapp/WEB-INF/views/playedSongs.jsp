
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internet Radio</title>
</head>
<body>
<%--@elvariable id="songs" type="io.kch.spring.mvc13.player.model.Songs"--%>
<c:forEach var="song" items="${songs.songs}" varStatus="loopStatus">
    <%--@elvariable id="song" type="io.kch.spring.mvc13.player.model.Song"--%>
    <p>
        ${loopStatus.index + 1}.
        <spring:message code="music.player.view.playSong.artist" />: ${song.artist}
        <spring:message code="music.player.view.playSong.album" />: ${song.album}
        <spring:message code="music.player.view.playSong.title" />: ${song.title}
    </p>
</c:forEach>
</body>
</html>
