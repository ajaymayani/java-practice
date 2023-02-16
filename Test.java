package file_operation_with_database;

import java.io.FileOutputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/java_practice", "root", "");
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select s.sId,s.FirstName,s.LastName,s.mobile,m.sub1,m.sub2,m.sub3,m.sub4,m.sub5,m.total,r.percentage,r.grade from student s, marks m , result r where s.sId = m.sId and s.sId = r.sId");

            FileOutputStream student = new FileOutputStream("student.csv");
            FileOutputStream marks = new FileOutputStream("marks.csv");
            FileOutputStream result = new FileOutputStream("result.csv");

            String s = "";
            String m = "";
            String r = "";

            while (rs.next()) {
                s += rs.getInt("sId") + "," + rs.getString("FirstName") + "," + rs.getString("LastName") + "," + rs.getString("mobile") + "\n";
                m += rs.getInt("sId") + "," + rs.getInt("sub1") + "," + rs.getInt("sub2") + "," + rs.getInt("sub3") + "," + rs.getInt("sub4") + "," + rs.getInt("sub5") + "," + rs.getInt("total") + "\n";
                r += rs.getInt("sId") + "," + rs.getFloat("percentage") + "," + rs.getString("grade") + "\n";
            }

            student.write(s.getBytes());
            marks.write(m.getBytes());
            result.write(r.getBytes());

            student.close();
            marks.close();
            result.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}