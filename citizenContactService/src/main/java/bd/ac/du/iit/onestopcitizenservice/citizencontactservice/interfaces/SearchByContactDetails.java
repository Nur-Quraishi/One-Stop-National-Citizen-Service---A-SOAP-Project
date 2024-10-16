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
import jakarta.xml.bind.annotation.XmlSchemaType;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for searchByContactDetails complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType name="searchByContactDetails"&gt;
 *   &lt;complexContent&gt;
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType"&gt;
 *       &lt;sequence&gt;
 *         &lt;element name="contact" type="{http://www.w3.org/2001/XMLSchema}string"/&gt;
 *         &lt;element name="columnToBeSorted" type="{http://iit.du.ac.bd/onestopcitizenservice/citizencontactservice/interfaces}columnToBeSorted"/&gt;
 *         &lt;element name="sortOrder" type="{http://iit.du.ac.bd/onestopcitizenservice/citizencontactservice/interfaces}sortOrder"/&gt;
 *       &lt;/sequence&gt;
 *     &lt;/restriction&gt;
 *   &lt;/complexContent&gt;
 * &lt;/complexType&gt;
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "searchByContactDetails", propOrder = {
    "contact",
    "columnToBeSorted",
    "sortOrder"
})
public class SearchByContactDetails {

    @XmlElement(required = true)
    protected String contact;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected ColumnToBeSorted columnToBeSorted;
    @XmlElement(required = true)
    @XmlSchemaType(name = "string")
    protected SortOrder sortOrder;

    /**
     * Gets the value of the contact property.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getContact() {
        return contact;
    }

    /**
     * Sets the value of the contact property.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setContact(String value) {
        this.contact = value;
    }

    /**
     * Gets the value of the columnToBeSorted property.
     * 
     * @return
     *     possible object is
     *     {@link ColumnToBeSorted }
     *     
     */
    public ColumnToBeSorted getColumnToBeSorted() {
        return columnToBeSorted;
    }

    /**
     * Sets the value of the columnToBeSorted property.
     * 
     * @param value
     *     allowed object is
     *     {@link ColumnToBeSorted }
     *     
     */
    public void setColumnToBeSorted(ColumnToBeSorted value) {
        this.columnToBeSorted = value;
    }

    /**
     * Gets the value of the sortOrder property.
     * 
     * @return
     *     possible object is
     *     {@link SortOrder }
     *     
     */
    public SortOrder getSortOrder() {
        return sortOrder;
    }

    /**
     * Sets the value of the sortOrder property.
     * 
     * @param value
     *     allowed object is
     *     {@link SortOrder }
     *     
     */
    public void setSortOrder(SortOrder value) {
        this.sortOrder = value;
    }

}
