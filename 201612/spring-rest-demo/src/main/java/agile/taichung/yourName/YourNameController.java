package agile.taichung.yourName;

import org.springframework.http.ResponseEntity;
import org.springframework.util.Assert;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class YourNameController {

    private String space = " ";

    @PostMapping(path = "/")
    public ResponseEntity splittingName(String fullName) {
        Assert.isTrue(!StringUtils.isEmpty(fullName));

        Map<String, String> result = new HashMap<>();
        result.put("firstName", fullName.split(space)[0]);
        result.put("lastName", fullName.split(space)[1]);

        return ResponseEntity.ok().body(result);
    }

    @PostMapping(path = "/firstName")
    public ResponseEntity getFirstName(String fullName) {
        return ResponseEntity.ok().body(
                fullName.split(space)[0]
        );
    }
}
