package crawler;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.table.DefaultTableModel;

public class DBUpdater {

    String conString = "jdbc:mysql://localhost:3306/ankit";
    String username = "root";
    String password = "";

    //INSERT INTO DB
    public Boolean add(String title, String link,String keyw,String freq) {
        //SQL STATEMENT
        String sql = "INSERT INTO links(TITLE,LINK,KEYWORD,FREQUENCY) VALUES('" + title + "','" + link + "','" + keyw + "','" + freq + "')";

        try {
            //GET COONECTION

            Connection con = DriverManager.getConnection(conString, username, password);

            // PREPARED STMT
            Statement s = con.prepareStatement(sql);

            s.execute(sql);

            return true;

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return false;
    }

    //RETRIEVE DATA
    public DefaultTableModel getData() {
        //ADD COLUMNS TO TABLE MODEL
        DefaultTableModel dm = new DefaultTableModel();
        dm.addColumn("ID");
        dm.addColumn("TITLE");
        dm.addColumn("LINK");
        dm.addColumn("KEYWORD");
        dm.addColumn("FREQUENCY");


        //SQL STATEMENT
        String sql = "SELECT * FROM links order by frequency DESC";

        try {
            Connection con = DriverManager.getConnection(conString, username, password);

            //PREPARED STMT
            Statement s = con.prepareStatement(sql);
            ResultSet rs = s.executeQuery(sql);

            //LOOP THRU GETTING ALL VALUES
            while (rs.next()) {
                //GET VALUES
                String id = rs.getString(1);
                String name = rs.getString(2);
                String pos = rs.getString(3);
                String keyw = rs.getString(4);
                String freq=rs.getString(5);


                dm.addRow(new String[]{id, name, pos,keyw,freq});
            }

            return dm;

        } catch (Exception ex) {
            ex.printStackTrace();
        }

        return null;

    }



    //DELETE DATA
    public Boolean delete(String id)
    {
        //SQL STMT
        String sql="DELETE FROM links WHERE ID ='"+id+"'";

        try
        {
            //GET COONECTION
            Connection con=DriverManager.getConnection(conString, username, password);

            //STATEMENT
            Statement s=con.prepareStatement(sql);

            //EXECUTE
            s.execute(sql);

            return true;

        }catch(Exception ex)
        {
            ex.printStackTrace();
            return false;
        }
    }

}
