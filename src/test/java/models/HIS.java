package models;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class HIS {
    String assessmentDate;
    String dateAssessorSigned;
    String accessibilityConcernsExplained;
    String homeDescriptionComments;
    String energyAssistanceComments;
    String homeMeaningComments;
    String status;
    String assessmentType;
}
