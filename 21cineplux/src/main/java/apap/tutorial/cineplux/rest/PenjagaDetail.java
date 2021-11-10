package apap.tutorial.cineplux.rest;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.Setter;
import java.util.Date;

@Getter @Setter
@JsonIgnoreProperties(ignoreUnknown = true)
public class PenjagaDetail {
    private String status;

    @JsonProperty("penjaga-license")
    private Integer penjagaLicense;

    @JsonProperty("valid-until")
    private Date validUntil;
}

