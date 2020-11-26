package homeword.collection;

import java.util.*;

/*
    定义一个Worker类，属性：
        name:String     age:int     salary:double
    1. 把若干Worker对象放在List中，排序并遍历输出，按照age升序排列
    2. 把若干Worker对象放在Set中，并遍历，要求没有重复元素
    3. 把若干Worker对象放在Map中并按照三种方式分别遍历，要求以Worker的姓名作为Key
 */
public class Work03 {
    public static void main(String[] args){
        // 创建数据
        Worker[] workers = {
            new Worker("普通员工", 25, 5000.0),
            new Worker("临时工", 22, 2000.0),
            new Worker("主管", 30, 10000.0),
            new Worker("组长", 28, 8000.0),
            new Worker("经理", 32, 12000.0),
        };

        // list操作
        listDemo(workers);

        // set操作
        setDemo(workers);
        
        // map操作
        mapDemo(workers);
    }

    /*
        map操作
            把若干Worker对象放在Map中并按照三种方式分别遍历，要求以Worker的姓名作为Key
     */
    private static void mapDemo(Worker[] workers) {
        System.out.println("==========mapDemo============");
        HashMap<String, Worker> stringWorkerHashMap = new HashMap<>();
        // 添加数据
        for (Worker worker:workers){
            stringWorkerHashMap.put(worker.getName(), worker);
        }

        System.out.println("第一种使用方法keySet()");
        Set<String> strings = stringWorkerHashMap.keySet();
        for(String string:strings){
            System.out.println(string + " = " + stringWorkerHashMap.get(string));
        }
        System.out.println();

        System.out.println("第二种使用方法entrySet()");
        Set<Map.Entry<String, Worker>> entries = stringWorkerHashMap.entrySet();
        for (Iterator<Map.Entry<String, Worker>> iterator = entries.iterator();iterator.hasNext();){
            Map.Entry<String, Worker> entry = iterator.next();
            System.out.println(entry.getKey() + " = " + entry.getValue());
        }
        System.out.println();

        System.out.println("第三种使用方法values()");
        Collection<Worker> values = stringWorkerHashMap.values();
        for (Worker workder:values){
            System.out.println(workder);
        }
    }

    /*
        Set操作
            把若干Worker对象放在Set中，并遍历，要求没有重复元素
     */
    private static void setDemo(Worker[] workers) {
        System.out.println("=============SetDemo================");
        HashSet<Worker> hs=  new HashSet<Worker>();
        for (Worker worker : workers) {
            hs.add(worker);
        }
        System.out.println(hs);

        // 添加重复元素(判断重复是通过对象的 equals 和 hashCode 方法来进行判断的)
        hs.add(new Worker("普通员工",25,5000.0));

        System.out.println("添加重复员工后");
        for (Iterator<Worker> iterator = hs.iterator(); iterator.hasNext();){
            System.out.println((Worker)iterator.next());
        }

        System.out.println();
    }

    /*
        list操作
            把若干Worker对象放在List中，排序并遍历输出，按照age升序排列
     */
    private static void listDemo(Worker[] workers) {
        System.out.println("===============listDemo===============");
        ArrayList<Worker> workerList = new ArrayList<>();
        for (Worker worker : workers) {
            workerList.add(worker);
        }
        System.out.println("未排序");
        System.out.println(workerList);

        Collections.sort(workerList);
        System.out.println("排序后");
        for (Iterator iterator = workerList.iterator(); iterator.hasNext();){
            System.out.println((Worker)iterator.next());
        }
        System.out.println();
    }
}
