package junit.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.henu.entity.Post;
import com.henu.entity.Reply;
import com.henu.entity.User;
import com.henu.utils.HibernateUtil;

public class ReplyTest {

	@Test
	public void testAdd() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {		
			Post post = session.get(Post.class, 3);
			User user = session.get(User.class, 1);
			
			Reply r1 = new Reply();
			r1.setContent("这个我也不会！！");
			r1.setReplyTime(new Date());
			r1.setPost(post);
			r1.setUser(user);		
			
			session.save(r1);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testAdd1() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {

			for (int i = 0; i < 100; i++) {
				Post post = session.get(Post.class, 3);
				int userid = (i % 4) + 1;
				User user = session.get(User.class, userid);

				Reply r1 = new Reply();
				r1.setContent("我是" + i+"楼");
				r1.setReplyTime(new Date());
				r1.setUser(user);
				r1.setPost(post);

				session.save(r1);
			}

			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		} finally {
			session.close();
		}
	}
	
	@Test
	public void testGet() {
//		ReplyService rs = new ReplyService();
//		List<Reply> replies = rs.findByPage(3, 1, 10);
//		for (Reply reply : replies) {
//			System.out.println(reply.getContent());
//		}
	}
}
