package id.muhammadfaisal.parkee.model.response.discount_type;

import java.math.BigInteger;

public class DiscountTypeResponse {
    private BigInteger id;
    private String type;

    public BigInteger getId() {
        return id;
    }

    public void setId(BigInteger id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }
}
