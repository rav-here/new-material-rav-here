package Numbers;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString // don't use this
@EqualsAndHashCode // don't use this 
@NoArgsConstructor
@AllArgsConstructor
public class Number {
	
	private int number;
	private int index;

}

