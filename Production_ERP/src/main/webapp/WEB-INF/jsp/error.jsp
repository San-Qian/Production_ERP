<%@ page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<head>
    <title>提示</title>
    <script>
        function redirectTo() {
            switch ('${requestScope.level}') {
                case '0':
                    window.location.href = "${pageContext.request.contextPath}/${requestScope.url}";
                    break;
                case '1':
                    window.parent.location.href = "${pageContext.request.contextPath}/${requestScope.url}";
                    break;
                case '2':
                    window.parent.parent.location.href = "${pageContext.request.contextPath}/${requestScope.url}";
                    break;
                default:
                    if (window.parent.parent == null) {
                        if (window.parent == null) {
                            window.location.href = "${pageContext.request.contextPath}/${requestScope.url}"
                        } else {
                            window.parent.location.href = "${pageContext.request.contextPath}/${requestScope.url}"
                        }
                    } else {
                        window.parent.parent.location.href = "${pageContext.request.contextPath}/${requestScope.url}"
                    }
            }
        }

        setTimeout("redirectTo()", ${requestScope.time})
    </script>
</head>
<body align="center">
<div style="font-size: large">
    <div style="margin:0 auto; width:700px; height:306px;">
        <div style="font-size: xx-large;padding-top: 150px">${requestScope.message}</div>
        <input type="image" src="${pageContext.request.contextPath}/images/${requestScope.messageImg}"
               style="padding-top: 50px;"/>
    </div>
</div>
</body>
</html>