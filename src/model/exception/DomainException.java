package model.exception;

// Exception obriga a tratar a exceção, RuntimeException não obriga. 

public class DomainException extends RuntimeException{
//public class DomainException extends Exception{

	private static final long serialVersionUID = 1L;

		public DomainException(String msg) {
			super(msg);
			}
		}
