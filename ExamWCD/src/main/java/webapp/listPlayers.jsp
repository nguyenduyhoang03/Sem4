<%@ page import="org.example.entity.Player" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Player List</title>
    <style>
        body {
            font-family: Arial, sans-serif;
            margin: 20px;
        }
        table {
            width: 80%;
            margin: auto;
            border-collapse: collapse;
        }
        th, td {
            border: 1px solid #ddd;
            padding: 8px;
            text-align: left;
        }
        th {
            background-color: #f4f4f4;
        }
    </style>
</head>
<body>
<h1>Player List</h1>
<table>
    <thead>
    <tr>
        <th>Name</th>
        <th>Full Name</th>
        <th>Age</th>
        <th>Actions</th>
    </tr>
    </thead>
    <tbody>
    <%
        // Lấy danh sách cầu thủ từ request attribute
        List<Player> players = (List<Player>) request.getAttribute("players");
        if (players != null) {
            for (Player player : players) {
    %>
    <tr>
        <td><%= player.getName() %></td>
        <td><%= player.getFullName() %></td>
        <td><%= player.getAge() %></td>
        <td>
            <a href="edit?id=<%= player.getPlayerId() %>">Edit</a>
            <a href="delete?id=<%= player.getPlayerId() %>">Delete</a>
        </td>
    </tr>
    <%
            }
        }
    %>
    </tbody>
</table>
</body>
</html>
