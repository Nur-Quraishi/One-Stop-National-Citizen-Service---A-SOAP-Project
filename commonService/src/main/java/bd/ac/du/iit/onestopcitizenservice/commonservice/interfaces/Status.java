//
// This file was generated by the Eclipse Implementation of JAXB, v3.0.2 
// See https://eclipse-ee4j.github.io/jaxb-ri 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2024.10.07 at 01:07:27 AM BDT 
//


package bd.ac.du.iit.onestopcitizenservice.commonservice.interfaces;

import jakarta.xml.bind.annotation.XmlEnum;
import jakarta.xml.bind.annotation.XmlEnumValue;
import jakarta.xml.bind.annotation.XmlType;


/**
 * <p>Java class for status.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <pre>
 * &lt;simpleType name="status"&gt;
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string"&gt;
 *     &lt;enumeration value="OK"/&gt;
 *     &lt;enumeration value="CREATED"/&gt;
 *     &lt;enumeration value="NO CONTENT"/&gt;
 *     &lt;enumeration value="UPDATED"/&gt;
 *     &lt;enumeration value="DELETED"/&gt;
 *     &lt;enumeration value="FAILED"/&gt;
 *     &lt;enumeration value="AUTHENTICATION_FAILED"/&gt;
 *     &lt;enumeration value="AUTHENTICATION_SUCCESSFUL"/&gt;
 *     &lt;enumeration value="SQL_QUERY_FAILURE"/&gt;
 *   &lt;/restriction&gt;
 * &lt;/simpleType&gt;
 * </pre>
 * 
 */
@XmlType(name = "status")
@XmlEnum
public enum Status {

    OK("OK"),
    CREATED("CREATED"),
    @XmlEnumValue("NO CONTENT")
    NO_CONTENT("NO CONTENT"),
    UPDATED("UPDATED"),
    DELETED("DELETED"),
    FAILED("FAILED"),
    AUTHENTICATION_FAILED("AUTHENTICATION_FAILED"),
    AUTHENTICATION_SUCCESSFUL("AUTHENTICATION_SUCCESSFUL"),
    SQL_QUERY_FAILURE("SQL_QUERY_FAILURE");
    private final String value;

    Status(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Status fromValue(String v) {
        for (Status c: Status.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
