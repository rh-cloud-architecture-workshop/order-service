package org.globex.retail.order.model.dto;

public class ShippingAddressDto {

    private String name;

    private String phone;

    private String address1;

    private String address2;

    private String city;

    private String zip;

    private String state;

    private String country;

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress1() {
        return address1;
    }

    public String getAddress2() {
        return address2;
    }

    public String getCity() {
        return city;
    }

    public String getZip() {
        return zip;
    }

    public String getState() {
        return state;
    }

    public String getCountry() {
        return country;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final ShippingAddressDto shippingAddressDto;

        public Builder() {
            this.shippingAddressDto = new ShippingAddressDto();
        }

        public Builder withName(String name) {
            shippingAddressDto.name = name;
            return this;
        }

        public Builder withPhone(String phone) {
            shippingAddressDto.phone = phone;
            return this;
        }

        public Builder withAddress1(String address1) {
            shippingAddressDto.address1 = address1;
            return this;
        }

        public Builder withAddress2(String address2) {
            shippingAddressDto.address2 = address2;
            return this;
        }

        public Builder withCity(String city) {
            shippingAddressDto.city = city;
            return this;
        }

        public Builder withZip(String zip) {
            shippingAddressDto.zip = zip;
            return this;
        }

        public Builder withState(String state) {
            shippingAddressDto.state = state;
            return this;
        }

        public Builder withCountry(String country) {
            shippingAddressDto.country = country;
            return this;
        }

        public ShippingAddressDto build() {
            return this.shippingAddressDto;
        }
    }
}
