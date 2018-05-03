package com.henu.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.henu.entity.Post;
import com.henu.entity.Topic;
import com.henu.entity.User;
import com.henu.utils.HibernateUtil;

public class PostDao {

	public Integer save(Post post) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer id = null;
		try {
			id = (Integer) session.save(post);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return id;
	}
	
	public Set<Post> listOfUser(Integer uid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Set<Post> posts = null;
		try {
			User user = session.find(User.class, uid);
			posts = user.getPostSet();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return posts;
	}

	public Set<Post> listOfTopic(Integer tid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Set<Post> posts = null;
		try {
			Topic topic = session.find(Topic.class, tid);
			posts = topic.getPostSet();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return posts;
	}

	public List<Post> list() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Post> posts = null;
		String hql = "from Post";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Post> query = session.createQuery(hql);
			posts = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return posts;
	}

	public List<Post> findByInfo(String info) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Post> posts = null;
		String hql = "from Post where title like %" + info + "%";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Post> query = session.createQuery(hql);
			posts = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return posts;
	}
	
	public List<Post> findTPByPage(Integer tid, int startIndex, int offset) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Post> posts = null;
		String hql = "from Post as p where p.topic.tid = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Post> query = session.createQuery(hql);
			query.setParameter(0, tid);
			query.setFirstResult(startIndex);
			query.setMaxResults(offset);
			posts = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return posts;
	}
	
	public List<Post> findUPByPage(Integer uid, int startIndex, int offset) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Post> posts = null;
		String hql = "from Post as p where p.user.userId = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Post> query = session.createQuery(hql);
			query.setParameter(0, uid);
			query.setFirstResult(startIndex);
			query.setMaxResults(offset);
			posts = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return posts;
	}

	public Post findById(int pid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Post post = null;
		try {
			post = session.find(Post.class, pid);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return post;
	}
	
	public Integer sender(int pid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer uid = 0;
		String hql = "select p.user.userId from Post as p where p.pid = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Integer> query = session.createQuery(hql);
			query.setParameter(0, pid);			
			uid = query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return uid;
	}
	
	public Topic getTopic(int pid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Topic topic = null;
		try {
			Post p = session.find(Post.class, pid);
			topic = session.find(Topic.class, p.getTopic().getTid());
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return topic;
	}
	
	public Integer sizeOfReply(int pid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer size = 0;
		String hql = "select count(r.rid) from Reply as r where r.post.pid = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Long> query = session.createQuery(hql);
			query.setParameter(0, pid);			
			size = query.getSingleResult().intValue();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return size;
	}
	
	public void delete(int pid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		
		try {
			Post post = session.find(Post.class, pid);
			session.delete(post);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	public Integer sizeOfUser(int uid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer size = 0;
		String hql = "select count(p.pid) from Post as p where p.user.userId = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Long> query = session.createQuery(hql);
			query.setParameter(0, uid);			
			size = query.getSingleResult().intValue();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return size;
	}
}
