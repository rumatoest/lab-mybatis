package lab.mybatis.domain;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.IOException;
import java.math.BigDecimal;

@Data
@EqualsAndHashCode(callSuper = true)
public class Customer extends CustomerBase {

    private String name;

    private String email;

    private BigDecimal balance;

    @JsonCreator
    public static Customer factory(String json) throws IOException {
        return new ObjectMapper().readValue(json, Customer.class);
    }

}
