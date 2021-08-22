package ex1.model.service;

import ex1.model.repository.IConvertRepos;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ConvertServiceImpl implements IConvertService {
    @Autowired
    IConvertRepos iConvertRepos;
    @Override
    public double convert(long amount, double rate) {
        return 0;
    }
}
