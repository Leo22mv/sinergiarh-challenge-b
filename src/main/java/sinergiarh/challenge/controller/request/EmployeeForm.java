package sinergiarh.challenge.controller.request;

import java.util.List;

import lombok.Getter;

@Getter
public class EmployeeForm {
    private String name;
    private String surname;
    private String phone = null;
    private Long gender_id;
    private Long tutor_id = null;
    private List<Long> tasks_ids;
}
