
package calculator.ui.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlSchemaType;
import javax.xml.bind.annotation.XmlType;
import javax.xml.datatype.XMLGregorianCalendar;


/**
 * <p>Java-Klasse für calculation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="calculation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="correctSolved" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}long"/>
 *         &lt;element name="operand1" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="operand2" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="submittedAt" type="{http://www.w3.org/2001/XMLSchema}dateTime" minOccurs="0"/>
 *         &lt;element name="userResult" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *         &lt;element name="username" type="{http://www.w3.org/2001/XMLSchema}string" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "calculation", propOrder = {
    "correctSolved",
    "id",
    "operand1",
    "operand2",
    "submittedAt",
    "userResult",
    "username"
})
public class Calculation {

    protected boolean correctSolved;
    protected long id;
    protected int operand1;
    protected int operand2;
    @XmlSchemaType(name = "dateTime")
    protected XMLGregorianCalendar submittedAt;
    protected int userResult;
    protected String username;

    /**
     * Ruft den Wert der correctSolved-Eigenschaft ab.
     * 
     */
    public boolean isCorrectSolved() {
        return correctSolved;
    }

    /**
     * Legt den Wert der correctSolved-Eigenschaft fest.
     * 
     */
    public void setCorrectSolved(boolean value) {
        this.correctSolved = value;
    }

    /**
     * Ruft den Wert der id-Eigenschaft ab.
     * 
     */
    public long getId() {
        return id;
    }

    /**
     * Legt den Wert der id-Eigenschaft fest.
     * 
     */
    public void setId(long value) {
        this.id = value;
    }

    /**
     * Ruft den Wert der operand1-Eigenschaft ab.
     * 
     */
    public int getOperand1() {
        return operand1;
    }

    /**
     * Legt den Wert der operand1-Eigenschaft fest.
     * 
     */
    public void setOperand1(int value) {
        this.operand1 = value;
    }

    /**
     * Ruft den Wert der operand2-Eigenschaft ab.
     * 
     */
    public int getOperand2() {
        return operand2;
    }

    /**
     * Legt den Wert der operand2-Eigenschaft fest.
     * 
     */
    public void setOperand2(int value) {
        this.operand2 = value;
    }

    /**
     * Ruft den Wert der submittedAt-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public XMLGregorianCalendar getSubmittedAt() {
        return submittedAt;
    }

    /**
     * Legt den Wert der submittedAt-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link XMLGregorianCalendar }
     *     
     */
    public void setSubmittedAt(XMLGregorianCalendar value) {
        this.submittedAt = value;
    }

    /**
     * Ruft den Wert der userResult-Eigenschaft ab.
     * 
     */
    public int getUserResult() {
        return userResult;
    }

    /**
     * Legt den Wert der userResult-Eigenschaft fest.
     * 
     */
    public void setUserResult(int value) {
        this.userResult = value;
    }

    /**
     * Ruft den Wert der username-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link String }
     *     
     */
    public String getUsername() {
        return username;
    }

    /**
     * Legt den Wert der username-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link String }
     *     
     */
    public void setUsername(String value) {
        this.username = value;
    }

}
