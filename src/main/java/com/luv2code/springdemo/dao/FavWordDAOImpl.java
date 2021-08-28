package com.luv2code.springdemo.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.luv2code.springdemo.entity.FavWord;
import javax.persistence.criteria.CriteriaQuery;

@Repository
public class FavWordDAOImpl implements FavWordDAO {

	// need to inject the session factory
	@Autowired
	private SessionFactory sessionFactory;
			
	@Override
	public List<FavWord> getFavWords() {
		
		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
				
		// create a query  ... sort by last name
//		Query<FavWord> theQuery = 
//				currentSession.createQuery("from favword",
//											FavWord.class);
		
		// execute query and get result list
		//List<FavWord> FavWords = theQuery.getResultList();
	   List<FavWord> FavWords = currentSession.createCriteria(FavWord.class).list();
		

		
		
		// return the results		
		return FavWords;
	}

	@Override
	public void saveFavWord(FavWord theFavWord) {

		// get current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// save/upate the FavWord ... finally LOL
		currentSession.saveOrUpdate(theFavWord);
		
	}

	@Override
	public FavWord getFavWord(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// now retrieve/read from database using the primary key
		FavWord theFavWord = currentSession.get(FavWord.class, theId);
		
		return theFavWord;
	}

	@Override
	public void deleteFavWord(int theId) {

		// get the current hibernate session
		Session currentSession = sessionFactory.getCurrentSession();
		
		// delete object with primary key
		Query theQuery = 
				currentSession.createQuery("delete from Favword where id=:FavWordId");
		theQuery.setParameter("FavWordId", theId);
		
		theQuery.executeUpdate();		
	}

}











