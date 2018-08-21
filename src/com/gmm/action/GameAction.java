package com.gmm.action;

import java.util.ArrayList;
import java.util.List;

import com.gmm.dao.GameDAO;
import com.gmm.dao.GameDAOImpl;
import com.gmm.entity.Game;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;

//ModelDriven interface of type Game to store input request values 
public class GameAction extends ActionSupport implements ModelDriven<Game> {

	private static final long serialVersionUID = 1L;
	private Game game = new Game(); // To store input values of input request
	private GameDAO gameDAO = new GameDAOImpl(); // Data access
	private List<Game> gameList = new ArrayList<>(); // for printing all items in games

	@Override
	public Game getModel() {
		return this.game;
	}

	public Game getGame() {
		return game;
	}

	public void setGame(Game game) {
		this.game = game;
	}

	public List<Game> getGameList() {
		return gameList;
	}

	public void setGameList(List<Game> gameList) {
		this.gameList = gameList;
	}
	
	//Function to add new game to the database
	public String insertGame() {
		try {
			if(game.getName()==null||game.getPrice()==0)
				return ERROR;
			gameDAO.insertGame(this.game);
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;	
		}
	}

	public String updateGame() {
		try {
			if(game.getId()==0||game.getName()==null||game.getPrice()==0)
				return ERROR;
			if (gameDAO.isIdPresent(game.getId())) {
				gameDAO.updateGame(this.game);
				return SUCCESS;
			} else
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String deleteGame() {
		try {
			if(game.getId()==0)
				return ERROR;
			if (gameDAO.isIdPresent(game.getId())) {
				gameDAO.deleteGame(game.getId());
				return SUCCESS;
			} else
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String findById() {
		try {
			if(game.getId()==0)
				return ERROR;
			if (gameDAO.isIdPresent(game.getId())) {
				this.game = gameDAO.findById(game.getId());
				return SUCCESS;
			} else
				return ERROR;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}

	public String listAll() {
		
		try {
			this.gameList = gameDAO.listAll();
			return SUCCESS;
		} catch (Exception e) {
			e.printStackTrace();
			return ERROR;
		}
	}
}