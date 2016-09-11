package hu.schonherz.training.venue.service.impl;

import hu.schonherz.training.venue.service.MailService;
import hu.schonherz.training.venue.vo.Sendable;
import hu.schonherz.training.venue.vo.SimpleMailVo;
import org.springframework.mail.MailException;
import org.springframework.mail.MailSender;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;

import javax.ejb.Local;
import javax.ejb.Stateless;

@Stateless(name = "MailService", mappedName = "MailService")
@Local(MailService.class)
public class MailServiceImpl implements MailService {

    private MailSender mailSender = new JavaMailSenderImpl();
    private SimpleMailMessage message = new SimpleMailMessage();

    @Override
    public void send(Sendable mail) {
        message.setFrom("organizer@con.org");
        message.setTo(mail.getToEmailAddress());
        if (mail instanceof SimpleMailVo) {
            message.setText("Dear " + ((SimpleMailVo) mail).getReceiverName() + "!" +
                    ((SimpleMailVo) mail).getBandProfileLink() +
                    ((SimpleMailVo) mail).getAcceptationLink() +
                    ((SimpleMailVo) mail).getRejectionLink()
            );
        } else {
            message.setText("empty");
        }
        try {
            this.mailSender.send(message);
        } catch (MailException ex) {
            ex.printStackTrace();
        }
    }
}
