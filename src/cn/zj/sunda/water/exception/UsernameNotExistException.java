package cn.zj.sunda.water.exception;


public class UsernameNotExistException extends WaterException {
	private String username;

	public UsernameNotExistException(String newUsername) {
		super("Username " + newUsername + " does not exist");
		this.username = newUsername;
	}
	
	public String getUsername() {
		return this.username;
	}
}
