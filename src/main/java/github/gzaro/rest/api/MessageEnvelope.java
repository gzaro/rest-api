package github.gzaro.rest.api;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

@ApiModel(value = "Message envelope", description = "A simple message")
public class MessageEnvelope {

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
