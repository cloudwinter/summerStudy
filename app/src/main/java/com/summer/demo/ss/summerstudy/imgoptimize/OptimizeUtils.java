package com.summer.demo.ss.summerstudy.imgoptimize;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

/**
 * Created by xiayundong on 2018/8/29.
 */

public class OptimizeUtils {


    /**
     * 质量压缩法，通过设置option使图片的大小小于一个固定的值
     *
     * @param bitmap
     * @param memorySize
     * @return
     */
    public static Bitmap qualityOptimize(Bitmap bitmap, int memorySize) {
        int option = 100;
        // 每次递减10
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        if (bitmap.getHeight() * bitmap.getWidth() / 1024 > memorySize) {
            option = option - 10;
            bitmap.compress(Bitmap.CompressFormat.PNG, option, outputStream);

            ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
            bitmap = BitmapFactory.decodeStream(inputStream);
        }
        return bitmap;


    }


    /**
     * 比例压缩法
     *
     * @param file   原图片
     * @param width  压缩后图片宽度
     * @param height 压缩后图片的长度
     * @return
     */
    public static Bitmap sizeOptimize(File file, int width, int height) {

        // 设置inJustDecodeBounds为true,不占内存
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        InputStream is = null;
        try {
            is = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        BitmapFactory.decodeStream(is, null, options);
        int srcWidth = options.outWidth;
        int srcHeight = options.outHeight;

        // 取最小比例的
        int resultSize = calculateSize(width, height, srcWidth, srcHeight);
        options.inJustDecodeBounds = false;
        options.inSampleSize = resultSize;
        return BitmapFactory.decodeStream(is, null, options);
    }

    /**
     * 计算合适的比例
     *
     * @param width
     * @param height
     * @param srcWidth
     * @param srcHeight
     * @return
     */
    private static int calculateSize(int width, int height, int srcWidth, int srcHeight) {
        int resultSize = 0;
        int sizeW = srcWidth / width;
        int sizeH = srcHeight / height;
        if (sizeW > sizeH) {
            resultSize = sizeH;
        } else {
            resultSize = sizeW;
        }
        return resultSize;
    }

}
