
//import javax.faces.bean.SessionScoped;
 import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;
import javax.faces.bean.ManagedBean;

import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


@ManagedBean(name="user")
//@SessionScoped
@RequestScoped
public class user{
 public String tc;
public String password;
public String output_msg;
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    public String getName() {
        return tc;
    }

    public void setName(String tc) {
        this.tc = tc;
    }
    DataSource dataSource;
    


public String login() throws SQLException{
    try
{
Context ctx = new InitialContext();
// You must write the database you will use. Here we use "sample" built-in database.
dataSource = (DataSource) ctx.lookup("jdbc/addressbook");
    }
catch (NamingException e) 
{
e.printStackTrace();
}
    if ( dataSource == null )
 throw new SQLException( "Unable to obtain DataSource" );

 // obtain a connection from the connection pool
 Connection connection = dataSource.getConnection();

 // check whether connection was successful
 if ( connection == null )
 throw new SQLException( "Unable to connect to DataSource" );

 try
 {
     // sql cümlesi yazmak için PreparedStatement oluşturmalıyız.    
 // create a PreparedStatement to select the records
 PreparedStatement object1 = connection.prepareStatement(
 "SELECT * from musteri" + "where sifre==" + password);
 CachedRowSet rs1 = new com.sun.rowset.CachedRowSetImpl();
        int tc1 = rs1.getInt(1);
        
 String password1 = rs1.getString(4);
        if(!tc.equals(tc1) ){
    output_msg="Kullanıcı Adı Yanlış";
    return null;
    }
    else{
    return "home.xhtml";
    }
 
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
    
    
}


}