/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Student;

/**
 *
 * @author THINKPAD
 */
public class AbsentDBContext extends DBContext<Student> {

    public ArrayList<Student> getStudentsByID(int id) {
        ArrayList<Student> students = new ArrayList<>();
        try {
            String sql = "SELECT s.stuname,s.stuid from Group_Student gs join Student s on gs.stuid = s.stuid\n"
                    + "WHERE gid = ?;";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, id);
            ResultSet rs = stm.executeQuery();
            while (rs.next()) {
                Student student = new Student();

                student.setId(rs.getInt("stuid"));
                student.setName(rs.getString("stuname"));
                students.add(student);
            }
        } catch (SQLException ex) {
            Logger.getLogger(AbsentDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return students;
    }

    @Override
    public Student getUsers(Student model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Student> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
