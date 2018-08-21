package com.lc.springcloud.pojo;


/**
 * Created by Liang on 2016/12/22.
 */
import javax.persistence.*;

@Entity
@Table(name="t_user_info"  )
public class UserInfo {

    /**
     * 用户ID
     */
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="user_id", length = 16)
    private Long userId;


    /**
     * 注册时间
     */
    @Column(name="create_time",columnDefinition=" bigint(13) COMMENT '注册时间' ")
    private Long createTime = System.currentTimeMillis();

    /**
     * 用户呢称
     */
    @Column(name="user_name",columnDefinition="  varchar(255) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户名' ")
    private String userName;


    /**
     * 登陆密码
     */
    @Column(name="password",columnDefinition=" varchar(32) CHARACTER SET utf8 COLLATE utf8_bin DEFAULT NULL COMMENT '用户密码' ")
    private String password;



    public UserInfo() {
    }



    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Long createTime) {
        this.createTime = createTime;
    }
}
