package xyz.redhawk.mybatisplus.enums;

import com.alibaba.fastjson.annotation.JSONType;
import com.baomidou.mybatisplus.core.enums.IEnum;

/**
 * @Description： 用户逻辑删除状态枚举类
 * @author: liping
 * @Date: 2019/11/28 20:19
 */
@JSONType(serializeEnumAsJavaBean = true)
public enum UserIsDeleted implements IEnum<Integer> {

    // 已删除
    USER_IS_DELETED(1, "已删除"),
    // 正常使用
    USER_NOT_DELETED(0, "正常");

    private Integer value;
    private String desc;

    UserIsDeleted(Integer value, String desc) {
        this.value = value;
        this.desc = desc;
    }


    @Override
    public Integer getValue() {
        return value;
    }
}
