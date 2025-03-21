package top.yf.requestservice.handler;

import com.alibaba.csp.sentinel.adapter.spring.webmvc.callback.BlockExceptionHandler;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.alibaba.csp.sentinel.slots.block.authority.AuthorityException;
import com.alibaba.csp.sentinel.slots.block.degrade.DegradeException;
import com.alibaba.csp.sentinel.slots.block.flow.FlowException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpStatus;

@Slf4j
public class SentinelException implements BlockExceptionHandler {

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, BlockException e) throws Exception {
        String msg="为止异常";
        int code = HttpStatus.SC_INTERNAL_SERVER_ERROR;
        log.error("Senyinel异常：",e);

        if(e instanceof FlowException){
            msg="被限流";
        }else if (e instanceof DegradeException){
            msg="被降级了";
        }else if (e instanceof AuthorityException){
        msg="无权限";
        }
        response.setContentType("application/json;charset=utf-8");
        response.setStatus(code);
        response.getWriter().println("{\"msg\": \"" + msg + "\", \"code\": " + code + "}");
    }
}
