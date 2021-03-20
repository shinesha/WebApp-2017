/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dao;

import java.io.PrintStream;
import java.sql.Connection;
import java.sql.DriverManager;
import javax.swing.JOptionPane;

/**
 *
 * @author Viran Gohil 15500582 Class to establish connection to database and
 *         give access to single instance of a db connection.
 * 
 */

public class CourseDBConnect {
	private Connection con;

	/**
	 * Singleton Pattern private constructor so cannot get instance outside the
	 * class.
	 * 
	 */
	private static CourseDBConnect CONNECT = new CourseDBConnect();

	private CourseDBConnect() {
	}

	/**
	 * getConnect is the method to give public access to an instance of the
	 * class.
	 * 
	 */
	public static CourseDBConnect getConnect() {
		return CONNECT;
	}

	/**
	 *
	 * Method to get instance of DB connection
	 * 
	 */
	public Connection getLink() {
		String url = "jdbc:mysql://mudfoot.doc.stu.mmu.ac.uk:3306/gohilv";
		String user = "gohilv";
		String password = "Lamnerwa6";
		String driver = "com.mysql.jdbc.Driver";
		try {
			// Reflection, loading the driver for the class
			Class.forName(driver).newInstance();
			System.out.print("viran");
			this.con = DriverManager.getConnection(url, user, password);
			System.out.print("viran A");
			if (this.con != null) {
				// pop up panel if we acquire a DB connection
				JOptionPane.showMessageDialog(null, "Connected");
			} else {
				// pop up panel if no DB connection obtained
				JOptionPane.showMessageDialog(null, "Not Connected");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.con;
	}
}