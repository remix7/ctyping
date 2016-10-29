package top.cynara.ctyping.exception;

import java.io.PrintStream;
import java.io.PrintWriter;

public class CtypingException extends RuntimeException {

	/**
	 * @Fields serialVersionUID : TODO（用一句话描述这个变量表示什么）
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void printStackTrace() {
		// TODO Auto-generated method stub
		super.printStackTrace();
	}

	@Override
	public void printStackTrace(PrintStream s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override
	public void printStackTrace(PrintWriter s) {
		// TODO Auto-generated method stub
		super.printStackTrace(s);
	}

	@Override
	public void setStackTrace(StackTraceElement[] stackTrace) {
		// TODO Auto-generated method stub
		super.setStackTrace(stackTrace);
	}

}
