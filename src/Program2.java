import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Program2 {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://127.0.0.1:3306/ex1?characterEncodiing=UTF-8";
//		String userId = "root";
//		String passwd = "dd39668710";
		//String sql ="INSERT INTO notices (TITLE, WRITER_ID,CONTENT,REGDATE) VALUES (?,?,?,now())"; 
		//String sql = "DELETE FROM notices where id = ?";
		//String sql = "UPDATE notices set title=?,hit=?,files=? where id =?;";
		
		Connection con = null;
		Statement st= null;
		try {
			String Title = "title1";
//			String Writer_id = "test1";
//			String content = "����";
			int id = 3;
			int HIT = 999;
			String files = "���ϳ���";
			
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(url,"song","a@123456789");
			//preparedstatement �� �̿��ؼ� ������������ �ƴ��� Ȯ���ؼ� �ð��� ���̱� ���� ����
			PreparedStatement stmt = con.prepareStatement(sql);
			
//			stmt.setString(1, Title);
//			stmt.setString(2,Writer_id);
//			stmt.setString(3, content);
//			
			stmt.setString(1,Title);
			stmt.setInt(2, HIT);
			stmt.setString(3, files);
			stmt.setInt(4, id);
			
			
			int result = stmt.executeUpdate();
			
			System.out.println("result:"+result);
			
			stmt.close();
			con.close();
		}
		catch(SQLException se) {
			se.printStackTrace();
		}
		
	}

}
