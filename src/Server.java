
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;



public class Server {


    public static void main(String[] args) {
        try {
            
            Registry reg= LocateRegistry.createRegistry(1099);
            loginImp instance= new loginImp();
            reg.rebind("db", instance);
            System.out.println("Server Running!..");
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
}


