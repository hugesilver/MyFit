public class Body {
    String gender; // 성별
    int topheight; // 상체 길에
    int bottomheight; // 하체 길이
    int shoulderwidth; // 어깨 너비
    int waistline; // 허리 둘레

    public Body(String gender, int topheight, int bottomheight, int shoulderwidth, int waistline){
        this.gender = gender;
        this.topheight = topheight;
        this.bottomheight = bottomheight;
        this.shoulderwidth = shoulderwidth;
        this.waistline = waistline;
    }
}
