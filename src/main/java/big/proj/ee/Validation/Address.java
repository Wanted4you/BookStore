package big.proj.ee.Validation;

import com.sun.istack.internal.NotNull;

/**
 * Created by Влад on 24.06.2016.
 */

public class Address {

    @NotNull
    private String street1;
    private String street2;
    @NotNull
    private String city;
    private String state;
    @NotNull @ZipCode
    private String zipcode;
    private String country;

    public Address() {
    }

    public Address(String country, String zipcode, String state, String city, String street1) {
        this.country = country;
        this.zipcode = zipcode;
        this.state = state;
        this.city = city;
        this.street1 = street1;
    }

    public String getStreet1() {
        return street1;
    }

    public void setStreet1(String street1) {
        this.street1 = street1;
    }

    public String getStreet2() {
        return street2;
    }

    public void setStreet2(String street2) {
        this.street2 = street2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZipcode() {
        return zipcode;
    }

    public void setZipcode(String zipcode) {
        this.zipcode = zipcode;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
