package org.acme.getting.started;

import javax.enterprise.context.ApplicationScoped;
import java.util.logging.Logger;

@ApplicationScoped
public class NotificationService {

    public void send(Notification notification) {
        Logger.getAnonymousLogger().info(
                String.format("%s %s", "Enviando notificação pelo serviço: ", notification.getMessage()));
    }

}
