//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.07 at 05:01:05 AM BDT 
//


package bd.ac.du.iit.onestopcitizenservice.citizencontactservice.interfaces;

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
 *         &lt;element name="searchByNameDetails" type="{http://iit.du.ac.bd/onestopcitizenservice/citizencontactservice/interfaces}searchByNameDetails"/&gt;
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
    "searchByNameDetails"
})
@XmlRootElement(name = "searchByNameRequest")
public class SearchByNameRequest {

    @XmlElement(required = true)
    protected SearchByNameDetails searchByNameDetails;

    /**
     * Gets the value of the searchByNameDetails property.
     * 
     * @return
     *     possible object is
     *     {@link SearchByNameDetails }
     *     
     */
    public SearchByNameDetails getSearchByNameDetails() {
        return searchByNameDetails;
    }

    /**
     * Sets the value of the searchByNameDetails property.
     * 
     * @param value
     *     allowed object is
     *     {@link SearchByNameDetails }
     *     
     */
    public void setSearchByNameDetails(SearchByNameDetails value) {
        this.searchByNameDetails = value;
    }

}
