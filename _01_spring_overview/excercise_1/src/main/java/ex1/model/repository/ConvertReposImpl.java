package ex1.model.repository;

import org.springframework.stereotype.Repository;

@Repository
public class ConvertReposImpl implements IConvertRepos {
    @Override
    public double convert(long amount, double rate) {
        return amount*rate;
    }
}
