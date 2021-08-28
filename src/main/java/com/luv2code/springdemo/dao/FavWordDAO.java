package com.luv2code.springdemo.dao;

import java.util.List;

import com.luv2code.springdemo.entity.FavWord;

public interface FavWordDAO {

	public List<FavWord> getFavWords();

	public void saveFavWord(FavWord theFavWord);

	public FavWord getFavWord(int theId);

	public void deleteFavWord(int theId);
	
}
