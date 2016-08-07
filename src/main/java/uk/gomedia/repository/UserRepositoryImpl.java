package uk.gomedia.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import uk.gomedia.entity.User;

@Repository
@Transactional(readOnly = true)
public class UserRepositoryImpl implements UserRepository{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	@Transactional
	public void addUser(User u) {
		try {
			em.persist(u);
		} catch (Exception e) {
			e.printStackTrace();
	    }
	}

	@Override
	public boolean isUserExsist(String email) {
		List<User> result = em.createQuery("from User where email = :email", User.class).setParameter("email", email)
				.getResultList();
		return !result.isEmpty();
	}
	
	public List<User> getUsers() {
		List<User> result = em.createQuery("from User", User.class).getResultList();
		return result;
	}

	

}
