package com.qaprosoft.stockproject.service;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.transport.Train;

public interface ITrainService {

    ArrayList<Train> getAll();

    Train getById(Long id);

    void deleteById(Long id);

}
