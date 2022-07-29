package com.example.xoplayer;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;

import java.io.File;
import java.util.ArrayList;

public class VideoFolderAdapter  extends RecyclerView.Adapter<VideoFolderAdapter.MyViewholder>{
    private Context mContext;
    static ArrayList<VideoFiles> foldervideoFiles;
    View view;

    public VideoFolderAdapter(Context mContext, ArrayList<VideoFiles> foldervideoFiles) {
        this.mContext = mContext;
        this.foldervideoFiles = foldervideoFiles;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view = LayoutInflater.from(mContext).inflate(R.layout.video_item, parent, false);
        return new MyViewholder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
        holder.fileName.setText(foldervideoFiles.get(position).getTitle());
        Glide.with(mContext).load(new File(foldervideoFiles.get(position).getPath())).into(holder.thumbnail);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, PlayerActivity.class);
                intent.putExtra("position", position);
                intent.putExtra("sender","FolderIsSending");
                mContext.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return foldervideoFiles.size();
    }

    public class MyViewholder  extends RecyclerView.ViewHolder {
        ImageView thumbnail, menuMore;
        TextView fileName, videoDuration;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);
            thumbnail = itemView.findViewById(R.id.thumbnail);
            menuMore = itemView.findViewById(R.id.menu_more);
            fileName = itemView.findViewById(R.id.video_file_name);
            videoDuration = itemView.findViewById(R.id.video_duration);
        }
    }
}
