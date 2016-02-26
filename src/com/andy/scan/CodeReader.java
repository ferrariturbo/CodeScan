package com.andy.scan;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;

import javax.imageio.ImageIO;

import org.jbarcode.JBarcode;  
import org.jbarcode.encode.EAN8Encoder;
import org.jbarcode.paint.EAN8TextPainter;
import org.jbarcode.paint.WidthCodedPainter;  
import org.jbarcode.util.ImageUtil;

import com.google.zxing.BinaryBitmap;
import com.google.zxing.LuminanceSource;
import com.google.zxing.MultiFormatReader;
import com.google.zxing.Result;
import com.google.zxing.client.j2se.BufferedImageLuminanceSource;
import com.google.zxing.common.HybridBinarizer;  

public class CodeReader { 
	public static void main(String[] paramArrayOfString) {  
        try {  
            JBarcode localJBarcode = new JBarcode(EAN8Encoder.getInstance(),WidthCodedPainter.getInstance(),EAN8TextPainter.getInstance());  
            String str = "0160224";  
            BufferedImage localBufferedImage = localJBarcode.createBarcode(str);  

           // saveToJPEG(localBufferedImage, "EAN8.jpg");
            decodeBarcode("/Users/Andy-Chan/Desktop/1.pic.jpg");
        }  
        catch (Exception localException) {  
            localException.printStackTrace();  
        }  
    }  

    static void saveToJPEG(BufferedImage paramBufferedImage, String paramString) {  
        saveToFile(paramBufferedImage, paramString, "jpeg");  
    }  

    static void saveToFile(BufferedImage paramBufferedImage, String paramString1, String paramString2) {  
        try {  
            FileOutputStream localFileOutputStream = new FileOutputStream("/Users/Andy-Chan/Desktop/" + paramString1);  
            ImageUtil.encodeAndWrite(paramBufferedImage, paramString2, localFileOutputStream, 96, 96);  
            localFileOutputStream.close();  
        }  
        catch (Exception localException) {  
            localException.printStackTrace();  
        }  
    }  
    
    
    public static String decodeBarcode(String barcodePath){
        BufferedImage image;
        Result result = null;
        try {
            image = ImageIO.read(new File(barcodePath));
            if (image != null) {
                LuminanceSource source = new BufferedImageLuminanceSource(image);
                BinaryBitmap bitmap = new BinaryBitmap(new HybridBinarizer(source));
                result = new MultiFormatReader().decode(bitmap, null);
                System.out.println("result: "+result);
            }
            return result.getText();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

}