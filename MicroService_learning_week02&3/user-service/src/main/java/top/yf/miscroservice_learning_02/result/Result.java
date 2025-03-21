package top.yf.miscroservice_learning_02.result;

import lombok.Builder;
import lombok.Data;
import top.yf.miscroservice_learning_02.entity.TUser;
@Data
@Builder
public class Result<T> {
    private  String code;
    private String message;
    private T data;
}
