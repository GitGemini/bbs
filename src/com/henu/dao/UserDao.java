package com.henu.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.henu.entity.User;
import com.henu.utils.HibernateUtil;

public class UserDao {

	public User login(String username, String pwd) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		String hql = "from User where (username=? or phone = ?)and password = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<User> query = session.createQuery(hql);
			query.setParameter(0, username);
			query.setParameter(1, username);
			query.setParameter(2, pwd);
			List<User> users = query.getResultList();
			if(users.size()>0) {
				user = users.get(0);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();	
		}finally {
			session.close();
		}
		return user;
	}
	
	public boolean save(User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try { 
			session.save(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();			
		}finally {
			session.close();
		}
		return true;
	}

	public boolean update(User user) {
		SessionFactory sf = HibernateUtil.getSessionFactory();
		Session session = sf.openSession();
		Transaction tx = session.beginTransaction();
		try { 
			session.update(user);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();			
		}finally {
			session.close();
		}
		return true;
	}

	public User findByName(String username) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		String hql = "from User where username=?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<User> query = session.createQuery(hql);
			query.setParameter(0, username);
			List<User> users = query.getResultList();
			if(users.size()>0) {
				user = users.get(0);
			}
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();	
		}finally {
			session.close();
		}
		return user;
	}
	
	public User findById(int uid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		User user = null;
		try {
			user = session.find(User.class, uid);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
			e.printStackTrace();	
		}finally {
			session.close();
		}
		return user;
	}
}
