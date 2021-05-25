/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package exception;

/**
 *
 * @author nguye
 */
public class InvalidDateFormatException extends Exception{

    public InvalidDateFormatException() {
    }

    public InvalidDateFormatException(String message) {
        super(message);
    }
    
}
