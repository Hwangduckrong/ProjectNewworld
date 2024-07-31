package com.javaex.project;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AdminDao {

	private Connection conn = null;
	private PreparedStatement pstmt = null;
	private ResultSet rs = null;

	private String driver = "com.mysql.cj.jdbc.Driver";
	private String url = "jdbc:mysql://localhost:3306/work_db";
	private String id = "admin";
	private String pw = "admin";

	public AdminDao() {

	}

	private void getConnection() {
		try {
			// 1. JDBC 드라이버 (Oracle) 로딩
			Class.forName(driver);

			// 2. Connection 얻어오기
			conn = DriverManager.getConnection(url, id, pw);

		} catch (ClassNotFoundException e) {
			System.out.println("error: 드라이버 로딩 실패 - " + e);

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	private void close() {
		// 5. 자원정리
		try {
			if (rs != null) {
				rs.close();
			}
			if (pstmt != null) {
				pstmt.close();
			}
			if (conn != null) {
				conn.close();
			}
		} catch (SQLException e) {
			System.out.println("error:" + e);
		}
	}

	// 전체리스트 출력
	public List<UserVo> selectEmployeesAll() {
		List<UserVo> UserList = new ArrayList<UserVo>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " select 	employee_id, ";
			query += "		    emp_name, ";
			query += "          login_ID, ";
			query += "          login_PW, ";
			query += "          email, ";
			query += "          department_id, ";
			query += "          phone_number, ";
			query += "          address, ";
			query += "          hire_date ";
			query += " from employees ";

			// *바인딩
			pstmt = conn.prepareStatement(query);

			// *실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			// 리스트로 만들기
			while (rs.next()) {
				int eId = rs.getInt("employee_id");
				String name = rs.getString("emp_name");
				String ID = rs.getString("login_ID");
				String PW = rs.getString("login_PW");
				String EM = rs.getString("email");
				int deID = rs.getInt("department_id");
				String num = rs.getString("phone_number");
				String add = rs.getString("address");
				String HD = rs.getString("hire_date");

				UserVo userVo = new UserVo(eId, name, ID, PW, EM, deID, num, add, HD);
				UserList.add(userVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return UserList;
	}

	//부서 수정

	public int updateDepartment( String oldDepartname, int oldmanagerId,String departmentName,int managerId ) {
		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " update department ";
			query += " set    department_name = ?, ";
			query += "        manager_id = ? ";
			query += " where  department_name = ? ";
			query += " and manager_id = ? ";

			// *바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1,departmentName);
			pstmt.setInt(2, managerId);
			pstmt.setString(3,oldDepartname);
			pstmt.setInt(4, oldmanagerId);

			// *실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 수정되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;

	}

	//부서 추가

	public int insertDepartment(String departmentname, int managerId) {
		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " insert into department ";
			query += " values(null, ?, ?) ";

			// *바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setString(1, departmentname);
			pstmt.setInt(2, managerId);

			// *실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 등록되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;
	}
	//부서 삭제

	public int deleteDepartment(int departmentId) {
		int count = -1;

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " delete from department ";
			query += " where department_id = ? ";

			// *바인딩 
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, departmentId);

			// *실행
			count = pstmt.executeUpdate();

			// 4.결과처리
			System.out.println(count + "건 삭제되었습니다.");

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return count;

	}
	public List<UserVo> selectdepartmentall(int departmentId) {
		List<UserVo> UserList = new ArrayList<UserVo>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비

			String query = "";
			query += " select 	e.employee_id, ";
			query += "		    e.emp_name, ";
			query += "          e.login_ID, ";
			query += "          e.login_PW, ";
			query += "          e.email, ";
			query += "          d.department_id, ";
			query += "          e.phone_number, ";
			query += "          e.address, ";
			query += "          e.hire_date ";
			query += " from employees e inner join department d";
			query += " where d.department_id = ? ";
			// *바인딩
			pstmt = conn.prepareStatement(query);
			pstmt.setInt(1, departmentId);
			// *실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			// 리스트로 만들기
			while (rs.next()) {
				int eId = rs.getInt("employee_id");
				String name = rs.getString("emp_name");
				String ID = rs.getString("login_ID");
				String PW = rs.getString("login_PW");
				String EM = rs.getString("email");
				int deID = rs.getInt("department_id");
				String num = rs.getString("phone_number");
				String add = rs.getString("address");
				String HD = rs.getString("hire_date");

				UserVo userVo = new UserVo(eId, name, ID, PW, EM, deID, num, add, HD);
				UserList.add(userVo);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return UserList;
	}
	public List<UserVo> selectUser(String userName) {
		List<UserVo> userVo = new ArrayList<>();

		this.getConnection();

		try {

			// 3. SQL문 준비 / 바인딩 / 실행
			// *sql문 준비
			String query = "";
			query += " select 	employee_id, ";
			query += "		    emp_name, ";
			query += "          login_ID,";
			query += "          login_PW, ";
			query += "          email,  ";
			query += "          department_id, ";
			query += "          phone_number, " ;
			query += "          address, ";
			query += "          hire_date ";
			query += " from employees ";
			query += " where emp_name like ? ";

			// *바인딩
			pstmt = conn.prepareStatement(query);
			String select = "%"+userName+"%";
			pstmt.setString(1, select);

			// *실행
			rs = pstmt.executeQuery();

			// 4.결과처리
			// 리스트로 만들기
			while (rs.next()) {
				int employeeId = rs.getInt("employee_id");
				String empName = rs.getString("emp_name");
				String loginID= rs.getString("login_ID");
				String loginPW = rs.getString("login_PW");
				String eMail = rs.getString("email");
				int departmentId = rs.getInt("department_id");
				String phoneNumber = rs.getString("phone_number");
				String addRess = rs.getString("address");
				String hireDate = rs.getString("hire_date");
				

				UserVo addPerson = new UserVo(employeeId,empName,loginID,loginPW,eMail,departmentId,phoneNumber,addRess,hireDate);
				userVo.add(addPerson);
			}

		} catch (SQLException e) {
			System.out.println("error:" + e);
		}

		this.close();

		return userVo;
}
}
