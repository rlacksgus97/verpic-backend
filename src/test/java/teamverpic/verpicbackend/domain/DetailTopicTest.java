package teamverpic.verpicbackend.domain;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import teamverpic.verpicbackend.domain.preview.DetailTopic;
import teamverpic.verpicbackend.domain.preview.UserAnswer;
import teamverpic.verpicbackend.repository.preview.DetailTopicRepository;
import teamverpic.verpicbackend.repository.preview.UserAnswerRepository;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@RunWith(SpringRunner.class)
@SpringBootTest
class DetailTopicTest {

    @Autowired
    private UserAnswerRepository userAnswerRepository;

    @Autowired
    private DetailTopicRepository detailTopicRepository;

    @Test
    public void save() {
        DetailTopic detailTopic = DetailTopic.builder()
                .context("what is your favorite color?")
                .build();
        detailTopicRepository.save(detailTopic);

        UserAnswer userAnswer = UserAnswer.builder()
                .user_id(1L)
                .answer("i like blue")
                .build();

        detailTopic.addUserAnswer(userAnswer);

        userAnswerRepository.save(userAnswer);

        List<DetailTopic> detailTopics = detailTopicRepository.findAll();
        assertThat(detailTopics.get(0).getContext()).isEqualTo("what is your favorite color?");
        assertThat(detailTopics.get(0).getUserAnswerList().get(0).getAnswer()).isEqualTo("i like blue");
    }
}