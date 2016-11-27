package teamProject.dao.database.hibernate;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import teamProject.dao.database.UserDao;
import teamProject.entities.User;

public class UserDaoImpl implements UserDao {
	private SessionFactory sessionFactory = null;
	private static final Logger LOG = LoggerFactory.getLogger(UserDaoImpl.class);

	public UserDaoImpl(SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	@Override
	public boolean add(User user) {
		try {
			sessionFactory.getCurrentSession().save(user);

		} catch (Exception ex) {
			LOG.error("Error when trying to add User.\n User login: {}\n", user.getLogin(), ex);
			return false;
		}
		return true;

	}

	@Override
	public boolean update(User user) {
		try {
			sessionFactory.getCurrentSession().saveOrUpdate(user);

		} catch (Exception ex) {
			LOG.error("Error when trying to change User.\n User login: {}\n", user.getLogin(), ex);
			return false;
		}
		return true;
	}

	@Override
	public List<User> getAll() {
		List<User> users = null;
		try {
			users = sessionFactory.getCurrentSession().createCriteria(User.class).list();
		} catch (Exception ex) {
			LOG.error("Error when trying to get all Users.", ex);
		}
		return users;
	}

	@Override
	public User getUser(String login) {
		User user = null;
		try {
			Criteria criteria = sessionFactory.getCurrentSession().createCriteria(User.class);
			user = (User) criteria.add(Restrictions.eq("login", login)).uniqueResult();
		} catch (Exception ex) {
			LOG.error("Error when trying to get User with login {}.", login, ex);
		}
		return user;
	}

	@Override
	public boolean delete(User user) {
		try {
			sessionFactory.getCurrentSession().delete(user);
		} catch (Exception ex) {
			LOG.error("Error when trying to Delete User with login {}.", user.getLogin(), ex);
			return false;
		}
		return true;

	}

	@Override
	public User getbyId(int id) {
		User user = null;
		try {
			user = (User) sessionFactory.getCurrentSession().get(User.class, id);
		} catch (Exception e) {
			LOG.error("Error when try get user with id={}", id);
		}
		return user;
	}

}
