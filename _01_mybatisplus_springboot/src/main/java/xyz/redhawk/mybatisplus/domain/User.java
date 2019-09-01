package xyz.redhawk.mybatisplus.domain;/**
 * @author RedHawk
 * @create 2019-08-31 13:45
 */

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.time.LocalDateTime;

/**
 * <Description> <br>
 *
 * @author redhawk<br>
 * @version 1.0<br>
 * @taskId: <br>
 * @createDate 2019/08/31 13:45 <br>
 * @see xzy.redhawk.mybatisplus.domain <br>
 */
@Data
@TableName("user")
public class User {
    //User 主键
    @TableId("id")
    private Long id;

    //姓名
    @TableField("name")
    private String name;
    //年龄
    private Integer age;
    //邮箱
    private String email;
    //直属上级
    private Long managerId;
    //创建时间
    private LocalDateTime createTime;


    // 排除非表字段演示
    //备注字段
    @TableField(exist=false)
    private  String remark;
}
