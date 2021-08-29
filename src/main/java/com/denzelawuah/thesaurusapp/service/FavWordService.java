package com.denzelawuah.thesaurusapp.service;

import java.util.List;

import com.denzelawuah.thesaurusapp.entity.FavWord;

public interface FavWordService {

	public List<FavWord> getFavWords();

	public void saveFavWord(FavWord theFavWord);

	public FavWord getFavWord(int theId);

	public void deleteFavWord(int theId);
	
}
