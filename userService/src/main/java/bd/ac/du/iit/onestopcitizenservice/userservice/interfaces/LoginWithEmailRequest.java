//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.07 at 01:09:52 AM BDT 
//


package bd.ac.du.iit.onestopcitizenservice.userservice.interfaces;

import jakarta.xml.bind.annotation.XmlAccessType;
import jakarta.xml.bind.annotation.XmlAccessorType;
import jakarta.xml.bind.annotation.XmlElement;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="loginWithEmailDetails" type="{http://iit.du.ac.bd/onestopcitizenservice/userservice/interfaces}loginWithEmailDetails"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "loginWithEmailDetails"
})
@XmlRootElement(name = "loginWithEmailRequest")
public class LoginWithEmailRequest {

    @XmlElement(required = true)
    protected LoginWithEmailDetails loginWithEmailDetails;

    /**
     * Gets the value of the loginWithEmailDetails property.
     * 
     * @return
     *     possible object is
     *     {@link LoginWithEmailDetails }
     *     
     */
    public LoginWithEmailDetails getLoginWithEmailDetails() {
        return loginWithEmailDetails;
    }

    /**
     * Sets the value of the loginWithEmailDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link LoginWithEmailDetails }
     *     
     */
    public void setLoginWithEmailDetails(LoginWithEmailDetails value) {
        this.loginWithEmailDetails = value;
    }

}
