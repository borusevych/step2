<!doctype html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport"
          content="width=device-width, user-scalable=no, initial-scale=1.0, maximum-scale=1.0, minimum-scale=1.0">
    <meta http-equiv="X-UA-Compatible" content="ie=edge">
    <title>Document</title>
</head>
<body>
    <table border="1">
        <thead>
            <td>
                operation
            </td>
            <td>
                time
            </td>
            <td>
                who
            </td>
        </thead>
        <tbody>
            <#list items as row>
                <tr>
                    <td>${row.line}</td>
                    <td>${row.time}</td>
                    <td>${row.who}</td>
                </tr>
            </#list>
        </tbody>
    </table>
    <a href="calc_form">again</a>

</body>

</html>