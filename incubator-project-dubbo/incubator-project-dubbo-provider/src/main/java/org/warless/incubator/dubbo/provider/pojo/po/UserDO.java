package org.warless.incubator.dubbo.provider.pojo.po;

import lombok.Data;
import org.apache.ibatis.type.Alias;

import java.util.Date;

/**
 * @author Noa Swartz
 * @version 1.0.0
 * @date 2019-10-11
 */
@Data
@Alias("User")
public class UserDO {

    private Long id;
    private String username;
    private String password;
    private Date birth;

}
