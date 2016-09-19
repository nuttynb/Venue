package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.service.MailService;
import hu.schonherz.training.venue.vo.OrganizingMailVo;
import hu.schonherz.training.venue.vo.Sendable;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ejb.interceptor.SpringBeanAutowiringInterceptor;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;

import javax.ejb.Local;
import javax.ejb.Stateless;
import javax.interceptor.Interceptors;

@Stateless(name = "MailService", mappedName = "MailService")
@Local(MailService.class)
@Interceptors({SpringBeanAutowiringInterceptor.class})
public class MailServiceImpl implements MailService {
    @Autowired
    private MailSender mailSender;

    private static final Logger LOG = LoggerFactory.getLogger(MailServiceImpl.class);

    @Override
    public void send(Sendable mail) {
        SimpleMailMessage message = new SimpleMailMessage();
        message.setFrom("concertorganizer@gmail.com");
        message.setTo(mail.getToEmailAddress());
        message.setSubject("ConOrg - Organizing");
        if (mail instanceof OrganizingMailVo) {
            message.setText(getText((OrganizingMailVo) mail));
        } else {
            message.setText("empty");
        }
        try {
            this.mailSender.send(message);
        } catch (MailException ex) {
            LOG.error(ex.toString());
        }
    }

    private String getText(OrganizingMailVo mail) {
        StringBuffer text = new StringBuffer();
        text.append("<!DOCTYPE html PUBLIC \"-//W3C//DTD XHTML 1.0 Transitional//EN\" \"http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd\"><html xmlns=\"http://www.w3.org/1999/xhtml\"><head><meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\" /></head><body><div>");
        text.append("Dear ").append(mail.getReceiverName()).append("!<br/><br/>");
        text.append(mail.getBandProfileLink()).append("<br/>");
        text.append(mail.getAcceptationLink()).append("<br/>");
        text.append(mail.getRejectionLink()).append("<br/><br/>");
        text.append("Sincerely,<br/>ConOrg Team</div></body></html>");
        return text.toString();
    }
}
