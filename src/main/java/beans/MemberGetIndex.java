package beans;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import dao.exceptions.DatabaseConnectException;
import dao.interfaces.DataGettable;

/*
 * Member의 Index만 가져오는 bean입니다. 실제로는 테이블의 일부, 혹은 복합적인 쿼리문을 받아올 수 있습니다.
 */
public class MemberGetIndex {
	public static final String QUERY_GET = "SELECT DEPTNO FROM DEPT";
 	
	private int index;
	
	public int getIndex() {
		return index;
	}

	public void setIndex(int index) {
		this.index = index;
	}
	
	/*
	 * 상수인 QUERY_GET에서 정의한 SELECT문을 실행한 뒤 결과로 반환한 ResultSet을 List로 담는 방법을 기술해 둔 콜백 메서드입니다. 
	 */
	
}

