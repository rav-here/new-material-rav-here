package Numbers;

import java.util.Objects;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode; //not needed since we override 
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode // not needed since we override these methods
public class HashAndEqualsNumber {
		
		private int index;
		private int number;
		
		//changes last line to return true when numbers in
		//the hashSet are duplicated 
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			HashAndEqualsNumber other = (HashAndEqualsNumber) obj;
			return number == other.number;
		}
		//changed to use number, instead of number and index 
		//this way the same hash code is assigned to objects with 
		//the same number
		@Override
		public int hashCode() {
			return Objects.hash(number);
		}
		

}

