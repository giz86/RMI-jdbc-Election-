
import java.rmi.*;
import java.rmi.server.*;
import java.util.*;
import java.sql.*;

import javax.swing.JOptionPane;


public class loginImp extends UnicastRemoteObject implements loginRemote{
   
            String JDBC_DRIVER = "com.mysql.jdbc.Driver";
            String DB_URL = "jdbc:mysql://localhost:3306/ele2013";
            String USER ="root";
            String PASS ="";
            public Connection conn= null;
            Statement stmt = null;
            private ArrayList vote;
            
    public loginImp()throws RemoteException{
        super();
        try {
            conn = DriverManager.getConnection(DB_URL, USER, PASS);
            stmt = conn.createStatement();
        } catch (Exception e) {
        }
    }

    @Override
    public boolean login(String user, String password) throws RemoteException {
   try {
       
            PreparedStatement st=conn.prepareStatement("SELECT * FROM election_officals where user=?  and password=? ");
            st.setString(1, user);
            st.setString(2, password);
            ResultSet rs=st.executeQuery();
            
            if(rs.next()){
                register reg= new  register();
                reg.setVisible(true);
            }
            else{
                JOptionPane.showMessageDialog(null, "login fail");
                loginClient cl=new loginClient();
                cl.setVisible(true);
            }
            
        } catch (Exception ex) {
            ex.printStackTrace();
            
        }
        return false;
    }



    @Override
    public void insert(String full_name, int state, int age, String gender, int phone, String station, String wereda, String address) throws RemoteException {
         try {
            PreparedStatement Stm=conn.prepareStatement("INSERT INTO voter"
                    + "(`full_name`, `state`, `age`, `gender`, `phone`, `station`, `wereda`, `address`)"
                    + " VALUES (?,?,?,?,?,?,?,?)");
       
            Stm.setString(1, full_name);
            Stm.setInt(2,state);
            Stm.setInt(3, age);
            Stm.setString(4, gender);
            Stm.setInt(5, phone);
            Stm.setString(6, station);
            Stm.setString(7, wereda);
            Stm.setString(8, address);
            int i=Stm.executeUpdate();
        
        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e);
        }

    }

    @Override
    public ArrayList   view() throws RemoteException {
          ArrayList<Voter> al=new ArrayList();
       try{
           ResultSet rs=stmt.executeQuery("SELECT * FROM voter order by date asc");
            
          while (rs.next()){
            
                    int id = rs.getInt("vot_no");
                    String full_name =rs.getString("full_name");
                    int state= rs.getInt("state");
                   int age= rs.getInt("age");
                   int phone=rs.getInt("phone");
                   String address=rs.getString("address");
                   String station=rs.getString("station");
                   String wereda=rs.getString("wereda");
                   String gender=rs.getString("gender");  
                    Voter  voters = new Voter();
                    voters.setVot_no(id);
                    voters.setFull_name(full_name);
                    voters.setState(state);
                    voters.setAge(age);
                    voters.setGender(gender);
                    voters.setPhone(phone);
                    voters.setWereda(wereda);
                    voters.setAddress(address);
                    voters.setStation(station);
                    al.add(voters);
                     }
     
      }catch(SQLException e){
          e.printStackTrace();

      } 
       return al;
        
    }

    @Override
    public void Edit(int vot_no,String full_name, int state, int age, 
            String gender, int phone, String station, String wereda, String address) throws RemoteException {
        try {
            PreparedStatement Stm=conn.prepareStatement("UPDATE voter SET full_name=?, state=?, age=?, gender=?,"
                    + " phone=?, station=?, wereda=?, address=? WHERE vot_no=?");
                Stm.setString(1, full_name);
                Stm.setInt(2,state);
                Stm.setInt(3, age);
                Stm.setString(4, gender);
                Stm.setInt(5, phone);
                Stm.setString(6, station);
                Stm.setString(7, wereda);
                Stm.setString(8, address);
                Stm.setInt(9, vot_no);
                int i=Stm.executeUpdate();
         System.out.print("Row Updated Successfully!\n");
      } catch (Exception e) {
            e.printStackTrace();}}
 @Override
    public void delete(int vot_no) throws RemoteException {
        String Query = "DELETE FROM voter WHERE vot_no = '"+vot_no+"'";
        try {
                Statement Down = conn.createStatement();
                Down.execute(Query);
                System.out.print("Row Deleted Successfully!\n");

        } catch (Exception e) {
            e.printStackTrace();
        }}}
    