package org.example.controller;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.*;
import org.example.DAO.PlayerDAO;
import org.example.entity.Player;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/")
public class PlayerController extends HttpServlet {
    private PlayerDAO playerDAO = new PlayerDAO();

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String action = request.getServletPath();

        switch (action) {
            case "/new":
                showNewForm(request, response);
                break;
            case "/insert":
                insertPlayer(request, response);
                break;
            case "/delete":
                deletePlayer(request, response);
                break;
            case "/edit":
                showEditForm(request, response);
                break;
            case "/update":
                updatePlayer(request, response);
                break;
            default:
                listPlayers(request, response);
                break;
        }
    }

    private void listPlayers(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        List<Player> players = playerDAO.getAllPlayers();
        request.setAttribute("players", players);
        RequestDispatcher dispatcher = request.getRequestDispatcher("listPlayers.jsp");
        dispatcher.forward(request, response);
    }

    private void insertPlayer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        String name = request.getParameter("name");
        String fullName = request.getParameter("fullName");
        String age = request.getParameter("age");
        int indexId = Integer.parseInt(request.getParameter("indexId"));

        Player player = new Player();
        player.setName(name);
        player.setFullName(fullName);
        player.setAge(age);
        player.setIndexer(new Indexer(indexId));

        playerDAO.savePlayer(player);
        response.sendRedirect("list");
    }

    private void showNewForm(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher dispatcher = request.getRequestDispatcher("addPlayer.jsp");
        dispatcher.forward(request, response);
    }

    private void deletePlayer(HttpServletRequest request, HttpServletResponse response) throws IOException {
        int id = Integer.parseInt(request.getParameter("id"));
        playerDAO.deletePlayer(id);
        response.sendRedirect("list");
    }
}

