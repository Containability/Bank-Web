
import javax.faces.bean.SessionScoped;

 import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.annotation.Resource;


import javax.sql.rowset.CachedRowSet;
import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;


@ManagedBean(name="loginBean")
@SessionScoped
@RequestScoped
public class serverlogin{
 int limit1;

    public int getLimit1() {
        return limit1;
    }

    public void setLimit1(int limit1) {
        this.limit1 = limit1;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public int getKart_no() {
        return kart_no;
    }

    public void setKart_no(int kart_no) {
        this.kart_no = kart_no;
    }

    public int getBakiye() {
        return bakiye;
    }

    public void setBakiye(int bakiye) {
        this.bakiye = bakiye;
    }

    public boolean isKredi() {
        return kredi;
    }

    public void setKredi(boolean kredi) {
        this.kredi = kredi;
    }
 String date;
    int kart_no;
    int bakiye;
    boolean kredi;
    int send;

    public int getSend() {
        return send;
    }

    public void setSend(int send) {
        this.send = send;
    }
    String tc;

    public String getTc() {
        return tc;
    }

    public void setTc(String tc) {
        this.tc = tc;
    }
 String password;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
     DataSource dataSource;
public serverlogin()
{
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
}

public String login() throws SQLException{
 
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
                "SELECT isim from musteri where sifre='"+password+"'"+" AND tc="+tc+" ");
 
 CachedRowSet rs1 = new com.sun.rowset.CachedRowSetImpl();
 
 rs1.populate(object1.executeQuery());
 

 return  "home.xhtml";

 
        
 

 
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally
    

}
public void getMusteri()
            throws SQLException {
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
                "SELECT * from musteri where sifre='"+password+"'"+" AND tc="+tc+" ");
 
 CachedRowSet rs1 = new com.sun.rowset.CachedRowSetImpl();
 
 rs1.populate(object1.executeQuery());
 String name1=rs1.getString("ISIM");
 String surname1=rs1.getString("SOYISIM");
 
 


 
        
 

 
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally

}

public void getKart()
            throws SQLException {
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
                "SELECT * from kartlar where tc="+tc+" ");
 
 CachedRowSet rs1 = new com.sun.rowset.CachedRowSetImpl();
 
 rs1.populate(object1.executeQuery());

kart_no=rs1.getInt("KART_NO");
 bakiye=rs1.getInt("BAKIYE");
  kredi=rs1.getBoolean("KREDI_KART");
  limit1=rs1.getInt("LIMIT");
 date=rs1.getString("EXPIRE_DATE");

 
        
 

 
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally

}






public void paraAktar() throws SQLException {
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
 PreparedStatement object2 = connection.prepareStatement(
                "UPDATE kartlar set bakiye="+send+"where tc="+tc+" ");
 
 CachedRowSet rs1 = new com.sun.rowset.CachedRowSetImpl();
 
        int updated = object2.executeUpdate();

 
        
 

 
 } // end try
 finally
 {
 connection.close(); // return this connection to pool
 } // end finally

    
    
    
}
}

