package co.com.sofka.usecase.deletecookies;

import co.com.sofka.model.cookies.gateways.CookiesRepository;
import lombok.RequiredArgsConstructor;
import reactor.core.publisher.Mono;

@RequiredArgsConstructor
public class DeleteCookiesUseCase {
    private final CookiesRepository cookiesRepository;
    public Mono<Void> deleteCookies(String id){
        return cookiesRepository.deleteById(id);
    }
}
