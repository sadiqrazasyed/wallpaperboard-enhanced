package com.dm.wallpaper.board.sample.activities;

import android.support.annotation.NonNull;

import com.dm.wallpaper.board.activities.WallpaperBoardMuzeiActivity;
import com.dm.wallpaper.board.sample.services.MuzeiService;

public class MuzeiActivity extends WallpaperBoardMuzeiActivity {

    @NonNull
    @Override
    public Class<?> onInit() {
        return MuzeiService.class;
    }
}
