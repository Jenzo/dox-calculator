
package calculator.ui.webservice;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java-Klasse für solveCalculation complex type.
 * 
 * <p>Das folgende Schemafragment gibt den erwarteten Content an, der in dieser Klasse enthalten ist.
 * 
 * <pre>
 * &lt;complexType name="solveCalculation">
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="calculation" type="{http://webservice.ui.calculator/}calculation" minOccurs="0"/>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "solveCalculation", propOrder = {
    "calculation"
})
public class SolveCalculation {

    protected Calculation calculation;

    /**
     * Ruft den Wert der calculation-Eigenschaft ab.
     * 
     * @return
     *     possible object is
     *     {@link Calculation }
     *     
     */
    public Calculation getCalculation() {
        return calculation;
    }

    /**
     * Legt den Wert der calculation-Eigenschaft fest.
     * 
     * @param value
     *     allowed object is
     *     {@link Calculation }
     *     
     */
    public void setCalculation(Calculation value) {
        this.calculation = value;
    }

}
