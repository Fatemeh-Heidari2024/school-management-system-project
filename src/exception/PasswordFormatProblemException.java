package exception;

public class PasswordFormatProblemException extends Exception{


    public PasswordFormatProblemException(String message) {
        System.out.println(message+" !   you must enter at least 8 character");
    }
}
