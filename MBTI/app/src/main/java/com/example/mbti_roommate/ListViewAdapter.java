package com.example.mbti_roommate;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

public class ListViewAdapter extends ArrayAdapter<UserInfo> implements View.OnClickListener{
    private ArrayList<UserInfo> listViewItemList= new ArrayList<UserInfo>();
    public interface ListBtnClickListener {
        void onListBtnClick(int position) ;
    }
    int resourceId;
    private ListBtnClickListener listBtnClickListener ;
    public ListViewAdapter(Context context, int resource,ArrayList<UserInfo> list,ListBtnClickListener clickListener){
        super(context,resource,list);
        this.resourceId = resource;
        this.listBtnClickListener = clickListener;
    }

    @Override
    public int getCount() {
        return listViewItemList.size();
    }

    // 지정한 위치(position)에 있는 데이터 리턴 : 필수 구현
    @Override
    public UserInfo getItem(int position) {
        return listViewItemList.get(position) ;
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        final int pos = position;
        final Context context = parent.getContext();

        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        convertView = inflater.inflate(R.layout.profile_default_info, parent, false);

        ImageView image = convertView.findViewById(R.id.image);
        TextView user_name = convertView.findViewById(R.id.user_name);
        TextView mbti_name = convertView.findViewById(R.id.mbti_name);
        TextView isSmoke = convertView.findViewById(R.id.isSmoke);

        final UserInfo listViewItem = listViewItemList.get(position);
        image.setImageResource(listViewItem.getMbti_image());
        user_name.setText(listViewItem.getPname());
        mbti_name.setText(MbtiInfo.MbtiInfo[listViewItem.getPmbti()]);
        if(listViewItem.getPsmoke()==1)
            isSmoke.setText("YES");
        else
            isSmoke.setText("NO");

        Button reqButton = (Button) convertView.findViewById(R.id.profile_request_btn);
        reqButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });

        Button denyButton = (Button) convertView.findViewById(R.id.profile_deny_btn);
        reqButton.setOnClickListener(new Button.OnClickListener() {
            public void onClick(View v) {

            }
        });

        Button showButton = (Button) convertView.findViewById(R.id.profile_show_btn);
        showButton.setTag(position);
        showButton.setOnClickListener(this);

        return convertView;
    }

    public void addItem(UserInfo userInfo) {
        UserInfo item = new UserInfo(userInfo);

        listViewItemList.add(item);
    }

    public void onClick(View v) {
         if (this.listBtnClickListener != null) {
            this.listBtnClickListener.onListBtnClick((int)v.getTag()) ;
        }
    }
}
