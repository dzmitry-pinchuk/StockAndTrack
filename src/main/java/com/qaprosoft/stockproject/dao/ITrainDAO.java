package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.transport.Train;

public interface ITrainDAO {

    ArrayList<Train> getAll();

    Train getById(Long id);

    void deleteById(Long id);

    void createNewTrack(Train train);

}
