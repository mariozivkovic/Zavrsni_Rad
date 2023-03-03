/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package otpremnastanica.util;

/**
 *
 * @author lovre
 */
public class OtpremnaStanicaException extends Exception {
    
    private String poruka;

    public OtpremnaStanicaException(String poruka) {
        super();
        this.poruka = poruka;
    }

    public String getPoruka() {
        return poruka;
    }
    
    
    
    
    
}
