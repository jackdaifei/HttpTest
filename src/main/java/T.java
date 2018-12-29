import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileOutputStream;
import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;

/**
 * Created by wintech
 * Date: 2018/12/12
 */
public class T {

    /**
     * 图片添加水印
     *
     * @param srcImgPath       需要添加水印的图片的路径
     * @param outImgPath       添加水印后图片输出路径
     * @param fontType         水印文字的字体
     * @param fontStyle        水印文字的字体份风格
     * @param markContentColor 水印文字的颜色
     * @param fontSize         水印的文字的大小
     * @param waterMarkContent 水印的文字内容
     */
    public void waterPress(String srcImgPath, String outImgPath, String fontType, int fontStyle, Color markContentColor, int fontSize, String waterMarkContent) {
        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);
            Image srcImg = null;
            if (srcImgFile.exists() && srcImgFile.isFile() && srcImgFile.canRead()) {
                srcImg = ImageIO.read(srcImgFile);
            }
            // 宽、高
            int srcImgWidth = srcImg.getWidth(null);
            int srcImgHeight = srcImg.getHeight(null);
            // 加水印
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TYPE_INT_RGB);
            Graphics2D g = bufImg.createGraphics();
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);
            Font font = new Font(fontType, fontStyle, fontSize);
            //设置水印颜色
            g.setColor(markContentColor);
            g.setFont(font);
            // 抗锯齿
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
            int fontLength = getContentLength(waterMarkContent, g);
            // 实际生成的水印文字，实际文字行数
            Double textLineCount = Math.ceil(Integer.valueOf(fontLength).doubleValue() / Integer.valueOf(srcImgWidth).doubleValue());
            // 实际所有的水印文字的高度
            int textHeight = textLineCount.intValue() * fontSize;
            // 相对与X的起始的位置
            int originX = 0;
            // 相对与Y的起始的位置
            int originY = 0;

            // 实际文字大于1行，则x则为默认起始0，
            if (1 == textLineCount.intValue()) {
                // 实际文字行数是1，1/2个图片高度，减去1/2个字符高度
                originY = (320 / 2 - fontSize / 2) + 2140;
                // 实际文字行数是1，计算x的居中的起始位置
                originX = (srcImgWidth - fontLength) / 2;
            } else {
                // 实际文字行数大于1，1/2个图片高度减去文字行数所需的高度
                originY = (srcImgHeight - textHeight) / 2;
            }
            System.out.println("水印文字总长度:" + fontLength + ",图片宽度:" + srcImgWidth + ",字符个数:" + waterMarkContent.length());
            //文字叠加,自动换行叠加
            int tempX = originX;
            int tempY = originY;
            int tempCharLen = 0;//单字符长度
            int tempLineLen = 0;//单行字符总长度临时计算
            StringBuffer stringBuffer = new StringBuffer();
            for (int i = 0; i < waterMarkContent.length(); i++) {
                char tempChar = waterMarkContent.charAt(i);
                tempCharLen = getCharLen(tempChar, g);
                if (tempLineLen >= srcImgWidth) {
                    // 绘制前一行
                    g.drawString(stringBuffer.toString(), tempX, tempY);
                    //清空内容,重新追加
                    stringBuffer.delete(0, stringBuffer.length());
                    //文字长度已经满一行,Y的位置加1字符高度
                    tempY = tempY + fontSize;
                    tempLineLen = 0;
                }
                //追加字符
                stringBuffer.append(tempChar);
                tempLineLen += tempCharLen;
            }
            //最后叠加余下的文字
            g.drawString(stringBuffer.toString(), tempX, tempY);
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "jpg", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void a(String srcImgPath, String outImgPath, String fontType, int fontStyle, Color contentColor, int fontSize, List<String> waterMarkContent) {
        try {
            // 读取原图片信息
            File srcImgFile = new File(srcImgPath);
            Image srcImg = null;
            if (srcImgFile.exists() && srcImgFile.isFile() && srcImgFile.canRead()) {
                srcImg = ImageIO.read(srcImgFile);
            }
            // 宽、高
            int srcImgWidth = srcImg.getWidth(null);
            int srcImgHeight = srcImg.getHeight(null);
            // 创建图片缓冲对象, 透明背景
            BufferedImage bufImg = new BufferedImage(srcImgWidth, srcImgHeight, BufferedImage.TRANSLUCENT);
            Graphics2D g = bufImg.createGraphics();
            // 将原始图片画到缓冲图片中
            g.drawImage(srcImg, 0, 0, srcImgWidth, srcImgHeight, null);

            // 设置文字样式
            Font font = new Font(fontType, fontStyle, fontSize);
            // 设置画笔颜色
            g.setColor(contentColor);
            // 设置画笔字体
            g.setFont(font);
            // 抗锯齿
            g.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

            // 相对与X的起始的位置
            int originX = 0;
            // 相对与Y的起始的位置
            int originY = 625;

            for (String content : waterMarkContent) {
                // 获取文字宽度
                int fontLength = getContentLength(content, g);
                // 计算x坐标
                originX = (srcImgWidth - fontLength) / 2;
                // 最后叠加余下的文字
                g.drawString(content, originX, originY);
                // 写完一行字后增加两行字高度
                originY += 24 * 2;
            }
            g.dispose();
            // 输出图片
            FileOutputStream outImgStream = new FileOutputStream(outImgPath);
            ImageIO.write(bufImg, "png", outImgStream);
            outImgStream.flush();
            outImgStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int getCharLen(char c, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charWidth(c);
    }

    /**
     * 获取水印文字总长度(px)
     * @param content
     * @param g
     * @return
     */
    public int getContentLength(String content, Graphics2D g) {
        return g.getFontMetrics(g.getFont()).charsWidth(content.toCharArray(), 0, content.length());
    }


    public static void main(String[] args) {
        LocalDateTime beginTime = LocalDateTime.now();
        // 原图位置, 输出图片位置, 水印字体，水印文字样式，水印文字颜色, 水印文字大小，水印文字内容
        String fontType = "PingFang HK";
        int fontStyle = Font.BOLD;
        int fontSize = 24;
        List<String> contentList = Arrays.asList("2018我在多点总花费1000元，省下了100元", "2019，继续做货来伸手的掌上明“猪”", "超市躺着逛  大奖躺着赢");
       /* String font = "印效果测水印效果整水印效果 ";*/
        Color color = new Color(184, 101, 11);

//        new T().waterPress("1.jpg", "2.jpg", fontType, fontStyle, color, fontSize, font);
        new T().a("111.png", "2.png", fontType, fontStyle, color, fontSize, contentList);
        Long timeConsuming = Duration.between(beginTime, LocalDateTime.now()).toMillis();
        System.out.println(timeConsuming);
    }

}
