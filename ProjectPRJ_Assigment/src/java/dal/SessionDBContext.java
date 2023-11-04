/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package dal;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Group;
import model.Room;
import model.Session;
import model.Subject;
import model.TimeSlot;

/**
 *
 * @author THINKPAD
 */
public class SessionDBContext extends DBContext<Session> {

    public ArrayList<Session> getSessions(int iid,Date sqlMon, Date sqlSun) {
        ArrayList<Session> sessions = new ArrayList<>();
        try {            
            String sql = "SELECT  \n"
                    + "                    	ses.sesid,ses.[date],ses.[index],r.roomid,sub.subid,sub.subname,g.gid,g.gname,t.tid,t.[description]\n"
                    + "                    FROM [Session] ses INNER JOIN [Group] g ON ses.gid = g.gid\n"
                    + "                    						INNER JOIN [Subject] sub ON g.subid = sub.subid\n"
                    + "                   						INNER JOIN Room r ON r.roomid = ses.rid\n"
                    + "                    						INNER JOIN TimeSlot t ON ses.tid = t.tid"
                    + "WHERE ses.iid = ? AND ses.[date] >= ? AND ses.[date] <= ?";
            PreparedStatement stm = connection.prepareStatement(sql);
            stm.setInt(1, iid);
            stm.setDate(2, sqlMon);
            stm.setDate(3, sqlSun);
            ResultSet rs = stm.executeQuery();
            while(rs.next()){
                Session session = new Session();
                session.setId(rs.getInt("sesid"));
                session.setDate(rs.getDate("date"));
                session.setIndex(rs.getInt("index"));
                
                Room r = new Room();
                r.setId(rs.getString("roomid"));
                session.setRoom(r);
                
                Group g = new Group();
                g.setId(rs.getInt("gid"));
                g.setName(rs.getString("gname"));
                session.setGroup(g);
                
                Subject sub = new Subject();
                sub.setId(rs.getInt("subid"));
                sub.setName(rs.getString("subname"));
                g.setSubject(sub);
                
                TimeSlot time = new TimeSlot();
                time.setId(rs.getInt("tid"));
                time.setDescription(rs.getString("description"));
                session.setSlot(time);
                
                sessions.add(session);
            }
        } catch (SQLException ex) {
            Logger.getLogger(SessionDBContext.class.getName()).log(Level.SEVERE, null, ex);
        }
        return sessions;
    }

    @Override
    public Session getUsers(Session model) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public ArrayList<Session> list() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    
}
