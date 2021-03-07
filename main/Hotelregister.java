
class HotelsTest {
    private final String hotelName;
    private final int regularWeekDay;
    private final int regularWeekEnd;
    private final int rewardeeWeekDay;
    private final int rewardeeWeekEnd;

    public HotelsTest(String hotelName, int regularWeekDay, int regularWeekEnd, int rewardeeWeekDay, int rewardeeWeekEnd) {
        this.hotelName = hotelName;
        this.regularWeekDay = regularWeekDay;
        this.regularWeekEnd = regularWeekEnd;
        this.rewardeeWeekDay = rewardeeWeekDay;
        this.rewardeeWeekEnd = rewardeeWeekEnd;
    }

    public String getHotelName() {
        return hotelName;
    }

    public int getRegularWeekDay() {
        return regularWeekDay;
    }

    public int getRegularWeekEnd() {
        return regularWeekEnd;
    }

    public int getRewardeeWeekDay() {
        return rewardeeWeekDay;
    }

    public int getRewardeeWeekEnd() {
        return rewardeeWeekEnd;
    }
}
