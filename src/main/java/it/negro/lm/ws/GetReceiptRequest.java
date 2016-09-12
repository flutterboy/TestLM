//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, v2.2.7 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2016.09.12 at 02:46:08 AM CEST 
//


package it.negro.lm.ws;

import java.util.ArrayList;
import java.util.List;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for anonymous complex type.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * 
 * <pre>
 * &lt;complexType>
 *   &lt;complexContent>
 *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *       &lt;sequence>
 *         &lt;element name="items">
 *           &lt;complexType>
 *             &lt;complexContent>
 *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                 &lt;sequence>
 *                   &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
 *                     &lt;complexType>
 *                       &lt;complexContent>
 *                         &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
 *                           &lt;sequence>
 *                             &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
 *                             &lt;element name="nominalPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
 *                             &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                             &lt;element name="imported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
 *                             &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
 *                           &lt;/sequence>
 *                         &lt;/restriction>
 *                       &lt;/complexContent>
 *                     &lt;/complexType>
 *                   &lt;/element>
 *                 &lt;/sequence>
 *               &lt;/restriction>
 *             &lt;/complexContent>
 *           &lt;/complexType>
 *         &lt;/element>
 *       &lt;/sequence>
 *     &lt;/restriction>
 *   &lt;/complexContent>
 * &lt;/complexType>
 * </pre>
 * 
 * 
 */
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {
    "items"
})
@XmlRootElement(name = "getReceiptRequest")
public class GetReceiptRequest {

    @XmlElement(required = true)
    protected GetReceiptRequest.Items items;

    /**
     * Gets the value of the items property.
     * 
     * @return
     *     possible object is
     *     {@link GetReceiptRequest.Items }
     *     
     */
    public GetReceiptRequest.Items getItems() {
        return items;
    }

    /**
     * Sets the value of the items property.
     * 
     * @param value
     *     allowed object is
     *     {@link GetReceiptRequest.Items }
     *     
     */
    public void setItems(GetReceiptRequest.Items value) {
        this.items = value;
    }


    /**
     * <p>Java class for anonymous complex type.
     * 
     * <p>The following schema fragment specifies the expected content contained within this class.
     * 
     * <pre>
     * &lt;complexType>
     *   &lt;complexContent>
     *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *       &lt;sequence>
     *         &lt;element name="item" maxOccurs="unbounded" minOccurs="0">
     *           &lt;complexType>
     *             &lt;complexContent>
     *               &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
     *                 &lt;sequence>
     *                   &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
     *                   &lt;element name="nominalPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
     *                   &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                   &lt;element name="imported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
     *                   &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
     *                 &lt;/sequence>
     *               &lt;/restriction>
     *             &lt;/complexContent>
     *           &lt;/complexType>
     *         &lt;/element>
     *       &lt;/sequence>
     *     &lt;/restriction>
     *   &lt;/complexContent>
     * &lt;/complexType>
     * </pre>
     * 
     * 
     */
    @XmlAccessorType(XmlAccessType.FIELD)
    @XmlType(name = "", propOrder = {
        "item"
    })
    public static class Items {

        protected List<GetReceiptRequest.Items.Item> item;

        /**
         * Gets the value of the item property.
         * 
         * <p>
         * This accessor method returns a reference to the live list,
         * not a snapshot. Therefore any modification you make to the
         * returned list will be present inside the JAXB object.
         * This is why there is not a <CODE>set</CODE> method for the item property.
         * 
         * <p>
         * For example, to add a new item, do as follows:
         * <pre>
         *    getItem().add(newItem);
         * </pre>
         * 
         * 
         * <p>
         * Objects of the following type(s) are allowed in the list
         * {@link GetReceiptRequest.Items.Item }
         * 
         * 
         */
        public List<GetReceiptRequest.Items.Item> getItem() {
            if (item == null) {
                item = new ArrayList<GetReceiptRequest.Items.Item>();
            }
            return this.item;
        }


        /**
         * <p>Java class for anonymous complex type.
         * 
         * <p>The following schema fragment specifies the expected content contained within this class.
         * 
         * <pre>
         * &lt;complexType>
         *   &lt;complexContent>
         *     &lt;restriction base="{http://www.w3.org/2001/XMLSchema}anyType">
         *       &lt;sequence>
         *         &lt;element name="id" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="name" type="{http://www.w3.org/2001/XMLSchema}string"/>
         *         &lt;element name="nominalPrice" type="{http://www.w3.org/2001/XMLSchema}double"/>
         *         &lt;element name="categoryId" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *         &lt;element name="imported" type="{http://www.w3.org/2001/XMLSchema}boolean"/>
         *         &lt;element name="quantity" type="{http://www.w3.org/2001/XMLSchema}int"/>
         *       &lt;/sequence>
         *     &lt;/restriction>
         *   &lt;/complexContent>
         * &lt;/complexType>
         * </pre>
         * 
         * 
         */
        @XmlAccessorType(XmlAccessType.FIELD)
        @XmlType(name = "", propOrder = {
            "id",
            "name",
            "nominalPrice",
            "categoryId",
            "imported",
            "quantity"
        })
        public static class Item {

            protected int id;
            @XmlElement(required = true)
            protected String name;
            protected double nominalPrice;
            protected int categoryId;
            protected boolean imported;
            protected int quantity;

            /**
             * Gets the value of the id property.
             * 
             */
            public int getId() {
                return id;
            }

            /**
             * Sets the value of the id property.
             * 
             */
            public void setId(int value) {
                this.id = value;
            }

            /**
             * Gets the value of the name property.
             * 
             * @return
             *     possible object is
             *     {@link String }
             *     
             */
            public String getName() {
                return name;
            }

            /**
             * Sets the value of the name property.
             * 
             * @param value
             *     allowed object is
             *     {@link String }
             *     
             */
            public void setName(String value) {
                this.name = value;
            }

            /**
             * Gets the value of the nominalPrice property.
             * 
             */
            public double getNominalPrice() {
                return nominalPrice;
            }

            /**
             * Sets the value of the nominalPrice property.
             * 
             */
            public void setNominalPrice(double value) {
                this.nominalPrice = value;
            }

            /**
             * Gets the value of the categoryId property.
             * 
             */
            public int getCategoryId() {
                return categoryId;
            }

            /**
             * Sets the value of the categoryId property.
             * 
             */
            public void setCategoryId(int value) {
                this.categoryId = value;
            }

            /**
             * Gets the value of the imported property.
             * 
             */
            public boolean isImported() {
                return imported;
            }

            /**
             * Sets the value of the imported property.
             * 
             */
            public void setImported(boolean value) {
                this.imported = value;
            }

            /**
             * Gets the value of the quantity property.
             * 
             */
            public int getQuantity() {
                return quantity;
            }

            /**
             * Sets the value of the quantity property.
             * 
             */
            public void setQuantity(int value) {
                this.quantity = value;
            }

        }

    }

}
