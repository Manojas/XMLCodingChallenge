package com.mindtree.xml.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;
import java.util.Set;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;

import com.mindtree.xml.dao.XmlDAOImpl;
import com.mindtree.xml.dao.XmlDAOInterface;
import com.mindtree.xml.model.Song;
import com.mindtree.xml.model.Songs;

public class XmlServiceImpl implements XmlServiceInterface {
	XmlDAOInterface xdi = new XmlDAOImpl();

	public Set<Song> getDataFromDatabase() {
		// TODO Auto-generated method stub

		Set<Song> songs = xdi.getSongsDetails();
		return songs;
	}

	public String convertToXMl(Set<Song> songs) {
		// TODO Auto-generated method stub

		String xmlData = "";
		if (songs != null) {
//			for(Song song:songs)
//			{
//				xmlData+=getXMl(song)+"\n";
//			}

			Songs allsongs = new Songs();
			allsongs.setSongs(songs);
			
			xmlData=getXMl(allsongs);
			File file = new File("Songs.xml");
			try (FileWriter fw = new FileWriter(file)) {
				fw.write(xmlData);
			} catch (IOException e) {
				System.out.println(e.getMessage());
			}
			System.out.println(xmlData);
		} else {
			System.out.println("Failed to read data");
		}
		return null;
	}

	private String getXMl(Songs songs) {
		// TODO Auto-generated method stub

		JAXBContext jaxbContext;
		try {
			jaxbContext = JAXBContext.newInstance(Songs.class);
			Marshaller marshaller = jaxbContext.createMarshaller();
			
			marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
			StringWriter sw = new StringWriter();

			marshaller.marshal(songs, sw);
			
			String songData = sw.toString();
			return songData;
		} catch (JAXBException e) {
			System.out.println(e.getMessage());
		}
		return null;
	}

}
