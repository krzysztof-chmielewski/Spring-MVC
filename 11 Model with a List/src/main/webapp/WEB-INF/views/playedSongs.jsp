
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Internet Radio</title>
</head>
<body>
<%--@elvariable id="songs" type="io.kch.spring.mvc11.player.model.Songs"--%>
<c:forEach var="song" items="${songs.songs}" varStatus="loopStatus">
    <%--@elvariable id="song" type="io.kch.spring.mvc11.player.model.Song"--%>
    <p>
        ${loopStatus.index + 1}.
        <spring:message code="music.player.view.playSong.artist" /> : ${song.artist}
        <!-- TODO: do something similar for the rest of Song properties -->
    </p>
</c:forEach>
</body>
</html>
