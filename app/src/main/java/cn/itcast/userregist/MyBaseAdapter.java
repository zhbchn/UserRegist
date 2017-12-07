package cn.itcast.userregist;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;


/**
 * Created by rain on 2017/11/29.
 */

public class MyBaseAdapter extends BaseAdapter {
    private List<ItemInfo> list;
    private Context context;
    public MyBaseAdapter(Context context, List<ItemInfo> list) {
        this.context=context;
        this.list=list;
    }

    //得到item的总数
    @Override
    public int getCount() {
        //返回ListView Item条目的总数
        return list.size();
    }
    //得到Item代表的对象
    @Override
    public Object getItem(int position) {
        //返回ListView Item条目代表的对象
        return list.get(position);
    }
    //得到Item的id
    @Override
    public long getItemId(int position) {
        //返回ListView Item的id
        return position;
    }
    //得到Item的View视图
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        convertView = getViewByHolder(position, convertView, parent);
        return convertView;
    }

    @NonNull
    private View getViewByHolder(int position, View convertView, ViewGroup parent) {
        ViewHolder holder;
        if (convertView == null) {
            convertView = LayoutInflater.from(context).
                    inflate(R.layout.list_item,parent,false);
            holder = new ViewHolder();

            holder.mName = (TextView)convertView.findViewById(R.id.tv_name);
            holder.mLife = (TextView)convertView.findViewById(R.id.tv_life);
            holder.mSpeed = (TextView)convertView.findViewById(R.id.tv_speed);
            holder.mAttack = (TextView)convertView.findViewById(R.id.tv_attack);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }
        holder.mName.setText(list.get(position).getName());
        holder.mLife.setText("生命值+"+list.get(position).getLife());
        holder.mSpeed.setText("敏捷度+" +list.get(position).getSpeed());
        holder.mAttack.setText("攻击力+" +list.get(position).getAcctack());
        return convertView;
    }

    class ViewHolder {
        TextView mName;
        TextView mLife;
        TextView mSpeed;
        TextView mAttack;
    }


}
