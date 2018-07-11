package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class CustomerDAO {

	public ArrayList<CustomerVO> selectAll() {

		ArrayList<CustomerVO> list = new ArrayList<CustomerVO>();

		String sql = "SELECT * FROM customer";

		try {
			Connection conn = ConnectionProvider.getConnection();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(sql);

			while (rs.next()) {

				CustomerVO cv = new CustomerVO();
				cv.setId(rs.getInt(1) + "");
				cv.setName(rs.getString(2));
				cv.setAddr(rs.getString(3));
				cv.setPhone(rs.getString(4));

				list.add(cv);
			}

			ConnectionProvider.close(rs, stmt, conn);

		} catch (Exception e) {
			System.out.println(e.getMessage());
		}

		return list;

	}

}
