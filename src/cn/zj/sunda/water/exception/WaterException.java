package cn.zj.sunda.water.exception;

public class WaterException extends Exception{

	public WaterException(String msg) {
		super(msg);
	}
	
	public WaterException(String msg, Throwable cause) {
		super(msg, cause);
	}
}
