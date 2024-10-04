package exception;

public class UsernameFormatProblemException extends Exception{


    public UsernameFormatProblemException(String message) {
        System.out.println(message+" !   you must enter at least 8 character");
    }
}
