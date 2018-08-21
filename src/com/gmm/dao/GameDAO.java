package com.gmm.dao;

import java.util.List;

import com.gmm.entity.Game;


//DataAccess layer for game table in the database;
public interface GameDAO {
	public void insertGame(Game game);
	public void updateGame(Game game);
	public void deleteGame(int id);
	public Game findById(int id);
	public List<Game> listAll();
	public boolean isIdPresent(int id);
}
