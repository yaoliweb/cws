package cn.zj.sunda.water.service.impl;

import java.util.List;

import cn.zj.sunda.water.bo.Message;
import cn.zj.sunda.water.dao.MessagesDao;
import cn.zj.sunda.water.service.MessagesService;

public class MessagesServiceImpl implements MessagesService {

	public MessagesDao messagesDao;
	
	public MessagesDao getMessagesDao() {
		return messagesDao;
	}

	public void setMessagesDao(MessagesDao messagesDao) {
		this.messagesDao = messagesDao;
	}

	public void SaveMessages(Message messages) {
		
		this.messagesDao.SaveMessages(messages);

	}

	public List<Message> queryAllMessages() {
		
		return this.messagesDao.queryAllMessages();
	}

}
