package com.fullall.lmq.connsql;

/**
 * Created by lmq on 2017/11/14.
 */


        import android.util.Log;

        import java.sql.Connection;
        import java.sql.DriverManager;
        import java.sql.PreparedStatement;
        import java.sql.ResultSet;
        import java.sql.SQLException;
        import java.sql.Statement;
        import java.util.ArrayList;


public class DBUtil
{

    private static Connection getSQLConnection(String ip, String user, String pwd,String sl, String db)
    {
        Connection con = null;
        try
        {
            Class.forName("net.sourceforge.jtds.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:jtds:sqlserver://" + ip + ":1433/" + db + ";instance=" + sl + ";charset=utf8", user, pwd);
        } catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch (SQLException e)
        {
            e.printStackTrace();
        }
        return con;
    }

    public static String QuerySQL()
    {
        String result = "";
        try
        {
            Connection conn = getSQLConnection("192.168.34.3", "sa", "yderp2865100","YD", "yddbbak");
            String sql = "select top 10 * from a";
            Statement stmt = conn.createStatement();//
            ResultSet rs = stmt.executeQuery(sql);
            while (rs.next())
            {
                String s1 = rs.getString("b");
                String s2 = rs.getString("c");
                result += s1 + " - " + s2 + "\n";
                System.out.println(s1 + " - " + s2);
            }
            rs.close();
            stmt.close();
            conn.close();
        } catch (SQLException e)
        {
            e.printStackTrace();
            result += "查询数据异常!" + e.getMessage();
        }
        return result;
    }

    public static void main(String[] args)
    {
//        QuerySQL();
    } }