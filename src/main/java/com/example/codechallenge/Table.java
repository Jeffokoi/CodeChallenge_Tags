package com.example.codechallenge;

public class Table {
    public static class Tags {

        public static String Table;
        public static String ID;
        public static String Name;
        public static String GroupID;

        static {
            Tags.Table = "tags";
            Tags.ID = "id";
            Tags.Name = "name";
            Tags.GroupID = "tag_group_id";
        }
    }

    public static class TagClosureTable
    {
        public static String Table;
        //public static String ID;
        //public static String TagID;
        public static String Ancestor;
        public static String Descendant;
        public static String Depth;

        static
        {
            TagClosureTable.Table = "TagClosureTable";
            //TagClosureTable.ID = "id";
            //TagClosureTable.TagID = "TagID";
            TagClosureTable.Ancestor = "Ancestor";
            TagClosureTable.Descendant = "Descendant";
            TagClosureTable.Depth = "Depth";
        }
    }

    public static class TagJoinTable
    {
        public static String Table;
        public static String ID;
        public static String TagID;
        public static String TaggedObjectID;
        public static String ObjectType;

        static
        {
            TagJoinTable.Table = "TagJoinTable";
            TagJoinTable.ID = "id";
            TagJoinTable.TagID = "TagID";
            TagJoinTable.TaggedObjectID = "TaggedObjectID";
            TagJoinTable.ObjectType = "ObjectTypeTableName";
        }
    }
    public static class UserTable {

        public static String Table;
        public static String ID;
        public static String Email;
        public static String PhoneNumber;
        public static String Password;
        public static String DateJoined;
        public static String DateActivated;
        public static String ActivationStatus;
        public static String UserGroupID;
        public static String Restriction;
        public static String LastUpdated;
        public static String LastSeen;
        public static String OfflineID;
        public static String BlockedStatus;

        static {
            UserTable.Table = "user";
            UserTable.ID = "id";
            UserTable.Email = "email";
            UserTable.PhoneNumber = "phone_number";
            UserTable.Password = "password";
            UserTable.DateJoined = "date_joined";
            UserTable.DateActivated = "date_activated";
            UserTable.ActivationStatus = "status";
            UserTable.UserGroupID = "user_group_id";
            UserTable.Restriction = "restriction";
            UserTable.LastUpdated = "Last_Updated";
            UserTable.LastSeen = "Last_Seen";
            UserTable.OfflineID = "OfflineID";
            UserTable.BlockedStatus = "blocked_status";
        }
    }
}
