package xyz.redhawk.mybatisplus.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableLogic;
import com.baomidou.mybatisplus.annotation.TableField;
import java.io.Serializable;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;
import xyz.redhawk.mybatisplus.enums.UserIsDeleted;

import javax.validation.constraints.NotNull;

/**
 * <p>
 *
 * </p>
 *
 * @author liping404
 * @since 2019-12-10
 */
@Data
@EqualsAndHashCode(callSuper = false)
@Accessors(chain = true)
@ApiModel(value="User对象", description="")
public class User extends Model<User> {

    private static final long serialVersionUID=1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @NotNull
    @TableField("username")
    private String username;

    @TableField("password")
    private String password;

    @TableField("roleId")
    private Integer roleId;

    @ApiModelProperty(value = "用户状态: 1: 锁定; 0: 正常")
    @TableLogic
    @TableField("isDeleted")
    private UserIsDeleted isDeleted;


    @Override
    protected Serializable pkVal() {
        return this.id;
    }

}
