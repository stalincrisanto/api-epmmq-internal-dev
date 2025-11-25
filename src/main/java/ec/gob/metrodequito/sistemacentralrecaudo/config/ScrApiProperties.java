package ec.gob.metrodequito.sistemacentralrecaudo.config;

// TODO: change to application.properties o application.yaml

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Getter
@Setter
@Component
@ConfigurationProperties(prefix = "scr.api.connection")
public class ScrApiProperties {
    private String baseUrl;
    private int connectTimeout = 5000;
    private int readTimeout = 10000;
}
