package com.dm.wallpaper.board.sample.services;

import com.dm.wallpaper.board.services.WallpaperBoardMuzeiService;

public class MuzeiService extends WallpaperBoardMuzeiService{

    private static final String SOURCE_NAME = "WallpaperBoard:MuzeiArtSource";

    public MuzeiService() {
        super(SOURCE_NAME);
    }
}
