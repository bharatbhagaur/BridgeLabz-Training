package aerovigil;

public class InvalidFlightException extends Exception {

	private static final long serialVersionUID = 1L;
	
    public InvalidFlightException(String message) {
        super(message);
    }
}
