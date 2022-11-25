package entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Entity
public class DvD {
	
	@Id
	private int id;
	private String title;
	private LocalDate releaseDate;
	private String rating;
	private String director;
	private String studio;
	private double duration;
	

}
