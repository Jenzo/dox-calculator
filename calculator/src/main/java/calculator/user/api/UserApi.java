package calculator.user.api;

import java.util.List;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;

import calculator.user.builder.UserBuilder;
import calculator.user.model.User;

@Stateless
public class UserApi {

	private EntityManager em;

	public User createUser(final String username) {
		User user = UserBuilder.newBuilder().withUsername(username).build();
		em.persist(user);

		return user;
	}

	public User findUserById(final long id) {
		return em.createNamedQuery(User.FIND_BY_ID, User.class)
				.setParameter("userId", id)
				.getSingleResult();
	}

	public List<User> findAll() {
		return em.createNamedQuery(User.FIND_ALL, User.class)
				.getResultList();
	}
}
