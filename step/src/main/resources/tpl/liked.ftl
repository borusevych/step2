<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liked Users</title>
    <link rel="stylesheet" href="/static0/1.css">
</head>
<body>
<h1>Liked Users</h1>
<div>
    <#if likedUsers?size == 0>
        <p>You dont like anyone</p>
    <#else>
        <#list likedUsers as user>
            <div>
                <img src="${user.img}" width="400" alt="${user.name}">
                <p>${user.name}</p>
                <form method="POST">
                    <button  name="response" value="${user.id}">Send Message</button>
                </form>
            </div>
        </#list>
    </#if>
</div>
</body>
</html>