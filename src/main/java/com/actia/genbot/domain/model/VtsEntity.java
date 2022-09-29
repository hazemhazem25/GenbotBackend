package com.actia.genbot.domain.model;



import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;

import lombok.Data;


@Data
@Entity
@Table(name = "vts")
@SuppressFBWarnings
public class VtsEntity {
	
	@Id
	@SequenceGenerator(name = "vts_instance_id_seq", sequenceName = "vts_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vts_instance_id_seq")
	private long id;
	
	@NotNull
	private String name;
	
	@NotNull
	@Min(value = 0 , message = "Value should be greater then then equal to 0")
    @Max(value = 10 , message = "Value should be less then then equal to 10")
	private Integer Quantity;
	
	
	@ManyToOne
	ProjectEntity project;
}
