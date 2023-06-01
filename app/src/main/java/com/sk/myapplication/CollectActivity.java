package com.sk.myapplication;

import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;


import java.util.ArrayList;

public class CollectActivity extends AppCompatActivity {
    private GridView id_gridview;
    private MyAdapter myAdapter;
    private ArrayList<Picture> listdata = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collect);
        InitView();
    }

    private void InitView() {
        InitData();
        id_gridview = findViewById(R.id.id_gridview);
        myAdapter = new MyAdapter();
        id_gridview.setAdapter(myAdapter);
        id_gridview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listdata.get(position).label;
                Toast.makeText(CollectActivity.this, ""+str, Toast.LENGTH_SHORT).show();
            }
        });
        id_gridview.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                String str = listdata.get(position).label;
                Toast.makeText(CollectActivity.this, "长按了"+str, Toast.LENGTH_SHORT).show();
                return false;
            }
        });
    }

    private void InitData() {
        Picture img1 = new Picture(getDrawable(R.mipmap.img1),"雷电将军");
        Picture img2 = new Picture(getDrawable(R.mipmap.img2),"钟离");
        Picture img3 = new Picture(getDrawable(R.mipmap.img3),"阿贝多");
        Picture img4 = new Picture(getDrawable(R.mipmap.img4),"神里绫华");
        Picture img5 = new Picture(getDrawable(R.mipmap.img5),"优菈·劳伦斯");
        Picture img6 = new Picture(getDrawable(R.mipmap.img6),"烟绯");
        Picture img7 = new Picture(getDrawable(R.mipmap.img7),"莫娜");
        Picture img8 = new Picture(getDrawable(R.mipmap.img8),"魈");
        Picture img9 = new Picture(getDrawable(R.mipmap.img9),"荧");
        Picture img10 = new Picture(getDrawable(R.mipmap.img10),"申鹤");
        listdata.add(img1);
        listdata.add(img2);
        listdata.add(img3);
        listdata.add(img4);
        listdata.add(img5);
        listdata.add(img6);
        listdata.add(img7);
        listdata.add(img8);
        listdata.add(img9);
        listdata.add(img10);
    }

    public void CollectExit(View view) {
        finish();
    }

    private class MyAdapter extends BaseAdapter{

        @Override
        public int getCount() {
            return listdata.size();
        }

        @Override
        public Picture getItem(int position) {
            return listdata.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            if (convertView==null){
                convertView=getLayoutInflater().inflate(R.layout.gridview_item,parent,false);
            }
            Picture picture = getItem(position);

            ((ImageView)convertView.findViewById(R.id.id_image)).setImageDrawable(picture.drawable);
            ((TextView)convertView.findViewById(R.id.id_label)).setText(picture.label);

            return convertView;
        }
    }
}
