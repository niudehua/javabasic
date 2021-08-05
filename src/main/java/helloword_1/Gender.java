
package helloword_1;


/**
 * @author:deng
 * @date: 2019/7/30
 * @time: 10:23 PM
 * @email 657563945@qq.com
 * 枚举
 */
public enum Gender {
    /**
     * 性别
     */
    MAN(0), WOMEN(1);

    Gender(Integer gender) {
        this.gender = gender;
    }

    private final Integer gender;

    public Integer getGender() {
        return gender;
    }
}




