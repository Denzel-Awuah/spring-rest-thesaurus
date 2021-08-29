package com.denzelawuah.thesaurusapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.denzelawuah.thesaurusapp.dao.FavWordDAO;
import com.denzelawuah.thesaurusapp.entity.FavWord;

@Service
public class FavWordServiceImpl implements FavWordService {

	// need to inject FavWord dao
	@Autowired
	private FavWordDAO FavWordDAO;
	
	@Override
	@Transactional
	public List<FavWord> getFavWords() {
		return FavWordDAO.getFavWords();
	}

	@Override
	@Transactional
	public void saveFavWord(FavWord theFavWord) {

		FavWordDAO.saveFavWord(theFavWord);
	}

	@Override
	@Transactional
	public FavWord getFavWord(int theId) {
		
		return FavWordDAO.getFavWord(theId);
	}

	@Override
	@Transactional
	public void deleteFavWord(int theId) {
		
		FavWordDAO.deleteFavWord(theId);
	}
}





