package hu.schonherz.training.venue.service;

import hu.schonherz.training.venue.vo.Sendable;

public interface MailService {
    void send(Sendable mail);
}
