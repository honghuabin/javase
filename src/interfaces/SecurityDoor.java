package interfaces;

/*
    防盗门
        继承门这个抽象类
        实现锁这个接口
 */
public class SecurityDoor extends Door implements Lock{
    @Override
    public void openDoor(){
        System.out.println("开门");
    }

    @Override
    public void openLock(){
        System.out.println("开锁");
    }

    @Override
    public void closeDoor(){
        System.out.println("关门");
    }

    @Override
    public void closeLock(){
        System.out.println("关锁");
    }

    public static void main(String[] args){
        SecurityDoor securityDoor = new SecurityDoor();
        securityDoor.openDoor();
        securityDoor.openLock();
        securityDoor.closeDoor();
        securityDoor.closeLock();
    }
}
