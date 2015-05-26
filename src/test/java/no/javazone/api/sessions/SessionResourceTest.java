package no.javazone.api.sessions;

import com.google.common.collect.Lists;
import io.dropwizard.testing.junit.ResourceTestRule;
import no.javazone.ems.EmsAdapter;
import no.javazone.sessions.*;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.GenericType;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class SessionResourceTest {

    private static final EmsAdapter mock = mock(EmsAdapter.class);

    private static final SessionRepository sessionRepository = new SessionRepository(mock);
    @ClassRule
    public static final ResourceTestRule resources = ResourceTestRule.builder()
            .addResource(new SessionResource(sessionRepository))
            .build();

    @Test
    public void sessions_returnerer_liste_med_sesjoner() throws Exception {
        List<Event> events = lag_test_sesjon();
        when(mock.getEvents()).thenReturn(events.stream());

        sessionRepository.refresh();

        final WebTarget resource = resources.client().target("/event/test-event-slug/sessions");

        List<SessionDTO> sessionDTO = resource.request().get(new GenericType<List<SessionDTO>>() { });

        assertThat(sessionDTO.get(0).tittel).isEqualTo("tittel");
    }

    private List<Event> lag_test_sesjon() {
        List<Event> events = Lists.newArrayList();
        List<Foredragsholder> foredragsholdere = Lists.<Foredragsholder>newArrayList();
        Session sessions = new Session(new SessionId("123"), "tittel", "format", new Slot("start", "slutt"), foredragsholdere, "norsk", "awesome", "Awesome", "Awesome");
        events.add(new Event(Lists.newArrayList(sessions), "test-event-slug"));
        return events;
    }

}