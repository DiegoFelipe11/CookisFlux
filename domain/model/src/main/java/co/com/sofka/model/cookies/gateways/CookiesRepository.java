package co.com.sofka.model.cookies.gateways;

import co.com.sofka.model.cookies.Cookies;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface CookiesRepository {

    Flux<Cookies> findAll();
    Mono<Cookies> save(Cookies cookies);
    Mono<Cookies> update(Cookies cookies,String id);
    Mono<Void> deleteById(String id);

}
