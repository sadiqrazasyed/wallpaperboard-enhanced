package com.dm.wallpaper.board.adapters;

import android.content.ActivityNotFoundException;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.dm.wallpaper.board.BuildConfig;
import com.dm.wallpaper.board.R;
import com.dm.wallpaper.board.helpers.UrlHelper;
import com.dm.wallpaper.board.utils.LogUtil;

/*
 * Wallpaper Board
 *
 * Copyright (c) 2017 Dani Mahardhika
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

public class AboutSocialAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private final Context mContext;
    private final String[] mUrls;

    public AboutSocialAdapter(@NonNull Context context, @NonNull String[] urls) {
        mContext = context;
        mUrls = urls;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mContext).inflate(
                R.layout.fragment_about_item_social, parent, false);
        return new SocialViewHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        SocialViewHolder socialViewHolder = (SocialViewHolder) holder;
        UrlHelper.Type type = UrlHelper.getType(mUrls[position]);
        Drawable drawable = UrlHelper.getSocialIcon(mContext, type);

        if (drawable != null && type != UrlHelper.Type.INVALID) {
            socialViewHolder.image.setImageDrawable(drawable);
            socialViewHolder.image.setVisibility(View.VISIBLE);
        } else {
            socialViewHolder.image.setVisibility(View.GONE);
        }
    }

    @Override
    public int getItemCount() {
        return mUrls.length;
    }

    private class SocialViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        private final ImageView image;

        SocialViewHolder(View itemView) {
            super(itemView);
            image = itemView.findViewById(R.id.image);

            image.setOnClickListener(this);
        }

        @Override
        public void onClick(View view) {
            int id = view.getId();
            int position = getAdapterPosition();
            if (position < 0 || position > mUrls.length) return;

            if (id == R.id.image) {
                UrlHelper.Type type = UrlHelper.getType(mUrls[position]);
                if (type == UrlHelper.Type.INVALID) return;

                if (type == UrlHelper.Type.EMAIL) {
                    try {
                        String deviceInfo="YOUR TEXT (Edit this) \n\n\n------------ Device Info ------------";
                        deviceInfo += "\n Android Version: " + android.os.Build.VERSION.RELEASE;
                        deviceInfo += "\n API Level: " + android.os.Build.VERSION.SDK_INT;
                        deviceInfo += "\n Device: " + android.os.Build.DEVICE;
                        deviceInfo += "\n Board: " + android.os.Build.BOARD;
                        deviceInfo += "\n Hardware: " + android.os.Build.HARDWARE;
                        deviceInfo += "\n Build ID: " + android.os.Build.ID;
                        deviceInfo += "\n Device Brand: " + android.os.Build.BRAND;
                        deviceInfo += "\n Device Manufacturer: " + android.os.Build.MANUFACTURER;
                        deviceInfo += "\n Model (and Product): " + android.os.Build.MODEL + " ("+ android.os.Build.PRODUCT + ")";
                        deviceInfo += "\n Library Version: " + BuildConfig.VERSION_NAME;
                        deviceInfo += "\n ---------------------------------------------";
                        deviceInfo += "\n\n" + (mContext.getResources().getString(R.string.email_lastline));

                        final Intent email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                                "mailto", mUrls[position], null));
                        email.putExtra(Intent.EXTRA_SUBJECT, (mContext.getResources().getString(
                                R.string.email_subject)));
                        email.putExtra(Intent.EXTRA_TEXT,deviceInfo);
                        mContext.startActivity(Intent.createChooser(email,
                                mContext.getResources().getString(R.string.email_client)));
                    }
                    catch (ActivityNotFoundException e) {
                        LogUtil.e(Log.getStackTraceString(e));
                    }
                    return;
                }

                try {
                    mContext.startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(mUrls[position])));
                } catch (ActivityNotFoundException e) {
                    LogUtil.e(Log.getStackTraceString(e));
                }
            }
        }
    }
}
