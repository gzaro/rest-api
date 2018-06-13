package github.gzaro.rest.api;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@Api(tags = "Sample API", description = "Echo service")
public class EchoController {

    public static final String PATH = "/api/v1/echo";

    @ApiResponses(value = {@ApiResponse(code = 200, message = "Message processed successfully", response = MessageEnvelope.class)})
    @ApiOperation(value = "Returns the string message contained in the request body")
    @RequestMapping(method = POST, value = PATH, consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public MessageEnvelope echo(@Valid @RequestBody MessageEnvelope envelope) {
        return envelope;
    }

}
