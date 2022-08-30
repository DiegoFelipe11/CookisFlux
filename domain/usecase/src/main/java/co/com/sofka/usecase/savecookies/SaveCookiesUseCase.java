package co.com.sofka.usecase.savecookies;

import co.com.sofka.model.cookies.Cookies;
import co.com.sofka.model.cookies.gateways.CookiesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class SaveCookiesUseCase {
    private final CookiesRepository cookiesRepository;
    public Mono<Cookies> saveCookies(Cookies cookies){
        return cookiesRepository.save(cookies);
    }
}
