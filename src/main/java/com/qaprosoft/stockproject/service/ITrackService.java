package com.qaprosoft.stockproject.service;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.transport.Track;

public interface ITrackService {
    
    ArrayList<Track> getAll();

    Track getById(Long id);

    void deleteById(Long id);

    void createNewTrack(Track track);


}
