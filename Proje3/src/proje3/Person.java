
package proje3;
/**
 *
 * @author arda
 */
public class Person {
    private String name;
    private int telNum;
    private int id;
  
    
 public Person(String name, int telNum, int id) throws Exception {
        this.name = name;
        this.telNum = telNum;
        this.id = id;
       
    
    }
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTelNum() {
        return telNum;
    }

    public void setTelNum(int telNum) {
        this.telNum = telNum;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    
}
class Admin extends Person{
    private String userName; 
    
    public Admin(String name, int telNum, int id) throws Exception {
        super(name, telNum, id);
      
    }
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }
}

class RegisteredUser extends Person {

    public RegisteredUser(String name, int telNum, int id) throws Exception {
        super(name, telNum,id);
        
            }
}

