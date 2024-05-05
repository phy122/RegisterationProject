package com.example.registerationproject;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class NoticeListAdapter extends BaseAdapter {

    private Context context;
    private List<Notice> noticeList;

    public NoticeListAdapter(Context context, List<Notice> noticeList) {
        this.context = context;
        this.noticeList = noticeList;
    }

    @Override
    public int getCount() {
        return noticeList.size();
    }

    @Override
    public Object getItem(int position) {
        return noticeList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = View.inflate(context, R.layout.notice, null);
        TextView noticeText = view.findViewById(R.id.noticeText);
        TextView nameText = view.findViewById(R.id.nameText);
        TextView dateText = view.findViewById(R.id.dateText);

        // 현재 position의 Notice 객체 가져오기
        Notice currentNotice = noticeList.get(position);

        // Notice 객체의 정보 설정
        noticeText.setText(currentNotice.getNotice());
        nameText.setText(currentNotice.getName());
        dateText.setText(currentNotice.getDate());

        // 공지사항 아이템을 클릭하면 해당 URL로 이동
        view.setOnClickListener(v -> {
            // URL을 확인하고, URL로 이동
            String url = currentNotice.getUrl();
            if (url != null && !url.isEmpty()) {
                Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
                // FLAG_ACTIVITY_NEW_TASK 플래그 추가
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                context.startActivity(intent);
            }
        });

        return view;
    }

}
