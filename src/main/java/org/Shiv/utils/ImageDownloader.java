package org.Shiv.utils;

import java.io.File;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.apache.commons.io.FileUtils;

public class ImageDownloader {
    public static void downloadImage (String imageUrl, String filename) throws Exception {
        URL url = new URL (imageUrl);
        HttpURLConnection connection = (HttpURLConnection) url.openConnection ();
        connection.setRequestProperty ("User-Agent", "Mozilla/5.0");
        connection.setRequestMethod ("GET");

        // Check if the response code is HTTP_OK (200)
        if (connection.getResponseCode () == HttpURLConnection.HTTP_OK) {
            try (InputStream in = connection.getInputStream ()) {
                File imageFile = new File (filename);
                FileUtils.copyInputStreamToFile (in, imageFile);
                System.out.println ("Image downloaded: " + filename);
            }
        } else {
            System.out.println (
                "Failed to download image. Server returned HTTP response code: " + connection.getResponseCode ());
        }
    }
}
