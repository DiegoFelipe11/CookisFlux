package co.com.sofka.api;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerResponse;

import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.RequestPredicates.*;


@Configuration
public class RouterRest {
@Bean
public RouterFunction<ServerResponse> routerFunction(Handler handler) {
    return route(GET("/api/cookies"), handler::ListCookiesGet)
            .andRoute(POST("/api/cookies"), handler::SaveCookiesPost)
            .andRoute(PUT("api/cookies/{id}"),handler::UpdateCookiesPut)
            .andRoute(DELETE("api/cookies/{id}"),handler::deleteCookiesDel)
            .andRoute(GET("api/cookies/category/{category}"),handler::searchCookieGet)
            .andRoute(GET("api/cookies/code/{code}"),handler::searchCodeGet);
    }
}
