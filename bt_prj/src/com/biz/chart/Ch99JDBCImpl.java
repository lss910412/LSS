package com.biz.chart;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Vector;

//import java.sql.*;

//--------------------------------------
// JDBCD Setting : lib 추가
//--------------------------------------
//C:\oraclexe\app\oracle\product\11.2.0\server\jdbc\lib\ojdbc6.jar
//C:\jp\jdk1.8.0_172\jre\lib\ext 카피
//이클립스 jre 설정확인 : Windows > Preference > Java > InstalledJREs > JDK1.8~~~ 확인
//프로젝트 트리 > JRE System Library > ojdbc.jar 보이는지 확인
//프로젝트 트리>우클릭 > Properties > Java Build Path > Lib탭 > jre보임

public class Ch99JDBCImpl implements Ch99JDBC {
	//ODBC : Windows에서 사용되는 DB연결
	//     : MSSql, Access      
	
	//JDBC(Java DataBase Connectivity)
	//     : Oralce, Mysql, SQLite, MariaDB
	// : Driver 
	// : jar(java Archive) 클래스 파일들을 압축해놓은것 == zip파일
	// : API(메서드 기능의 묶음)
	//public static void main(String[] args) {
	
	
	
public EmpVO empView(int empno) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		EmpVO evo = new EmpVO(); 
		Ch99DBManager db = new Ch99DBManager();
		
		try {
			conn = db.dbConn();
			
			//String sql = "select empno, ename from emp where "+searchColumn+"=?";
			//String sql = "select empno, ename from emp where "+searchColumn+" like '%"+searchStr+"%'";
			String sql = "select empno, ename from emp where empno=?";	
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, empno);  //바인딩
			rs = pstmt.executeQuery();
			if(rs.next()) {
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			db.add(9);
			db.dbClose(rs, pstmt, conn);
		}
		return evo;
	}

	
	@Override
	public ArrayList<EmpVO> empList(String searchColumn, Object searchStr) {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpVO> list = new ArrayList<EmpVO>(); 
		Ch99DBManager db = new Ch99DBManager();
		
		try {
			conn = db.dbConn();
			
			//String sql = "select empno, ename from emp where "+searchColumn+"=?";
			//String sql = "select empno, ename from emp where "+searchColumn+" like '%"+searchStr+"%'";
			String sql = "select empno, ename from emp where "+searchColumn+" like '%'||?||'%'";
															    //where ename like '%'||'LA'||'%'
																	
			System.out.println(sql);
			
			pstmt = conn.prepareStatement(sql);
			pstmt.setObject(1, searchStr);  //바인딩
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				list.add(evo);
//				int no = 		rs.getInt("empno");
//				String name = 	rs.getString("ename");
//				System.out.println(no + "\t" + name);
				
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			db.add(9);
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	
	//-------------------------------------------------
	//SWING JTABLE 용도
	//-------------------------------------------------
	
	public ArrayList<Vector> empListForSwing() {
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Ch99DBManager db = new Ch99DBManager();
		ArrayList<Vector> list = new ArrayList<Vector>();
		try {
			conn = db.dbConn();
			String sql = "select empno, ename, job, deptno from emp";
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				Vector<Object> vo = new Vector<Object>(); 
				vo.addElement(rs.getInt("empno"));
				vo.addElement(rs.getString("ename"));
				vo.addElement(rs.getString("job"));
				vo.addElement(rs.getInt("deptno"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}
	
	
	public ArrayList<EmpVO> empList() {
		
		Connection conn = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		ArrayList<EmpVO> list = new ArrayList<EmpVO>(); 
		Ch99DBManager db = new Ch99DBManager();
		
		try {
			conn = db.dbConn();
			String sql = "select empno, ename, to_char(hiredate,'YYYY-MM-DD') hiredate from emp";
			System.out.println(sql);
			pstmt = conn.prepareStatement(sql);
			rs = pstmt.executeQuery();
			while(rs.next()) {
				EmpVO evo = new EmpVO();
				evo.setEmpno(rs.getInt("empno"));
				evo.setEname(rs.getString("ename"));
				evo.setHiredate(rs.getString("hiredate"));
				list.add(evo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
//			db.add(9);
			db.dbClose(rs, pstmt, conn);
		}
		return list;
	}

	
	public int empInsert(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		Ch99DBManager db = new Ch99DBManager();
		try { 
			conn = db.dbConn();
			String sql = "insert into emp(empno, ename, job, deptno) values(?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, vo.getEmpno());
			pstmt.setString(2, vo.getEname());
			pstmt.setString(3, vo.getJob());
			pstmt.setInt(4, vo.getDeptno());
			res = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public int empInsert(int prmEmpno, String prmEname) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		Ch99DBManager db = new Ch99DBManager();
		try { 
			conn = db.dbConn();
			String sql = "insert into emp(empno, ename) values(?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prmEmpno);
			pstmt.setString(2, prmEname);
			res = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	public int empUpdate(EmpVO vo) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		Ch99DBManager db = new Ch99DBManager();
		try { 
			conn = db.dbConn();
			String sql = "update emp set ename=?, job=?, deptno=? where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, vo.getEname());
			pstmt.setString(2, vo.getJob());
			pstmt.setInt(3, vo.getDeptno());
			pstmt.setInt(4, vo.getEmpno());
			res = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}
	
	@Override
	public int empUpdate(int prmSal, int prmEmpno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		Ch99DBManager db = new Ch99DBManager();
		try { 
			conn = db.dbConn();
			String sql = "update emp set sal=? where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prmSal);
			pstmt.setInt(2, prmEmpno);
			res = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

	@Override
	public int empDelete(int prmEmpno) {
		Connection conn = null;
		PreparedStatement pstmt = null;
		int res = 0;
		Ch99DBManager db = new Ch99DBManager();
		try { 
			conn = db.dbConn();
			String sql = "delete from emp where empno=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setInt(1, prmEmpno);
			res = pstmt.executeUpdate();
		}catch(SQLException e) {
			e.printStackTrace();
		}
		return res;
	}

}
