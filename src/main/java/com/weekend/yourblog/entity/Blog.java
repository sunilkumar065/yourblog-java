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
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name="T_BLOG")
@Getter
@Setter
public class Blog {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="BLOG_ID")
	private Long blogId;
	
	@ManyToOne
	@JoinColumn(name="AUTHOR_ID")
	private User user;
	
	@Column(name="LIKES")
	private int likes;
	
	@Column(name="CONTENT")
	private String content;
	
	@Column(name="HEADING")
	private String heading;
	
	@Column(name="CREATED_DT")
	@CreationTimestamp
	private Date createdAt;
	
	@Column(name="UPDT_DT")
	@UpdateTimestamp
	private Date updatedAt;
	
	@OneToMany(mappedBy="blog")
	private List<Comment> comments;
	
	@ManyToMany(mappedBy="blogs")
	private Set<Topic> topics;
}
