package com.henu.utils;

import java.awt.Image;
import java.awt.Rectangle;
import java.awt.geom.AffineTransform;
import java.awt.image.AffineTransformOp;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Iterator;

import javax.imageio.ImageIO;
import javax.imageio.ImageReadParam;
import javax.imageio.ImageReader;
import javax.imageio.stream.ImageInputStream;

public class ImageUtil {
	/**
	 * 根据尺寸图片居中裁剪
	 * 
	 * @param in	 流
	 * @param dest	 文件存储位置
	 * @param w  	 宽
	 * @param h		 高
	 * @param formatname 文件后缀名
	 * @return
	 * @throws IOException
	 */
	public static Boolean cutCenterImage(InputStream in, String dest, int w, int h, String formatname)
			throws IOException {

		Iterator<ImageReader> iterator = ImageIO.getImageReadersByFormatName(formatname);
		ImageReader reader = (ImageReader) iterator.next();
		ImageInputStream iis = ImageIO.createImageInputStream(in);
		reader.setInput(iis, true);
		ImageReadParam param = reader.getDefaultReadParam();
		int imageIndex = 0;
		Rectangle rect = new Rectangle((reader.getWidth(imageIndex) - w) / 2, (reader.getHeight(imageIndex) - h) / 2, w,
				h);
		param.setSourceRegion(rect);
		BufferedImage bi = reader.read(0, param);
		return ImageIO.write(bi, formatname, new File(dest));
	}

	/**
	 * <p>
	 * description：根据尺寸图片居中裁剪 ,返回文件流
	 * </p>
	 * 
	 * @author zhanglixin
	 * @createtime 2017年1月13日下午2:05:55
	 * @param in  流
	 * @param dest  文件存储位置
	 * @param w   宽
	 * @param h  高
	 * @param formatname  文件后缀名
	 * @return
	 * @throws IOException
	 */
	public static InputStream cutCenterImageStream(InputStream in, String dest, int w, int h, String formatname)
			throws IOException {
		if (cutCenterImage(in, dest, w, h, formatname)) {
			File imagefile = new File(dest);
			;
			InputStream ins = new FileInputStream(imagefile);
			return ins;
		}
		return null;
	}

	/**
	 * 根据图片规定尺寸缩放
	 * 
	 * @param in  文件流
	 * @param dest 存储位置
	 * @param w  宽
	 * @param h  高
	 * @return
	 * @throws Exception
	 */
	public static Boolean zoomImage(InputStream in, String dest, int w, int h) throws Exception {

		double wr = 0, hr = 0;
		File destFile = new File(dest);
		BufferedImage bufImg = ImageIO.read(in);
		Image Itemp = bufImg.getScaledInstance(w, h, Image.SCALE_SMOOTH);
		wr = w * 1.0 / bufImg.getWidth();
		hr = h * 1.0 / bufImg.getHeight();
		AffineTransformOp ato = new AffineTransformOp(AffineTransform.getScaleInstance(wr, hr), null);
		Itemp = ato.filter(bufImg, null);
		try {
			ImageIO.write((BufferedImage) Itemp, dest.substring(dest.lastIndexOf(".") + 1), destFile);
			return true;
		} catch (Exception ex) {
			ex.printStackTrace();
			return false;
		}
	}
}
