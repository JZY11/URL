<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ include file="commons/inc.jsp" %>
<html>
<head>
    <title>URL</title>
    <link rel="stylesheet" href="${ctx}/assets/css/material.css">
    <script src="${ctx}/assets/js/material.js"></script>
    <link rel="stylesheet" href="https://fonts.googleapis.com/icon?family=Material+Icons">
</head>
<body>
<div class="mdl-grid">
    <div class="mdl-cell mdl-cell--4-col"></div>
    <div class="mdl-cell mdl-cell--4-col">
        <h1 class="mdl-typography--text-center">URL</h1>
    </div>
    <div class="mdl-cell mdl-cell--4-col"></div>
    <div class="mdl-cell mdl-cell--4-col"></div>
    <div class="mdl-cell mdl-cell--4-col">
        <form action="${ctx}/create" method="post">
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input name="original" class="mdl-textfield__input" type="text" id="original">
                <label class="mdl-textfield__label" for="original">Enter a long URL</label>
            </div>
            <div>
                <button class="mdl-button mdl-js-button mdl-button--raised mdl-js-ripple-effect mdl-button--accent">
                    Make
                </button>
            </div>
            <div class="mdl-textfield mdl-js-textfield mdl-textfield--floating-label">
                <input name="original" class="mdl-textfield__input" type="text" id="creation">
                <label class="mdl-textfield__label" for="creation">Custom alias (optional)</label>
            </div>
            <small style="color: #f00;">${sessionScope.message}</small>
            <c:if test="${sessionScope.mapper ne null}">
            <p>Original URL:</p>
            <p>${sessionScope.mapper.original}</p>
            <p class="mdl-color-text--accent">Creation URL:</p>
            <p class="mdl-color--amber"><a href="http://localhost:8080/${sessionScope.mapper.creation}"
                                           target="_blank">http://localhost:8080/${sessionScope.mapper.creation}</a></p>
            <a href="${ctx}/assets/qrcode/${sessionScope.mapper.creation}.png" target="_blank">
                <img src="${ctx}/assets/qrcode/${sessionScope.mapper.creation}.png" width="100">
            </a>
            </c:if>
    </div>
    <div class="mdl-cell mdl-cell--4-col"></div>
</div>
</body>
</html>