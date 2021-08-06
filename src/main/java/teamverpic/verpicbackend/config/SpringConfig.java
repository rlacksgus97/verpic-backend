package teamverpic.verpicbackend.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import teamverpic.verpicbackend.domain.reservation.dao.StudyReservationRepository;
import teamverpic.verpicbackend.domain.topic.dao.TopicRepository;
import teamverpic.verpicbackend.domain.user.dao.UserRepository;

import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;

@Configuration
public class SpringConfig {

    @Bean
    public Map<Long, Set<String>> getRoomId2SessionIDs() {
        Map<Long, Set<String>> roomId2SessionIDs = new ConcurrentHashMap<>();
        return roomId2SessionIDs;
    }

    @Bean
    public Map<String, Long> getSessionId2RoomId() {
        Map<String, Long> sessionId2RoomId = new ConcurrentHashMap<>();
        return sessionId2RoomId;
    }
}
