package co.com.sofka.usecase.listcookies;

import co.com.sofka.model.cookies.Cookies;
import co.com.sofka.model.cookies.gateways.CookiesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Flux;

@RequiredArgsConstructor
public class ListCookiesUseCase {
    private final CookiesRepository cookiesRepository;
    public Flux<Cookies> listCookies(){
        return cookiesRepository.findAll();
    }
}
