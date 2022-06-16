import Topinfo.Adidas001;
import Topinfo.Nike001;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.LocalDateTime; // 시스템 시간 import
import java.time.format.DateTimeFormatter; // 시간 포맷 import

public class MakeBody{
    public MakeBody(String gender,int topheight, int bottomheight, int shoulderwidth, int waistline, String what) throws IOException {
        Nike001 nike001 = new Nike001();
        Adidas001 adidas001 = new Adidas001();

        // Body 이미지 파일 디렉토리
        String image_head = "src/img/body_head.png";
        String image_top = "src/img/body_top.png";
        String image_bot = "src/img/body_bot.png";

        // 이미지 가져오기
        Image body_head = ImageIO.read(new File(image_head));
        Image body_top = ImageIO.read(new File(image_top));
        Image body_bot = ImageIO.read(new File(image_bot));
        Image 나이키001 = ImageIO.read(new File(nike001.getPath()));
        Image 아디다스001 = ImageIO.read(new File(adidas001.getPath()));

        // 이미지 리사이즈
        Image temp_body_head = body_head.getScaledInstance(50, 85, Image.SCALE_DEFAULT);
        Image temp_body_top = body_top.getScaledInstance(150 + shoulderwidth, (110 + topheight) + 80, Image.SCALE_DEFAULT);
        Image temp_body_bot = body_bot.getScaledInstance(55 + waistline, 243 + bottomheight, Image.SCALE_DEFAULT);

        Image temp_나이키001 = 나이키001.getScaledInstance(170 + nike001.getShoulderwidth(),100 + nike001.getHeight(), Image.SCALE_DEFAULT);
        Image temp_아디다스001 = 아디다스001.getScaledInstance(170 + adidas001.getShoulderwidth(),100 + adidas001.getHeight(), Image.SCALE_DEFAULT);

        // 캔버스 폭 값
        int image_width = 500;

        // 이미지 합성
        BufferedImage mergedImage = new BufferedImage(image_width, 650, BufferedImage.TYPE_INT_RGB);
        Graphics2D graphics = (Graphics2D)mergedImage.getGraphics();

        // 폰트 설정
        graphics.setFont(graphics.getFont().deriveFont(14f));

        //투명도 있는 이미지 합성 설정
        float alpha = 0.95f;
        AlphaComposite ac = AlphaComposite.getInstance(AlphaComposite.SRC_OVER, alpha);
        Graphics2D graphics_alpha = (Graphics2D)mergedImage.getGraphics();
        graphics_alpha.setComposite(ac);

        graphics.drawImage(temp_body_head, (image_width - temp_body_head.getWidth(null)) / 2, 15, null);
        graphics.drawImage(temp_body_top, (image_width - temp_body_top.getWidth(null)) / 2, 85, null);
        graphics.drawImage(temp_body_bot, (image_width - temp_body_bot.getWidth(null)) / 2, (100 + topheight) + 85, null);
        graphics.drawString("성별 : " + gender,10, 485);

        if(what.equals("나이키001")){
            graphics_alpha.drawImage(temp_나이키001, (image_width - temp_나이키001.getWidth(null)) / 2, 85, null);
            graphics.drawString("상품명 : " + nike001.getName(),10, 520);
            graphics.drawString("사이즈 : " + nike001.getSize(),10, 555);
            if(shoulderwidth + 3 < nike001.getShoulderwidth() || topheight + 3 < nike001.getHeight()){
                graphics.drawString("착용감 : ⚠️ 너무 큼",10, 590);
            }
            else if(shoulderwidth > nike001.getShoulderwidth() || topheight > nike001.getHeight()){
                graphics.drawString("착용감 : ❌ 너무 작음",10, 590);
            }
            else{
                graphics.drawString("착용감 : ✅ 적당함",10, 590);
            }
        }
        else if(what.equals("아디다스001")){
            graphics_alpha.drawImage(temp_아디다스001, (image_width - temp_아디다스001.getWidth(null)) / 2, 85, null);
            graphics.drawString("상품명 : " + adidas001.getName(),10, 520);
            graphics.drawString("사이즈 : " + adidas001.getSize(),10, 555);
            if(shoulderwidth + 3 < adidas001.getShoulderwidth() || topheight + 3 < adidas001.getHeight()){
                graphics.drawString("착용감 : ⚠️ 너무 큼",10, 590);
            }
            else if(shoulderwidth > adidas001.getShoulderwidth() || topheight > adidas001.getHeight()){
                graphics.drawString("착용감 : ❌ 너무 작음",10, 590);
            }
            else{
                graphics.drawString("착용감 : ✅ 적당함",10, 590);
            }
        }
        else{
            System.out.println("의상 정보를 찾지 못했습니다.");
            graphics.drawString("정보 : ❌ 알 수 없음",10, 590);
        }

        // 사진 창 띄우기
        ImageIcon imageicon = new ImageIcon(mergedImage);
        JFrame jframe = new JFrame();
        jframe.setLayout(new FlowLayout());
        jframe.setSize(mergedImage.getWidth(), mergedImage.getHeight());

        JLabel jlabel = new JLabel();
        jlabel.setIcon(imageicon);
        jframe.add(jlabel);
        jframe.setVisible(true);
        jframe.setDefaultCloseOperation(jframe.EXIT_ON_CLOSE);

        graphics.dispose();

        // 사진 저장
        LocalDateTime now = LocalDateTime.now();
        String datenow = now.format(DateTimeFormatter.ofPattern("yyyy-MM-dd-HH-mm-ss"));
        ImageIO.write(mergedImage, "png", new File("src/img/temp/" + datenow + ".png"));
    }
}