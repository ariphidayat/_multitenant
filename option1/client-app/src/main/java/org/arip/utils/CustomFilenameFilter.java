package org.arip.utils;

import java.io.File;
import java.io.FilenameFilter;

/**
 * Created by Arip Hidayat on 1/16/2017.
 */
public class CustomFilenameFilter implements FilenameFilter {

    @Override
    public boolean accept(File dir, String name) {
        return name.toLowerCase().endsWith(".properties");
    }
}
