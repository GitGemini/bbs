package com.henu.dao;

import java.util.List;
import java.util.Set;

import javax.persistence.TypedQuery;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.henu.entity.Post;
import com.henu.entity.Reply;
import com.henu.entity.User;
import com.henu.utils.HibernateUtil;

public class ReplyDao {

	public Integer save(Reply reply) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer id = null;
		try {
			id = (Integer) session.save(reply);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return id;
	}
	
	public Set<Reply> listOfUser(Integer uid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Set<Reply> replies = null;
		try {
			User user = session.find(User.class, uid);
			replies = user.getReplySet();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return replies;
	}

	public Set<Reply> listOfPost(Integer pid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Set<Reply> replies = null;
		try {
			Post post = session.find(Post.class, pid);
			replies = post.getReplySet();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return replies;
	}

	public List<Reply> list() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Reply> replies = null;
		String hql = "from Reply";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Reply> query = session.createQuery(hql);
			replies = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return replies;
	}

	public List<Reply> findByInfo(String info) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Reply> replies = null;
		String hql = "from Reply where content like %" + info + "%";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Reply> query = session.createQuery(hql);
			replies = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return replies;
	}
	
	public List<Reply> findPRByPage(Integer pid, int startIndex, int offset) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Reply> replies = null;
		String hql = "from Reply as r where r.post.pid = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Reply> query = session.createQuery(hql);
			query.setParameter(0, pid);
			query.setFirstResult(startIndex);
			query.setMaxResults(offset);
			replies = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return replies;
	}
	
	public List<Reply> findURByPage(Integer uid, int startIndex, int offset) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		List<Reply> replies = null;
		String hql = "from Reply as r where r.user.userId = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Reply> query = session.createQuery(hql);
			query.setParameter(0, uid);
			query.setFirstResult(startIndex);
			query.setMaxResults(offset);
			replies = query.getResultList();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return replies;
	}

	public Reply findById(int rid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Reply reply = null;
		try {
			reply = session.find(Reply.class, rid);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return reply;
	}
	
	public Integer sender(int rid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer uid = 0;
		String hql = "select r.user.userId from Reply as r where r.rid = ?";
		try {
			@SuppressWarnings("unchecked")
			TypedQuery<Integer> query = session.createQuery(hql);
			query.setParameter(0, rid);
			uid = query.getSingleResult();
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return uid;
	}
	
	public Integer sizeOfUser(int uid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Integer size = 0;
		String hql = "select count(r.rid) from Reply as r where r.user.userId = ?";
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

	public Post getPost(int rid) {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		Post post = null;
		try {
			Reply r = session.find(Reply.class, rid);
			post = session.find(Post.class, r.getPost().getPid());
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
		return post;
	}
}
