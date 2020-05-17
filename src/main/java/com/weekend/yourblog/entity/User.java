package com.weekend.yourblog.entity;

import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="T_USR")
@Getter
@Setter
public class User {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="USR_ID", updatable=false, nullable=false)
	private Long userId;
	
	@Column(name="FST_NM", nullable=false)
	private String fristName;
	
	@Column(name="LST_NM")
	private String lastName;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="CREATED_DT")
	@CreationTimestamp
	private Date createdDate;
	
	@OneToMany(mappedBy="user")
	private List<Blog> blogs;
	
	@OneToMany(mappedBy="user")
	private List<Comment> comments;
	
	@ManyToMany
	@JoinTable(name="T_USR_TOPIC",
			joinColumns= { @JoinColumn(name="USER_ID") },
			inverseJoinColumns= { @JoinColumn(name="TOPIC_ID") })
	private Set<Topic> topics;
}
