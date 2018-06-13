package github.gzaro.rest.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.validation.constraints.Size;

@ApiModel(value = "Message envelope", description = "A simple message")
public class MessageEnvelope {

    @Size(min = 1, max = 50)
    @ApiModelProperty(value = "The message content", required = true)
    private String message;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    @Override
    public String toString() {
        return "MessageEnvelope{" +
                "message='" + message + '\'' +
                '}';
    }
}
