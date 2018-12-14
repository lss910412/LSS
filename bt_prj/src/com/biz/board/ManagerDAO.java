package com.biz.board;

import java.util.ArrayList;

import org.apache.ibatis.session.SqlSession;
import com.biz.common.MyBatisFactory;
import com.biz.mapper.MemberMapper;

public class ManagerDAO {

	/**
	 * 등록
	 * @param mvo
	 * @return
	 **/
	public int insert(ManagerVO mvo) {
		SqlSession conn =null;
		int res = 0;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			res = conn.insert("managerNameSpace.insert", mvo);
			conn.commit();
		} finally {
			conn.close();
		}
		return res;
	}
	
	
	
	public ManagerVO selectBoardInfo(String code) {
		ManagerVO vo  = new ManagerVO();
		SqlSession conn =null;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			vo = conn.selectOne("managerNameSpace.selectBoardInfo", code);
		} finally {
			conn.close();
		}
		return vo;
	}
	
	
	public ArrayList<ManagerVO> boardList(String code) {
		ArrayList<ManagerVO> list  = new ArrayList<ManagerVO>();
		SqlSession conn =null;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			list = (ArrayList)conn.selectList("managerNameSpace.boardList", code);
		} finally {
			conn.close();
		}
		return list;
	}
	
	
	/**
	 * 조회
	 * @param userId
	 * @return
	 */
	public ArrayList<ManagerVO> select() {
		ArrayList<ManagerVO> list  = new ArrayList<ManagerVO>();
		SqlSession conn =null;
		try { 
			conn = MyBatisFactory.getFactory().openSession();
			list = (ArrayList)conn.selectList("managerNameSpace.select");
		} finally {
			conn.close();
		}
		return list;
	}
}


