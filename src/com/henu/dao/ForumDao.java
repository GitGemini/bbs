package com.henu.dao;

import java.util.List;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.henu.entity.Forum;
import com.henu.utils.HibernateUtil;

public class ForumDao {

	public Integer save(Forum forum) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer id = null;
		try {
			id = (Integer)session.save(forum);			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return id;
	}
	
	public List<Forum> list() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Forum> forums = null;
		String hql = "from Forum";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Forum> query = session.createQuery(hql);
			forums = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return forums;
	}
	
	public Forum findByName(String fname) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Forum forum = null;
		String hql = "from Forum where fname=?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Forum> query = session.createQuery(hql);
			query.setParameter(0, fname);
			forum = query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return forum;
	}
	
	public Forum findById(Integer fid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Forum forum = null;
		try {
			forum = session.find(Forum.class, fid);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return forum;
	}
}
