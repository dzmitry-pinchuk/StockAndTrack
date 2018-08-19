package com.qaprosoft.stockproject.dao;

import java.util.ArrayList;

import com.qaprosoft.stockproject.entity.transport.Track;

public interface ITrackDAO {

    ArrayList<Track> getAll();

    Track getById(Long id);

    void deleteById(Long id);

    void createNewTrack(Track track);

}
