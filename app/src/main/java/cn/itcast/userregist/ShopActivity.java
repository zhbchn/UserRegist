package cn.itcast.userregist;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class ShopActivity extends AppCompatActivity implements
        View.OnClickListener {
    private ItemInfo itemInfo;
    private ListView mListView;
    List<ItemInfo> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);

        mListView = (ListView) findViewById(R.id.dataList);
        itemInfo = new ItemInfo("金剑", 100, 20, 20);
        list=new ArrayList<ItemInfo>();
        list.add(itemInfo);
        itemInfo = new ItemInfo("铁剑", 40, 10, 10);
        list.add(itemInfo);
        itemInfo = new ItemInfo("铜剑", 60, 15, 16);
        list.add(itemInfo);
        itemInfo = new ItemInfo("银剑", 80, 18, 18);
        list.add(itemInfo);
        MyBaseAdapter mAdapter = new MyBaseAdapter(this,list);
        //设置Adapter
        mListView.setAdapter(mAdapter);
        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent();
                intent.putExtra("equipment", list.get(position));
                setResult(1, intent);
                finish();
            }
        });

//        itemInfo = new ItemInfo("金剑", 100, 20, 20);
//        findViewById(R.id.rl).setOnClickListener(this);
//        TextView mLifeTV = (TextView) findViewById(R.id.tv_life);
//        TextView mNameTV = (TextView) findViewById(R.id.tv_name);
//        TextView mSpeedTV = (TextView) findViewById(R.id.tv_speed);
//        TextView mAttackTV = (TextView) findViewById(R.id.tv_attack);
//        mLifeTV.setText("生命值+" + itemInfo.getLife());
//        mNameTV.setText(itemInfo.getName() + "");
//        mSpeedTV.setText("敏捷度+" + itemInfo.getSpeed());
//        mAttackTV.setText("攻击力+" + itemInfo.getAcctack());
    }
    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
//        switch (v.getId()) {
//            case R.id.rl:
//                Intent intent = new Intent();
//                intent.putExtra("equipment", itemInfo);
//                setResult(1, intent);
//                finish();
//                break;
//        }
    }


}
