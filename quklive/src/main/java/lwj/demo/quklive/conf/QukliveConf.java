package lwj.demo.quklive.conf;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

import lombok.Data;

/**
 * 配置类
 *
 * @author liuweijia
 * @date 2018年1月31日 下午3:40:54 
 * @since 2.0.0
 */
@Configuration
@Component
@Data
public class QukliveConf {

    //@Value("${image.handle.watermark}")
    //private String imageHandleWatermark;
}
