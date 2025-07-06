<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Liked Users</title>
    <link rel="stylesheet" href="/static0/1.css">
</head>
<body>
<h1>Messages</h1>
<div>
    <#if messages?size == 0>
        <p>There are no messages yet</p>
    <#else>
        <#list messages as message>
            <div>
                <p>${message.senderName} says:</p>
                <p>${message.message}</p>
                <p style="margin-bottom: 40px;">${message.date}</p>
            </div>
        </#list>
    </#if>
    <form method="POST">
        <input type="text" name="message" placeholder="Enter your message" required>
        <button type="submit">Send Message</button>
    </form>

</div>
</body>
</html>