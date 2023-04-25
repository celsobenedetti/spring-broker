package djc.broker.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    // TODO: arrumar essa gambiarra
    @Value("${services.catshop.url}")
    private String catshopServiceUrl;

    @Bean
    public RouteLocator gatewayRouteLocator(RouteLocatorBuilder builder) {
        return builder.routes()
                .route("catshop", route -> route.path("/cats")
                        .uri(catshopServiceUrl))
                .build();
    }

}
