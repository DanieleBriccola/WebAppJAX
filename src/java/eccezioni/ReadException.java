/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eccezioni;

import java.io.IOException;

/**
 *
 * @author danie
 */
public class ReadException extends IOException {
    public ReadException(String message, Throwable cause) {
        super(message, cause);
    }
}
