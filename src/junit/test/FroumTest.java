package junit.test;

import org.hibernate.Session;
import org.hibernate.Transaction;
import org.junit.Test;

import com.henu.entity.Forum;
import com.henu.entity.Topic;
import com.henu.utils.HibernateUtil;

public class FroumTest {

	@Test
	public void testAdd() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Forum froum = session.find(Forum.class, 1);
			
			
			Topic t1 = new Topic();
			t1.setTname("XML");
			t1.setInfo("Web 开发 XML");
			
			froum.getTopicSet().add(t1);
			
			session.save(froum);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
	}
	
	@Test
	public void testSave() {
		Session session = HibernateUtil.openSession();
		Transaction tx = session.beginTransaction();
		try {
			Forum froum = session.find(Forum.class, 2);
			
			Topic t3 = new Topic();
			t3.setTname("J2ME");
			t3.setInfo("Java J2ME");
			
			Topic t2 = new Topic();
			t2.setTname("Java SE");
			t2.setInfo("Web 开发 ASP");
			
			Topic t1 = new Topic();
			t1.setTname("J2EE");
			t1.setInfo("Java 2 Platform Enterprise Edition");
			
			Topic t4 = new Topic();
			t4.setTname("Eclipse");
			t4.setInfo("Java Eclipse");
			
			Topic t5 = new Topic();
			t5.setTname("JBoss");
			t5.setInfo("JBoss技术交流");
			
			t1.setFroum(froum);
			t2.setFroum(froum);
			t3.setFroum(froum);
			t4.setFroum(froum);
			t5.setFroum(froum);
			session.save(t1);
			session.save(t2);
			session.save(t3);
			session.save(t4);
			session.save(t5);
			
			tx.commit();
		} catch (Exception e) {
			tx.rollback();
		}finally {
			session.close();
		}
	}
}
