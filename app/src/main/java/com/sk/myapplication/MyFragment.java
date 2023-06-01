package com.sk.myapplication;


import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MyFragment extends Fragment {
    private ListView listView;
    private MyAdapter myAdapter;
    private ArrayList<My> myArrayList = new ArrayList<>();
    private View view;
    private TextView id_my_name;
    private ArrayList<APPUser> users = doLoginActivity.users;
    private int userID = doLoginActivity.UserID;
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_my, container, false);
        InitView();
        return view;
    }

    private void InitView() {
        id_my_name = view.findViewById(R.id.id_my_name);
        id_my_name.setText(users.get(userID).getUsername());
        myArrayList.clear();
        InitData();
        listView = view.findViewById(R.id.id_listview_my);
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
    }

    private void InitData() {
        My my = new My();
        my.setIcon(getResources().getDrawable(R.drawable.ic_pyq));
        my.setText("朋友圈");
        myArrayList.add(my);

        my = new My();
        my.setIcon(getResources().getDrawable(R.drawable.ic_kb));
        my.setText("卡包");
        myArrayList.add(my);

        my = new My();
        my.setIcon(getResources().getDrawable(R.drawable.ic_yx));
        my.setText("游戏");
        myArrayList.add(my);

        my = new My();
        my.setIcon(getResources().getDrawable(R.drawable.ic_gw));
        my.setText("购物");
        myArrayList.add(my);

        my = new My();
        my.setIcon(getResources().getDrawable(R.drawable.ic_sp));
        my.setText("视频号");
        myArrayList.add(my);

        my = new My();
        my.setIcon(getResources().getDrawable(R.drawable.ic_xcx));
        my.setText("小程序");
        myArrayList.add(my);

        my = new My();
        my.setIcon(getResources().getDrawable(R.drawable.ic_fj));
        my.setText("附近");
        myArrayList.add(my);

        my = new My();
        my.setIcon(getResources().getDrawable(R.drawable.ic_xy));
        my.setText("协议");
        myArrayList.add(my);
    }

    private class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return myArrayList.size();
        }

        @Override
        public My getItem(int position) {
            return myArrayList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView == null){
                convertView = getLayoutInflater().inflate(R.layout.listview_my_item,parent,false);
            }
            My item = getItem(position);
            ImageView imageView = convertView.findViewById(R.id.id_icon);
            TextView textView = convertView.findViewById(R.id.id_text);

            imageView.setImageDrawable(item.getIcon());
            textView.setText(item.getText().toString());
            return convertView;
        }
    }
}
