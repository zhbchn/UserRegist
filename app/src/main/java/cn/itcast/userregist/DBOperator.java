package cn.itcast.userregist;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.annotation.Nullable;

import java.util.LinkedList;
import java.util.List;

//import cn.itcast.Information.Information;

/**
 * Created by rain on 2017/11/26.
 */

public class DBOperator {
    private Context context;
    private String name="itcast.db";
    private int version=1;
    private SQLiteDatabase db;
    private MyHelper myHelper;

    public DBOperator(Context context) {

        myHelper= new MyHelper(context,name,null,version);
    }

    public int insert(String sql,Object[] para){

        return dbExecSQL(sql, para);
    }

    private int dbExecSQL(String sql, Object[] para) {
        try {
            db=myHelper.getWritableDatabase();
            db.execSQL(sql,para);
            return 1;
        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }finally {
            db.close();
        }
    }

    public int update(String sql,Object[] para){
        return dbExecSQL(sql, para);
    }

    public int delete(String sql,Object[] para){
        return dbExecSQL(sql, para);
    }

    public List<ItemInfo> query(String sql, String [] para){
        db=myHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,para);

        List<ItemInfo> informations = getInformation(cursor);
        if (informations == null) return null;
        cursor.close();
        db.close();
        return informations;

    }

//    public Cursor query(String sql, String [] para){
//        db=myHelper.getReadableDatabase();
//        Cursor cursor = db.rawQuery(sql,para);
//
//        db.close();
//        return cursor;
//
//    }
    @Nullable
    private List<ItemInfo> getInformation(Cursor cursor) {
        List<ItemInfo> informations =new LinkedList<>();
        if(cursor.getCount()==0) {
            return null;
        }else{
            for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {
//                ItemInfo infor =new ItemInfo();
//                infor.setId(cursor.getInt(0));
//                infor.setName(cursor.getString(1));
//                infor.setPhone(cursor.getString(2));

//                informations.add(infor);
            }
        }
        return informations;
    }

    public  UserInfo queryUser(String sql,String [] param){
        db=myHelper.getReadableDatabase();
        Cursor cursor = db.rawQuery(sql,param);

        UserInfo userInfo = getUserInfo(cursor);
        if (userInfo == null) return null;
        cursor.close();
        db.close();
        return userInfo;
    }

    private UserInfo getUserInfo(Cursor cursor) {
        UserInfo userInfo =new UserInfo();
        if(cursor.getCount()==0) {
            return null;
        }else{
            for (cursor.moveToFirst(); !(cursor.isAfterLast()); cursor.moveToNext()) {

                userInfo.setId(cursor.getInt(0));
                userInfo.setName(cursor.getString(1));
                userInfo.setPassword(cursor.getString(2));

            }
        }
        return userInfo;
    }

}
