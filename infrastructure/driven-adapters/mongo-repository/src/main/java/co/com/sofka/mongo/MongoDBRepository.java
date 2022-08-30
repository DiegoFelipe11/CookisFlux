package co.com.sofka.mongo;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.data.repository.query.ReactiveQueryByExampleExecutor;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;

public interface MongoDBRepository extends ReactiveMongoRepository<CookiesDocument, String>, ReactiveQueryByExampleExecutor<CookiesDocument>, ReactiveCrudRepository<CookiesDocument,String> {
}
