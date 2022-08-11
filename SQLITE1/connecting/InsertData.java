    import java.sql.Connection;  
    import java.sql.DriverManager;  
    import java.sql.Statement;  
    import java.sql.SQLException;  
       
    public class InsertData {  
       
        private Connection connect() {  
            // SQLite connection string  
            String url = "jdbc:sqlite:Movies.db";  
            Connection conn = null;  
            try {  
                conn = DriverManager.getConnection(url);  
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
            return conn;  
        }  
       
      
        public void insert(String Name,String Actor,String Actress,String Director,int ReleasedYear) {  
            String sql = "INSERT INTO MovieDetails(Name, Actor, Actress, Director, ReleasedYear ) VALUES(?,?,?,?,?)";  
       
            try{  
                Connection conn = this.connect();  
                Statement stmt = conn.createStatement();  
                stmt.execute(sql);   
            } catch (SQLException e) {  
                System.out.println(e.getMessage());  
            }  
        }  
       
        public static void main(String[] args) {  
       
            InsertData dt = new InsertData();
           dt.insert("RRR", "NTR", "Alia", "Rajamouli",2022);
	     dt.insert("Pokiri", "Maheshbabu", "Ileana","Puri",2006);
	     dt.insert("Vikram", "Kamal Hasan", "Gayathri","Lokesh",2022);
	     dt.insert("Bhool Bullaya2", "Karthik", "Kiara","Anees",2022);  
        }  
       
    }  