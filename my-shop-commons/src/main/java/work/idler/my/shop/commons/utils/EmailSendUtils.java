package work.idler.my.shop.commons.utils;

import org.apache.commons.mail.Email;
import org.apache.commons.mail.EmailException;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * 邮件发送工具类
 * @Auther:http://blog.idler.work
 * @Date:2019/4/19
 * @Description:work.idler.my.shop.commons.utils
 * @version:1.0
 */
public class EmailSendUtils {

    @Autowired
    private Email email;

    public void send(String subject, String msg, String... to) throws EmailException {
        email.setSubject(subject);
        email.setMsg(msg);
        email.addTo(to);
        email.send();
    }
}
