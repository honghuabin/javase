package interfaces;

/*
    锁接口
        开锁
        关锁
 */
public interface Lock {
    // 开锁
    public abstract void openLock();

    // 关锁
    public abstract void closeLock();
}
