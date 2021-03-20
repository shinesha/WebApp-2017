/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package dto;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Viran Gohil 15500582 Class to enable JQuery script to organise
 *         records returned in client viewer.
 */

public class DataTableObject {
	private int iTotalRecords;
	private int iTotalDisplayRecords;
	private String sEcho;
	private String sColumns;
	List<CourseBean> aaData;

	/**
	 * get All Records
	 * 
	 * @return
	 */
	public int getiTotalRecords() {
		return iTotalRecords;
	}

	/**
	 * set DataTableObject Total Records
	 * 
	 * @param iTotalRecords
	 *            new iTotalRecords
	 */
	public void setiTotalRecords(int iTotalRecords) {
		this.iTotalRecords = iTotalRecords;
	}

	/**
	 * get Display All Records
	 * 
	 * @return
	 */
	public int getiTotalDisplayRecords() {
		return iTotalDisplayRecords;
	}

	/**
	 * set DataTableObject Display All Records
	 * 
	 * @param iTotalDisplayRecords
	 *            new iTotalDisplayRecords
	 */
	public void setiTotalDisplayRecords(int iTotalDisplayRecords) {
		this.iTotalDisplayRecords = iTotalDisplayRecords;
	}

	/**
	 * get Echo
	 * 
	 * @return
	 */
	public String getsEcho() {
		return sEcho;
	}

	/**
	 * set DataTableObject Echo
	 * 
	 * @param sEcho
	 *            new sEcho
	 */
	public void setsEcho(String sEcho) {
		this.sEcho = sEcho;
	}

	/**
	 * get Table Columns
	 * 
	 * @return
	 */
	public String getsColumns() {
		return sColumns;
	}

	/**
	 * set DataTableObject Columns
	 * 
	 * @param sColumns
	 *            new sColumns
	 */
	public void setsColumns(String sColumns) {
		this.sColumns = sColumns;
	}

	/**
	 * get Array of CourseBeans
	 * 
	 * @return
	 */
	public List<CourseBean> getAaData() {
		return aaData;
	}

	/**
	 * set Arrya or CourseBeans
	 * 
	 * @param aaData
	 *            new aaData
	 */
	public void setAaData(List<CourseBean> aaData) {
		this.aaData = aaData;
	}

}
