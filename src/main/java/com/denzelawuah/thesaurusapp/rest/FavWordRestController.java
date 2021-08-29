package com.denzelawuah.thesaurusapp.rest;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.denzelawuah.thesaurusapp.entity.FavWord;
import com.denzelawuah.thesaurusapp.exception.FavWordNotFoundException;
import com.denzelawuah.thesaurusapp.service.FavWordService;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
@RequestMapping("/api")
public class FavWordRestController {

	// autowire the FavWordService
	@Autowired
	private FavWordService FavWordService;
	
	
	// add mapping for GET /FavWords
	@GetMapping("/favwords")
	public List<FavWord> getFavWords() {
		
		return FavWordService.getFavWords();
		
	}
	
	
	// add mapping for GET /FavWords/{FavWordId}
	
	@GetMapping("/favwords/{FavWordId}")
	public FavWord getFavWord(@PathVariable int FavWordId) {
		
		FavWord theFavWord = FavWordService.getFavWord(FavWordId);
		
		if (theFavWord == null) {
			throw new FavWordNotFoundException("FavWord id not found - " + FavWordId);
		}
		
		return theFavWord;
	}
	
	// add mapping for POST /FavWords  - add new FavWord
	
	@PostMapping("/favwords")
	public FavWord addFavWord(@RequestBody FavWord theFavWord) {
		
		// also just in case the pass an id in JSON ... set id to 0
		// this is force a save of new item ... instead of update
		
		theFavWord.setId(0);
		
		FavWordService.saveFavWord(theFavWord);
		
		return theFavWord;
	}
	
	// add mapping for PUT /FavWords - update existing FavWord
	
	@PutMapping("/favwords")
	public FavWord updateFavWord(@RequestBody FavWord theFavWord) {
		
		FavWordService.saveFavWord(theFavWord);
		
		return theFavWord;
		
	}
	
	// add mapping for DELETE /FavWords/{FavWordId} - delete FavWord
	
	@DeleteMapping("/favwords/{FavWordId}")
	public String deleteFavWord(@PathVariable int FavWordId) {
		
		FavWord tempFavWord = FavWordService.getFavWord(FavWordId);
		
		// throw exception if null
		
		if (tempFavWord == null) {
			throw new FavWordNotFoundException("FavWord id not found - " + FavWordId);
		}
				
		FavWordService.deleteFavWord(FavWordId);
		
		return "Deleted FavWord id - " + FavWordId;
	}
	
}


















