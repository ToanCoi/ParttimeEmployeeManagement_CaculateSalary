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
public class InvalidDayOfWeekException extends Exception{

    public InvalidDayOfWeekException() {
    }

    public InvalidDayOfWeekException(String message) {
        super(message);
    }
    
}
