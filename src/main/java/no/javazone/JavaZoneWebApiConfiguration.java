package no.javazone;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.dropwizard.Configuration;
import org.hibernate.validator.constraints.NotEmpty;

import java.util.List;

public class JavaZoneWebApiConfiguration extends Configuration {
    @NotEmpty
    private String emsHost;

    @JsonProperty
    public String getEmsHost() {
        return emsHost;
    }

    @JsonProperty
    public void setEmsHost(String emsHost) {
        this.emsHost = emsHost;
    }
}