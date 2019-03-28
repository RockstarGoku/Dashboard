package com.example.pratik.dashboard;

import android.annotation.SuppressLint;
import android.annotation.TargetApi;
import android.app.DownloadManager;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Build;
import android.os.Environment;
import android.support.annotation.NonNull;
import android.support.annotation.RequiresApi;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ImageViewHolder> {

    private Context mContext;
    public List<Upload> mUploads;

    public ImageAdapter(Context context, List<Upload> uploads)
    {
        mContext = context;
        mUploads = uploads;
    }

    @NonNull
    @Override
    public ImageViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int i) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.image_item, parent, false);
        return new ImageViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ImageViewHolder holder, int position) {
        Upload uploadCurrent = mUploads.get(holder.getAdapterPosition());
        holder.textViewName.setText(uploadCurrent.getName());
        if (mUploads.get(holder.getAdapterPosition()).getType().equals("IMAGE")) {
            Picasso.get()
                    .load(uploadCurrent.getImageUrl())
                    .fit()
                    .centerCrop()
                    .into(holder.imageView);
        }
        else {
            holder.imageView.setImageResource(R.drawable.file);
        }
        holder.imageView.setOnClickListener(new View.OnClickListener() {
            @TargetApi(Build.VERSION_CODES.HONEYCOMB)
            @RequiresApi(api = Build.VERSION_CODES.GINGERBREAD)
            @Override
            public void onClick(View v) {
                DownloadManager downloadManager =  (DownloadManager) mContext.getSystemService(Context.DOWNLOAD_SERVICE);
                Uri uri = Uri.parse(mUploads.get(holder.getAdapterPosition()).getImageUrl());
                DownloadManager.Request request = new DownloadManager.Request(uri);

                request.setNotificationVisibility(DownloadManager.Request.VISIBILITY_VISIBLE_NOTIFY_COMPLETED);
                switch (mUploads.get(holder.getAdapterPosition()).getType())
                {
                    case "IMAGE":
                        request.setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS,mUploads.get(holder.getAdapterPosition()).getName()+".png");
                        downloadManager.enqueue(request);
                        break;
                    case "PDF":
                        request.setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS,mUploads.get(holder.getAdapterPosition()).getName()+".pdf");
                        downloadManager.enqueue(request);
                        break;

                    case "EXCEL":
                        request.setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS,mUploads.get(holder.getAdapterPosition()).getName()+".xls");
                        downloadManager.enqueue(request);
                        break;

                    case "WORD":
                        request.setDestinationInExternalFilesDir(mContext, Environment.DIRECTORY_DOWNLOADS,mUploads.get(holder.getAdapterPosition()).getName()+".doc");
                        downloadManager.enqueue(request);
                        break;

                }
            }
        });
    }

    public int getItemCount() {
        return mUploads.size();
    }

    public class ImageViewHolder extends RecyclerView.ViewHolder
    {
        public TextView textViewName,texttype;
        public ImageView imageView;
        public ImageViewHolder(@NonNull View itemView) {
            super(itemView);

            textViewName = itemView.findViewById(R.id.text_view_name);
            imageView = itemView.findViewById(R.id.image_view_upload);
            texttype = itemView.findViewById(R.id.texttype);
        }
    }
}