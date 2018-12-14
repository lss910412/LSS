package com.biz.chart;

import java.util.ArrayList;

public interface Ch99JDBC {
	//Create: insert
	//Read : select
	//Update : update
	//Delete : delete
	public abstract ArrayList<EmpVO> empList(String searchColumn, Object searchStr);
	public ArrayList<EmpVO> empList();
	
	public int empInsert(int prmEmpno, String prmEname);
	public int empUpdate(int prmSal, int prmEmpno);
	public int empDelete(int prmEmpno);

	
	
		
}
