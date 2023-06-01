package com.sk.myapplication;


import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import java.util.ArrayList;
import java.util.Iterator;


/**
 * A simple {@link Fragment} subclass.
 */
public class MainFragment extends Fragment {
    private ListView listView;
    private MyAdapter myAdapter;
    public static ArrayList<Student> students = new ArrayList<>();
    private boolean isMode = false;
    private Button btn;
    private View view;
    static {
        InitData();
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_main, container, false);
        InitView();
        return view;
    }

    private void InitView() {
        listView = view.findViewById(R.id.id_listview);
        btn = view.findViewById(R.id.id_btn);
        myAdapter = new MyAdapter();
        listView.setAdapter(myAdapter);
        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                isMode = !isMode;
                if (isMode){
                    //ToDo 调用进入删除模式的代码
                    myAdapter.nextDelMode(position);

                }else {
                    //ToDo 调用进入普通模式的代码
                    myAdapter.cancle();
                }
                return false;
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                if (isMode){
                    Student item = myAdapter.getItem(position);
                    item.checked=!item.checked;//单击选中，再次点击取消选中
                    myAdapter.notifyDataSetChanged();//更新UI
                }
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //ToDo 调用删除数据代码
                myAdapter.deleteStudent();
            }
        });

    }

    private static void InitData() {
        Student it = new Student();
        it.sex = false;
        it.name = "Wang Hong";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Zhang San";
        students.add(it);

        it = new Student();
        it.sex = false;
        it.name = "Liu Fang";
        students.add(it);

        it = new Student();
        it.sex = false;
        it.name = "MaHiRo";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Li Si";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Wang Wu";
        students.add(it);
        it = new Student();
        it.sex = true;
        it.name = "Zhang San";
        students.add(it);

        it = new Student();
        it.sex = false;
        it.name = "Liu Fang";
        students.add(it);

        it = new Student();
        it.sex = false;
        it.name = "MaHiRo";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Li Si";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Wang Wu";
        students.add(it);
        it = new Student();
        it.sex = true;
        it.name = "Zhang San";
        students.add(it);

        it = new Student();
        it.sex = false;
        it.name = "Liu Fang";
        students.add(it);

        it = new Student();
        it.sex = false;
        it.name = "MaHiRo";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Li Si";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Wang Wu";
        students.add(it);
        it = new Student();
        it.sex = true;
        it.name = "Zhang San";
        students.add(it);

        it = new Student();
        it.sex = false;
        it.name = "Liu Fang";
        students.add(it);

        it = new Student();
        it.sex = false;
        it.name = "MaHiRo";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Li Si";
        students.add(it);

        it = new Student();
        it.sex = true;
        it.name = "Wang Wu";
        students.add(it);
    }

    private class MyAdapter extends BaseAdapter {

        public void deleteStudent() {
            Iterator<Student> iterator = students.iterator();
            while (iterator.hasNext()){
                Student item = iterator.next();//遍历
                if (item.checked){
                    iterator.remove();//删除选中数据
                }
                notifyDataSetChanged();//更新UI
            }
            isMode = false;//取消删除模式
            this.cancle();//进入普通模式
        }

        public void nextDelMode(int position) {
            btn.setVisibility(View.VISIBLE);
            Student item = myAdapter.getItem(position);
            item.checked=true;
            myAdapter.notifyDataSetChanged();
        }

        public void cancle() {
            btn.setVisibility(View.GONE);
            for (Student student : students) {
                student.checked = false;
            }
            myAdapter.notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return students.size();
        }

        @Override
        public Student getItem(int position) {
            return students.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.listview_item,parent,false);
            }
            Student student=getItem(position);
            ImageView sexView=convertView.findViewById(R.id.id_sex);
            TextView nameView=convertView.findViewById(R.id.id_name);
            ImageView checkView=convertView.findViewById(R.id.id_checked);

            Drawable[] sexIcon = new Drawable[2];
            sexIcon[0] = getResources().getDrawable(R.drawable.ic_male);
            sexIcon[1] = getResources().getDrawable(R.drawable.ic_female);

            Drawable[] checkIcon = new Drawable[2];
            checkIcon[0] = getResources().getDrawable(R.drawable.ic_check);
            checkIcon[1] = getResources().getDrawable(R.drawable.ic_checked);

            sexView.setImageDrawable(student.sex?sexIcon[0]:sexIcon[1]);
            nameView.setText(student.name);
            checkView.setImageDrawable(student.checked?checkIcon[0]:checkIcon[1]);
            if (isMode){
                checkView.setVisibility(View.VISIBLE);
            }else {
                checkView.setVisibility(View.GONE);
            }
            return convertView;
        }
    }
}
