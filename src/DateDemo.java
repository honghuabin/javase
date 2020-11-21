import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Calendar;

/*
    时间操作示例
        java.util.Date; 日期类
        java.text.SimpleDateFormat; 与日期类联合使用，用来进行格式化
        java.util.Calendar; 日历类

    作业：
        根据用户收入的时间，生成该月的日历
 */
public class DateDemo {
    public static void main(String[] args) {
        dateDemo();
        System.out.println("==============");

        calendarDemo();
    }

    /*
        日历类
            获取对象的方式：Calendar.getInstance();
     */
    private static void calendarDemo() {
        Calendar calendar = Calendar.getInstance();
        System.out.println(calendar);

        // 获取当前时间，格式    年-月-日 时:分:秒
        // 设置时间格式
//        calendar.set();
        System.out.println(calendar.getTime());
        // 获取年
        System.out.println(String.format("%d-%d-%d %d:%d:%d",
                calendar.get(Calendar.YEAR)
                ,calendar.get(Calendar.MONTH) + 1
                ,calendar.get(Calendar.DAY_OF_MONTH)
                ,calendar.get(Calendar.HOUR_OF_DAY)
                ,calendar.get(Calendar.MINUTE)
                ,calendar.get(Calendar.SECOND)));
    }

    /*
        日期类
            常用方法：getTime()  获取当前毫秒时间
     */
    private static void dateDemo() {
        Date date = new Date();
        // 获取当前毫秒时间
        long time = date.getTime();
        System.out.println(time);

        // 初始化日期格式化对象
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("y-MM-dd HH:mm:ss");
        // 将date按照格式化的方式进行输出
        String format = simpleDateFormat.format(date);
        System.out.println(format);

        // 将指定时间戳转化为日期
        try {
            Date parse = simpleDateFormat.parse("2020-11-21 17:20:27");
            System.out.println(parse);
        } catch (ParseException e) {
            e.printStackTrace();
        }
    }
}
