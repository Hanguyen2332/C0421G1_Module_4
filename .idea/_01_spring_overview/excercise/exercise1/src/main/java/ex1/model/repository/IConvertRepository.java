package ex1.model.repository;

import org.springframework.stereotype.Repository;

@Repository
public interface IConvertRepository {
    double convert(long amount, double rate);
}
