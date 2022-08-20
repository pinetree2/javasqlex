import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;

public class Program {

	public static void main(String[] args) throws ClassNotFoundException {
		// TODO Auto-generated method stub

		String url = "jdbc:mysql://127.0.0.1:3306/ex1?characterEncodiing=UTF-8";
//		String userId = "root";
//		String passwd = "dd39668710";
		String sql ="SELECT * FROM notices";
		
		Connection con = null;
		Statement st= null;
		ResultSet rs = null;
		String title,Writer_id,Content,files;
		Date Regdate;
		int hit;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver"); //드라이버가 알아서 재정의를 해줌
			con = DriverManager.getConnection(url,"song","a@123456789");
			st = con.createStatement();
			rs = st.executeQuery(sql); //객체임 인터페이스는 객체를 만들 수 없음  
			
			while(rs.next()) {
				title = rs.getString("title");
				Writer_id = rs.getString("writer_id");
				Content = rs.getString("content");
				Regdate = rs.getDate("regdate");
				hit = rs.getInt("hit");
				files = rs.getString("files");

				System.out.println("title: "+title+" writer_id: "+Writer_id+" content: "+Content
						+" regdate: "+Regdate+" hit: "+hit+" files:"+files);
			};
			

		}
		catch(SQLException se) {
			se.printStackTrace();
		}finally {
			try{
				rs.close(){
				
			}catch(SQLException a) {
				a.printStackTrace();};
			}
			try{
				st.close()
				}catch(SQLException a) {
					b.printStackTrace();};
				};
			try {
				
				con.close();
			}catch(SQLException c) {
				c.printStackTrace();};
				};
			
	}

}
