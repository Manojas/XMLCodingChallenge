package com.mindtree.xml.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
@XmlRootElement(name="songs")
public class Songs {
	private Set<Song> songs;

	public Songs() {
		super();
	}

	@XmlElement(name="song")
	public Set<Song> getSongs() {
		return songs;
	}

	public void setSongs(Set<Song> songs) {
		this.songs = songs;
	}
	
	
}
