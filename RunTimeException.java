
public class RunTimeException extends Exception {
	public RunTimeException(String str) {
		super(str + " is not an accurate input");
	}
}
