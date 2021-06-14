package com.mindtree.xml.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedHashSet;
import java.util.Set;

import com.mindtree.xml.model.Singer;
import com.mindtree.xml.model.Song;
import com.mindtree.xml.utility.ClassNFCustomException;
import com.mindtree.xml.utility.GetConnection;

public class XmlDAOImpl implements XmlDAOInterface{

	public Set<Song> getSongsDetails() {
		// TODO Auto-generated method stub
		Connection con=null;
		try {
			 con=GetConnection.getConnection();
		} catch (ClassNFCustomException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		PreparedStatement pstmt1=null;
		PreparedStatement pstmt2=null;
		Set<Song> songs=new LinkedHashSet<Song>();
		try {
			String query="select * from song";
			pstmt1=con.prepareStatement(query);
			ResultSet rs=pstmt1.executeQuery();
			
			while(rs.next())
			{
				int songId=rs.getInt("sid");
				String songName=rs.getString("title");
				String songLength=rs.getString("length");
				Set<Singer> singers=new LinkedHashSet<Singer>();
				
				String query2="select s2.id,s2.name,s2.gender from singer s2 join songs_record s1"
						+ " where sid="+songId+" and s2.id=s1.id";
				
				pstmt2=con.prepareStatement(query2);
				ResultSet rs2=pstmt2.executeQuery();
				
				while(rs2.next())
				{
					int singerId=rs2.getInt("id");
					String singerName=rs2.getString("name");
					String singerGender=rs2.getString("gender");
					singers.add(new Singer(singerId,singerName,singerGender));
				}
				songs.add(new Song(songId,songName,songLength,singers));
				
			}
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
		}
		finally {
			if(pstmt2!=null ||pstmt1!=null)
			{
				try {
					pstmt2.close();
					pstmt1.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			
			if(con!=null)
			{
				try {
					con.close();
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}
		return songs;
	}

}
