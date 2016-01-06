package cn.zj.sunda.water.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.support.HibernateDaoSupport;

import cn.zj.sunda.water.bo.Message;
import cn.zj.sunda.water.dao.MessagesDao;

public class MessagesDaoImpl extends HibernateDaoSupport implements MessagesDao {

	public void SaveMessages(Message messages) {
		
		getHibernateTemplate().saveOrUpdate(messages);

	}

	public List<Message> queryAllMessages() {
		List<Message> list =getHibernateTemplate().find("from Message order by messageId desc");
		return list;
	}

}
