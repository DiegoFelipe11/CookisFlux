package co.com.sofka.mongo;

import co.com.sofka.model.cookies.Cookies;
import co.com.sofka.model.cookies.gateways.CookiesRepository;
import co.com.sofka.mongo.helper.AdapterOperations;
import org.reactivecommons.utils.ObjectMapper;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.lang.management.MonitorInfo;

@Repository
public class MongoRepositoryAdapter extends AdapterOperations<Cookies,CookiesDocument, String, MongoDBRepository>
 implements CookiesRepository {

    public MongoRepositoryAdapter(MongoDBRepository repository, ObjectMapper mapper) {
        /**
         *  Could be use mapper.mapBuilder if your domain model implement builder pattern
         *  super(repository, mapper, d -> mapper.mapBuilder(d,ObjectModel.ObjectModelBuilder.class).build());
         *  Or using mapper.map with the class of the object model
         */
        super(repository, mapper, d -> mapper.map(d, Cookies.class));
    }

    @Override
    public Mono<Cookies> update(Cookies cookies, String id) {
        /*cookies.setId(id);
        return repository.save(new CookiesDocument(cookies.getId(),cookies.getName(),cookies.getTypeOfCookie()))
                .flatMap(ele->Mono.just(ele));*/
        return null;
    }
}


