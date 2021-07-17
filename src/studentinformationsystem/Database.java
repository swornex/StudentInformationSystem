package studentinformationsystem;

import java.util.List;
import java.sql.*;
import java.util.LinkedList;

/**
 *
 * @author swors
 */
public class Database {

    public static Connection connect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection("jdbc:mysql://localhost:3306/studentInfo", "root", "");
        } catch (ClassNotFoundException | SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public static int insert(Student student) throws Exception {
        final String INSERT_QUERY = "insert into student (FirstName, LastName, Address, PhoneNumber, ParentsName, ParentsNumber, Department) "
                + "values (?,?,?,?,?,?,?)";
        PreparedStatement pst = connect().prepareStatement(INSERT_QUERY);
        pst.setString(1, student.getfName());
        pst.setString(2, student.getlName());
        pst.setString(3, student.getAddress());
        pst.setLong(4, student.getPhoneNumber());
        pst.setString(5, student.getParentsName());
        pst.setLong(6, student.getParentsNumber());
        pst.setString(7, student.getDepartment());
        int affectedRow = pst.executeUpdate();
        return affectedRow;
    }

    public static List<Student> display() throws Exception {
        final String DISPLAY_QUERY = "select * from student";
        Statement st = connect().createStatement();
        ResultSet rs = st.executeQuery(DISPLAY_QUERY);
        List<Student> students = new LinkedList<>();
        while (rs.next()) {
            Student student = new Student();
            student.setId(rs.getInt("Id"));
            student.setfName(rs.getString("FirstName"));
            student.setlName(rs.getString("LastName"));
            student.setAddress(rs.getString("Address"));
            student.setPhoneNumber(rs.getLong("PhoneNumber"));
            student.setParentsName(rs.getString("ParentsName"));
            student.setParentsNumber(rs.getLong("ParentsNumber"));
            student.setDepartment(rs.getString("Department"));
            students.add(student);
        }
        return students;
    }

    public static int update(Student student) throws Exception {
        final String UPDATE_QUERY = "update student set "
                + "FirstName=?, "
                + "LastName=?, "
                + "Address=?, "
                + "PhoneNumber=?, "
                + "ParentsName=?, "
                + "ParentsNumber=?, "
                + "Department=? "
                + "where Id=?";
        PreparedStatement pst = connect().prepareStatement(UPDATE_QUERY);
        pst.setString(1, student.getfName());
        pst.setString(2, student.getlName());
        pst.setString(3, student.getAddress());
        pst.setLong(4, student.getPhoneNumber());
        pst.setString(5, student.getParentsName());
        pst.setLong(6, student.getParentsNumber());
        pst.setString(7, student.getDepartment());
        pst.setInt(8, student.getId());
        System.out.println(student.getParentsName());
        System.out.println(student.getId());
        int affectedRow = pst.executeUpdate();
        if (affectedRow > 0) {
            System.out.println("sucess");
        } else {
            System.out.println("Fail");
        }
        return affectedRow;
    }

    public static int remove(int id) throws Exception {
        final String REMOVE_QUERY = "delete from student where id=?";
        PreparedStatement pst = connect().prepareStatement(REMOVE_QUERY);
        pst.setInt(1, id);
        int affectedRow = pst.executeUpdate();
        return affectedRow;
    }

    public static Student findOne(int id) throws Exception {
        final String FINDONE_QUERY = "select * from student where id = ?";
        PreparedStatement pst = connect().prepareStatement(FINDONE_QUERY);
        pst.setInt(1, id);
        ResultSet rs = pst.executeQuery();
        Student student = new Student();
        rs.next();
        student.setId(rs.getInt("Id"));
        student.setfName(rs.getString("FirstName"));
        student.setlName(rs.getString("LastName"));
        student.setAddress(rs.getString("Address"));
        student.setPhoneNumber(rs.getLong("PhoneNumber"));
        student.setParentsName(rs.getString("ParentsName"));
        student.setParentsNumber(rs.getLong("ParentsNumber"));
        student.setDepartment(rs.getString("Department"));
        return student;

    }
}
