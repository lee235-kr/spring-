package repository;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;

import Model.EmployeeDTO;

public class EmployeeRepository {
	@Autowired
	SqlSession sqlSession;
	
	String namespace = "mappers.employeeMapper";
	String statement;
	public void empInsert(EmployeeDTO dto) {
		statement = namespace + ".empInsert";
		int i=  sqlSession.insert(statement,dto);
		System.out.println(i+"개가 저장!!><사원!");
	}
	public String empNo() {
		statement = namespace + ".empNo";
		return sqlSession.selectOne(statement);
	}
}
