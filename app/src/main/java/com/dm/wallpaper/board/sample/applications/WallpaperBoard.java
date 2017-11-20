package com.dm.wallpaper.board.sample.applications;

import android.support.annotation.NonNull;

import com.dm.wallpaper.board.applications.WallpaperBoardApplication;
import com.dm.wallpaper.board.applications.WallpaperBoardConfiguration;

public class WallpaperBoard extends WallpaperBoardApplication {

    @NonNull
    @Override
    public WallpaperBoardConfiguration onInit() {
        WallpaperBoardConfiguration configuration = new WallpaperBoardConfiguration();

        /* Add your configurations here
         */
        return configuration;
    }
}
