package co.com.sofka.usecase.listcategory;

import co.com.sofka.model.cookies.Cookies;
import co.com.sofka.model.cookies.gateways.CookiesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.Collections;
import java.util.function.Function;

@RequiredArgsConstructor
public class ListCategoryUseCase implements Function<String, Flux<Cookies>> {
    private final CookiesRepository cookiesRepository;

    @Override
    public Flux<Cookies> apply(String category) {
        return cookiesRepository.findAll()
                .filter(data -> data.getCategory().contains(category))
                .defaultIfEmpty(new Cookies())
                .onErrorResume(error->Mono.just(null));

    }
}