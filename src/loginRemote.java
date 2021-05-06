 import java.rmi.*;
import java.util.ArrayList;
 
public interface loginRemote extends Remote{
    
    public boolean login(String user, String password) throws RemoteException;
    
    public void insert (String full_name, int state, int age, String gender, int phone,String station,
            String wereda,String address)throws RemoteException;
   
    public void Edit(int vot_no
            ,String full_name, int state, int age, String gender, int phone,String station,
            String wereda,String address) throws RemoteException;
    
    public ArrayList<Voter> view()throws RemoteException;
    
    
    public void delete(int vot_no)throws RemoteException;
    
}
