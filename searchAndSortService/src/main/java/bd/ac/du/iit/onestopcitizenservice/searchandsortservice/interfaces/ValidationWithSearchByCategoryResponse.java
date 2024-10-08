//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.09 at 02:11:13 AM BDT 
//


package bd.ac.du.iit.onestopcitizenservice.searchandsortservice.interfaces;

import bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces.ContactList;
import bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces.ServiceStatus;
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
 *         &lt;element name="searchResults" type="{http://iit.du.ac.bd/onestopcitizenservice/citizencontactservice/interfaces}contactList"/&gt;
 *         &lt;element ref="{http://iit.du.ac.bd/onestopcitizenservice/commonservice/interfaces}serviceStatus"/&gt;
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
    "searchResults",
    "serviceStatus"
})
@XmlRootElement(name = "validationWithSearchByCategoryResponse")
public class ValidationWithSearchByCategoryResponse {

    @XmlElement(required = true)
    protected ContactList searchResults;
    @XmlElement(namespace = "http://iit.du.ac.bd/onestopcitizenservice/commonservice/interfaces", required = true)
    protected ServiceStatus serviceStatus;

    /**
     * Gets the value of the searchResults property.
     * 
     * @return
     *     possible object is
     *     {@link ContactList }
     *     
     */
    public ContactList getSearchResults() {
        return searchResults;
    }

    /**
     * Sets the value of the searchResults property.
     * 
     * @param value
     *     allowed object is
     *     {@link ContactList }
     *     
     */
    public void setSearchResults(ContactList value) {
        this.searchResults = value;
    }

    /**
     * Gets the value of the serviceStatus property.
     * 
     * @return
     *     possible object is
     *     {@link ServiceStatus }
     *     
     */
    public ServiceStatus getServiceStatus() {
        return serviceStatus;
    }

    /**
     * Sets the value of the serviceStatus property.
     * 
     * @param value
     *     allowed object is
     *     {@link ServiceStatus }
     *     
     */
    public void setServiceStatus(ServiceStatus value) {
        this.serviceStatus = value;
    }

}
