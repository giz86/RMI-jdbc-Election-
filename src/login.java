
import java.io.Serializable;

public class login implements Serializable{
    
    private String user_name,password,f_name,l_name,m_name,address;
    private int age,phone_number;
    
    
    public void setUser_name(String new_user_name){
       user_name=new_user_name;
   }
    public void setf_name(String new_f_name){
   
       f_name=new_f_name;
    }
     public void setl_name(String new_l_name){
   
       l_name=new_l_name;
    }
      public void setm_name(String new_m_name){
   
      m_name=new_m_name;
    }
    
       public void setaddress(String new_address){
   
       address=new_address;
    }
        public void setage(int new_age){
   
       age=new_age;
        }
         public void setlphone(int new_phone){
   
       phone_number=new_phone;
    }
   public void setPassword(String new_password){
        password=new_password;
   }
    public String getUser_name(){
    return this.user_name;
   }
   
   public String getPassword(){
        return this.password;
   }
    public String getf_name(){
        return this.f_name;
   }
     public String getl_name(){
        return this.l_name;
   }
       public String getm_name(){
        return this.m_name;
   }
         public String getaddress(){
        return this.address;
   }
   
    public int getage(){
        return this.age;
   }
    public int getphone(){
        return this.phone_number;
   }
   
   
}
