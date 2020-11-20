package interfaces;

public class I9100Phone extends Phone implements Network, Photo, Video{
    public I9100Phone(String name, String type) {
        super("I9100", type);
    }


    @Override
    public void onNet() {
        System.out.println("上网");
    }

    @Override
    public void takePhoto() {
        System.out.println("拍照");
    }

    @Override
    public void playVideo() {
        System.out.println("播放视频");
    }
}
