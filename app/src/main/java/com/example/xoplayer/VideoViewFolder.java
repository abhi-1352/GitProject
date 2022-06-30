package com.example.xoplayer;


import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

public class VideoViewFolder extends RecyclerView.ViewHolder {
    public ImageView imgThumbnail;
    public TextView txtName;
    public CardView cardView;
    public VideoViewFolder(@NonNull View itemView) {
        super(itemView);
        imgThumbnail = itemView.findViewById(R.id.imgThumbnail);
        txtName = itemView.findViewById(R.id.txtName);
        cardView = itemView.findViewById(R.id.main_container);
    }
}
