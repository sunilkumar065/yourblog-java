package com.weekend.yourblog.entity;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="T_TOPIC")
@Getter
@Setter
public class Topic {
	
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="TOPIC_ID",updatable=false, nullable=false)
	private Long topicId;
	
	@Column(name="TOPIC_TAG")
	private String topicName;
	
	@Column(name="TOPIC_DS")
	private String topicDesc;
	
	@ManyToMany
	@JoinTable(name="T_BLOG_TOPIC",
			joinColumns = { @JoinColumn(name="BLOG_ID") },
			inverseJoinColumns = { @JoinColumn(name="TOPIC_ID") })
	private Set<Blog> blogs;
	
	@ManyToMany(mappedBy="topics")
	private Set<User> users;
}
