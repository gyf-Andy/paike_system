package com.gyf.tools;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.Random;

public class VerificationCode {

    // 验证码字符集
    private static final char[] chars = {
            '0', '1', '2', '3', '4', '5', '6', '7', '8', '9',
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N',
            'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z'};

    //验证码图片上的字符数量
    private static final int SIZE=4;
    //干扰线数量
    private static final int LINES=10;
    //图片宽度
    private static final int WIDTH = 100;
    //图片高度
    private static final int HEIGHT = 32;
    //字体大小
    private static final int FONT_SIZE = 20;

    /**
     * 对验证码图片进行绘制
     * @return
     */

    public static Object[] createImage(){
        StringBuffer sb=new StringBuffer();
        //创建空白图片
        BufferedImage image=new BufferedImage(WIDTH,HEIGHT,BufferedImage.TYPE_INT_BGR);
        //获取图片画笔
        Graphics graphics=image.createGraphics();
        //设置画笔颜色
        graphics.setColor(Color.LIGHT_GRAY);
        //绘制矩形背景
        graphics.fillRect(0,0,WIDTH,HEIGHT);
        //画随机字符
        Random random=new Random();
        for(int i=0;i<SIZE;i++){
            //取随机字符索引
            int index=random.nextInt(chars.length);
            //设置随机颜色
            graphics.setColor(getRandomColor());
            //设置字体大小
            graphics.setFont(new Font(null, Font.BOLD + Font.ITALIC, FONT_SIZE));
            //画字符
            graphics.drawString(chars[index]+"",i*WIDTH/4,HEIGHT/2);
            // 记录字符
            sb.append(chars[index]);
        }

        // 6.画干扰线
        for (int i = 0; i < LINES; i++) {

            graphics.setColor(getRandomColor());
            // 随机画线
            graphics.drawLine(random.nextInt(WIDTH), random.nextInt(HEIGHT),
                    random.nextInt(WIDTH), random.nextInt(HEIGHT));
        }
        // 7.返回验证码和图片
        return new Object[]{sb.toString(), image};
    }

    /**
     * 随机取色
     */
    public static Color getRandomColor() {
        Random ran = new Random();
        Color color = new Color(ran.nextInt(256),
                ran.nextInt(256), ran.nextInt(256));
        return color;
    }

}
