package lambda;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/*
    流操作
 */
public class StreamDemo {
    // 通过数组来生产
    static void gen1(){
        String[] strs = {"a","b","c","d"};
        Stream<String> strs1 = Stream.of(strs);
        strs1.forEach(System.out::println);
    }

    // 通过集合来生成
    static void gen2(){
        List<String> list = Arrays.asList("a","b","c","d");
        final Stream<String> stream = list.stream();
        stream.forEach(System.out::println);
    }

    // 通过流自身的generate生成(注意自身生成的是无限个，需要使用limit进行限制)
    static void gen3(){
        final Stream<Integer> generate = Stream.generate(() -> new Random().nextInt(100));
        generate.limit(5).forEach(System.out::println);
    }

    // 使用流的iterator生成(也需要注意在使用的时候使用limit进行限制)
    static void gen4(){
        final Stream<Integer> iterate = Stream.iterate(1, x -> x + 1);
        iterate.limit(5).forEach(System.out::println);
    }

    // 其它方式
    static void gen5(){
        String str = "abcdefg";
        IntStream stream = str.chars();
        stream.forEach(System.out::println);
    }

    public static void main(String[] args) {
        // 生成流
//        generateStream();

        useStream();
    }

    // 创建流
    private static void generateStream(){
        // 通过数组，使用Stream.of来生成
        gen1();
        System.out.println("---------------");
        gen2();
        System.out.println("---------------");
        gen3();
        System.out.println("---------------");
        gen4();
        System.out.println("---------------");
        gen5();

    }

    // 使用流
    private static void useStream(){
        List<Integer> listInt= Arrays.asList(1,2,3,4,5,6,7,8,9);

        // 取出能被2整除的数据并打印
        listInt.stream().filter(x->x%2==0).forEach(System.out::println);
        // 求出所有偶数的和 (需要将基本流转化成IntStream，使用IntStream中的sum方法)
        System.out.println(listInt.stream().filter(x -> x % 2 == 0).mapToInt(x -> x).sum());
        // 求集合中的最大值
        System.out.println(listInt.stream().max((a, b) -> a - b).get());
        // 求集合中的最小值
        System.out.println(listInt.stream().min((a, b) -> a - b).get());
        // 获取集合中第一个偶数
        System.out.println(listInt.stream().filter(x -> x % 2 == 0).findAny().get());
        // 获取余数为6的第一个数
        System.out.println(listInt.stream().filter(x -> x % 10 == 6).findFirst().get());
        System.out.println("-------------------");
        // 查看filter的代码何时执行
        final Stream<Integer> integerStream = listInt.stream().filter(x -> {
            System.out.println("运行filter里面的代码");
            return x % 2 == 0;
        });
        System.out.println(integerStream.findAny().get());
        // 判断是不是所有的匹配
        System.out.println(listInt.stream().allMatch(x -> x > 5));
        System.out.println();

        final List<String> strings = Arrays.asList("java", "php", "javascript", "c#", "python", "c++");
        // 排序(默认自然排序)
        strings.stream().sorted().forEach(System.out::println);
        System.out.println("====sort after====");
        strings.stream().sorted((a,b) -> a.length() - b.length()).forEach(System.out::println);
        System.out.println("=======返回新集合========");
        // 对流进行过滤并返回一个新的集合对象
        final List<String> collect = strings.stream().filter(s -> s.length() > 3).collect(Collectors.toList());
        collect.forEach(System.out::println);

        // 去重
        System.out.println("======= 去重 =======");
        final List<Integer> listForDistinct = Arrays.asList(1, 3, 4, 5, 62, 3, 4, 6, 43, 6, 4, 3);
        listForDistinct.stream().distinct().forEach(System.out::println);
        listForDistinct.stream().collect(Collectors.toSet()).forEach(System.out::println);

        System.out.println("打印某一段数据");
        // 打印 20 - 30 这样的集合数据(使用skip和limit)
        Stream.iterate(0, x -> x + 1).skip(20).limit(11).forEach(System.out::println);

        System.out.println("==== 拆分字符串，然后做转换 ==== ");
        // 拆分字符串然后做相关操作
        String str = "1,2,3,4,5";
        System.out.println(Stream.of(str.split(",")).mapToInt(x -> Integer.valueOf(x)).sum());
        System.out.println(Stream.of(str.split(",")).mapToInt(Integer::valueOf).sum());
        System.out.println(Stream.of(str.split(",")).map(x -> Integer.valueOf(x)).mapToInt(x -> x).sum());
        System.out.println(Stream.of(str.split(",")).map(Integer::valueOf).mapToInt(x -> x).sum());
        // 将每一个值都打印出来，然后在求和
        System.out.println(Stream.of(str.split(",")).peek(System.out::println).mapToInt(Integer::valueOf).sum());

        // 使用对象
        String str2 = "java,php,python";
        Stream.of(str2.split(",")).map(s -> new StreamObject(s)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(StreamObject::new).forEach(System.out::println);
        Stream.of(str2.split(",")).map(s -> StreamObject.build(s)).forEach(System.out::println);
        Stream.of(str2.split(",")).map(StreamObject::build).forEach(System.out::println);
    }
}
