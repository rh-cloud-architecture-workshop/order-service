package org.globex.retail.order.model.dto;

public class LineItemDto {

    private String product;

    private int quantity;

    private double price;

    public String getProduct() {
        return product;
    }

    public int getQuantity() {
        return quantity;
    }

    public double getPrice() {
        return price;
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private final LineItemDto lineItemDto;

        public Builder() {
            this.lineItemDto = new LineItemDto();
        }

        public Builder withProduct(String product) {
            lineItemDto.product = product;
            return this;
        }

        public Builder withQuantity(Integer quantity) {
            lineItemDto.quantity = quantity;
            return this;
        }

        public Builder withPrice(Double price) {
            lineItemDto.price = price;
            return this;
        }

        public LineItemDto build() {
            return this.lineItemDto;
        }
    }
}
