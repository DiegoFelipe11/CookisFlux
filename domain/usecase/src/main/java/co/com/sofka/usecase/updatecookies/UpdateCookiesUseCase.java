package co.com.sofka.usecase.updatecookies;

import co.com.sofka.model.cookies.Cookies;
import co.com.sofka.model.cookies.gateways.CookiesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class UpdateCookiesUseCase {
    private final CookiesRepository cookiesRepository;
    public Mono<Cookies> updateCookies(Cookies cookies , String id){
        return cookiesRepository.update(cookies,id);
    }
}
