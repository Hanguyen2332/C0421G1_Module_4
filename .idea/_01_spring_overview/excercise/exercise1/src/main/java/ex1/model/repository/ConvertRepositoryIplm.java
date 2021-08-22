package ex1.model.repository;

import org.springframework.stereotype.Repository;

public class ConvertRepositoryIplm implements IConvertRepository{
    @Override
    public double convert(long amount, double rate) {
        return amount*rate;
    }
}
