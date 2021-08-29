package com.denzelawuah.thesaurusapp.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="favword")
public class FavWord {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="id")
	private int id;
	
	@Column(name="favourite_word")
	private String favouriteWord;
	

	
	public FavWord() {
		
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFavouriteWord() {
		return favouriteWord;
	}

	public void setFavouriteWord(String favouriteWord) {
		this.favouriteWord = favouriteWord;
	}

	@Override
	public String toString() {
		return "FavWord [id=" + id + ", favouriteWord=" + favouriteWord + "]";
	}


	
}





