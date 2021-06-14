package com.mindtree.xml.service;

import java.util.Set;

import com.mindtree.xml.model.Song;

public interface XmlServiceInterface {
public Set<Song> getDataFromDatabase();

public String convertToXMl(Set<Song> songs);

}
