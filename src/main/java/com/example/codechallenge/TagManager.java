package com.example.codechallenge;

import java.io.UnsupportedEncodingException;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;

public class TagManager {




        //region CREATE
        public static int CreateNewTag(String TagName) throws SQLException, UnsupportedEncodingException, ClassNotFoundException
        {
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put(Table.Tags.Name, TagName);
            int TagID = DBManager.insertTableDataReturnID(Table.Tags.Table, data, "");
            return TagID;
        }

        public static int TagAnObject(int TagID, int ObjectID, String ObjectType) throws SQLException, UnsupportedEncodingException, ClassNotFoundException
        {
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put(Table.TagJoinTable.TagID, Integer.valueOf(TagID));
            data.put(Table.TagJoinTable.TaggedObjectID, Integer.valueOf(ObjectID));
            data.put(Table.TagJoinTable.ObjectType, ObjectType);
            int TagRecordID = DBManager.insertTableDataReturnID(Table.TagJoinTable.Table, data, "");
            return TagRecordID;
        }

        public static boolean ParentATag(int ParentTagID, int ChildTagID) throws SQLException, UnsupportedEncodingException, ClassNotFoundException {
            HashMap<String, Object> data = new HashMap<String, Object>();
            data.put(Table.TagClosureTable.Ancestor, ParentTagID);
            data.put(Table.TagClosureTable.Descendant, ChildTagID);
            int Success = DBManager.insertTableDataReturnID(Table.TagClosureTable.Table, data, "");
            if (Success == 0)
                return false;
            else return true;
        }
        //endregion


        //region READ
        public static HashMap<String, String> GetTagByID(int TagID) throws SQLException, UnsupportedEncodingException, ClassNotFoundException
        {
            HashMap<String, String> result = DBManager.GetTableData(Table.Tags.Table, "where " + Table.Tags.ID + "=" + TagID);
            return result;
        }

        public static HashMap<String, String> GetAllItemsWithTag(int TagID) throws SQLException, UnsupportedEncodingException, ClassNotFoundException
        {
            HashMap<String, String> result = DBManager.GetTableData(Table.TagJoinTable.Table, "where " + Table.TagJoinTable.TagID + " = " + TagID);
            return result;
        }

        public static int GetTagParentID(int TagID) throws SQLException, UnsupportedEncodingException, ClassNotFoundException {
            return DBManager.GetInt(Table.TagClosureTable.Ancestor, Table.TagClosureTable.Table, "where " + Table.TagClosureTable.Descendant + "");
        }
        //endregion

        //region UPDATE
        public static String UpdateTagName(int TagID, String NewName) throws SQLException, UnsupportedEncodingException, ClassNotFoundException {
            String result = DBManager.UpdateStringData(Table.Tags.Table, Table.Tags.Name, NewName, "where " + Table.Tags.ID + "=" + TagID);
            return result;
        }
        //endregion

        //region DELETE
        public static void DeleteTag(String TagID) throws SQLException, UnsupportedEncodingException, ClassNotFoundException
        { String result =DBManager.DeleteObject(Table.Tags.Table, "where" + Table.Tags.ID + "=" + TagID);

        }

        public static String UnParentATag(int TagID) throws SQLException, UnsupportedEncodingException, ClassNotFoundException {
            return DBManager.DeleteObject(Table.TagClosureTable.Table, "where " + Table.TagClosureTable.Descendant + "=" + TagID);
        }
        //endregion
    // region GET ALL TAGS
    public static List<String> getAllTags ()throws SQLException, UnsupportedEncodingException, ClassNotFoundException
    {
        List<String> result = (List<String>) DBManager.GetTableData(Table.Tags.Table, "");
        return result;
    }


}
