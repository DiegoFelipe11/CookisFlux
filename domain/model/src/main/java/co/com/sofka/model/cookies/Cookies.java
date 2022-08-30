package co.com.sofka.model.cookies;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Set;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)

public class Cookies {
    private String id;
    private String name;
    private String code;
    private Set<String> category;
}
