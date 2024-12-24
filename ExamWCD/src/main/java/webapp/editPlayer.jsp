<%@ page import="org.example.entity.Indexer" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Edit Player</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        form {
            width: 300px;
            margin: auto;
        }
        input, select, button {
            width: 100%;
            padding: 10px;
            margin: 5px 0;
        }
    </style>
</head>
<body>
<h1>Edit Player</h1>
<form action="update" method="post">
    <input type="hidden" name="id" value="<%= request.getAttribute("playerId") %>">

    <label for="name">Name:</label>
    <input type="text" id="name" name="name" value="<%= request.getAttribute("name") %>" required>

    <label for="fullName">Full Name:</label>
    <input type="text" id="fullName" name="fullName" value="<%= request.getAttribute("fullName") %>" required>

    <label for="age">Age:</label>
    <input type="text" id="age" name="age" value="<%= request.getAttribute("age") %>" required>

    <label for="indexId">Indexer:</label>
    <select id="indexId" name="indexId">
        <%
            List<Indexer> indexers = (List<Indexer>) request.getAttribute("indexers");
            if (indexers != null) {
                for (Indexer indexer : indexers) {
                    boolean selected = indexer.getIndexId() == (int) request.getAttribute("indexId");
                    out.println("<option value='" + indexer.getIndexId() + "' " + (selected ? "selected" : "") + ">" + indexer.getName() + "</option>");
                }
            }
        %>
    </select>

    <button type="submit">Update Player</button>
</form>
</body>
</html>
