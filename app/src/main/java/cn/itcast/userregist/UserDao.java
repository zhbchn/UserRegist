package cn.itcast.userregist;

import android.content.Context;
import android.database.Cursor;
import android.support.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

/**
 * Created by rain on 2017/12/7.
 */

public class UserDao {
    DBOperator db ;
    public UserDao(Context context) {
        db=new DBOperator(context);
    }

    public void insertUser(UserInfo user){
      String sql= "insert into user(name,password) values(?,?)";
      Object[] para= new Object[]{user.getName(),user.getPassword()};
      db.insert(sql,para);
    }

    public UserInfo query(String name,String pwd){
        String sql= "select * from  user where name = ? and password=?";
        String[] para= new String[]{name,pwd};
        UserInfo userInfo = db.queryUser(sql,para);
//        Cursor cursor=dbo.query("select * from information",null);
//        List<Information> informations = getInformation(cursor);
//        cursor.close();
        return userInfo;
    }


}
