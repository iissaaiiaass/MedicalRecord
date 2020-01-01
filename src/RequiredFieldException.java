/**  
 * Program: RequiredFiedlException.java <br>  
 * Date   : 01/29/2019 <br>  
 * Description: <br>  
 * 				Exception class that will be uses when the user lets a required field empty. <br>  
 * <br>  
 * History:<br>  
 * 				01/29/2019 - File created. IDLM, JRO, GMR<br>  
 * 				02/01/2019 - Project completed. IDLM, JRO, GMR <br>  
 * 
 * @author Isaías De León  Millán de_91747@stundents.pupr.edu <br>  
 * @author Julio G. Rivera Oriz rivara_95136@students.pupr.edu <br>
 * @author Gustavo A. Maldonado Rosado maldonado_9130@students.pupr.edu <br>
 */ 
public class RequiredFieldException extends Exception {

	public RequiredFieldException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public RequiredFieldException(String message, Throwable cause, boolean enableSuppression,
			boolean writableStackTrace) {
		super(message, cause, enableSuppression, writableStackTrace);
		// TODO Auto-generated constructor stub
	}

	public RequiredFieldException(String message, Throwable cause) {
		super(message, cause);
		// TODO Auto-generated constructor stub
	}

	public RequiredFieldException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}

	public RequiredFieldException(Throwable cause) {
		super(cause);
		// TODO Auto-generated constructor stub
	}

}
