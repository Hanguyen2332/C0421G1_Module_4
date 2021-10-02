package com.practice.model.service.impl;
import com.practice.model.entity.employee.Position;
import com.practice.model.repository.IPositionRepository;
import com.practice.model.service.IPosition;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@Service
public class PositionImpl implements IPosition {
    @Autowired
    private IPositionRepository iPositionRepository;
    @Override
    public List<Position> findAll() {
        return iPositionRepository.findAll();
    }
}
