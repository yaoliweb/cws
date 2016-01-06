package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Csusers;
import cn.zj.sunda.water.dao.UserDao;

public class UserDaoImpl extends HibernateDaoSupport implements UserDao{

	public Csusers getUser(String username) {
		/*Configuration config = new AnnotationConfiguration();
		SessionFactory sessionFactory = config.configure("/hibernate.cfg.xml").buildSessionFactory();
		Session session = sessionFactory.getCurrentSession();
		Transaction tx = session.beginTransaction();		
		Query query = session.createQuery("from Users u where u.logid="+"'"+username+"'");
		List<Users> list = query.list();
		Users user = (Users)list.get(0);		
    	tx.commit();*/
		//getHibernateTemplate().setCacheQueries(true);
		Csusers user;
		try {
			 user = (Csusers)getHibernateTemplate().find("from Csusers  where logid = '"+username+"'").get(0);	
				System.out.println(user.getLogid());
				System.out.println(user.getLogpass());
		} catch (Exception e) {
			System.out.println("没找到用户");
			// TODO: handle exception
			return null;
		}
	
		return user;
	}

	public List<Csusers> queryAllUsers() {
		//getHibernateTemplate().setCacheQueries(true);
		List<Csusers> list = getHibernateTemplate().find("from Csusers");
		return list;
	}

	public void saveUser(Csusers user) {
		
		getHibernateTemplate().saveOrUpdate(user);
		
	}

	public void deleteUsersById(int id) {
		
		getHibernateTemplate().delete(getUserById(id));
		
	}
	
	public Csusers getUserById(int id){
		//getHibernateTemplate().setCacheQueries(true);
		return getHibernateTemplate().load(Csusers.class,id);
	}

	public List<Csusers> queryUserByUserLogid(String logid) {
		//getHibernateTemplate().setCacheQueries(true);
		List<Csusers> list = getHibernateTemplate().find("from Csusers where logid='"+logid+"'");
		return list;
	}

	public Csusers queryUserByid(int id) {
		//getHibernateTemplate().setCacheQueries(true);
		Csusers user = (Csusers)getHibernateTemplate().find("from Csusers where userid ="+id).get(0);
		return user;
	}
}
