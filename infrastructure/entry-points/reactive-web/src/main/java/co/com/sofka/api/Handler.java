package co.com.sofka.api;

import co.com.sofka.model.cookies.Cookies;
import co.com.sofka.usecase.cookiecode.CookieCodeUseCase;
import co.com.sofka.usecase.deletecookies.DeleteCookiesUseCase;
import co.com.sofka.usecase.listcategory.ListCategoryUseCase;
import co.com.sofka.usecase.listcookies.ListCookiesUseCase;
import co.com.sofka.usecase.savecookies.SaveCookiesUseCase;
import co.com.sofka.usecase.updatecookies.UpdateCookiesUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Component
@RequiredArgsConstructor
@Slf4j
public class Handler {
    private final SaveCookiesUseCase saveCookiesUseCase;
    private final ListCookiesUseCase listCookiesUseCase;
    private final UpdateCookiesUseCase updateCookiesUseCase;

    private final DeleteCookiesUseCase deleteCookiesUseCase;

    private final ListCategoryUseCase listCategoryUseCase;

    private final CookieCodeUseCase cookieCodeUseCase;
    public Mono<ServerResponse> SaveCookiesPost(ServerRequest serverRequest) {
        return serverRequest
                .bodyToMono(Cookies.class)
                .flatMap(cookies -> ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(saveCookiesUseCase.saveCookies(cookies),Cookies.class));
    }

    public Mono<ServerResponse> ListCookiesGet(ServerRequest serverRequest) {
        Flux<Cookies> cookiesFlux = listCookiesUseCase.listCookies();
        return  ServerResponse.ok()
                .contentType(MediaType.APPLICATION_JSON)
                .body(cookiesFlux,Cookies.class);
    }

    public Mono<ServerResponse> UpdateCookiesPut(ServerRequest serverRequest) {
        String id = serverRequest.pathVariable("id");
        return serverRequest.bodyToMono(Cookies.class)
               .flatMap(cookies -> ServerResponse.ok()
               .contentType(MediaType.APPLICATION_JSON)
               .body(updateCookiesUseCase.updateCookies(cookies,id),Cookies.class));
    }

    public Mono<ServerResponse> deleteCookiesDel(ServerRequest serverRequest){
        String id = serverRequest.pathVariable("id");
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(deleteCookiesUseCase.deleteCookies(id),Cookies.class);
    }

    public Mono<ServerResponse> searchCookieGet(ServerRequest serverRequest){
        String category=serverRequest.pathVariable("category");
        System.out.println(category);
        return ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
               .body(listCategoryUseCase.apply(category),Cookies.class);
    }

    public Mono<ServerResponse> searchCodeGet(ServerRequest serverRequest){
        String code = serverRequest.pathVariable("code");
        return  ServerResponse.ok().contentType(MediaType.APPLICATION_JSON)
                .body(cookieCodeUseCase.apply(code),Cookies.class);
    }
}
