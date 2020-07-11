package _contest._biweekly._30;

/**
 * @Description: 重新格式化日期
 * <p>
 * 给定date形式的字符串  Day Month Year，其中：
 * <p>
 * Day 在集合中{"1st", "2nd", "3rd", "4th", ..., "30th", "31st"}。
 * Month 在集合中{"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"}。
 * Year 在范围内[1900, 2100]。
 * 将日期字符串转换为格式YYYY-MM-DD，其中：
 * <p>
 * YYYY 表示4位数的年份。
 * MM 表示两位数的月份。
 * DD 表示两位数的日期。
 * @Author: Pythagodzilla
 * @Date: 2020/7/11
 */

public class Solution1 {
    public static String reformatDate(String date) {
        StringBuilder sb = new StringBuilder();
        String[] strings = date.split(" ");
        sb.append(strings[2]);
        sb.append("-");
        String[] months = {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        String month = "";
        for (int i = 0; i < months.length; i++)
            if (strings[1].equals(months[i])) {
                month = i + 1 < 10 ? "0" + (i + 1) : "" + (i + 1);
                break;
            }
        sb.append(month);
        sb.append("-");
        String day = "";
        day = strings[0].length() < 4 ? "0" + strings[0].substring(0, 1) : strings[0].substring(0, 2);
        sb.append(day);
        return sb.toString();
    }

    public static void main(String[] args) {
        String date1 = "20th Oct 2052";
        String date2 = "6th Jun 1933";
        System.out.println(reformatDate(date1));//"2052-10-20"
        System.out.println(reformatDate(date2));//"1933-06-06"
    }
}
