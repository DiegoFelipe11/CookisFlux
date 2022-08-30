package co.com.sofka.usecase.cookiecode;

import co.com.sofka.model.cookies.Cookies;
import co.com.sofka.model.cookies.gateways.CookiesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;
import java.util.function.Function;

@RequiredArgsConstructor
public class CookieCodeUseCase implements Function<String,Mono<Cookies>> {
    private final CookiesRepository cookiesRepository;
    @Override
    public Mono<Cookies> apply(String code) {
        return  cookiesRepository.findAll()
                .filter(data -> data.getCode().equalsIgnoreCase(code))
                .defaultIfEmpty(new Cookies() )
                .next().onErrorResume(error -> Mono.just(null));

    }
}
