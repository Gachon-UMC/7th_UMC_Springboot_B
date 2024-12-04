package umc.umc.study.apiPayload.code.status;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;


@Getter
    @Builder
    public class ErrorReasonDTO {

        private HttpStatus httpStatus;

        private final boolean isSuccess;
        private final String code;
        private final String message;

        public boolean getIsSuccess(){return isSuccess;}
    }

