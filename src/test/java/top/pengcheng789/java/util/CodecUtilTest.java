package top.pengcheng789.java.util;

import org.junit.Test;
import top.pengcheng789.java.springblog.util.CodecUtil;

/**
 * CreateDate:2017-08-10
 *
 * @author pen
 */
public class CodecUtilTest {

    @Test
    public void shouldEncodeStringByMd5() {
        System.out.println(CodecUtil.md5("123456"));
    }
}
