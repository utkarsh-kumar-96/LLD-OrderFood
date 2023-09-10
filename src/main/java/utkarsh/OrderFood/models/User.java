package utkarsh.OrderFood.models;

import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.io.Serial;

@Builder
@Getter
@ToString
public class User {
	private String id;
	private String phNo;
	private String name;
}
