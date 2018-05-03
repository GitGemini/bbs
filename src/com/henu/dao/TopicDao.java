package com.henu.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.henu.entity.Forum;
import com.henu.entity.Topic;
import com.henu.utils.HibernateUtil;

public class TopicDao {
	
	public Integer save(Topic topic) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer id = null;
		try {
			id = (Integer)session.save(topic);			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return id;
	}
	
	public Set<Topic> listOfForum(Integer fid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Set<Topic> topics = null;
		try {
			Forum forum = session.find(Forum.class, fid);
			topics = forum.getTopicSet();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return topics;
	}
	
	public List<Topic> list() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Topic> topics = null;
		String hql = "from Topic";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Topic> query = session.createQuery(hql);
			topics = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return topics;
	}
	
	public Topic findByName(String tname) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Topic topic = null;
		String hql = "from Topic where tname=?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Topic> query = session.createQuery(hql);
			query.setParameter(0, tname);
			topic = query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return topic;
	}
	
	public Topic findById(Integer tid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Topic topic = null;
		try {			
			topic = session.find(Topic.class, tid);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return topic;
	}
	
	public Integer size(Integer tid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer size = null;		
		String hql = "select count(p.pid) from Post as p where p.topic.tid = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Long> query = session.createQuery(hql);
			query.setParameter(0, tid);			
			size = query.getSingleResult().intValue();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
		return size;
	}
}
