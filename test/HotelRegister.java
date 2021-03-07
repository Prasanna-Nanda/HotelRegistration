import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

class HotelsRegister {
    String hotelName;
    private int regularWeekDay;
    private int regularWeekEnd;
    private int rewardeeWeekDay;
    private int rewardeeWeekEnd;

    HotelsRegister(String name) {
        this.hotelName = name;
    }

    public int getRegularWeekDay() {
        return regularWeekDay;
    }

    public void setRegularWeekDay(int regularWeekDay) {
        this.regularWeekDay = regularWeekDay;
    }

    public int getRegularWeekEnd() {
        return regularWeekEnd;
    }

    public void setRegularWeekEnd(int regularWeekEnd) {
        this.regularWeekEnd = regularWeekEnd;
    }

    public int getRewardeeWeekDay() {
        return rewardeeWeekDay;
    }

    public void setRewardeeWeekDay(int rewardeeWeekDay) {
        this.rewardeeWeekDay = rewardeeWeekDay;
    }

    public int getRewardeeWeekEnd() {
        return rewardeeWeekEnd;
    }

    public void setRewardeeWeekEnd(int rewardeeWeekEnd) {
        this.rewardeeWeekEnd = rewardeeWeekEnd;
    }

    public String getHotelName() {
        return hotelName;
    }
}

class TestHotel {

    private static HotelsRegister x, y, z;

    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        String s = bf.readLine();

        x = new HotelsRegister("LakeWood");
        x.setRegularWeekDay(110);
        x.setRegularWeekEnd(90);
        x.setRewardeeWeekDay(80);
        x.setRewardeeWeekEnd(80);

        y = new HotelsRegister("RidgeWood");
        y.setRegularWeekDay(220);
        y.setRegularWeekEnd(150);
        y.setRewardeeWeekDay(100);
        y.setRewardeeWeekEnd(40);

        z = new HotelsRegister("BridgeWood");
        z.setRegularWeekDay(150);
        z.setRegularWeekEnd(50);
        z.setRewardeeWeekDay(110);
        z.setRewardeeWeekEnd(50);

        int index = s.indexOf(":");
        String type = s.substring(0, index);

        int cost_x = 0, cost_y = 0, cost_z = 0;
        int day_index_start = 0, day_index_end = 0;

        while (day_index_start != -1) {
            day_index_start = s.indexOf("(", day_index_start + 1);
            day_index_end = s.indexOf(")", day_index_end + 1);

            if (day_index_start != -1) {
                String day = s.substring(day_index_start + 1, day_index_end);
                if (day.equalsIgnoreCase("sun") || day.equalsIgnoreCase("sat")) {
                    if (type.equalsIgnoreCase("regular")) {
                        cost_x += x.getRegularWeekEnd();
                        cost_y += y.getRegularWeekEnd();
                        cost_z += z.getRegularWeekEnd();
                    } else {
                        cost_x += x.getRewardeeWeekEnd();
                        cost_y += y.getRewardeeWeekEnd();
                        cost_z += z.getRewardeeWeekEnd();
                    }
                } else {
                    if (type.equalsIgnoreCase("regular")) {
                        cost_x += x.getRegularWeekDay();
                        cost_y += y.getRegularWeekDay();
                        cost_z += z.getRegularWeekDay();
                    } else {
                        cost_x += x.getRewardeeWeekDay();
                        cost_y += y.getRewardeeWeekDay();
                        cost_z += z.getRewardeeWeekDay();
                    }
                }
            }
        }
        System.out.println(cost_x);
        System.out.println(cost_y);
        System.out.println(cost_z);

        String result = min(cost_x, cost_y, cost_z);
        System.out.println(result);
    }

    private static String min(int a, int b, int c) {
        if (a < b && a < c) {
            return x.getHotelName();
        } else if (b < a && b < c) {
            return y.getHotelName();
        } else if (c < a && c < b) {
            return z.getHotelName();
        } else if (a == b || b == c) {
            return y.getHotelName();
        } else if (c == a) {
            return z.getHotelName();
        } else {
            return x.getHotelName();
        }
    }

}
