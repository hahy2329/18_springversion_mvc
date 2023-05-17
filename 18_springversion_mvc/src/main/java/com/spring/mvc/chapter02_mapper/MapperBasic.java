package com.spring.mvc.chapter02_mapper;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MapperBasic {


	@Autowired
	private SqlSession sqlSession; // db연결 변수


	/*
	 * 
	 *   Mapper To DAO
	 * 
	 *  - select 쿼리 조회 결과 데이터가 반드시 1row인 경우 .selectOne("namespace.id") 메서드를 사용한다. (primary key 조건 , sum() , avg() , count())
	 *  - select 쿼리 조회 결과 데이터가 1row 이상일 경우   .selectList("namespace.id") 메서드를 사용하며 반환데이터는 List<반환타입>으로 데이터를 매핑한다.
	 *      
	 *  - insert 쿼리를 사용할 경우 .insert("namespace.id") 메서드를 사용한다.
	 *  - update 쿼리를 사용할 경우 .update("namespace.id") 메서드를 사용한다.
	 *  - delete 쿼리를 사용할 경우 .delete("namespace.id") 메서드를 사용한다.
	 *  
	 *  - select 쿼리는 resultType , resultMap 속성(필수)과 반드시 같이 사용하며
	 *    select , insert , update , delete 쿼리에서 파라메타 전달은 parameterType속성(옵션)과 같이 사용한다.
	 *    
	 *  - DAO로직에서 하나의 메서드는 하나의 쿼리문과 1 : 1 관계로 매핑하며 Service와 DAO 관계에서 1 : N관계로 매핑한다.
	 *  
	 * */
	
	//DAO역할
	// selectList("namepsace.id") 예시
	public void ex01() {
		sqlSession.selectList("basic.ex01");
	}
	
	// selectOne("namepsace.id") 예시
	public void ex02() {
		sqlSession.selectOne("basic.ex02");
	}
	// insert("namepsace.id") 예시
	public void ex03() {
		sqlSession.insert("basic.ex03", "파라메타");
	}
	// update("namepsace.id") 예시
	public void ex04() {
		sqlSession.update("basic.ex04", "파라메타");
	}
	// delete("namepsace.id") 예시
	public void ex05() {
		sqlSession.delete("basic.ex04", "파라메타");
	}
	
	
	
}
