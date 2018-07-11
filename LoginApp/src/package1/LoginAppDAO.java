package package1;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;


public class LoginAppDAO 
{
	private static LoginAppDAO obj;
	private LoginAppDAO() {}
	 
    public static LoginAppDAO getInstance()
    {
        if (obj==null)
            obj = new LoginAppDAO();
        return obj;
    }
 private Connection con;
	public boolean CreateConnection()
	{
		try{ 
			Class.forName("com.mysql.jdbc.Driver");  
			// con=DriverManager.getConnection( "jdbc:mysql://localhost:3306/test","root","root1234"); 
			 con=DriverManager.getConnection( "jdbc:mysql://aa1b9lbrrjddtlp.csrs2ndmz3ve.us-east-2.rds.amazonaws.com:3306/ebdb?user=root&password=root12345");
		}catch(Exception e){
			System.out.println(e);
		    return false;	
		}   
	  return true;
	}
	
	 boolean insertdata(Employee tmpemp)
	{
		String query= new String("INSERT INTO emp VALUES (?,?,?,?,?,?,?)");
		try 
		{
		PreparedStatement sql=con.prepareStatement(query);
			sql.setInt(1, tmpemp.id);
			sql.setString(2, tmpemp.name);
			sql.setString(3, tmpemp.password);
			sql.setString(4, tmpemp.firstname);
			sql.setString(5, tmpemp.lastname);
			sql.setString(6, tmpemp.email);
			sql.setString(7,tmpemp.address);
			sql.execute();
	    }catch(Exception e){ System.out.println(e);return false;}
	return true;
	}
	
	 
	 boolean validate(String name,String password)
	 {
		 String query= new String("SELECT * FROM emp WHERE USERNAME=? AND PASS=?");
		 ResultSet rs;	
		 try 
			{
			PreparedStatement sql=con.prepareStatement(query);
				sql.setString(1,name);
				sql.setString(2,password);
				rs=sql.executeQuery();
				while(rs.next())
					return true;
		    }catch(Exception e){ System.out.println(e);}
			return false;
	 }
	
	  Employee retrivedata(int n)
	 {
	 		Employee tmpemp=new Employee();
	 		try 
	 		{
	 		String query= new String("Select * from emp where id=?");
	 		PreparedStatement sql=con.prepareStatement(query);
	 		sql.setInt(1,n);
	 		ResultSet rs=sql.executeQuery();
	 		while(rs.next()) 
	 		{
	 		 tmpemp.id=rs.getInt(1);
	 	     tmpemp.name=rs.getString(2);
	 	     tmpemp.password=rs.getString(3);
	 	     tmpemp.firstname=rs.getString(4);
	 	     tmpemp.lastname=rs.getString(5);
	 	     tmpemp.email=rs.getString(6);
	 	     tmpemp.address=rs.getString(7);
	 		}
	 		}
	 		catch(Exception e){ System.out.println(e);}
	  return tmpemp;
	 }
}
