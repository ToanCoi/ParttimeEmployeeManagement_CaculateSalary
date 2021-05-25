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
public class PaidException extends Exception{

    public PaidException() {
    }

    public PaidException(String message) {
        super(message);
    }
    
}
