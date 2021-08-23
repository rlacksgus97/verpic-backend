package teamverpic.verpicbackend.domain.topic.dto;

import lombok.Getter;
import teamverpic.verpicbackend.domain.topic.domain.Day;
import teamverpic.verpicbackend.domain.topic.domain.Topic;

import java.util.Date;

@Getter
public class TopicResponseDto {
    private Date studyDate;
    private Day studyDay;
    private String korTheme;
    private String engTheme;

    public TopicResponseDto(Topic entity) {
        this.studyDate = entity.getStudyDate();
        this.studyDay = entity.getStudyDay();
//        this.theme = entity.getTheme();
        this.korTheme=entity.getKorTheme();
        this.engTheme=entity.getEngTheme();
    }
}
