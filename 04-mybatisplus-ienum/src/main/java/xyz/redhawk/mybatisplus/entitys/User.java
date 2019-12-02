package xyz.redhawk.mybatisplus.entitys;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.extension.activerecord.Model;
import xyz.redhawk.mybatisplus.enums.UserIsDeleted;

import java.io.Serializable;

/**
 * <p>
 *
 * </p>
 *
 * @author liping404
 * @since 2019-11-28
 */
public class User extends Model<User> {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    private String username;

    private String password;

    @TableField("roleId")
    private Integer roleId;

    /**
     * 用户状态: 1: 锁定; 0: 正常
     */
    @TableField("isDeleted")
    private UserIsDeleted isDeleted;


    public Integer getId() {
        return id;
    }

    public User setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUsername() {
        return username;
    }

    public User setUsername(String username) {
        this.username = username;
        return this;
    }

    public String getPassword() {
        return password;
    }

    public User setPassword(String password) {
        this.password = password;
        return this;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public User setRoleId(Integer roleId) {
        this.roleId = roleId;
        return this;
    }

    public UserIsDeleted getIsDeleted() {
        return isDeleted;
    }

    public void setIsDeleted(UserIsDeleted isDeleted) {
        this.isDeleted = isDeleted;
    }

    @Override
    protected Serializable pkVal() {
        return this.id;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", roleId=" + roleId +
                ", isDeleted=" + isDeleted.getValue() +
                '}';
    }
}
