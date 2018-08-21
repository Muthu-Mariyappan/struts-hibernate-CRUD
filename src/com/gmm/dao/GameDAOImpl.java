package com.gmm.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.gmm.entity.Game;
import com.googlecode.s2hibernate.struts2.plugin.annotations.SessionTarget;
import com.googlecode.s2hibernate.struts2.plugin.annotations.TransactionTarget;


//Implementation of dataAccessLayer
public class GameDAOImpl implements GameDAO {

	//These objects are injected using the Full Hibernate Plug-in 1.4 GA. 
	@SessionTarget
	Session session; 

	@TransactionTarget
	Transaction transaction;

	@Override
	public void insertGame(Game game) {

		try {
			session.save(game);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public void updateGame(Game game) {

		try {
			session.update(game);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteGame(int id) {

		try {
			Game game = (Game) session.get(Game.class, id);
			session.delete(game);
		} catch (Exception e) {
			transaction.rollback();
			e.printStackTrace();
		}
	}

	@Override
	public Game findById(int id) {
		return (Game) session.get(Game.class, id);
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Game> listAll() {
		return session.createQuery("from Game").list(); //The table name is Entity class name representing database table

	}
	
	public boolean isIdPresent(int id) {
		Game game = (Game) session.get(Game.class, id);
		if(game==null)
			return false;
		return true;
	}
}