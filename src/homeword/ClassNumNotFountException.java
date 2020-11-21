package homeword;

/*
    自定义一个异常类
 */
public class ClassNumNotFountException extends Exception{
    public ClassNumNotFountException(){
        System.out.println("课程号不存在");
    }

    public ClassNumNotFountException(String msg){
        System.out.println(msg);
    }
}
