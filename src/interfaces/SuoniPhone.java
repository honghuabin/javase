package interfaces;

public class SuoniPhone extends Phone implements Music{
    public SuoniPhone(String brand, String type) {
        super("索尼爱立信", type);
    }

    @Override
    public void startMusic() {
        System.out.println("播放音乐");
    }

    @Override
    public void stopMusic(){
        System.out.println("暂停播放音乐");
    }
}
