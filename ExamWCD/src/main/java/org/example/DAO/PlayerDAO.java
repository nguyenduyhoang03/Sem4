package org.example.DAO;

import org.example.entity.Player;
import org.example.util.HibernateUtil;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.List;

public class PlayerDAO {
    public void savePlayer(Player player) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.save(player);
        transaction.commit();
        session.close();
    }

    public List<Player> getAllPlayers() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Player> players = session.createQuery("from Player", Player.class).list();
        session.close();
        return players;
    }

    public Player getPlayerById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Player player = session.get(Player.class, id);
        session.close();
        return player;
    }

    public void updatePlayer(Player player) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        session.update(player);
        transaction.commit();
        session.close();
    }

    public void deletePlayer(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction transaction = session.beginTransaction();
        Player player = session.get(Player.class, id);
        if (player != null) {
            session.delete(player);
        }
        transaction.commit();
        session.close();
    }
}

