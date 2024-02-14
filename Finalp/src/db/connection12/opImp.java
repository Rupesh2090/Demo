package db.connection12;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import db.connection.GetConnection;
import db.connection.operation;

public class opImp implements operation {

	@Override
	public void insertData() {
		PreparedStatement ps;

		try {
			ps = GetConnection.getConnection().prepareStatement("insert into login values(?,?)");
			ps.setString(1, "ralph");
			ps.setString(2, "dk");
			ps.executeUpdate();
			System.out.println("inserted");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void ubdateData() {
		PreparedStatement ps;

		try {
			ps = GetConnection.getConnection().prepareStatement("update login set username=? where password=?");
			ps.setString(1, "jer");
			ps.setString(2, "tom1");
			ps.executeUpdate();
			System.out.println("update");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void deletetData() {
		
		PreparedStatement ps;
		try {
			ps = GetConnection.getConnection().prepareStatement("delete from login where password=?");
			ps.setString(1, "dk");
			ps.executeUpdate();
			System.out.println("deleted");
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public void disPlay() {
		Statement s;
		try {
			s = GetConnection.getConnection().createStatement();
			ResultSet rs = s.executeQuery("select * from login");
			while (rs.next()) {
				System.out.println(rs.getString(1));
				System.out.println(rs.getString(2));
			}
			System.out.println("done");
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void main(String[] args) {
		opImp op = new opImp();
		//op.insertData();
	//op.ubdateData();
//		op.deletetData();
//		op.disPlay();

	}

}
