package models;

import java.util.Date;
import lombok.*;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class Purchases {
	private String buyerId;
	private String order;
	private Date date;
}
