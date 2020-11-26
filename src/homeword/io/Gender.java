package homeword.io;

/*
    性别
 */
public enum Gender {
    GENDER_MAN(1), GENDER_WOMAN(2);
    private int id;
    private String name;

    Gender(int id){
        switch (id){
            case 1:
                this.name = "男";
                break;
            case 2:
                this.name = "女";
                break;
            default:
                System.out.println("参数异常");
        }
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static Gender getGender(int id){
        for (Gender gender: Gender.values()) {
            if (gender.getId() == id){
                return gender;
            }
        }
        System.out.println("未找到相关数据");
        return null;
    }
}
