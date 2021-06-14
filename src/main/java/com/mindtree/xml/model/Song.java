package com.mindtree.xml.model;

import java.util.Set;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
//@XmlRootElement
public class Song {
private int songId;
private String songName;
private String songLength;
private Set<Singer> singers;

public Song() {
	super();
}
public Song(int songId, String songName, String songLength, Set<Singer> singers) {
	super();
	this.songId = songId;
	this.songName = songName;
	this.songLength = songLength;
	this.singers = singers;
}
public int getSongId() {
	return songId;
}
//@XmlElement
public void setSongId(int songId) {
	this.songId = songId;
}
public String getSongName() {
	return songName;
}
public void setSongName(String songName) {
	this.songName = songName;
}
public String getSongLength() {
	return songLength;
}
public void setSongLength(String songLength) {
	this.songLength = songLength;
}
//@XmlElement
public Set<Singer> getSingers() {
	return singers;
}
public void setSingers(Set<Singer> singers) {
	this.singers = singers;
}
@Override
public String toString() {
	return "Song [songId=" + songId + ", songName=" + songName + ", songLength=" + songLength + ", singers=" + singers
			+ "]";
}



}
