public class InvalidInputFormatException extends Exception{

    public InvalidInputFormatException(String error){
        System.err.println(error);
    }
}
