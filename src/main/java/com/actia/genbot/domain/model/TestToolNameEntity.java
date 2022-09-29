package com.actia.genbot.domain.model;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import edu.umd.cs.findbugs.annotations.SuppressFBWarnings;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@Entity
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@ToString
@Table(name = "test_tool_name")
@SuppressFBWarnings
public class TestToolNameEntity {
	@Id
	@SequenceGenerator(name = "test_tool_name_instance_id_seq", sequenceName = "test_tool_name_instance_id_seq", allocationSize = 50)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "test_tool_name_instance_id_seq")
	private long id;
	
	@NotNull
	private String name;
}
