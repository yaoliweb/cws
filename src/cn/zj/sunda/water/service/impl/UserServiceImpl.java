/*
 * JCatalog Project
 */
package cn.zj.sunda.water.service.impl;

import java.util.List;

import org.apache.log4j.Logger;

import cn.zj.sunda.water.bo.Csusers;
import cn.zj.sunda.water.dao.UserDao;
import cn.zj.sunda.water.service.UserService;
import cn.zj.sunda.water.util.CipherUtil;

public class UserServiceImpl implements UserService {

	private static Logger logger = Logger.getLogger(UserServiceImpl.class);

	private String smtpHost;

	private String defaultSenderAddress;

	private String defaultSenderName;

	private List receiverAddresses;

	private UserDao userDao;

	public UserDao getUserDao() {
		return userDao;
	}

	public void setSmtpHost(String host) {
		this.smtpHost = host;
	}

	public void setDefaultSenderAddress(String newDefaultSenderAddress) {
		this.defaultSenderAddress = newDefaultSenderAddress;
	}

	public void setDefaultSenderName(String newDefaultSenderName) {
		this.defaultSenderName = newDefaultSenderName;
	}

	public void setReceiverAddresses(List newDefaultReceiverAddresses) {
		this.receiverAddresses = newDefaultReceiverAddresses;
	}

	public void setUserDao(UserDao newUserDao) {
		this.userDao = newUserDao;
	}

	public Csusers login(String username, String password) {
		Csusers user = this.userDao.getUser(username);
		if (user != null) {
			if (!CipherUtil.validatePassword(user.getLogpass(), password)) {
				user = null;
			}
		}
		System.out.println(user+"============");
		return user;

	}


	public List<Csusers> queryAllUsers() {

		return this.userDao.queryAllUsers();
	}

	public void saveUser(Csusers user) {

		this.userDao.saveUser(user);

	}

	public void deleteUserById(int id) {

		this.userDao.deleteUsersById(id);

	}

	public void deleteUserByIds(String[] ids) {

		for (int i = 0; i < ids.length; i++) {
			deleteUserById(Integer.valueOf(ids[i]));
		}

	}

	public List<Csusers> queryUserByUserLogid(String logid) {

		return this.userDao.queryUserByUserLogid(logid);
	}

	public Csusers queryUserByUserId(int userId) {

		return this.userDao.queryUserByid(userId);
	}
}
