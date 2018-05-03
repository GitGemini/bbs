package junit.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.henu.dao.PostDao;
import com.henu.entity.Post;
import com.henu.entity.Topic;
import com.henu.entity.User;
import com.henu.service.PostService;
import com.henu.utils.HibernateUtil;

public class PostTest {

	@Test
	public void testSize() {
//		PostDao dao = new PostDao();
//		System.out.println(dao.size(3));
	}
	
	@Test
	public void testPage() {
//		PostDao dao = new PostDao();
//		List<Post> posts = dao.findByPage(3, 2, 10);
//		System.out.println(posts);
	}

	@Test
	public void testAdd() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {

			for (int i = 0; i < 10; i++) {
				Topic topic = session.get(Topic.class, 2);
				int userid = (i % 4) + 1;
				User user = session.get(User.class, userid);

				Post p1 = new Post();
				p1.setTitle("测试问题——————" + i);
				p1.setCreateTime(new Date());
				p1.setTopic(topic);
				p1.setUser(user);

				session.save(p1);
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testChange() {
		PostService ps = new PostService();
		List<Post> posts = ps.list();
		for (Post post : posts) {
			if(post.getContent()==null) {
				post.setContent("发一个测试的问题？？？？？");
				ps.save(post);
			}			
		}
	}
	
	@Test
	public void testUser() {
		PostService ps = new PostService();
		User user = ps.sender(3);
		System.out.println(user.getUsername());
	}
	
	@Test
	public void testUser1() {
		PostDao pd = new PostDao();
		Integer user = pd.sender(100);
		System.out.println(user);
	}
	
	@Test
	public void testDelete() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {			
			Post post = session.find(Post.class, 109);
			session.delete(post);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testOne() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {

			Topic topic = session.get(Topic.class, 3);
			int userid = 1;
			User user = session.get(User.class, userid);

			Post p1 = new Post();
			p1.setTitle("测试问题————" + 0);
			p1.setCreateTime(new Date());
			p1.setTopic(topic);
			p1.setUser(user);

			session.save(p1);
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	@Test
	public void testGet() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {
			User user = session.get(User.class, 4);
			int a = user.getReplySet().size();
			System.out.println(a);

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}

	// @Test
	// public void testGet1() {
	// Session session = HibernateUtil.openSession();
	// Transaction tx = session.beginTransaction();
	// User user = null;
	// try {
	// user = session.get(User.class, 2);
	// tx.commit();
	// } catch (Exception e) {
	// tx.rollback();
	// }finally {
	// session.close();
	// }
	// int n = user.getPostSet().size();
	// System.out.println(n);
	// }
}
