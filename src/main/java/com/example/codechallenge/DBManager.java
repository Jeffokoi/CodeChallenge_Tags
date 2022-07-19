package com.example.codechallenge;

import java.io.UnsupportedEncodingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class DBManager {
    public static int insertTableDataReturnID(String Tablename, HashMap<String, Object> Data, String Condition) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        int result = 0;
        String dataString = "";
        String Columns = "";
        ArrayList<String> Cols = new ArrayList<>();
        Set<String> keys = Data.keySet();
        Iterator<String> iterator = keys.iterator();
        while (iterator.hasNext()) {
            String col = iterator.next();
            Cols.add(col);
            Columns = Columns + "`" + col + "`,";
            dataString = dataString + "?,";
        }
        dataString = dataString.replaceAll(",$", "");
        Columns = Columns.replaceAll(",$", "");
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String sql = "INSERT INTO " + Tablename + " (" + Columns + ") VALUES (" + dataString + ") " + Condition;
        try {
            con = (new JDBCConnector()).getConnection();
            stmt = con.prepareStatement(sql, 1);
            for (int count = 0; count < Data.size(); count++) {
                String col = Cols.get(count);
                stmt.setObject(count + 1, Data.get(col));
            }
            int affectedRows = stmt.executeUpdate();
            if (affectedRows == 0)
                throw new SQLException("Data entry failed, no rows affected.");
            try (ResultSet generatedKeys = stmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    result = generatedKeys.getInt(1);
                } else {
                    throw new SQLException("Data entry failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            String error = e.getMessage();
            System.out.print(error);
            return result;
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        }
        return result;
    }


    public static String UpdateStringData(String TableName, String inputColumn, String Data, String Condition) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String result = "failed";
        String sql = "Update " + TableName + " SET " + inputColumn + " = ? " + Condition;
        try {
            con = (new JDBCConnector()).getConnection();
            stmt = con.prepareStatement(sql);
            stmt.setString(1, Data);
            stmt.executeUpdate();
            result = "success";
        } catch (SQLException e) {
            String error = e.getMessage();
            System.out.print(error);
            return result;
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        }
        return result;
    }
    public static String DeleteObject(String TableName, String Condition) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        String result = "";
        String sql = "Delete from " + TableName + " " + Condition;
        try {
            con = (new JDBCConnector()).getConnection();
            stmt = con.prepareStatement(sql);
            stmt.executeUpdate();
            result = "successful";
        } catch (SQLException e) {
            String error = e.getMessage();
            System.out.print(error);
            result = "failed";
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        }
        return result;
    }
    public static HashMap<String, String> GetTableData(String TableName, String Condition) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        HashMap<String, String> result = new HashMap<>();
        String sql = "Select * from " + TableName + " " + Condition;
        try {
            con = (new JDBCConnector()).getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.last()) {
                ResultSetMetaData rsmd = rs.getMetaData();
                int i;
                for (i = 1; i <= rsmd.getColumnCount(); i++) {
                    int type = rsmd.getColumnType(i);
                    String ColumnName = rsmd.getColumnName(i);
                    if (type == 12 || type == 1 || type == -1) {
                        result.put(ColumnName, rs.getString(i));
                    } else if (type == 4) {
                        result.put(ColumnName, "" + rs.getInt(i));
                    } else if (type == 91) {
                        result.put(ColumnName, "" + rs.getDate(i));
                    } else if (type == 92) {
                        result.put(ColumnName, "" + rs.getTime(i));
                    } else {
                        result.put(ColumnName, "" + rs.getLong(i));
                    }
                }
                while (rs.previous()) {
                    for (i = 1; i <= rsmd.getColumnCount(); i++) {
                        int type = rsmd.getColumnType(i);
                        String ColumnName = rsmd.getColumnName(i);
                        if (type == 12 || type == 1 || type == -1) {
                            result.put(ColumnName, rs.getString(i));
                        } else if (type == 4) {
                            result.put(ColumnName, "" + rs.getInt(i));
                        } else if (type == 91) {
                            result.put(ColumnName, "" + rs.getDate(i));
                        } else if (type == 92) {
                            result.put(ColumnName, "" + rs.getTime(i));
                        } else {
                            result.put(ColumnName, "" + rs.getLong(i));
                        }
                    }
                }
            }
        } catch (SQLException e) {
            String error = e.getMessage();
            System.out.print(error);
            return result;
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        }
        return result;
    }
    public static int GetInt(String outputColumn, String TableName, String Condition) throws ClassNotFoundException, SQLException, UnsupportedEncodingException {
        Connection con = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        int result = 0;
        String sql = "Select * from " + TableName + " " + Condition;
        try {
            con = (new JDBCConnector()).getConnection();
            stmt = con.prepareStatement(sql);
            rs = stmt.executeQuery();
            if (rs.last()) {
                result = rs.getInt(outputColumn);
            } else {
                result = 0;
            }
        } catch (SQLException e) {
            String error = e.getMessage();
            System.out.print(error);
            return result;
        } finally {
            if (rs != null)
                rs.close();
            if (stmt != null)
                stmt.close();
            if (con != null)
                con.close();
        }
        return result;
    }


}

