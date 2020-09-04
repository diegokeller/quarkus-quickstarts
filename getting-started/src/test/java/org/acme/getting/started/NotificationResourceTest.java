package org.acme.getting.started;

import io.quarkus.test.junit.QuarkusTest;
import io.quarkus.test.junit.mockito.InjectMock;
import io.restassured.http.ContentType;
import org.junit.jupiter.api.Test;

import java.util.logging.Logger;

import static io.restassured.RestAssured.given;
import static org.mockito.Mockito.*;

@QuarkusTest
public class NotificationResourceTest {

    @InjectMock
    NotificationService notificationService;

    @Test
    public void testHelloEndpoint() {
        Notification notification = new Notification("Teste");
        doAnswer(a -> {
            Notification notificacao = a.getArgument(0);
            Logger.getAnonymousLogger().info("Forjando envio de notificação: " + notificacao.getMessage());
            return null;
        })
        .when(notificationService)
        .send(any(Notification.class));

        given()
                .contentType(ContentType.JSON)
                .body(notification)
                .when().post("/notification")
                .then()
                .statusCode(204);
    }

}
