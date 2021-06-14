package com.mindtree.xml.client;

import java.util.LinkedHashSet;
import java.util.Scanner;
import java.util.Set;

import com.mindtree.xml.model.Song;
import com.mindtree.xml.service.XmlServiceImpl;
import com.mindtree.xml.service.XmlServiceInterface;

public class Main {
	static XmlServiceInterface xsi=new XmlServiceImpl();
public static void main(String[] args)
{
	Scanner in=new Scanner(System.in);
	boolean flag=true;
	do {
	System.out.println("Press 1 to convert data into xml file");
	int choice=in.nextInt();
	
	switch(choice)
	{
	case 1:String str=convertDataintoXmlFile();
	break;
	}
	
	}while(flag);
}
private static String convertDataintoXmlFile() {
	// TODO Auto-generated method stub
	//Set<Song> song=new LinkedHashSet<Song>();
	Set<Song> songs=xsi.getDataFromDatabase();
	String str=xsi.convertToXMl(songs);
	
	return str;
}
}
