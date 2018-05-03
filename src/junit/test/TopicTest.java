package junit.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.henu.dao.TopicDao;
import com.henu.entity.Post;
import com.henu.entity.Topic;
import com.henu.entity.User;
import com.henu.utils.HibernateUtil;

public class TopicTest {

	@Test
	public void testSize() {
		TopicDao dao = new TopicDao();
		System.out.println(dao.size(3));
	}
	
	@Test
	public void testAdd() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {		
			Topic topic = session.get(Topic.class, 3);
			User user = session.get(User.class, 2);
			
			Post p1 = new Post();
			p1.setTitle("Java eclipse问题求大神解答？？？？？");
			p1.setCreateTime(new Date());
			p1.setTopic(topic);
			p1.setUser(user);
			topic.getPostSet().add(p1);
			user.getPostSet().add(p1);
			
			Post p2 = new Post();
			p2.setTitle("发一个测试的问题？？？？？");
			p2.setCreateTime(new Date());
			p2.setTopic(topic);
			p2.setUser(user);
			topic.getPostSet().add(p2);
			user.getPostSet().add(p2);
			
			Post p3 = new Post();
			p3.setTitle("发一个测试的问题？？？？？");
			p3.setCreateTime(new Date());
			p3.setTopic(topic);
			p3.setUser(user);
			topic.getPostSet().add(p3);
			user.getPostSet().add(p3);
			
			session.save(topic);
			session.save(user);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
	}
}
